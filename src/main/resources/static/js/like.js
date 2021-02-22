$(document).ready(function () {
    $(".like_button").on('click', function () {
        const post_no = $("#review_productNo").val();
        const like_data_json = { "product_no": post_no };
        if($("#likeIcon").hasClass("xi-heart-o")) {
            $.ajax({
                type: "post",
                data: like_data_json,
                url: "/like",
                dataType: "text",
                success: function(data){
                    alert(data);
                    if(data == "좋아요가 등록되었습니다.") {
                        $(".like_button").find(".xi-heart-o").attr('class','xi-heart');
                    }
                }
            });
        } else {
            $.ajax({
                type: "post",
                data: like_data_json,
                url: "/like",
                dataType: "text",
                success: function(data){
                    alert(data);
                    if(data == "좋아요에서 삭제되었습니다.") {
                        $(".like_button").find(".xi-heart").attr('class','xi-heart-o');
                    }
                }
            });
        }
    });
});