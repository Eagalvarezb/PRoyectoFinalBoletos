module.exports = (sequelize, Sequelize) => {
  const Inventario = sequelize.define("inventario", {
    id_inventario: {
      type: Sequelize.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    nombre_producto: {
      type: Sequelize.STRING,
      allowNull: false
    },
    cantidad: {
      type: Sequelize.INTEGER,
      allowNull: false
    },
    precio_unitario: {
      type: Sequelize.FLOAT,
      allowNull: false
    },
    fecha_ingreso: {
      type: Sequelize.DATE,
      allowNull: false
    }
  });

  return Inventario;
};
