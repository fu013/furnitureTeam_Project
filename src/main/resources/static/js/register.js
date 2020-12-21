window.onload = function() {
	// 아이디, 비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자
	var idPwJ = /^[a-z]+[a-z0-9]{5,19}$/i;
	// 이메일은 숫자, 알파벳, 대문자 가능 + @ + 영어, 숫자조합, 대문자 가능 + com들어오는 자리는 2~3자리만 가능
	var emailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 이름은 2~6자리 한글만 가능
	var nameJ = /^[가-힣]{2,6}$/;
	// 핸드폰번호는 숫자로 3~4자리만 가능
	var phoneJ = /^[0-9]{3,4}$/;

	$("#registerSuccess").on('click', function(e) {
		var id = document.getElementById("registerId");
		var pw = document.getElementById("registerPassword");
		var pw2 = document.getElementById("registerRePassword");
		var name = document.getElementById("registerName");
		var birth = document.getElementById("registerBirth");
		var gender = document.getElementById("registerGender");
		var email = document.getElementById("registerEmail");
		var phone1 = document.getElementById("registerPhone1");
		var phone2 = document.getElementById("registerPhone2");
		var phone3 = document.getElementById("registerPhone3");

		if (id.value == "") {
			alert("아이디를 입력해 주세요");
			id.focus();
			e.preventDefault;
			return false;
		}
		else if (idPwJ.test(id.value) == false) {
			alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다");
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
		else if (idPwJ.test(pw.value) == false) {
			alert("비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다");
			pw.focus();
			e.preventDefault;
			return false;
		}
		else if (pw2.value == ""){
			alert("비밀번호를 재입력해 주세요");
			pw2.focus();
			e.preventDefault;
			return false;
		}
		else if (pw.value !== pw2.value){
			alert("비밀번호가 일치하지 않습니다");
			pw2.focus();
			e.preventDefault;
			return false;
		}
		else if (name.value == ""){
			alert("이름을 입력해 주세요");
			name.focus();
			e.preventDefault;
			return false;
		}
		else if (nameJ.test(name.value) == false){
			alert("이름은 2~6자리 한글만 가능합니다");
			name.focus();
			e.preventDefault;
			return false;
		}
		else if (birth.value == ""){
			alert("생년월일을 입력해주세요");
			e.preventDefault;
			return false;
		}
		else if (email.value == ""){
			alert("이메일을 입력해 주세요");
			email.focus();
			e.preventDefault;
			return false;
		}
		else if (emailJ.test(email.value) == false){
			alert("이메일 양식에 맞게 입력해 주세요");
			email.focus();
			e.preventDefault;
			return false;
		}
		else if (phone2.value == ""){
			alert("전화번호를 입력해 주세요");
			phone2.focus();
			e.preventDefault;
			return false;
		}
		else if (phoneJ.test(phone2.value) == false){
			alert("전화번호 양식에 맞게 입력해 주세요");
			phone2.focus();
			e.preventDefault;
			return false;
		}
		else if (phone3.value == ""){
			alert("전화번호를 입력해 주세요")
			phone3.focus();
			e.preventDefault;
			return false;
		}
		else if (phoneJ.test(phone3.value) == false){
			alert("전화번호 양식에 맞게 입력해 주세요");
			phone3.focus();
			e.preventDefault;
			return false;
		}
		else {
			const formData = new FormData($('#registerForm')[0]);
			e.preventDefault();
			$.ajax({
				type: "POST",
				enctype: 'multipart/form-data',
				url: '/registerSuccess',
				data: formData,
				processData: false,
				contentType: false,
				cache: false,
				success: function(result) {
					location.href = "/";
				},
				error: function(e) {
				}
			});
		}
	})
}