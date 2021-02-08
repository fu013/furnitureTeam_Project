$(document).ready(function () {
    	function Request(){
            var requestParam ="";

        	// getParameter 함수
        	this.getParameter = function(param){
                //현재 주소를 decoding
                var url = unescape(location.href);
                //파라미터만 자르고, 다시 &그분자를 잘라서 배열에 넣는다.
                var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&");

                for(var i = 0 ; i < paramArr.length ; i++){
                   var temp = paramArr[i].split("="); //파라미터 변수명을 담음

                   if(temp[0].toUpperCase() == param.toUpperCase()){
                     // 변수명과 일치할 경우 데이터 삽입
                     requestParam = paramArr[i].split("=")[1];
                     break;
                   }
                }
                return requestParam;
            }
        }

        // Request 객체 생성
        var request = new Request();

        // searchType 라는 파라메터 값을 얻기
        var paramSearchType = request.getParameter("searchType");
        if (paramSearchType == "") {
            $('.product_no').addClass('on');
        } else {
            $(`.${paramSearchType}`).addClass('on');
        }

});