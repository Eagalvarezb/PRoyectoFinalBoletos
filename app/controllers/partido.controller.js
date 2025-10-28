const db = require("../models");
const Partido = db.partidos;
const Op = db.Sequelize.Op;

// Crear un nuevo partido
exports.create = (req, res) => {
    if (!req.body.equipo_visitante || !req.body.equipo_local || !req.body.fecha_partido || !req.body.estadio) {
        return res.status(400).json({
            message: "SVB-GUA: Faltan datos obligatorios (visitante, local, fecha, estadio)."
        });
    }

    const partido = {
        equipo_visitante: req.body.equipo_visitante,
        equipo_local: req.body.equipo_local,
        fecha_partido: req.body.fecha_partido,
        estadio: req.body.estadio,
        estado: req.body.estado || 'programado'
    };

    Partido.create(partido)
        .then(data => res.status(201).json({ ok: true, message: "Partido registrado correctamente", partido: data }))
        .catch(err => res.status(500).json({ message: err.message || "SVB-GUA: Error al crear partido." }));
};

// Listar todos los partidos
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

        const data = await Partido.findAll({ where, order: [['fecha_partido', 'ASC']] });
        res.json({ ok: true, partidos: data });
    } catch (err) {
        res.status(500).json({ message: err.message || "SVB-GUA: Error al listar partidos." });
    }
};

// Obtener partido por ID
exports.findOne = (req, res) => {
    const id = req.params.id;
    Partido.findByPk(id)
        .then(data => {
            if (data) res.json({ ok: true, partido: data });
            else res.status(404).json({ ok: false, message: "SVB-GUA: Partido no encontrado." });
        })
        .catch(err => res.status(500).json({ message: "SVB-GUA: Error al obtener partido." }));
};

// Actualizar partido
exports.update = (req, res) => {
    const id = req.params.id;
    Partido.update(req.body, { where: { id_partido: id } })
        .then(num => {
            if (num[0] === 1) res.json({ ok: true, message: "Partido actualizado correctamente." });
            else res.status(404).json({ ok: false, message: `No se pudo actualizar el partido con id=${id}.` });
        })
        .catch(err => res.status(500).json({ message: "SVB-GUA: Error al actualizar partido." }));
};

// Eliminar partido
exports.delete = (req, res) => {
    const id = req.params.id;
    Partido.destroy({ where: { id_partido: id } })
        .then(num => {
            if (num === 1) res.json({ ok: true, message: "Partido eliminado correctamente." });
            else res.status(404).json({ ok: false, message: `No se pudo eliminar el partido con id=${id}.` });
        })
        .catch(err => res.status(500).json({ message: "SVB-GUA: Error al eliminar partido." }));
};

