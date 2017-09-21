$(document).ready(function () {
    // all custom jQuery will go here
    $('.message a').click(function () {
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
});