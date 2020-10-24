/**
 * @author Pham Thanh Tam
 */
var userName = null;
var websocket = null;
var userinfo;
function setInfo(){
			$.ajax({
				url: "http://localhost:8080/ambi/api/user-information",
				method: "GET",
				headers: { 'Authorization': localStorage.getItem('token') },
				async: false,
				success: function(data){
					userinfo = data;
					console.clear();
				}
			});	
		}
function init(username) {
	if ("WebSocket" in window) {		
		setInfo();
		userName = userinfo.userUrl;

		websocket = new WebSocket('ws://localhost:8080/ambi/chat/' + userName);

		websocket.onopen = function(data) {
			
		};

		websocket.onmessage = function(data) {
			// setMessage(JSON.parse(data.data));
			sendtype = JSON.parse(data.data).sendtype;
			if(sendtype === 'subcomment'){
				setSubComment(JSON.parse(data.data));
			}else if(sendtype ==='comment'){
				setComment(JSON.parse(data.data));
			}else if(sendtype === 'checkOnline'){
				setOnline(JSON.parse(data.data));
			}else if(sendtype ==='message'){
				setMessage(JSON.parse(data.data));
			}else if( sendtype === 'notification'){
				setNotification(JSON.parse(data.data));
			}
			
		};

		websocket.onerror = function(e) {
			alert('An error occured, closing application');
			
			cleanUp();
		};

		websocket.onclose = function(data) {
			cleanUp();
		
/*			var reason = (data.reason && data.reason !== null) ? data.reason : 'Goodbye';
			alert(reason);*/
		};
	} else {
		/*alert("Websockets not supported");*/
	}
}

function cleanUp() {
	userName = null;
	websocket = null;
}
function createMessage(userFriendName, useravt, conid){
	if(!document.getElementById(`chat${conid}`)){
		$('#chat').append(
		`
	<div id="chat${conid}" class="chat">
      <div class="header" >
          <div class="avatar"><a href=""><img src='/ambi/albums/user/avt/${useravt}' alt=""></a><div class="active"></div></div>
          <div class="name" onclick="showChat(${conid})"></div>
          <div class="event" >
              <div class="hidee" onclick="hideChat(${conid})" onmouseover="hideDetail(${conid})" onmouseout="hideDetailClose(${conid})"><p class="hideeee">-</p></div>
              <div class="closee" onclick="closeChat(${conid})" onmouseover="closeDetail(${conid})" onmouseout="closeDetailClose(${conid})"><p class="closeeee">X</p></div>
          </div>
          <div id="hide-detail-${conid}" class="hide-detail"><p>Minimize tab</p></div>
          <div id="close-detail-${conid}" class="close-detail"><p>Close tab</p></div>
      </div>
      <div class="content" id ="content-${conid}">
          <div class="host">
              <div style="display:flex"><a href=""><img src='/ambi/albums/user/avt/${useravt}' alt=""></a></div>
              <div class="host-mess"><p>Hi, How are you?</p></div>
          </div>
          <div class="friend">
              <div style="display:flex"><a href=""><img src='/ambi/albums/user/avt/${useravt}' alt=""></a></div>
              <div class="friend-mess"><p>I'm good! How are you?</p></div>
          </div>
      </div>
       <div class="form" id ="form-${conid}">
          <div id="content"><textarea id = "textarea-${conid}" rows="4" cols="4"></textarea></div>
          <div id="submit" onclick='sendMessage("${userFriendName}" ,"${conid}")' onmouseover="sendDetail(${conid})" onmouseout="sendDetailClose(${conid})"><i class="far fa-paper-plane"></i></div>
          <div id="send-detail-${conid}" class= "send-detail"><p>Press enter to send</p></div>
      </div>
  	</div>
		`
	);
	var chatDtos;
	$.ajax({
		url : `http://localhost:8080/ambi/api/chat/?conid=${conid}&userfriend=${userFriendName}`,
		headers: { 'Authorization': localStorage.getItem('token') },
		type : "GET",
        contentType: "application/json; charset=utf-8",
		dataType: "json",
		async : false,
		success : function(chatdto) {
			chatDtos = chatdto;
		},
		error : function(error){
		}
		});
	$.each(chatDtos,function(index, chatDto){
		if (chatDto.user.userUrl === userName) {
			$(`#content-${chatDto.conId}`).append(`
					<div class="host">
		              <div style="display:flex"><a href=""><img src="/ambi/albums/user/avt/${chatDto.user.useravt}" alt=""></a></div>
		              <div class="host-mess"><p>${chatDto.content}</p></div>
		          	</div>
				`)
		} else {
			$(`#content-${chatDto.conId}`).append(`
				<div class="friend">
	              <div style="display:flex"><a href=""><img src="/ambi/albums/user/avt/${chatDto.user.useravt}" alt=""></a></div>
	              <div class="friend-mess"><p>${chatDto.content}</p></div>
	          	</div>
			`)
		}
	});
	}	
	
	
	scrollEnd("content-"+conid);
	

}



