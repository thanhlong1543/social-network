/**
 * @author : truong
 */

$(document).mouseup(function (e)
    		{
    		  
    		    var container = $(".form-group");
    		 
    		  
    		    if (!container.is(e.target) && container.has(e.target).length === 0)
    		    {
    		        container.children("ul").hide();
    		        container.children("input").val("");
					
    		    }
    		});
    
    
    
    $(document).ready(function(){
    	 $.ajaxSetup({
    			  headers: { 'Authorization': localStorage.getItem('token')},
    			  url : 'http://localhost:8080/ambi/api/userlist' ,		
    			  cache: false });
    	 $('#searchAllPeople').keyup(function(){
    		 $(".form-group").children("ul").show();
    	  $('#resultFriends').html('');
    	  $('#state').val('');
    	 /*  var  flickerApi = "http://localhost:8080/ambi/api/userlist"; */
    	  var searchField = $('#searchAllPeople').val();
    	  var expression = new RegExp(searchField, "i");
    	  $.getJSON('http://localhost:8080/ambi/api/userlist', function(data) {
    	   $.each(data, function(key, value){
    	    if (value.name.search(expression) != -1)
    	    {	
    	    	 $('#resultFriends').append('<li class="list-group-item link-class"> <a href="/ambi/profile/'+value.userUrl+'"><img src="/ambi/albums/user/avt/'+value.useravt+'"  class="img-thumbnail" />'+value.name+' </a> </li>');
    	    }
    	   });   
    	  });
    	 });
    	 
    	 $('#resultFriends').on('click', 'li', function() {
    	  var click_text = $(this).text().split('|');
    	  $('#searchAllPeople').val($.trim(click_text[0]));
    	  $("#resultFriends").html('');
    	 });
    	});
    
   