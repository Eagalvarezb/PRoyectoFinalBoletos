// Rutas para endpoints de partidos
const express = require('express');
const router = express.Router();
const partidoCtrl = require('../controllers/partido.controller');

// (Opcional) middleware de autenticación/roles si ya lo tienen
// const auth = require('../middleware/auth.middleware'); // ejemplo
// router.use(auth); // si quieremos proteger todas


router.post('/', /* auth.ensureAdmin, */ partidoCtrl.crearPartido); // solo ADMIN debería crear
router.get('/', partidoCtrl.listarPartidos);
router.get('/:id', partidoCtrl.obtenerPartido);
router.put('/:id', /* auth.ensureAdmin, */ partidoCtrl.actualizarPartido); // ADMIN
router.delete('/:id', /* auth.ensureAdmin, */ partidoCtrl.eliminarPartido); // ADMIN

module.exports = router;
