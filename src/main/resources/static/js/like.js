$(document).ready(function () {
    $(".like_button").on('click', function () {
        const post_no = $("#review_comment").val();
        const like_data_json = { "like_post_no": post_no };
        if($("#likeIcon").hasClass("xi-heart-o")) {
            $.ajax({
                type: "post",
                data: like_data_json,
                url: "/like",
                dataType: "html",
                success: function(data){
                    alert("좋아요에 등록되었습니다.");
                    $(".like_button").find(".xi-heart-o").attr('class','xi-heart');
                }
            });
        } else {
            $.ajax({
                type: "post",
                data: like_data_json,
                url: "/likeDelete",
                dataType: "html",
                success: function(data){
                    alert("좋아요가 해제되었습니다.");
                    $(".like_button").find(".xi-heart").attr('class','xi-heart-o');
                }
            });
        }
    });
});