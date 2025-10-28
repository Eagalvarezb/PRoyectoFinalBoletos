module.exports = (sequelize, Sequelize) => {
    const Venta = sequelize.define("ventas", {
        id_venta: {
            type: Sequelize.INTEGER,
            autoIncrement: true,
            primaryKey: true
        },
        id_vendedor: {
            type: Sequelize.INTEGER,
            allowNull: false
        },
        fecha_venta: {
            type: Sequelize.DATE,
            defaultValue: Sequelize.NOW
        },
        total_venta: {
            type: Sequelize.DECIMAL(10, 2),
            allowNull: false
        }
    });
    
    Venta.associate = (models) => {
        Venta.belongsTo(models.usuarios, { 
            foreignKey: 'id_vendedor', 
            as: 'vendedor' 
        });
    };


    return Venta;
};
