module.exports = app => {
    const ventas = require("../controllers/venta.controller.js");
    var router = require("express").Router();

    router.post("/", ventas.create);
    router.get("/", ventas.findAll);
    router.get("/:id", ventas.findOne);
    router.put("/:id", ventas.update);
    router.delete("/:id", ventas.delete);

    app.use("/api/venta", router);
};
