module.exports = (sequelize, Sequelize) => {
  const Localidad = sequelize.define("localidad", {
    id_localidad: {
      type: Sequelize.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    nombre_localidad: {
      type: Sequelize.STRING,
      allowNull: false
    },
    direccion: {
      type: Sequelize.STRING,
      allowNull: false
    },
    capacidad: {
      type: Sequelize.INTEGER,
      allowNull: false
    }
  }, {
    timestamps: true,
    tableName: "localidad"
  });

  Localidad.associate = (models) => {
    Localidad.hasMany(models.inventario_boletos, {
      foreignKey: "id_localidad",
      as: "inventario"
    });
  };

  return Localidad;
};
