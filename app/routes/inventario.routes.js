
module.exports = app => {
    const inventario = require("../controllers/inventario.controller.js");
    var router = require("express").Router();

    router.post("/", inventario.create);
    router.get("/", inventario.findAll);
    router.get("/:id", inventario.findOne);
    router.put("/:id", inventario.update);
    router.delete("/:id", inventario.delete);

    app.use("/api/inventarios", router);
};

