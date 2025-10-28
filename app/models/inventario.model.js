module.exports = (sequelize, Sequelize) => {
  const Inventario = sequelize.define("inventario", {
    id_inventario: {
      type: Sequelize.INTEGER,
      autoIncrement: true,
      primaryKey: true
    },
    id_partido: {
      type: Sequelize.INTEGER,
      allowNull: false
    },
    id_localidad: {
      type: Sequelize.INTEGER,
      allowNull: false
    },
    cantidad_total: {
      type: Sequelize.INTEGER,
      allowNull: false
    },
    cantidad_disponible: {
      type: Sequelize.INTEGER,
      allowNull: false
    }
  }, {
    timestamps: true,
    tableName: "inventario"
  });


  Inventario.associate = (models) => {
    Inventario.belongsTo(models.partidos, {
      foreignKey: "id_partido",
      as: "partido"
    });

    Inventario.belongsTo(models.localidad, {
      foreignKey: "id_localidad",
      as: "localidad"
    });
  };
  return Inventario;
};
