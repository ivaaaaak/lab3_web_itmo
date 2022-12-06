class DotsSender {

    sendDot(dot) {
        $.ajax({
            url: "./float_args",
            type: "POST",
            data: {x: dot.x, y: dot.y,  r: dot.r},
            success: function () {
                location.href = "../.."
            }
        })
    }
}