function sendMessage(userFriendName, conid) {
	var messageContent = document.getElementById(`textarea-${conid}`).value;
	var data = {		content: messageContent,
						conId:conid,
						userId: userinfo.userId,
						chatTime: ''
					};
		$.ajax({
		url : "http://localhost:8080/ambi/api/chat",
		headers: { 'Authorization': localStorage.getItem('token') },
		type : "POST",
		data : JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
		dataType: "json",
		async : false,
		success : function(chat) {
		},
		error : function(error){
		}
		});
	var message = buildcomment(userName, messageContent, conid,userinfo.name,userinfo.useravt,userinfo.userId,'message',userFriendName);
	document.getElementById(`textarea-${conid}`).value = '';
	setMessage(message);
	websocket.send(JSON.stringify(message));
}
function sendComment(id,name,useravt,userId) {
	var sendType = 'comment'; 
	var sendTypeNoti = "notification";
	var notiDatas;
	var messageContent = document.getElementById('inputcomment'+ id).value;
	if(messageContent !== ""){
		document.getElementById('inputcomment'+ id).value = '';
	
		var commentId;
		var data = {	content: messageContent,
							commentDate:'',
							userId: userId,
							postId: id,
							isdelete: false,
							remotion: 'qwe'
						};
			$.ajax({
			url : "http://localhost:8080/ambi/api/comment",
			headers: { 'Authorization': localStorage.getItem('token') },
			type : "POST",
			data : JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
			dataType: "json",
			async : false,
			success : function(data) {
				notiDatas = data.notifications;
				commentId = data.comment.commentId;
			},
			error : function(error){
			}
			});
		var message = buildcomment(userName, messageContent,id,name,useravt,userId,sendType,commentId);
		$.each(notiDatas,function(index, notiData){
			var noti = buildMessage(userName,notiData.content,notiData.notiId,name,useravt,notiData.userId,sendTypeNoti);
			websocket.send(JSON.stringify(noti));
		});
		setComment(message);
		websocket.send(JSON.stringify(message));
	}
	
}
function sendSubComment(idComment,name,useravt,userId) {
	var sendType = 'subcomment';
	var messageContent = document.getElementById('subcomment'+ idComment).value;
	document.getElementById('subcomment'+ idComment).value = '';
	if(messageContent !== ""){
		var message = buildMessage(userName, messageContent,idComment,name,useravt,userId,sendType);

		var data = {	content: messageContent,
							commentDate:'',
							userId: userId,
							commentId: idComment,
							isdelete: false,
							remotion: 'qwe'
						};
			$.ajax({
			url : "http://localhost:8080/ambi/api/subcomment",
			headers: { 'Authorization': localStorage.getItem('token') },
			type : "POST",
			data        : JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
			dataType: "json",
			
			success : function(comment) {
			}
		});	
		
		setSubComment(message);
		websocket.send(JSON.stringify(message));
	}
	
}

