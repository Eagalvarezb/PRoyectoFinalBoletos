
module.exports = (sequelize, DataTypes) => {
  const Partido = sequelize.define('Partido', {
    id_partido: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    equipo_visitante: {
      type: DataTypes.STRING(100),
      allowNull: false
    },
    equipo_local: {
      type: DataTypes.STRING(100),
      allowNull: false
    },
    fecha_partido: {
      type: DataTypes.DATE,
      allowNull: false
    },
    estadio: {
      type: DataTypes.STRING(100),
      allowNull: false
    },
    estado: {
      type: DataTypes.STRING(20),
      allowNull: false,
      defaultValue: 'programado', // programado | activo | finalizado
      validate: {
        isIn: [['programado', 'activo', 'finalizado']]
      }
    },
    creado_en: {
      type: DataTypes.DATE,
      allowNull: false,
      defaultValue: DataTypes.NOW
    }
  }, {
    tableName: 'partidos',
    timestamps: false // use creado_en en vez de createdAt
  });

  return Partido;
};
