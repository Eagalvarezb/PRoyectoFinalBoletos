const db = require("../models");
const DetalleVenta = db.detalle_ventas;
const Op = db.Sequelize.Op;

exports.create = (req, res) => {
    if (!req.body.id_venta || !req.body.id_localidad || !req.body.id_partido) {
        res.status(400).send({ message: "Campos obligatorios faltantes." });
        return;
    }

    const detalle = {
        id_venta: req.body.id_venta,
        id_localidad: req.body.id_localidad,
        id_partido: req.body.id_partido,
        cantidad: req.body.cantidad,
        precio_unitario: req.body.precio_unitario
    };

    DetalleVenta.create(detalle)
        .then(data => { res.send(data); })
        .catch(err => {
            res.status(500).send({
                message: err.message || "Ocurrió un error al crear el Detalle de Venta."
            });
        });
};

exports.findAll = async (req, res) => {
    try {
        const data = await DetalleVenta.findAll({
            include: ["venta", "localidad", "partido"] // si defines alias en relaciones
        });
        res.send(data);
    } catch (err) {
        res.status(500).send({
            message: err.message || "Error al recuperar los Detalles de Venta."
        });
    }
};


exports.findOne = (req, res) => {
    const id = req.params.id;

    DetalleVenta.findByPk(id)
        .then(data => { res.send(data); })
        .catch(err => {
            res.status(500).send({ message: "Error recuperando Detalle con id=" + id });
        });
};

exports.update = (req, res) => {
    const id = req.params.id;

    DetalleVenta.update(req.body, { where: { id_detalle: id } })
        .then(num => {
            if (num == 1) res.send({ message: "Detalle de Venta actualizado correctamente." });
            else res.send({ message: `No se pudo actualizar Detalle con id=${id}.` });
        })
        .catch(err => {
            res.status(500).send({ message: "Error actualizando Detalle con id=" + id });
        });
};

exports.delete = (req, res) => {
    const id = req.params.id;

    DetalleVenta.destroy({ where: { id_detalle: id } })
        .then(num => {
            if (num == 1) res.send({ message: "Detalle de Venta eliminado correctamente!" });
            else res.send({ message: `No se pudo eliminar Detalle con id=${id}.` });
        })
        .catch(err => {
            res.status(500).send({ message: "No se pudo eliminar Detalle con id=" + id });
        });
};

