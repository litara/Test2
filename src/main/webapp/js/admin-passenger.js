$( document ).ready(function(){
  $("#search").keyup(function(){
     var search = $("#search").val();
     $.ajax({
       type: "POST",
       url: "/search-admin-passenger",
       data: {"name": search},
       cache: false,                                 
       success: function(result){
    	   var array=result.result;
    	   var resultString="";
    	   for(var i=0; i<array.length; i++){
    		   if(i<10){
    			   resultString+="<tr><td>"+array[i].email+"</td><td>"+array[i].name+"</td><td>"+array[i].surname+"</td><td>"+array[i].middle_name+"</td>";
    			   resultString+="<td><form method=\"POST\" action=\"admin-passenger-del\"><input type=\"hidden\" name=\"do\" value=\"del\"/><input type=\"submit\" class=\"btn\" value=\"Удалить\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"/></form></td>"
    			   resultString+="<td><form action=\"admin-passenger-update\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"><input type=\"submit\" class=\"btn\" value=\"Изменить\"></form></td>";
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
	       url: "/search-admin-passenger",
	       data: {"name": search},
	       cache: false,                                 
	       success: function(result){
	    	   var array=result.result;
	    	   var resultString="";
	    	   for(var i=page-10; i<array.length; i++){
	    		   if(page-i>0){
	    			   resultString+="<tr><td>"+array[i].email+"</td><td>"+array[i].name+"</td><td>"+array[i].surname+"</td><td>"+array[i].middle_name+"</td>";
	    			   resultString+="<td><form method=\"POST\" action=\"admin-passenger-del\"><input type=\"hidden\" name=\"do\" value=\"del\"/><input type=\"submit\" class=\"btn\" value=\"Удалить\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"/></form></td>"
	    			   resultString+="<td><form action=\"admin-passenger-update\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+array[i].id+"\"><input type=\"submit\" class=\"btn\" value=\"Изменить\"></form></td>";
	    		   }
	    		}
	          $("#tbody").html(resultString);
	          console.log("SUCCESS : ", result);
	       }
	     });
  });
});