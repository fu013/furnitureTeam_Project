// 댓글등록 AJAX 요청
$(document).ready(function() {
    $("#review_button").click(function (e) {
        let currentDate = new Date();
        const product_no = $("#review_productNo").val();
        const review_comment = $("#review_comment").val();
        const review_size = $("#review_size").val();
        const review_satisfaction = $("#review_satisfaction").val();
        const review_color = $("#review_color").val();
        const review_data_json = {
            "product_no": product_no,
            "review_comment": review_comment,
            "review_satisfaction": review_satisfaction,
            "current_Date" : currentDate,
            "review_size" : review_size,
            "review_color" : review_color
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
                        <h4 class="size">상품 사이즈 : ${review_size}</h4>
                        <h4 class="color">상품 컬러 : ${review_color}</h4>
                        <p class="user_nickname">유저닉네임 : 미정 </p>
                        <p class="product_satisfaction">만족도 : ${review_satisfaction}</p>
                        <button type='button' class='fix_button'>수정</button>
                        <button type='button' class='delete_button'>삭제</button>
                        <h5 class="content">코멘트 = ${review_comment}</h5>
                        <p class='created_at'> 작성시간 : ${currentDate}</p>
                    </div>`
                )
            }
        });
    });
});