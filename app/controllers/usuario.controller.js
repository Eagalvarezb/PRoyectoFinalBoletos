const db = require("../models");
const Usuario = db.usuarios;
const Op = db.Sequelize.Op;

//------------------Create------------------
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
//------------------------------------------

//-----------------Find_All-----------------
    exports.findAll = async (req, res) => {
        try {
        const nombre = req.query.nombre_usuario;
        const condition = nombre ? { nombre_usuario: { [Op.iLike]: `%${nombre}%` } } : null;
        const data = await Usuario.findAll({ where: condition, order: [["id_usuario", "ASC"]] });
        res.send(data);
        } catch (err) {
        res.status(500).send({ message: err.message });
        }
    };
//------------------------------------------

//-----------------Find_One-----------------
    exports.findOne = (req, res) => {
        const id = req.params.id;

        Usuario.findByPk(id)
            .then(data => { res.send(data); })
            .catch(err => {
                res.status(500).send({ message: "Error recuperando Usuario con id=" + id });
            });
    };
//------------------------------------------

//------------------Update------------------
    exports.update = async (req, res) => {
        try {
            const id = req.params.id;

            if ('id_usuario' in req.body) {
                delete req.body.id_usuario;
            }

            const [updated] = await Usuario.update(req.body, {
                where: { id_usuario: id }
            });

            if (updated) {
                const updatedUser = await Usuario.findByPk(id);
                res.json(updatedUser);
            } else {
                res.status(404).json({ message: `Usuario con id=${id} no encontrado o sin cambios.` });
            }
        } catch (error) {
            console.error("Error al actualizar usuario:", error);
            res.status(500).json({ message: 'Error interno del servidor', error });
        }
    };
//------------------------------------------

//------------------Delete------------------
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
//------------------------------------------

//-------------------Login------------------
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
//------------------------------------------
