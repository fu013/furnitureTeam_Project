window.onload = function(){
    $("#productRegister").on('click', function(e) {
        const formData = new FormData($('#postWriterWrapperForm')[0]);
        e.preventDefault();
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: '/productRegister',
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function (result) {
                location.href="/shop";
            },
            error: function (e) {
           }
        });
    });
}