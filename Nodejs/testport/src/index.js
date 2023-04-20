const PORT = 2812;
const http = require("http");
const fs = require("fs");
const path = require("path");
const server = http.createServer((request, response) => {
    const url = request.url;
    const method = request.method;
    if (url === "/") {
        // response.write(fs.readFileSync(path.resolve(__dirname, "./views/HomePage.html")).toString());
        return response.end();
    }
    // response.write(fs.readFileSync(path.resolve(__dirname, "./views/ErrorPage.html")).toString());
    return response.end();
})

server.listen(PORT, () => {
    console.log("Server run in " + PORT);
})