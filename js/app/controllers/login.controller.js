const db = require("../models"); 
const Usuario = db.usuario; 
const Op = db.Sequelize.Op;

exports.login = async (req, res) => {
  try {
    const { nombre_usuario, contrasena } = req.body;

    // Verificar que ambos campos se enviaron
    if (!nombre_usuario || !contrasena) {
      return res.status(400).json({ mensaje: "Faltan credenciales" });
    }

    // Buscar usuario por nombre_usuario
    const usuario = await Usuario.findOne({ where: { nombre_usuario } });
    if (!usuario) {
      return res.status(401).json({ mensaje: "Usuario no encontrado" });
    }

    // Comparar contraseñas
    const passwordValido = await bcrypt.compare(contrasena, usuario.contrasena_hash);
    if (!passwordValido) {
      return res.status(401).json({ mensaje: "Contraseña incorrecta" });
    }

    // Respuesta al cliente
    res.json({
      mensaje: "Login exitoso",
      usuario: {
        id_usuario: usuario.id_usuario,
        nombre_completo: usuario.nombre_completo,
        rol: usuario.rol,
      },
    });
  } catch (error) {
    console.error("Error en login:", error);
    res.status(500).json({ mensaje: "Error interno del servidor" });
  }
};