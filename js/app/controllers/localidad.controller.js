const db = require("../models");
const Localidad = db.localidad;

// Crear una localidad
exports.create = async (req, res) => {
  try {
    const nueva = await Localidad.create(req.body);
    res.status(201).json(nueva);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Mostrar todas las localidades
exports.findAll = async (req, res) => {
  try {
    const data = await Localidad.findAll();
    res.json(data);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Buscar localidad por ID
exports.findOne = async (req, res) => {
  try {
    const id = req.params.id;
    const item = await Localidad.findByPk(id);
    if (item) res.json(item);
    else res.status(404).json({ message: "Localidad no encontrada" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Actualizar localidad
exports.update = async (req, res) => {
  try {
    const id = req.params.id;
    const result = await Localidad.update(req.body, { where: { id_localidad: id } });
    if (result[0] === 1) res.json({ message: "Localidad actualizada" });
    else res.status(404).json({ message: "No se encontró la localidad" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// Eliminar localidad
exports.delete = async (req, res) => {
  try {
    const id = req.params.id;
    const result = await Localidad.destroy({ where: { id_localidad: id } });
    if (result === 1) res.json({ message: "Localidad eliminada" });
    else res.status(404).json({ message: "No se encontró la localidad" });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};
