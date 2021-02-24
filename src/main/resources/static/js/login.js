// 로그인 AJAX 요청
$(document).ready(function() {
    // 로그인 버튼을 누르면 공백인지 검사 후 json요청
	$("#loginSuccess").on('click', function (e) {
		const idVal = $("#loginId").val();
		const pwVal = $("#loginPassword").val();
		const login_data_json = {
            "userRegisterId": idVal,
            "userRegisterPassword": pwVal
        };
		if (idVal == "") {
			alert("아이디를 입력해 주세요");
			id.focus();
			e.preventDefault;
			return false;
		} else if (pwVal == "") {
			alert("비밀번호를 입력해 주세요");
			pw.focus();
			e.preventDefault;
			return false;
		} else {
			$.ajax({
				type: "post",
                data: login_data_json,
				url : '/loginSuccess',
                dataType: "text",
				success: function(data) {
                    location.href = "/";
                    alert(data);
                }
			});
		}
	});
});