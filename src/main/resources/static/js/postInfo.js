$(document).ready(function () {
    $(".tabContent").on("click", function (e) {
        e.preventDefault();
        $("body, html").animate({
            scrollTop: $('.targetInfo')
                .offset()
                .top - 300
        }, 300);
    });

    $(".tabReview").on("click", function (e) {
        e.preventDefault();
        $("body, html").animate({
            scrollTop: $('.targetReview')
                .offset()
                .top - 300
        }, 300);
    });
});