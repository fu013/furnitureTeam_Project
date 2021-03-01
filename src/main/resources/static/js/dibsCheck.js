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
        let isChecked = $("input:checkbox[name='dibs_item_s']:checked").val(); // 체크가 됬는지 안됬는지 알려면 뒤에 꼭! val를 붙여야한다. 체크되면 value값으로 on, 체크가 안되면 undefined를 반환하기때문이다.
        let checked_item = $("input:checkbox[name='dibs_item_s']:checked");
        if (isChecked) {
            for (let i = 0; i < $(checked_item).length; i++) {
                let selected_product_num = $(checked_item[i])
                    .parent('.inner_td')
                    .siblings(".dibs_item_num")
                    .val();
                    console.log(selected_product_num);
                let this_parent = $(checked_item[i]).parents(".dibs_product_tr");
                let deletePostNum_json = {
                    "deletePostNum": selected_product_num
                };
                $.ajax({
                    type: "post",
                    data: deletePostNum_json,
                    url: "/dibsPostDelete",
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
    $(".basket_button").on('click', function () {
        const product_no = $(this).parents(".basket_button_td").siblings(".dibs_item_num").val();
        const basket_data_json = { "basketProductNum": product_no };
        $.ajax({
            type: "post",
            data: basket_data_json,
            url: "/basketRegister",
            dataType: "text",
            success: function (data) {
                alert(data);
            }
        });
    });
});