function buildcomment(userName, message,id,name,useravt,userid, type,commentId) {
	return {
		username : userName,
		message : message,
		id : id,
		name : name,
		useravt : useravt,
		userid : userid,
		sendtype: type,
		commentid : commentId
	};
}
function buildMessage(userName, message,id,name,useravt,userid, type) {
	return {
		username : userName,
		message : message,
		id : id,
		name : name,
		useravt : useravt,
		userid : userid,
		sendtype: type
	};
}
function setComment(msg) {	
		var d = new Date();		
		var divCommentContainer = $(`<div id = 'commentinput${msg.commentid}' class='row comment-container'></div>`);
		var divColsm2 =$("<div class='col-sm-2 col-md-2'></div>");
		var divColsm2_img =$(`<img class='avt-comment' src='/ambi/albums/user/avt/${msg.useravt}'>`);
		var divColsm10 = $(`<div id ='replycomment${msg.commentid}' class='col-sm-10 col-md-10'></div>`);
		var divColsm10_commentContent = $("<div class='comment-content'></div>");
		var span = $(`<span><a href='#'>${msg.name}</a></span>`);
		var pDate =$(`<p class="text-muted">${d.getHours()}:${d.getMinutes()}:${d.getSeconds()} </br> </p>`);
		var p = $(`<p>${msg.message} </p>`);
		var divRow = $("<div class='row'></div>");
		var a1 = $(`<a onclick='createSubCmtInput(${msg.commentid},"${userinfo.name}","${userinfo.useravt}","${userinfo.userId}")'>Reply</a>`);
		var a2 =$("<a href='' class='show-replies'>Show more replies <i>---------</i></a>");
		
		divRow.append(a1,a2);
		divColsm10_commentContent.append(span,pDate,p,divRow);
		divColsm2.append(divColsm2_img);
		divColsm10.append(divColsm10_commentContent);
		divCommentContainer.append(divColsm2,divColsm10);
		
		
		var comment = $(`<div class="comment-line" id ="commentinput${msg.commentid}">
							<div class="avt-left">
								<div class="img-box">
									<img src='/ambi/albums/user/avt/${msg.useravt}' alt="">
								</div>
		
							</div>
							<div class="comment-right" >
								<a href="">${msg.name}</a><span>${d.getHours()}:${d.getMinutes()}:${d.getSeconds()}</span>
								<p>${msg.message}</p>
								<a onclick='createSubCmtInput(${msg.commentid},"${userinfo.name}","${userinfo.useravt}","${userinfo.userId}")'><i class="fas fa-reply"></i>Reply</a>
								<div id ="replycomment${msg.commentid}">
								</div>
							</div>
						</div>`);
		$(`#comment${msg.id}`).append(comment);
}
function setSubComment(msg){
	var d = new Date();
	var subComment = $(`<div class="sub-comment">
                        <div class="avt-left">
                            <div class="img-box">
                                <img src='/ambi/albums/user/avt/${msg.useravt}'>
                            </div>

                        </div>
                        <div class="comment-right">
                            <a href="">${msg.name}</a><span>${d.getHours()}:${d.getMinutes()}:${d.getSeconds()}</span>
                            <p>${msg.message}</p>
                        </div>
                    </div>`);
	$(`#replycomment${msg.id}`).append(subComment);
}

function setOnline(user){
	var data = {
					userid: user.userid,
					userfriendid: `${userinfo.userId}`
				};
	var conUser;
	$.ajax({
		url : "http://localhost:8080/ambi/api/conversationuser/get",
		headers: { 'Authorization': localStorage.getItem('token') },
		type : "GET",
		data : data,
        contentType: "application/json; charset=utf-8",
		dataType: "json",
		async : false,
		success : function(conuser) {
			conUser = conuser;
		},
		error : function(error){
		}
	});
	if(! document.getElementById(user.username)){
	var li = $(`<li id ='${user.username}'></li>`)
	var a = $(`<a onclick='createMessage("${user.username}","${user.useravt}","${conUser}")' title='Linda Lohan'></a>`);
	var img = $(`<img src='/ambi/albums/user/avt/${user.useravt}' alt="user"
					class="img-responsive profile-photo" />`);
	var span = $("<span class='online-dot'></span>");
	a.append(img,span);
	li.append(a);
	$("#chatonline").append(li);
	}
	
}

