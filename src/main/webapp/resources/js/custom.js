//Chuc Kim Thien

closeChat = function(userFriend){
        $(`#chat${userFriend}`).remove();
    }

    hideChat = function(userFriend){
        element= document.querySelector(`#content-${userFriend}`);
		element.style.display="none";    
		element1= document.querySelector(`#form-${userFriend}`);
		element1.style.display="none";
    }

    showChat = function(userFriend){
        element= document.querySelector(`#content-${userFriend}`);
        element.style.display="block";
        element1= document.querySelector(`#form-${userFriend}`);
        element1.style.display="block";
    }

    appearChat = function(userFriend){
        element= document.querySelector(`#content-${userFriend}`);
        element.style.display="block";
		element1= document.querySelector(`#form-${userFriend}`);
		element1.style.display="block";
    }
    
    var height = 0;
    $('.content div').each(function(i, value){
        height += parseInt($(this).height());
    });
    height += '';

    $('.content').animate({scrollTop: height});
    
    
 	function hideDetail(userFriend){
        a = document.getElementById(`hide-detail-${userFriend}`);
        a.style.display='block';
    }
    function hideDetailClose(userFriend){
        a = document.getElementById(`hide-detail-${userFriend}`);
        a.style.display='none';
    }
    function closeDetail(userFriend){
        b = document.getElementById(`close-detail-${userFriend}`);
        b.style.display='block';
    }
    function closeDetailClose(userFriend){
        b = document.getElementById(`close-detail-${userFriend}`);
        b.style.display='none';
    }
    function sendDetail(userFriend){
        c = document.getElementById(`send-detail-${userFriend}`);
        c.style.display='block';
    }
    function sendDetailClose(userFriend){
        c = document.getElementById(`send-detail-${userFriend}`);
        c.style.display='none';
    }
    
    function scrollEnd(id){
		var chatList = document.getElementById(id);
		chatList.scrollTop = chatList.scrollHeight;
	}
    
    function loadName(postId){
    	a = document.getElementById(`getName${postId}`);
    	a.style.display="block";
    	$.ajax({
			headers: { 'Authorization': localStorage.getItem('token') },
			type:"GET",
			url : "http://localhost:8080/ambi/api/like/"+postId,
			success : function(result) {
				var str ="";
				$.each(result,function(key,value){
					str+=`<p>${value.name}</p>`;
				})
				$("#getName"+postId).html(str);
			}
		});
    	
    }
    function hideName(postId){
    	a = document.getElementById(`getName${postId}`);
    	a.style.display="none";
    }