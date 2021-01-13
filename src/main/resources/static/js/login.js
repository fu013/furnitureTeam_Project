window.onload = function(){
	$("#loginSuccess").on('click', function(e) {
		var id = document.getElementById("loginId");
		var pw = document.getElementById("loginPassword");
		
		if (id.value == "") {
			alert("아이디를 입력해 주세요");
			id.focus();
			e.preventDefault;
			return false;
		}
		else if (pw.value == "") {
			alert("비밀번호를 입력해 주세요");
			pw.focus();
			e.preventDefault;
			return false;
		}
		else {
			const formData = new FormData($('#loginForm')[0]);
			e.preventDefault();
			$.ajax({
				type : "POST",
				enctype : 'multipart/form-data',
				url : '/loginSuccess',
				data : formData,
				processData : false,
				contentType : false,
				chche : false,
				success : function(result) {
					location.href = "/";
				},
				error : function(e) {
				}
			});
		}
	});
}