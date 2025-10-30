module.exports = app => {
    const router = require("express").Router();
    const partido = require("../controllers/partido.controller");

    router.post("/", partido.create);
    router.get("/", partido.findAll);
    router.get("/:id", partido.findOne);
    router.put("/:id", partido.update);
    router.delete("/:id", partido.delete);

    app.use("/api/partidos", router);
};
