window.onload = function(){
    $("#productRegister").on('click', function(e) {
        const formData = new FormData($('#postWriterWrapperForm')[0]);
        const productName = $("#productName").val();
        const productPrice = $("#productPrice").val();
        e.preventDefault();
        if (productName == "") {
            alert("상품명을 입력해 주세요");
            productName.focus();
            e.preventDefault;
            return false;
        } else if (productPrice == "") {
            alert("상품가격을 입력해 주세요");
            productPrice.focus();
            e.preventDefault;
            return false;
        } else {
            $.ajax({
                type: "post",
                enctype: 'multipart/form-data',
                url: '/productRegister',
                data: formData,
                dataType: "text",
                processData: false,
                contentType: false,
                cache: false,
                success: function(result) {
                    if (result == '부가이미지 개수가 3개보다 많습니다.') {
                        alert(result);
                    } else {
                        alert('게시물이 성공적으로 등록되었습니다.');
                        location.href="/shop";
                    }
                },
                error: function (e) {
                }
            });
        }
    });
}