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

// 장바구니 등록
$(document).ready(function () {
    $("#basket_button").on('click', function () {
        const product_no = $("#review_productNo").val();
        const basket_data_json = { "basketProductNum": product_no };
        const basket_delete_data_json = { "deletePostNum": product_no };
        $.ajax({
            type: "post",
            data: basket_data_json,
            url: "/basketRegister",
            dataType: "text",
            success: function (data) {
                alert(data);
            }
        });
    });

    // 숫자 타입에서 쓸 수 있도록 format() 함수 추가
    Number.prototype.format = function(){
        if(this==0) return 0;

        var reg = /(^[+-]?\d+)(\d{3})/;
        var n = (this + '');

        while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

        return n;
    };

    // 문자열 타입에서 쓸 수 있도록 format() 함수 추가
    String.prototype.format = function(){
        var num = parseFloat(this);
        if( isNaN(num) ) return "0";

        return num.format();
    };

    const productPrice = $(".productPrice").text();
    $(".productPrice").text(productPrice.format() + "₩");
    const productPrice2 = $(".productPrice2").text();
    $(".productPrice2").text(productPrice2.format() + "₩");
});
