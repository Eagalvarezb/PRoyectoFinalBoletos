const db = require("../models");
const Venta = db.ventas;
const Op = db.Sequelize.Op;

//------------------Create------------------
    exports.create = (req, res) => {
        if (!req.body.id_vendedor || !req.body.total_venta) {
            res.status(400).send({ message: "Faltan datos obligatorios para la venta." });
            return;
        }

        const venta = {
            id_vendedor: req.body.id_vendedor,
            total_venta: req.body.total_venta
        };

        Venta.create(venta)
            .then(data => { res.send(data); })
            .catch(err => {
                res.status(500).send({
                    message: err.message || "Ocurrió un error al crear la Venta."
                });
            });
    };
//------------------------------------------

//-----------------Find_All-----------------
    exports.findAll = (req, res) => {
        Venta.findAll({order: [["id_usuario", "ASC"]]})
            .then(data => { res.send(data); })
            .catch(err => {
                res.status(500).send({
                    message: err.message || "Ocurrió un error al recuperar las Ventas."
                });
            });
    };
//------------------------------------------

//-----------------Find_One-----------------
    exports.findOne = (req, res) => {
        const id = req.params.id;

        Venta.findByPk(id)
            .then(data => { res.send(data); })
            .catch(err => {
                res.status(500).send({ message: "Error recuperando Venta con id=" + id });
            });
    };
//------------------------------------------

//------------------Update------------------
    exports.update = (req, res) => {
        const id = req.params.id;

        Venta.update(req.body, { where: { id_venta: id } })
            .then(num => {
                if (num == 1) res.send({ message: "Venta actualizada correctamente." });
                else res.send({ message: `No se pudo actualizar Venta con id=${id}.` });
            })
            .catch(err => {
                res.status(500).send({ message: "Error actualizando Venta con id=" + id });
            });
    };
//------------------------------------------

//------------------Delete------------------
    exports.delete = (req, res) => {
        const id = req.params.id;

        Venta.destroy({ where: { id_venta: id } })
            .then(num => {
                if (num == 1) res.send({ message: "Venta eliminada correctamente!" });
                else res.send({ message: `No se pudo eliminar Venta con id=${id}.` });
            })
            .catch(err => {
                res.status(500).send({ message: "No se pudo eliminar Venta con id=" + id });
            });
    };
//------------------------------------------
