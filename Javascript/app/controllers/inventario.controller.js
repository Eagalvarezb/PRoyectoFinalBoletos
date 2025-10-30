const db = require("../models");
const Inventario = db.inventario;

//------------------Create------------------
  exports.create = (req, res) => {
    Inventario.create(req.body)
      .then(data => {
        res.status(201).json(data);
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//-----------------Find_All-----------------
  exports.findAll = (req, res) => {
    Inventario.findAll({
    order: [['id_inventario', 'ASC']]
  })
      .then(data => {
        res.json(data);
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//-----------------Find_One-----------------
  exports.findOne = (req, res) => {
    const id = req.params.id;
    
    Inventario.findByPk(id)
      .then(data => {
        if (data) {
          res.json(data);
        } else {
          res.status(404).json({ message: "Inventario no encontrado" });
        }
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------

//------------------Update------------------
  exports.update = async (req, res) => {
    try {
      const id = req.params.id;
      const [updated] = await Inventario.update(req.body, {
        where: { id_inventario: id }
      });

      if (updated === 1) {
        res.json({ message: "Inventario actualizado" });
      } else {
        res.status(404).json({ message: "No se encontró el registro" });
      }
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  };
//------------------------------------------

//------------------Delete------------------
  exports.delete = (req, res) => {
    const id = req.params.id;
    
    Inventario.destroy({ where: { id_inventario: id } })
      .then(result => {
        if (result === 1) {
          res.json({ message: "Inventario eliminado" });
        } else {
          res.status(404).json({ message: "No se encontró el registro" });
        }
      })
      .catch(err => {
        res.status(500).json({ message: err.message });
      });
  };
//------------------------------------------