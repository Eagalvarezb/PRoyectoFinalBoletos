module.exports = app => {
    const router = require("express").Router();
    const localidad = require("../controllers/localidad.controller");

    router.post("/", localidad.create);
    router.get("/", localidad.findAll);
    router.get("/:id", localidad.findOne);
    router.put("/:id", localidad.update);
    router.delete("/:id", localidad.delete);

    app.use("/api/localidades", router);
};
