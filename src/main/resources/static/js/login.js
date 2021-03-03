// 로그인 AJAX 요청
$(document).ready(function() {
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
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '895240771293343',
      cookie     : true,
      xfbml      : true,
      version    : 'v10.0'
    });

    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
});