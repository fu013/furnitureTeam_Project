window.onload = function() {
	// 아이디, 비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자
	var idPwJ = /^[a-z]+[a-z0-9]{5,19}$/i;
	// 이메일은 숫자, 알파벳, 대문자 가능 + @ + 영어, 숫자조합, 대문자 가능 + com들어오는 자리는 2~3자리만 가능
	var emailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	// 이름은 2~6자리 한글만 가능
	var nameJ = /^[가-힣]{2,6}$/;
	// 핸드폰번호는 숫자로 3~4자리만 가능
	var phoneJ = /^[0-9]{3,4}$/;

    // 아이디 중복확인 버튼 js -> 공백, 유효성 검사 후 json요청
	$("#idOverlap").on('click', function(e) {
              const idVal = $("#userRegisterId").val();
              const idOverlap_data_json = {
                 "idOverlapCheck" : idVal
              };
              if (idVal == "") {
                alert("아이디를 입력해주세요");
                e.preventDefault;
                return false;
              } else if (idPwJ.test(idVal) == false) {
    			alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다");
    			e.preventDefault;
    			return false;
              } else {
                $.ajax({
                     type : "post",
                     data : idOverlap_data_json,
                     url : '/idOverlapCheck',
                     dataType : "text",
                     success : function(data) {
                        alert(data);
                        if(data == "이 아이디는 사용가능합니다."){
                            $("input[name='checkedId']").val('Y');
                        }
                        else {
                            $("input[name='checkedId']").val('');
                        }
                     }
                });
              }
           });

    // 이메일 중복확인 버튼 js -> 공백, 유효성 검사 후 json요청
     $("#emailOverlap").on('click', function(e){
            const emailVal = $("#userRegisterEmail").val();
            const emailOverlap_data_json = {
                "emailOverlapCheck" : emailVal
            };
            if (emailVal == "") {
                alert("이메일을 입력해 주세요");
                e.preventDefault;
                return false;
            } else if (emailJ.test(emailVal) == false) {
                alert("이메일 양식에 맞게 입력해 주세요");
                e.preventDefault;
                return false;
            } else {
                $.ajax({
                    type : "post",
                    data : emailOverlap_data_json,
                    url : '/emailOverlapCheck',
                    dataType : "text",
                    success : function(data) {
                        alert(data);
                        if(data == "이 이메일은 사용가능합니다."){
                            $("input[name='checkedEmail']").val('Y');
                        }
                        else {
                            $("input[name='checkedEmail']").val('');
                        }
                    }
                })
            }
     })

    // 회원가입 버튼을 누르면 유효성 검사 후 formData로 요청
	$("#userRegisterSuccess").on('click', function(e) {
		var id = document.getElementById("userRegisterId");
		var pw = document.getElementById("userRegisterPassword");
		var pw2 = document.getElementById("userRegisterRePassword");
		var name = document.getElementById("userRegisterName");
		var birth = document.getElementById("userRegisterBirth");
		var gender = document.getElementById("userRegisterGender");
		var email = document.getElementById("userRegisterEmail");
		var phone1 = document.getElementById("userRegisterPhone1");
		var phone2 = document.getElementById("userRegisterPhone2");
		var phone3 = document.getElementById("userRegisterPhone3");

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
		else if ($("input[name='checkedId']").val()=="") {
		    alert("아이디 중복 확인을 해주세요");
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
		else if($("input[name='checkedEmail']").val()=="") {
		    alert("이메일 중복 확인을 해주세요");
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
			const formData = new FormData($('#userRegisterForm')[0]);
			e.preventDefault();
			$.ajax({
				type: "POST",
				enctype: 'multipart/form-data',
				url: '/userRegisterSuccess',
				data: formData,
				processData: false,
				contentType: false,
				cache: false,
				success: function(result) {
					alert("회원가입을 축하합니다");
					location.href = "/";
				},
				error: function(e) {
				}
			});
		}
	})
}
