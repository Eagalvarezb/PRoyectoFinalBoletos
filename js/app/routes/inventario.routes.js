const express = require("express");
const router = express.Router();
const inventarioController = require("../controllers/inventario.controller");

// Rutas CRUD
router.post("/", inventarioController.create);
router.get("/", inventarioController.findAll);
router.get("/:id", inventarioController.findOne);
router.put("/:id", inventarioController.update);
router.delete("/:id", inventarioController.delete);

module.exports = router;
