window.onload = function(){
    var emailCheckJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

   $("#registerSuccess").on('click', function(e) {
      var id = document.getElementById("registerId");
      var pw = document.getElementById("registerPassword");
      var pw2 = document.getElementById("registerRePassword");
      var name = document.getElementById("registerName");
      var birth = document.getElementById("registerBirth");
      var gender = document.getElementById("registerGender");
      var email = document.getElementById("registerEmail");
      var phone = document.getElementById("registerPhone");

      if(phone.value == "") {
         alert("전화번호를 입력해 주세요");
         phone.focus();
         e.preventDefault;
         return false;
      } else {
         const formData = new FormData($('#registerForm')[0]);
         e.preventDefault();
         $.ajax({
            type : "POST",
            enctype : 'multipart/form-data',
            url : '/registerSuccess',
            data : formData,
            processData : false,
            contentType : false,
            cache : false,
            success : function (result) {
               location.href = "/";
            },
            error : function(e) {
            }
         });
      }
   })
}