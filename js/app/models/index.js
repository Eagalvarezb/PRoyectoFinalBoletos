//  Conexión a la Base de Datos con Sequelize
const { Sequelize } = require('sequelize');
const dbConfig = require('../config/db.config.js');

// Crear la conexión a PostgreSQL (Neon)
const sequelize = new Sequelize(dbConfig.DB, dbConfig.USER, dbConfig.PASSWORD, {
  host: dbConfig.HOST,
  dialect: dbConfig.dialect,
  pool: dbConfig.pool,
  dialectOptions: {
    ssl: {
      require: true, // Neon requiere SSL
      rejectUnauthorized: false
    }
  },
  logging: false // Desactiva logs SQL innecesarios
});

// Importar modelos
const Partido = require('./partido.model.js')(sequelize, Sequelize);
const Localidad = require('./localidad.model.js')(sequelize, Sequelize);
const Inventario = require('./inventario.model.js')(sequelize, Sequelize);

// Definir relaciones
Inventario.belongsTo(Partido, { foreignKey: 'id_partido', as: 'partido' });
Inventario.belongsTo(Localidad, { foreignKey: 'id_localidad', as: 'localidad' });

// Exportar conexión y modelos
const db = {
  Sequelize,
  sequelize,
  Partido,
  Localidad,
  Inventario
};

module.exports = db;
