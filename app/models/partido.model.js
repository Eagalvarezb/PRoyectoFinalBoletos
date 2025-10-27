module.exports = (sequelize, Sequelize) => {
    const Partido = sequelize.define("partidos", {
        id_partido: {
            type: Sequelize.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        equipo_local: {
            type: Sequelize.STRING,
            allowNull: false
        },
        equipo_visitante: {
            type: Sequelize.STRING,
            allowNull: false
        },
        fecha_partido: {
            type: Sequelize.DATE,
            allowNull: false
        },
        estadio: {
            type: Sequelize.STRING,
            allowNull: false
        },
        estado: {
            type: Sequelize.STRING,
            allowNull: false
        }
    }, {
        timestamps: true,
        tableName: "partidos"
        });

    Partido.associate = (models) => {
    Partido.hasMany(models.inventario_boletos, {
        foreignKey: "id_partido",
        as: "inventario"
    });
    };

return Partido;
};
