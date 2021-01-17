<<<<<<< HEAD
// 로그인 AJAX 요청
=======
>>>>>>> 70e244beb6ab58e2d28f04335c231ac8275930a6
$(document).ready(function() {
	$("#loginSuccess").on('click', function (e) {
		const id = document.getElementById("loginId");
		const pw = document.getElementById("loginPassword");
		const idVal = $("#loginId").val();
		const pwVal = $("#loginPassword").val();
		const login_data_json = {
            "userRegisterId": idVal,
            "userRegisterPassword": pwVal
        };
		if (id.value == "") {
			alert("아이디를 입력해 주세요");
			id.focus();
			e.preventDefault;
			return false;
		} else if (pw.value == "") {
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
                    alert("로그인에 성공했습니다.");
                }, error: function(e) {
                    alert("로그인에 실패했습니다.");
                }
			});
		}
	});
});