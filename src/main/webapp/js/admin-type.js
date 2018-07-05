$( document ).ready(function(){
  $("#search").keyup(function(){
     var search = $("#search").val();
     $.ajax({
       type: "POST",
       url: "/search-admin-type",
       data: {"name": search},
       cache: false,                                 
       success: function(result){
    	   var array=result.result;
    	   var resultString="";
    	   for(var i=0; i<array.length; i++){
    		   if(i<10){
    			   resultString+="<tr><td>"+array[i].name+"</td>";
    			   resultString+="<td><form method=\"POST\" action=\"admin-type-del\"><input type=\"hidden\" name=\"do\" value=\"del\"/><input type=\"submit\" class=\"btn\" value=\"Удалить\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"/></form></td>"
    			   resultString+="<td><form action=\"admin-type-update\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"><input type=\"submit\" class=\"btn\" value=\"Изменить\"></form></td>";
    		   }
    	   }
          $("#tbody").html(resultString);
          console.log("SUCCESS : ", result);
       }
     });
     return false;
   });
  $("#next").click(function(){
	 var page=10*Number($("#page").val());
	 var search=$("#search").val();
	 $.ajax({
	       type: "POST",
	       url: "/search-admin-type",
	       data: {"name": search},
	       cache: false,                                 
	       success: function(result){
	    	   var array=result.result;
	    	   var resultString="";
	    	   for(var i=page-10; i<array.length; i++){
	    		   if(page-i>0){
	    			   resultString+="<tr><td>"+array[i].name+"</td>";
	    			   resultString+="<td><form method=\"POST\" action=\"admin-type-del\"><input type=\"hidden\" name=\"do\" value=\"del\"/><input type=\"submit\" class=\"btn\" value=\"Удалить\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"/></form></td>"
	    			   resultString+="<td><form action=\"admin-type-update\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"><input type=\"submit\" class=\"btn\" value=\"Изменить\"></form></td>";
	    		   }
	    		}
	          $("#tbody").html(resultString);
	          console.log("SUCCESS : ", result);
	       }
	     });
  });
});