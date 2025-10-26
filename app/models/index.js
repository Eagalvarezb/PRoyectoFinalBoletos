const dbConfig = require("../config/db.config");
const Sequelize = require("sequelize");

const sequelize = new Sequelize(dbConfig.DB, dbConfig.USER, dbConfig.PASSWORD, {
    host: dbConfig.HOST,
    dialect: dbConfig.dialect,
    dialectOptions: {
        ssl: { require: true, rejectUnauthorized: false }
    },
    pool: {
        max: dbConfig.pool.max,
        min: dbConfig.pool.min,
        acquire: dbConfig.pool.acquire,
        idle: dbConfig.pool.idle
    }
});

const db = {};
db.Sequelize = Sequelize;
db.sequelize = sequelize;

// Modelos
db.detalle_ventas = require("./detalle_venta.model.js")(sequelize, Sequelize);
db.inventario = require("./inventario.model.js")(sequelize, Sequelize);
db.localidad = require("./localidad.model.js")(sequelize, Sequelize);
db.partidos = require("./partido.model.js")(sequelize, Sequelize);
db.usuarios = require("./usuario.model.js")(sequelize, Sequelize);
db.ventas = require("./venta.model.js")(sequelize, Sequelize);

// Relaciones
db.ventas.hasMany(db.detalle_ventas, { foreignKey: "id_venta" });
db.detalle_ventas.belongsTo(db.ventas, { foreignKey: "id_venta" });

db.localidad.hasMany(db.detalle_ventas, { foreignKey: "id_localidad", as: "detalle_ventas" });
db.detalle_ventas.belongsTo(db.localidad, { foreignKey: "id_localidad", as: "localidad" });

db.localidad.hasMany(db.inventario, { foreignKey: "id_localidad", as: "inventarios" });
db.inventario.belongsTo(db.localidad, { foreignKey: "id_localidad", as: "localidad" });

db.partidos.hasMany(db.detalle_ventas, { foreignKey: "id_partido" });
db.detalle_ventas.belongsTo(db.partidos, { foreignKey: "id_partido" });

module.exports = db;
