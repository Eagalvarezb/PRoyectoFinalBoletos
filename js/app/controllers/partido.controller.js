// Controlador para manejar la lógica de Partidos (SVB-GUA)

const { Partido } = require('../models'); // asume que models/index.js exporta Partido
const { Op } = require('sequelize');

module.exports = {
  // Crear un partido nuevo
  async crearPartido(req, res) {
    try {
      const { equipo_visitante, equipo_local, fecha_partido, estadio, estado } = req.body;

      // Validaciones básicas
      if (!equipo_visitante || !equipo_local || !fecha_partido || !estadio) {
        return res.status(400).json({ ok: false, message: 'SVB-GUA: Faltan datos obligatorios (visitante, local, fecha, estadio).' });
      }

      // Evitar crear partido idéntico (mismo equipos y misma fecha)
      const existe = await Partido.findOne({
        where: {
          equipo_local: equipo_local,
          equipo_visitante: equipo_visitante,
          fecha_partido: fecha_partido
        }
      });
      if (existe) {
        return res.status(409).json({ ok: false, message: 'SVB-GUA: Ya existe un partido programado con los mismos equipos y fecha.' });
      }

      const nuevo = await Partido.create({
        equipo_visitante,
        equipo_local,
        fecha_partido,
        estadio,
        estado: estado || 'programado'
      });

      return res.status(201).json({
        ok: true,
        message: 'SVB-GUA: Partido registrado correctamente.',
        partido: nuevo
      });
    } catch (err) {
      console.error('ERROR crearPartido:', err);
      return res.status(500).json({ ok: false, message: 'SVB-GUA: Error interno al crear partido.' });
    }
  },

  // Listar partidos (con filtros opcionales por fecha o estado)
  async listarPartidos(req, res) {
    try {
      const { desde, hasta, estado, q } = req.query;
      const where = {};

      if (estado) where.estado = estado;
      if (desde || hasta) {
        where.fecha_partido = {};
        if (desde) where.fecha_partido[Op.gte] = new Date(desde);
        if (hasta) where.fecha_partido[Op.lte] = new Date(hasta);
      }
      if (q) {
        where[Op.or] = [
          { equipo_local: { [Op.iLike]: `%${q}%` } },
          { equipo_visitante: { [Op.iLike]: `%${q}%` } },
          { estadio: { [Op.iLike]: `%${q}%` } }
        ];
      }

      const partidos = await Partido.findAll({ where, order: [['fecha_partido', 'ASC']] });

      return res.json({ ok: true, partidos });
    } catch (err) {
      console.error('ERROR listarPartidos:', err);
      return res.status(500).json({ ok: false, message: 'SVB-GUA: Error al obtener lista de partidos.' });
    }
  },

  // Obtener un partido por id
  async obtenerPartido(req, res) {
    try {
      const id = Number(req.params.id);
      if (Number.isNaN(id)) return res.status(400).json({ ok: false, message: 'SVB-GUA: ID de partido inválido.' });

      const partido = await Partido.findByPk(id);
      if (!partido) return res.status(404).json({ ok: false, message: 'SVB-GUA: Partido no encontrado.' });

      return res.json({ ok: true, partido });
    } catch (err) {
      console.error('ERROR obtenerPartido:', err);
      return res.status(500).json({ ok: false, message: 'SVB-GUA: Error al obtener partido.' });
    }
  },

  // Actualizar partido
  async actualizarPartido(req, res) {
    try {
      const id = Number(req.params.id);
      if (Number.isNaN(id)) return res.status(400).json({ ok: false, message: 'SVB-GUA: ID de partido inválido.' });

      const partido = await Partido.findByPk(id);
      if (!partido) return res.status(404).json({ ok: false, message: 'SVB-GUA: Partido no existe.' });

      const { equipo_visitante, equipo_local, fecha_partido, estadio, estado } = req.body;

      // Actualizamos solo los campos que vengan
      await partido.update({
        equipo_visitante: equipo_visitante ?? partido.equipo_visitante,
        equipo_local: equipo_local ?? partido.equipo_local,
        fecha_partido: fecha_partido ?? partido.fecha_partido,
        estadio: estadio ?? partido.estadio,
        estado: estado ?? partido.estado
      });

      return res.json({ ok: true, message: 'SVB-GUA: Partido actualizado con éxito.', partido });
    } catch (err) {
      console.error('ERROR actualizarPartido:', err);
      return res.status(500).json({ ok: false, message: 'SVB-GUA: Error al actualizar partido.' });
    }
  },

  // Eliminar partido
  async eliminarPartido(req, res) {
    try {
      const id = Number(req.params.id);
      if (Number.isNaN(id)) return res.status(400).json({ ok: false, message: 'SVB-GUA: ID de partido inválido.' });

      const partido = await Partido.findByPk(id);
      if (!partido) return res.status(404).json({ ok: false, message: 'SVB-GUA: Partido no encontrado.' });

      await partido.destroy();
      return res.json({ ok: true, message: 'SVB-GUA: Partido eliminado correctamente.' });
    } catch (err) {
      console.error('ERROR eliminarPartido:', err);
      return res.status(500).json({ ok: false, message: 'SVB-GUA: Error al eliminar partido.' });
    }
  }
};
