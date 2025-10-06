const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
const PORT = process.env.PORT || 8081;

var corsOptions = {
    origin : `http://localhost:${PORT}`
};

app.use(cors(corsOptions));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

const db = require("./app/models");

db.sequelize.sync().then(() => {
    console.log("Database synced.");

    require("./app/routes/loadRoutes.js")(app);

    app.get("/", (req, res) => {
        res.json({ message: "UMG Application" });
    });

    app.use((req, res) => {
        res.status(404).json({ error: "Ruta no encontrada" });
    });

    app.listen(PORT, () => {
        console.log(`Server is running on port ${PORT}.`);
    });
}).catch(err => {
    console.error("Failed to sync database:", err.message);
});
