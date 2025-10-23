module.exports = app => {
    
    const Login = require("../controllers/login.controller.js");
    var router = require("express").Router();

    router.post("/login", Login.create);
   
    app.use("/api/Login", router);
};