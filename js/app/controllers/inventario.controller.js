const db = require("../models");
const Inventario = db.inventario;

// Crear un nuevo registro
exports.create = async (req, res) => {
  try {
    const nuevo = await Inventario.create(req.body);
    res.status(201).json(nuevo);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Mostrar todos los registros
exports.findAll = async (req, res) => {
  try {
    const data = await Inventario.findAll();
    res.json(data);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Buscar por ID
exports.findOne = async (req, res) => {
  try {
    const id = req.params.id;
    const item = await Inventario.findByPk(id);
    if (item) res.json(item);
    else res.status(404).json({ message: "Inventario no encontrado" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Actualizar registro
exports.update = async (req, res) => {
  try {
    const id = req.params.id;
    const result = await Inventario.update(req.body, { where: { id_inventario: id } });
    if (result[0] === 1) res.json({ message: "Inventario actualizado" });
    else res.status(404).json({ message: "No se encontró el registro" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Eliminar registro
exports.delete = async (req, res) => {
  try {
    const id = req.params.id;
    const result = await Inventario.destroy({ where: { id_inventario: id } });
    if (result === 1) res.json({ message: "Inventario eliminado" });
    else res.status(404).json({ message: "No se encontró el registro" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
