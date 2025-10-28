module.exports = (sequelize, Sequelize) => {
    const DetalleVenta = sequelize.define("detalle_ventas", {
        id_detalle: {
            type: Sequelize.INTEGER,
            autoIncrement: true,
            primaryKey: true
        },
        id_venta: {
            type: Sequelize.INTEGER,
            allowNull: false
        },
        id_localidad: {
            type: Sequelize.INTEGER,
            allowNull: false
        },
        id_partido: {
            type: Sequelize.INTEGER,
            allowNull: false
        },
        cantidad: {
            type: Sequelize.INTEGER,
            allowNull: false
        },
        precio_unitario: {
            type: Sequelize.DECIMAL(10, 2),
            allowNull: false
        }
    });

    DetalleVenta.associate = (models) => {
        DetalleVenta.belongsTo(models.ventas, {
            foreignKey: "id_venta",
            as: "venta"
        });
        DetalleVenta.belongsTo(models.localidad, {
            foreignKey: "id_localidad",
            as: "localidad"
        });
        DetalleVenta.belongsTo(models.partidos, {
            foreignKey: "id_partido",
            as: "partido"
        });
    };

    return DetalleVenta;
};
