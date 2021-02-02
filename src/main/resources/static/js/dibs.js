// 찜하기 등록
$(document).ready(function(){
    const noVal = $("#review_productNo").val();
	$(".dibs_button").click(function(e){
		const dibs_data_json = {
			"product_no" : noVal
		};
		
		$.ajax({
			type : "post",
			data : dibs_data_json,
			url : "/dibsSuccess",
			dataType : "text",
			success : function(data) {
			    alert(data);
			}
		});
	});
});