const express = require("express");
const router = express.Router();
const localidadController = require("../controllers/localidad.controller");

// Rutas CRUD
router.post("/", localidadController.create);
router.get("/", localidadController.findAll);
router.get("/:id", localidadController.findOne);
router.put("/:id", localidadController.update);
router.delete("/:id", localidadController.delete);

module.exports = router;
