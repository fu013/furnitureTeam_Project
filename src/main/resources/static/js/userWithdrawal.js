$(".user_withdrawal_button").on('click', function () {
    let delete_user_id = document.getElementById('delete_user_id').value;
      const user_id_data_json = {
          "userRegisterId":delete_user_id
        };
        $.ajax({
        type: "post",
        data: user_id_data_json,
        url: "/userWithdrawal",
        dataType: "text",
        success: function(data) {
            alert(data);
            location.href = '/logout';
        }
    });
});