window.onload = function() {
   $("#idOverlap").on('click', function(e) {
      const idVal = $("#userRegisterId").val();
      const idOverlap_data_json = {
         "idOverlapCheck" : idVal
      };
      $.ajax({
         type : "post",
         data : idOverlap_data_json,
         url : '/idOverlapCheck',
         dataType : "text",
         success : function(data) {
            alert(data);
         }
      });
   });
};