window.onload = function() {
	// 아이디, 비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자
	const pwJ = /^[a-z]+[a-z0-9]{5,19}$/i; // 알파벳 a~b 대문자가능, 숫자 0~9까지가능 특문안됨, 길이 4~12

	$("#passwordCheck").on('click', function(e) {
      const user_pw = $("#user_pw").val();
      const origin_password = document.getElementById('origin_password').value;
      const userRegisterPassword_data_json = {
         "userRegisterPassword" : user_pw
      };
      if(user_pw == '') {
          alert('비밀번호를 입력해주세요.');
          document.getElementById('user_pw').focus();
          return false;
      }

      if(pwJ.test(user_pw) == false) {
          alert('비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자로 이루어져 있어야 합니다.');
          document.getElementById('user_pw').focus();
          return false;
      }

      if(origin_password != user_pw) {
          alert('비밀번호가 기존의 비밀번호와 불일치합니다.');
          document.getElementById('origin_password').focus();
          return false;
      } else {
        $.ajax({
             type : "post",
             data : userRegisterPassword_data_json,
             url : '/passwordCheck',
             dataType : "text",
             success : function(data) {
               if(data == "패스워드가 일치하지 않습니다.") {
                   alert("패스워드를 다시 입력해주세요.");
                   return false;
               } else {
                   alert("패스워드가 일치합니다.");
                   location.href = "/myPage_UserInfoFix";
               }
             }
        });
      }
   });
}
