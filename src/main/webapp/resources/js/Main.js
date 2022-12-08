const canvas = document.getElementById("graph");

function getR() {
    const form = document.getElementById("form");
    const formData = new FormData(form);
    return parseFloat(formData.get('form:r_input'));
}

const drawer = new GraphDrawer(canvas);
drawer.drawGraph();

function convertX(x) {
    return ((x - drawer.width / 2) / 25);
}

function convertY(y) {
    return (-(y - drawer.height / 2) / 25);
}

canvas.onmousedown = function (event) {
    const r = getR();
    const x = convertX(event.offsetX);
    const y = convertY(event.offsetY);
    addPoint(
        [
            {
                name: "x",
                value: x.toString()
            },
            {
                name: "y",
                value: y.toString()
            },
            {
                name: "r",
                value: r.toString()
            }
        ]
    );
};





