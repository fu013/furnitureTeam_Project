$(document).ready(function() {
	// 아이디, 비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자
	var idPwJ = /^[a-z]+[a-z0-9]{5,19}$/i;

    // 아이디 찾기
    $("#findUserId").on('click', function(e) {
        const nameVal = $("#findUserIdName").val();
        const emailVal = $("#findUserIdEmail").val();
        const phone1Val = $("#findUserIdPhone1").val();
        const phone2Val = $("#findUserIdPhone2").val();
        const phone3Val = $("#findUserIdPhone3").val();
        const findId_data_json = {
            "userRegisterName" : nameVal,
            "userRegisterEmail" : emailVal,
            "userRegisterPhone1" : phone1Val,
            "userRegisterPhone2" : phone2Val,
            "userRegisterPhone3" : phone3Val
        };
        if (nameVal == ""){
            alert("이름을 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (emailVal == ""){
            alert("이메일을 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (phone2Val == "") {
            alert("전화번호를 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (phone3Val == "") {
            alert("전화번호를 입력해 주세요");
            e.preventDefault;
            return false;
        } else {
            $.ajax({
                type: "post",
                data: findId_data_json,
                url: '/findUserId',
                dataType: "text",
                success: function(data) {
                    alert(data);
                }
            })
        }
    })

    // 비밀번호 찾기
    $("#findUserPassword").on('click', function(e) {
        const idVal = $("#findUserPasswordId").val();
        const nameVal = $("#findUserPasswordName").val();
        const emailVal = $("#findUserPasswordEmail").val();
        const phone1Val = $("#findUserPasswordPhone1").val();
        const phone2Val = $("#findUserPasswordPhone2").val();
        const phone3Val = $("#findUserPasswordPhone3").val();
        const findPassword_data_json = {
            "userRegisterId" : idVal,
            "userRegisterName" : nameVal,
            "userRegisterEmail" : emailVal,
            "userRegisterPhone1" : phone1Val,
            "userRegisterPhone2" : phone2Val,
            "userRegisterPhone3" : phone3Val
        };
        if (idVal == "") {
            alert("아이디를 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (nameVal == "") {
            alert("이름을 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (emailVal == "") {
            alert("이메일을 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (phone2Val == "" || phone2Val == null) {
            alert("전화번호를 입력해 주세요");
            e.preventDefault;
            return false;
        } else if (phone3Val == "") {
            alert("전화번호를 입력해주세요");
            e.preventDefault;
            return false;
        } else {
            $.ajax({
                type: "post",
                data: findPassword_data_json,
                url: '/findUserPassword',
                dataType: "text",
                success: function(data){
                    alert(data);
                    if(data == "회원님의 정보가 일치합니다."){
                        location.href = "modifyUserPassword";
                    }
                },
                error: function(e){
                }
            })
        }
    })

    // 비밀번호 수정
    $("#modifySuccess").on('click', function(e){
        const passwordVal = $("#modifyPassword").val();
        const passwordReVal = $("#modifyRePassword").val();
        const modifyPassword_data_json = {
            "userRegisterPassword" : passwordVal,
            "userRegisterRePassword" : passwordReVal
        };
        if(passwordVal == ""){
            alert("사용할 비밀번호를 입력해주세요.");
            e.preventDefault;
            return false;
        } else if(idPwJ.test(passwordVal) == false){
            alert("비밀번호는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다");
            e.preventDefault;
            return false;
        } else if(passwordReVal == ""){
            alert("비밀번호를 재입력해 주세요.");
            e.preventDefault;
            return false;
        } else if(passwordVal !== passwordReVal){
            alert("비밀번호가 일치하지 않습니다.");
            e.preventDefault;
            return false;
        } $.ajax({
            type: "post",
            data: modifyPassword_data_json,
            url: '/modifyUserPassword',
            dataType: "text",
            success: function(data){
                alert(data);
            }
        })
    })
})