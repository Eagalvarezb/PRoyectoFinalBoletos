const fs = require("fs");
const path = require("path");

module.exports = (app) => {
    const routesPath = __dirname;

    fs.readdirSync(routesPath).forEach(file => {
        if (file.endsWith(".routes.js")) {
            const route = require(path.join(routesPath, file));
            if (typeof route === "function") {
                route(app);
                console.log(`Ruta cargada: ${file}`);
            }
        }
    });
};
