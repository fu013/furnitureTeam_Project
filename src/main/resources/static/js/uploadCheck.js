$(document).ready(function () {
    // 전체선택
    $('.all_item_select').on('click', function () {
        $(".inner_checkbox").prop('checked', true);
        alert('전체 체크');
    });
    // 전체선택 헤제
    $('.all_item_deselect').on('click', function () {
        $(".inner_checkbox").prop('checked', false);
        alert('전체 체크해제');
    });

    $(".selected_item_delete").on('click', function () {
        let isChecked = $("input:checkbox[name='upload_item_s']:checked").val(); // 체크가 됬는지 안됬는지 알려면 뒤에 꼭! val를 붙여야한다. 체크되면 value값으로 on, 체크가 안되면 undefined를 반환하기때문이다.
        let checked_item = $("input:checkbox[name='upload_item_s']:checked");
        if (isChecked) {
            for (let i = 0; i < $(checked_item).length; i++) {
                let selected_product_num = $(checked_item[i])
                    .parent('.inner_td')
                    .siblings(".upload_item_num")
                    .val();
                let selected_product_name = $(checked_item[i])
                    .parent('.inner_td')
                    .siblings(".upload_product_name")
                    .val();
                let this_parent = $(checked_item[i]).parents(".upload_product_tr");
                let deletePostNum_json = {
                    "deletePostNum": selected_product_num,
                    "productName": selected_product_name
                };
                $.ajax({
                    type: "post",
                    data: deletePostNum_json,
                    url: "/uploadPostDelete",
                    dataType: "html",
                    success: function (data) {
                        this_parent.hide();
                    }
                });
            }
            alert('선택한 상품이 삭제 되었습니다.');
        } else {
            alert('상품을 먼저 선택해주세요.');
            return false;
        }
    });
    $(document).on("click", ".fix_button", function(){
        $(this).hide();
        $(this).parents('.fix_button_td').siblings(".product_price_td").find(".product_price").css("display", "none");
        $(this).parents('.fix_button_td').siblings(".product_price_td").find(".fix_product_price").css("display", "block");
        $(this).parents('.fix_button_td').siblings(".product_size_td").find(".product_size").css("display", "none");
        $(this).parents('.fix_button_td').siblings(".product_size_td").find(".fix_product_size").css("display", "block");
        $(this).parents('.fix_button_td').siblings(".product_size_td").find(".fix_product_size").siblings(".nice-select").css("display", "none");
        $(this).parents('.fix_button_td').siblings(".product_name_td").find(".product_name").css("display", "none");
        $(this).parents('.fix_button_td').siblings(".product_name_td").find(".fix_product_name").css("display", "block");
        $(this).parents('.fix_button_td').siblings(".product_color_td").find(".product_color").css("display", "none");
        $(this).parents('.fix_button_td').siblings(".product_color_td").find(".fix_product_color").css("display", "block");
        $(this).parents('.fix_button_td').siblings(".product_color_td").find(".product_color").siblings(".nice-select").css("display", "none");
        $(this).after(`<button type="button" class="btn btn-primary fix_register smallBtn">등록</button>`);
        $(this).after(`<button type="button" class="btn btn-primary cancel_fix smallBtn" style="margin-right: 4px;">취소</button>`);

        // 업로드한 게시물: 수정-등록
        $(document).on("click", ".fix_register", function(){
            const product_no = $(this).parents('.fix_button_td').siblings(".upload_item_num").val();
            const productPrice = $(this).parents('.fix_button_td').siblings(".product_price_td").find(".fix_product_price").val();
            const productSize = $(this).parents('.fix_button_td').siblings(".product_size_td").find(".fix_product_size").val();
            const productName = $(this).parents('.fix_button_td').siblings(".product_name_td").find(".fix_product_name").val();
            const productColor = $(this).parents('.fix_button_td').siblings(".product_color_td").find(".fix_product_color").val();
            const fixedPost_json = { "productPrice":productPrice, "productSize":productSize, "productName":productName, "productColor":productColor, "product_no":product_no };
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
                   data: fixedPost_json,
                   url: "/uploadPostFixed",
                   dataType: "text",
                   success:function(data){
                       if (data = "게시물이 성공적으로 수정되었습니다.") {
                           alert("게시물이 성공적으로 수정되었습니다.");
                           location.href = "/myPage_UploadPost";
                       } else {
                           alert("게시물 수정이 실패했습니다.");
                       }
                   }
                });
            }
        });
        // 업로드한 게시물: 수정-취소
        $(document).on("click", ".cancel_fix", function(){
            $(this).hide();
            $(this).parents('.fix_button_td').siblings(".product_price_td").find(".product_price").css("display", "block");
            $(this).parents('.fix_button_td').siblings(".product_price_td").find(".fix_product_price").css("display", "none");
            $(this).parents('.fix_button_td').siblings(".product_size_td").find(".product_size").css("display", "block");
            $(this).parents('.fix_button_td').siblings(".product_size_td").find(".fix_product_size").css("display", "none");
            $(this).parents('.fix_button_td').siblings(".product_name_td").find(".product_name").css("display", "block");
            $(this).parents('.fix_button_td').siblings(".product_name_td").find(".fix_product_name").css("display", "none");
            $(this).parents('.fix_button_td').siblings(".product_color_td").find(".product_color").css("display", "block");
            $(this).parents('.fix_button_td').siblings(".product_color_td").find(".fix_product_color").css("display", "none");
            $(this).siblings('.fix_register').hide();
            $(this).siblings('.fix_button').show();
        });
    });
});