const db = require("../models");
const Usuario = db.usuarios;
const Op = db.Sequelize.Op;

exports.create = (req, res) => {
    if (!req.body.nombre_usuario || !req.body.contrasena_hash) {
        res.status(400).send({
            message: "El nombre de usuario y la contraseña no pueden estar vacíos."
        });
        return;
    }

    const usuario = {
        nombre_usuario: req.body.nombre_usuario,
        contrasena_hash: req.body.contrasena_hash,
        nombre_completo: req.body.nombre_completo,
        rol: req.body.rol
    };

    Usuario.create(usuario)
        .then(data => { res.send(data); })
        .catch(err => {
            res.status(500).send({
                message: err.message || "Ocurrió un error al crear el Usuario."
            });
        });
};

exports.findAll = async (req, res) => {
    try {
    const nombre = req.query.nombre_usuario;
    const condition = nombre ? { nombre_usuario: { [Op.iLike]: `%${nombre}%` } } : null;
    const data = await Usuario.findAll({ where: condition });
    res.send(data);
    } catch (err) {
    res.status(500).send({ message: err.message });
    }
};


exports.findOne = (req, res) => {
    const id = req.params.id;

    Usuario.findByPk(id)
        .then(data => { res.send(data); })
        .catch(err => {
            res.status(500).send({ message: "Error recuperando Usuario con id=" + id });
        });
};

exports.update = (req, res) => {
    const id = req.params.id;

    Usuario.update(req.body, { where: { id_usuario: id } })
        .then(num => {
            if (num == 1) {
                res.send({ message: "Usuario actualizado correctamente." });
            } else {
                res.send({
                    message: `No se pudo actualizar el Usuario con id=${id}. Tal vez no existe o req.body está vacío.`
                });
            }
        })
        .catch(err => {
            res.status(500).send({ message: "Error actualizando Usuario con id=" + id });
        });
};

exports.delete = (req, res) => {
    const id = req.params.id;

    Usuario.destroy({ where: { id_usuario: id } })
        .then(num => {
            if (num == 1) res.send({ message: "Usuario eliminado correctamente!" });
            else res.send({ message: `No se pudo eliminar el Usuario con id=${id}.` });
        })
        .catch(err => {
            res.status(500).send({ message: "No se pudo eliminar Usuario con id=" + id });
        });
};

exports.login = async (req, res) => {
    try {
        const { nombre_usuario, contrasena_hash } = req.body;
        const user = await Usuario.findOne({ where: { nombre_usuario, contrasena_hash } });

        if (!user) {
            return res.status(404).send({ message: "Usuario o contraseña incorrectos." });
        }

        res.status(200).send(user);
        } catch (error) {
        res.status(500).send({ message: "Error en el servidor.", error });
        }
};

