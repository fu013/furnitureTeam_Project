// 댓글 등록
$(document).ready(function() {
    $("#review_button").click(function (e) {
        const review_comment = $("#review_comment").val();
        if (!review_comment) {
            alert("내용을 입력해주세요.");
        } else {
            let currentDate = new Date();
            const product_no = $("#review_productNo").val();
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
        }
    });
});

// 댓글 수정 & 삭제
$(document).ready(function() {
    $(document).on("click", ".fix_button", function(){
        let comment = $(this).siblings('.fix_comment').val();
        if (comment) {
            $(this).siblings('.delete_button').hide();
            $(this).siblings('.fix_comment').show();
            $(this).siblings('.fix_register').show();
            $(this).siblings('.cancel_fix').show();
        } else {
            $(this).hide();
            $(this).siblings('.delete_button').hide();
            $(this).before(`<textarea class="fix_comment" id="comment_fix" style="width: 80%; height: 100px; margin-left: 20px;" placeholder='수정할 내용을 입력하세요.'></textarea>`);
            $(this).after(`<button type="button" class="fix_register">등록</button>`);
            $(this).after(`<button type="button" class="cancel_fix">취소</button>`);
        }

        // 댓글: 수정-등록
        $(document).on("click", ".fix_register", function(){
            const comment_no = $(this).siblings(".comment_no").val(); // 코멘트 넘버
            let fixed_review = $(this).siblings(".fix_comment").val(); // 수정할 내용
            let AjaxFixedReview = $(this).siblings('.content'); // 댓글을 수정할 텍스트 에이리어 영역
            const fixedReview_json = { "fix_comment_no":comment_no, "fixed_review_comment":fixed_review };
            $.ajax({
               type: "post",
               data: fixedReview_json,
               url: "/postReviewInfoFix",
               dataType: "text",
               success:function(data){
                   AjaxFixedReview.text(`수정된 댓글 : ${fixed_review}`);
                   alert("댓글이 수정 되었습니다.");
               }
            });
        });

        // 댓글: 수정-취소
        $(document).on("click", ".cancel_fix", function(){
            $(this).hide();
            $(this).siblings('.fix_comment').hide();
            $(this).siblings('.fix_register').hide();
            $(this).siblings('.delete_button').show();
            $(this).siblings('.fix_button').show();
        });
    });

    // 댓글: 삭제-활성화 1
    $(document).on("click", ".delete_button", function(){
        let delete_real = $(this).siblings('.real_delete_button').val();
        if(delete_real) {
            $(this).hide();
            $(this).siblings('.cancel_delete').show();
            $(this).siblings('.fix_button').hide();
            $(this).siblings('.real_delete_button').show();
        } else {
            $(this).hide();
            $(this).siblings('.fix_button').hide();
            $(this).after(`<button type="button" class="cancel_delete">취소</button>`);
            $(this).after(`<button type="button" class="real_delete_button" id="delete_real_button">삭제확인</button>`);
        } // 댓글: 삭제-확인
        $(document).on("click", ".real_delete_button", function(){
            $(this).parents('.simple_review').hide();
            const comment_no = $(this).siblings(".comment_no").val(); // 코멘트 넘버
            const deleteReview_json = { "delete_comment_no":comment_no };
            $.ajax({
               type: "post",
               data: deleteReview_json,
               url: "/postReviewInfoDelete",
               dataType: "text",
               success:function(data){
                   alert(data);
               }
            });
        });
        $(document).on("click", ".cancel_delete", function(){
            $(this).hide();
            $(this).siblings('.real_delete_button').hide();
            $(this).siblings('.delete_button').show();
            $(this).siblings('.fix_button').show();
        });
    });
});