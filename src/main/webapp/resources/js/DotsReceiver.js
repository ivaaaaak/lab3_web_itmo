class DotsReceiver {

    getDotsFromServer() {
        return new Promise(function (resolve) {
            $.ajax({
                url: "./controller?pointsFlag=1",
                method: "GET",
                success: function (dots) {
                    resolve(JSON.parse(dots));
                }
            });
        })
    }
}
