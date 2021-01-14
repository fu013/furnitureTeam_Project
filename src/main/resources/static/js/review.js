// 댓글등록 AJAX 요청
$(document).ready(function() {
    $("#review_button").click(function (e) {
        let currentDate = new Date();
        const product_no = $("#review_productNo").val();
        const review_comment = $("#review_productName").val();
        const review_satisfaction = $("#review_productName").val();
        const review_data_json = {
            "product_no": product_no,
            "review_comment": review_comment,
            "review_satisfaction": review_satisfaction
        };
        $.ajax({
            type: "post",
            data: review_data_json,
            url: "/postReviewInfo",
            dataType: "json",
            success: function (data) {
                console.log(data);
                $(".review_spot").append(
                    `<div class="simple_review">
                        <p class="product_no">상품번호 : ${product_no}</p>
                        <p class="product_name">상품이름 : ${review_comment}</p>
                        <p class="product_satisfaction">상품만족도 : ${review_satisfaction}</p>
                        <p class='created_at'> 작성시간 : ${currentDate}</p>
                    </div>`
                )
            }
        });
    });
});