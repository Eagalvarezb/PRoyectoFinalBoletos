const db = require("../models");
const DetalleVenta = db.detalle_ventas;
const Inventario = db.inventario;
const Op = db.Sequelize.Op;

//------------------Create------------------
    exports.create = async (req, res) => {
        try {
            const { id_inventario, cantidad, id_venta, id_partido, precio_unitario } = req.body;

            // Obtener inventario
            const inventario = await Inventario.findByPk(id_inventario);
            if (!inventario) return res.status(404).send({ message: "Inventario no encontrado" });

            // Obtener partido para validar estado
            const partido = await db.partidos.findByPk(id_partido);
            if (!partido) return res.status(404).send({ message: "Partido no encontrado" });

            // Bloquear venta si partido finalizado
            if (partido.estado === "finalizado") {
                return res.status(400).send({ message: "No se pueden vender entradas para un partido finalizado." });
            }

            // Validar inventario
            if (inventario.cantidad_disponible < cantidad) {
                return res.status(400).send({ message: "No hay suficiente inventario disponible." });
            }

            // Restar la cantidad vendida
            inventario.cantidad_disponible -= cantidad;
            await inventario.save();

            // Crear detalle de venta
            const detalle = await DetalleVenta.create(req.body);
            res.status(201).send({ ok: true, message: "Detalle de venta creado correctamente.", detalle });

        } catch (err) {
            res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------

//-----------------Find_All-----------------
    exports.findAll = async (req, res) => {
        try {
            const data = await DetalleVenta.findAll({include: ["venta", "localidad", "partido", "inventario"]});
            res.send(data);
        } catch (err) {
            res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------

//-----------------Find_One-----------------
    exports.findOne = async (req, res) => {
        try {
            const id = req.params.id;
            const detalle = await DetalleVenta.findByPk(id, { include: ["venta", "localidad", "partido", "inventario"] });
            if (!detalle) return res.status(404).send({ message: "Detalle no encontrado." });
            res.send(detalle);
        } catch (err) {
            res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------

//------------------Update------------------
    exports.update = async (req, res) => {
        try {
            const id = req.params.id;
            const { cantidad, id_inventario, id_partido } = req.body;

            // Obtener detalle actual
            const detalleViejo = await DetalleVenta.findByPk(id);
            if (!detalleViejo) return res.status(404).send({ message: "Detalle de venta no encontrado." });

            // Obtener partido para validar estado
            const partido = await db.partidos.findByPk(detalleViejo.id_partido);
            if (!partido) return res.status(404).send({ message: "Partido no encontrado." });

            if (partido.estado === "finalizado") {
                return res.status(400).send({ message: "No se pueden modificar ventas de un partido finalizado." });
            }

            // Obtener inventario correspondiente
            const inventario = await Inventario.findByPk(detalleViejo.id_inventario);
            if (!inventario) return res.status(404).send({ message: "Inventario no encontrado." });

            // Ajustar inventario
            const diferencia = cantidad - detalleViejo.cantidad; // puede ser + o -
            if (inventario.cantidad_disponible < diferencia) {
                return res.status(400).send({ message: "No hay suficiente inventario para esta actualización." });
            }

            inventario.cantidad_disponible -= diferencia;
            await inventario.save();

            // Actualizar detalle
            await DetalleVenta.update(req.body, { where: { id_detalle: id } });
            res.send({ ok: true, message: "Detalle de venta actualizado correctamente." });

        } catch (err) {
            res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------

//------------------Delete------------------
    exports.delete = async (req, res) => {
        try {
            const id = req.params.id;
            const detalle = await DetalleVenta.findByPk(id);
            if (!detalle) return res.status(404).send({ message: "Detalle de venta no encontrado." });

            const inventario = await Inventario.findByPk(detalle.id_inventario);
            if (!inventario) return res.status(404).send({ message: "Inventario no encontrado." });

            inventario.cantidad_disponible += detalle.cantidad;
            await inventario.save();

            await DetalleVenta.destroy({ where: { id_detalle: id } });
            res.send({ message: "Detalle de venta eliminado correctamente." });

        } catch (err) {
            res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------
