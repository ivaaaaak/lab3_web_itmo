class GraphDrawer {

    constructor(canvas, dotsReceiver) {
        this.ctx = canvas.getContext('2d');
        this.width = canvas.width;
        this.height = canvas.height;
        this.setR(getR());
        this.dotsReceiver = dotsReceiver;
    }

    setR(r) {
        this.R = r * 25;
        this.r = r;
    }

    drawAbscissaAxis() {
        this.ctx.strokeStyle = "black";
        this.ctx.beginPath();
        this.ctx.moveTo(0, this.height / 2);
        this.ctx.lineTo(this.width, this.height / 2);
        this.ctx.lineTo(
            this.width - 10,
            this.height / 2 - 5
        );
        this.ctx.moveTo(this.width, this.height / 2);
        this.ctx.lineTo(
            this.width - 10,
            this.height / 2 + 5
        );
        this.ctx.stroke();
    }

    drawOrdinateAxis() {
        this.ctx.strokeStyle = "black";
        this.ctx.beginPath();
        this.ctx.moveTo(this.width / 2, this.height);
        this.ctx.lineTo(this.width / 2, 0);
        this.ctx.lineTo(
            this.width / 2 - 5,
            10
        );
        this.ctx.moveTo(this.width / 2, 0);
        this.ctx.lineTo(
            this.width / 2 + 5,
            10
        );
        this.ctx.stroke();
    }

    drawAbscissaMarks() {
        this.ctx.strokeStyle = "black";
        this.ctx.fillStyle = "black";
        this.ctx.beginPath();

        this.ctx.fillText(-this.r, this.width / 2 - this.R, this.height / 2 + 15);
        this.ctx.moveTo(this.width / 2 - this.R, this.height / 2 + 4);
        this.ctx.lineTo(this.width / 2 - this.R, this.height / 2 - 4);

        this.ctx.fillText(-this.r/2, this.width / 2 - this.R / 2, this.height / 2 + 15);
        this.ctx.moveTo(this.width / 2 - this.R / 2, this.height / 2 + 4);
        this.ctx.lineTo(this.width / 2 - this.R / 2, this.height / 2 - 4);

        this.ctx.fillText(this.r/2, this.width / 2 + this.R / 2, this.height / 2 + 15);
        this.ctx.moveTo(this.width / 2 + this.R / 2, this.height / 2 + 4);
        this.ctx.lineTo(this.width / 2 + this.R / 2, this.height / 2 - 4);

        this.ctx.fillText(this.r, this.width / 2 + this.R, this.height / 2 + 15);
        this.ctx.moveTo(this.width / 2 + this.R, this.height / 2 + 4);
        this.ctx.lineTo(this.width / 2 + this.R, this.height / 2 - 4);

        this.ctx.stroke();
    }

     drawOrdinateMarks() {
         this.ctx.strokeStyle = "black";
         this.ctx.fillStyle = "black";
         this.ctx.beginPath();

         this.ctx.fillText(this.r, this.width / 2 + 15, this.height / 2 - this.R);
         this.ctx.moveTo(this.width / 2 + 4, this.height / 2 - this.R)
         this.ctx.lineTo(this.width / 2 - 4, this.height / 2 - this.R)

         this.ctx.fillText(this.r/2, this.width / 2 + 15, this.height / 2 - this.R / 2);
         this.ctx.moveTo(this.width / 2 + 4, this.height / 2 - this.R / 2)
         this.ctx.lineTo(this.width / 2 - 4, this.height / 2 - this.R / 2)

         this.ctx.fillText(-this.r, this.width / 2 + 15, this.height / 2 + this.R);
         this.ctx.moveTo(this.width / 2 + 4, this.height / 2 + this. R)
         this.ctx.lineTo(this.width / 2 - 4, this.height / 2 + this.R)

         this.ctx.fillText(-this.r/2, this.width / 2 + 15, this.height / 2 + this.R / 2);
         this.ctx.moveTo(this.width / 2 + 4, this.height / 2 + this.R / 2)
         this.ctx.lineTo(this.width / 2 - 4, this.height / 2 + this.R / 2)

         this.ctx.stroke()

    }

    drawRectangle() {
        this.ctx.fillRect(this.width/2, this.height/2 - this.R, this.R, this.R)
    }

    drawTriangle() {
        this.ctx.beginPath();
        this.ctx.moveTo(this.width / 2, this.height / 2);
        this.ctx.lineTo(this.width / 2 + this.R, this.height / 2);
        this.ctx.lineTo(this.width / 2, this.height / 2 + this.R/2);
        this.ctx.fill();
    }

    drawSector() {
        this.ctx.beginPath();
        this.ctx.arc(
            this.width / 2,
            this.height / 2,
            this.R/2,
            Math.PI / 2,
            - Math.PI,
            false
        );
        this.ctx.lineTo(this.width / 2, this.height / 2);
        this.ctx.fill();
    }

    drawAreas() {
        this.ctx.fillStyle = "pink";
        this.drawTriangle();
        this.drawSector();
        this.drawRectangle();
    }

    convertXToCanvasCoordinate(x, r, canvasR) {
        return (x / r * canvasR + this.width / 2);
    }

    convertYToCanvasCoordinate(y, r, canvasR) {
        return (-y / r * canvasR + this.height / 2);
    }

    drawDot(dot) {
        const x = this.convertXToCanvasCoordinate(dot.x, dot.r, this.R);
        const y = this.convertYToCanvasCoordinate(dot.y, dot.r, this.R);
        if (dot.hit) {
            this.ctx.fillStyle = "#110033";
        } else {
            this.ctx.fillStyle = "#E6E6FF";
        }
        this.ctx.beginPath();
        this.ctx.arc(x, y, 3, 0, Math.PI * 2);
        this.ctx.fill();
    }

    drawDots() {
        this.dotsReceiver.getDotsFromServer().then(dots => {
            dots.forEach(dot => {
                this.drawDot(dot);
            })
        });
    }

    drawGraph() {
        this.drawAreas();
        this.drawAbscissaAxis();
        this.drawAbscissaMarks();
        this.drawOrdinateAxis();
        this.drawOrdinateMarks();
        this.drawDots();
    }

    redrawGraph() {
        this.ctx.clearRect(0, 0, canvas.width, canvas.height)
        this.setR(getR());
        this.drawGraph();
    }
}
