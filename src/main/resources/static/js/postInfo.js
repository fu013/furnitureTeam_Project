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
        if($("#basketIcon").hasClass("xi-cart-o")) {
            $.ajax({
                type: "post",
                data: basket_data_json,
                url: "/basketRegister",
                dataType: "text",
                success: function (data) {
                    alert(data);
                    $("#basket_button").find(".xi-cart-o").attr('class','xi-cart');
                }
            });
        } else {
            $.ajax({
                type: "post",
                data: basket_delete_data_json,
                url: "/basketPostDelete",
                dataType: "text",
                success: function(data){
                    alert("장바구니에서 제거되었습니다.");
                    $("#basket_button").find(".xi-cart").attr('class','xi-cart-o');
                }
            });
        }
    });
});