const db = require("../models");
const Localidad = db.localidad;

//------------------Create------------------
  exports.create = (req, res) => {
    Localidad.create(req.body)
      .then(data => {
        res.status(201).json(data);
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//-----------------Find_All-----------------
  exports.findAll = async (req, res) => {
    try {
      const data = await Localidad.findAll({
        order: [['id_localidad', 'ASC']] // ASC para ascendente, DESC para descendente
      });
      res.json(data);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  };
//------------------------------------------

//-----------------Find_One-----------------
  exports.findOne = (req, res) => {
    const id = req.params.id;
    
    Localidad.findByPk(id)
      .then(data => {
        if (data) {
          res.json(data);
        } else {
          res.status(404).json({ message: "Localidad no encontrada" });
        }
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//------------------Update------------------
  exports.update = (req, res) => {
    const id = req.params.id;
    
    Localidad.update(req.body, { where: { id_localidad: id } })
      .then(result => {
        if (result[0] === 1) {
          res.json({ message: "Localidad actualizada" });
        } else {
          res.status(404).json({ message: "No se encontró la localidad" });
        }
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//------------------Delete------------------
  exports.delete = (req, res) => {
    const id = req.params.id;
    
    Localidad.destroy({ where: { id_localidad: id } })
      .then(result => {
        if (result === 1) {
          res.json({ message: "Localidad eliminada" });
        } else {
          res.status(404).json({ message: "No se encontró la localidad" });
        }
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------
