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
            const review_color = $("#review_color").val();
            const review_reason = $("#review_reason").val();
            const review_nickname = $("#review_nickname").val();
            let review_satisfaction = $(":input:radio[name=review_satisfaction]:checked").val();
            var starRepeat = '';
            for (let i = 0; i < review_satisfaction; i++) {
                starRepeat +=
                `<span style="margin-right: 2px;">
                    <i class="fa fa-star" aria-hidden="true"></i>
                </span>`;
            }
            const review_data_json = {
                "product_no": product_no,
                "review_comment": review_comment,
                "review_satisfaction": review_satisfaction,
                "current_Date" : currentDate,
                "review_size" : review_size,
                "review_color" : review_color,
                "review_reason" : review_reason,
                "review_userNickname" : review_nickname
            };
            $.ajax({
                type: "post",
                data: review_data_json,
                url: "/postReviewInfo",
                dataType: "json",
                success: function (data) {
                    $(".review_spot").append(
                        `
                        <div class="single_user_review mb-15">
                            <div class="review-rating">
                                ${starRepeat}
                                <span>for ${review_reason}</span>
                            </div>
                            <p style="margin: 5px 0;">${review_comment}</p>
                            <button type='button' class='btn btn-primary fix_button smallBtn'>수정</button>
                            <button type='button' class='btn btn-primary delete_button smallBtn'>삭제</button>
                            <div class="review-details">
                                <p>by ${review_nickname} on <span>${currentDate}</span></p>
                            </div>
                        </div>
                        `
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
            $(this).before(`<textarea class="form-control fix_comment" id="comment_fix" style="width: 30%; height: 100px; margin-bottom: 10px;" placeholder='수정할 내용을 150자 이내로 입력해주세요.'></textarea>`);
            $(this).after(`<button type="button" class="btn btn-primary fix_register smallBtn">등록</button>`);
            $(this).after(`<button type="button" class="btn btn-primary cancel_fix smallBtn" style="margin-right: 4px;">취소</button>`);
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
            $(this).after(`<button type="button" class="btn btn-primary real_delete_button smallBtn" id="delete_real_button">삭제확인</button>`);
            $(this).after(`<button type="button" class="btn btn-primary cancel_delete smallBtn" style="margin-right: 4px;">취소</button>`);
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