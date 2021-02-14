// 찜하기 등록

$(document).ready(function () {
    const noVal = $("#review_productNo").val();
    	$(".dibs_button").click(function(e){
    		const dibs_data_json = {
    			"product_no" : noVal
    		};
        if($("#dibsIcon").hasClass("xi-gift-o")) {
            $.ajax({
                type: "post",
                data: dibs_data_json,
                url: "/dibsSuccess",
                dataType: "text",
                success: function(data){
                    alert(data);
                    if(data == "찜 목록에 추가되었습니다.") {
                        $(".dibs_button").find(".xi-gift-o").attr('class','xi-gift');
                    }
                }
            });
        } else {
            $.ajax({
                type: "post",
                data: dibs_data_json,
                url: "/dibsSuccess",
                dataType: "text",
                success: function(data){
                    alert(data);
                    if(data == "찜 목록에서 삭제되었습니다.") {
                        $(".dibs_button").find(".xi-gift").attr('class','xi-gift-o');
                    }
                }
            });
        }
    });
});