function createSubCmtInput(idComment, name, useravt,userId){
	if(document.getElementById(`inputReply${idComment}`)){
		var value123 = document.getElementById(`subcomment${idComment}`).value;
		$(`#inputReply${idComment}`).remove();
	}
	
	
	var div_textarea = $(`<div class="write-comment" id='inputReply${idComment}'>
	                    	<textarea id="subcomment${idComment}" aria-label="With textarea"></textarea>
							<button  class="btn-cuaduc" onclick='sendSubComment(${idComment},"${name}","${useravt}","${userId}")' >Post</button>
	                 	  </div>`);

	$(`#commentinput${idComment}`).append(div_textarea);
	if(value123 != null ){
		document.getElementById(`subcomment${idComment}`).value = value123;	
	}
	
}
function setMessage(msg) {
	if(! document.getElementById(`chat${msg.id}`)){
		var userFriendUrl;		
		createMessage(msg.commentid, msg.useravt, msg.id);
	} else{
		if (msg.username === userName) {
			$(`#content-${msg.id}`).append(`
				<div class="host">
	              <div style="display:flex"	><a href=""><img src="/ambi/albums/user/avt/${msg.useravt}" alt=""></a></div>
	              <div class="host-mess"><p>${msg.message}</p></div>
	          	</div>
			`)
		} else {
			$(`#content-${msg.id}`).append(`
				<div class="friend">
	              <div style="display:flex"><a href=""><img src="/ambi/albums/user/avt/${msg.useravt}" alt=""></a></div>
	              <div class="friend-mess"><p>${msg.message}</p></div>
	          	</div>
			`)
		}
	}

	scrollEnd("content-"+msg.id); 

}
function setNotification(msg){
	var item;
	$.ajax({
		url : `http://localhost:8080/ambi/api/noti/get?notiid=${msg.id}`,
		headers: { 'Authorization': localStorage.getItem('token') },
		type : "GET",
        contentType: "application/json; charset=utf-8",
		dataType: "json",
		async : false,
		success : function(noti) {
			item = noti;
		},
		error : function(error){
		}
	});
	if( document.getElementById(`noti-${item.notiId}`)){
		$(`#noti-${item.notiId}`).remove();
		if(item.notiTypeId == 2){
			$("#noti").prepend(
			`
				<div id ="noti-${item.notiId}"class="noti-item unread">
					<div class="noti-action">
						<a><i class="fas fa-times"></i></a>
						<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
					</div>
					<div class="img-box">
						<img src='/ambi/albums/user/avt/${item.user.useravt}' alt="user" />
					</div>
					<div class="right">
						<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
							<p onclick="readNoti(${item.notiId})">${item.description}</p>
						<p class="font-time">${item.notiDate }</p>
					</div>
				</div>
			`
			
			);
		}else if(item.notiTypeId == 3 || item.notiTypeId == 1){
				$("#noti").prepend(
			`
				<div id ="noti-${item.notiId}"class="noti-item unread">
					<div class="noti-action">
						<a><i class="fas fa-times"></i></a>
						<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
					</div>
					<div class="img-box">
						<img src='/ambi/albums/user/avt/${item.user.useravt}' alt="user" />
					</div>
					<div class="right">
						<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
							<p onclick="showPost(${item.memo})">${item.description}</p>
						<p class="font-time">${item.notiDate }</p>
					</div>
				</div>
			`
			
		);
	}

	}else{
		if(item.notiTypeId == 2){
			$("#noti").prepend(
			`
				<div id ="noti-${item.notiId}"class="noti-item unread">
					<div class="noti-action">
						<a><i class="fas fa-times"></i></a>
						<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
					</div>
					<div class="img-box">
						<img src='/ambi/albums/user/avt/${item.user.useravt}' alt="user" />
					</div>
					<div class="right">
						<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
							<p onclick="readNoti(${item.notiId})">${item.description}</p>
						<p class="font-time">${item.notiDate }</p>
					</div>
				</div>
			`
			
			);
		}else if(item.notiTypeId == 3 || item.notiTypeId == 1){
				$("#noti").prepend(
			`
				<div id ="noti-${item.notiId}"class="noti-item unread">
					<div class="noti-action">
						<a><i class="fas fa-times"></i></a>
						<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
					</div>
					<div class="img-box">
						<img src='/ambi/albums/user/avt/${item.user.useravt}' alt="user" />
					</div>
					<div class="right">
						<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
							<p onclick="showPost(${item.memo})">${item.description}</p>
						<p class="font-time">${item.notiDate }</p>
					</div>
				</div>
			`
			
		);
	}
	}
	
}
