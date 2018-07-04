$( document ).ready(function(){
  $("#search").keyup(function(){
     var search = $("#search").val();
     $.ajax({
       type: "POST",
       url: "/search-admin",
       data: {"name": search},
       cache: false,                                 
       success: function(result){
          $("#resSearch").html(JSON.stringify(result, null, 4));
          console.log("SUCCESS : ", result);
       }
     });
     return false;
   });
});