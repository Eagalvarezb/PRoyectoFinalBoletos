module.exports = app => {
    const detalles = require("../controllers/detalle_venta.controller.js");
    const router = require("express").Router();

    router.post("/", detalles.create);
    router.get("/", detalles.findAll);
    router.get("/:id", detalles.findOne);
    router.put("/:id", detalles.update);
    router.delete("/:id", detalles.delete);

    app.use("/api/detalle_venta", router);
};
