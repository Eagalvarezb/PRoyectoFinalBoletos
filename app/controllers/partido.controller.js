const db = require("../models");
const Partido = db.partidos;
const Op = db.Sequelize.Op;

actualizarEstadosPartidos();


//------------------Create------------------
    exports.create = async (req, res) => {
        try {
            if (!req.body.equipo_visitante || !req.body.equipo_local || !req.body.fecha_partido || !req.body.estadio) {
                return res.status(400).json({
                    message: "BoletoChapín: Faltan datos obligatorios (visitante, local, fecha, estadio)."
                });
            }

            const partido = {
                equipo_visitante: req.body.equipo_visitante,
                equipo_local: req.body.equipo_local,
                fecha_partido: req.body.fecha_partido,
                estadio: req.body.estadio,
                estado: calcularEstado(req.body.fecha_partido)
            };

            const data = await Partido.create(partido);
            res.status(201).json({ ok: true, message: "Partido registrado correctamente", partido: data });

        } catch (err) {
            res.status(500).json({ message: err.message || "BoletoChapín: Error al crear partido." });
        }
    };
//------------------------------------------

//-----------------Find_All-----------------
    exports.findAll = async (req, res) => {
        try {
            const { desde, hasta, estado, q } = req.query;
            const where = {};

            if (estado) where.estado = estado;
            if (desde || hasta) {
                where.fecha_partido = {};
                if (desde) where.fecha_partido[Op.gte] = new Date(desde);
                if (hasta) where.fecha_partido[Op.lte] = new Date(hasta);
            }
            if (q) {
                where[Op.or] = [
                    { equipo_local: { [Op.iLike]: `%${q}%` } },
                    { equipo_visitante: { [Op.iLike]: `%${q}%` } },
                    { estadio: { [Op.iLike]: `%${q}%` } }
                ];
            }

            const data = await Partido.findAll({ where, order: [['id_partido', 'ASC']] });

            // Actualizar estados dinámicamente al consultar
            for (let p of data) {
                const nuevoEstado = calcularEstado(p.fecha_partido);
                if (p.estado !== nuevoEstado) {
                    await p.update({ estado: nuevoEstado });
                }
            }

            res.json({ ok: true, partidos: data });
        } catch (err) {
            res.status(500).json({ message: err.message || "BoletoChapín: Error al listar partidos." });
        }
    };
//------------------------------------------

//-----------------Find_One-----------------
    exports.findOne = async (req, res) => {
        try {
            const id = req.params.id;
            const partido = await Partido.findByPk(id);
            if (!partido) return res.status(404).json({ ok: false, message: "BoletoChapín: Partido no encontrado." });

            const nuevoEstado = calcularEstado(partido.fecha_partido);
            if (partido.estado !== nuevoEstado) {
                await partido.update({ estado: nuevoEstado });
            }

            res.json({ ok: true, partido });
        } catch (err) {
            res.status(500).json({ message: "BoletoChapín: Error al obtener partido." });
        }
    };
//------------------------------------------

//------------------Update------------------
    exports.update = async (req, res) => {
        try {
            const id = req.params.id;

            const partidoExistente = await Partido.findByPk(id);
            if (!partidoExistente) return res.status(404).json({ ok: false, message: "Partido no encontrado" });

            const datosActualizados = { ...req.body };

            if (datosActualizados.fecha_partido) {
                datosActualizados.estado = calcularEstado(datosActualizados.fecha_partido);
            } else {
                datosActualizados.estado = calcularEstado(partidoExistente.fecha_partido);
            }

            const num = await Partido.update(datosActualizados, { where: { id_partido: id } });

            if (num[0] === 1) res.json({ ok: true, message: "Partido actualizado correctamente." });
            else res.status(404).json({ ok: false, message: `No se pudo actualizar el partido con id=${id}.` });

        } catch (err) {
            res.status(500).json({ message: "BoletoChapín: Error al actualizar partido." });
        }
    };
//------------------------------------------

//------------------Delete------------------
    exports.delete = async (req, res) => {
        try {
            const id = req.params.id;
            const num = await Partido.destroy({ where: { id_partido: id } });
            if (num === 1) res.json({ ok: true, message: "Partido eliminado correctamente." });
            else res.status(404).json({ ok: false, message: `No se pudo eliminar el partido con id=${id}.` });
        } catch (err) {
            res.status(500).json({ message: "BoletoChapín: Error al eliminar partido." });
        }
    };
//------------------------------------------

//-------------------Date-------------------
    function calcularEstado(fechaPartido) {
        const hoy = new Date();
        const partido = new Date(fechaPartido);
        hoy.setHours(0,0,0,0);
        partido.setHours(0,0,0,0);

        if (partido.getTime() === hoy.getTime()) return "activo";
        if (partido.getTime() > hoy.getTime()) return "programado";
        return "finalizado";
    }
//------------------------------------------

//--------------Update_Status---------------
async function actualizarEstadosPartidos() {
    try {
        const partidos = await Partido.findAll();
        for (let p of partidos) {
            const nuevoEstado = calcularEstado(p.fecha_partido);
            if (p.estado !== nuevoEstado) {
                await p.update({ estado: nuevoEstado });
                console.log(`Partido ${p.id_partido} actualizado a estado: ${nuevoEstado}`);
            }
        }
    } catch (err) {
        console.error("Error actualizando estados de partidos:", err);
    }
}
//------------------------------------------