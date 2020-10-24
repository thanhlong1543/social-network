/**
 * @author Duc
 */
setInfo()
function setInfo(){
	$.ajax({
		url: "http://localhost:8080/ambi/api/user-information",
		method: "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(data){
			$("#id-profile").attr("href",`/ambi/profile/${data.userUrl}`);
			//$("#id-timeline").attr("href",`/ambi/profile/${data.userUrl}/`);
			//$(".avt img").attr("src", `/ambi/albums/user/avt/${data.useravt}`);
			//$(".bgr img").attr("src", `/ambi/images/covers/1.jpg`);
			//$("#profile-name").text(data.name);
			//getFriend(data.userUrl);
			//console.log(data.userUrl);
			/*var idUser = $(`<input type='hidden' class='id-user' value='${data.userId}' >`);
			var option = $("<div class='dot-more'></div>");
			var op1 = $("<span class='dot'></span>");
			var op2 = $("<span class='dot'></span>");
			var op3 = $("<span class='dot'></span>");
			var subMenu = $("<div class='sub-menu'></div>");
			var subContainer = $("<div class='sub-container'></div>");
			var sub1 = $(`<a onclick="confirmUnfriend(this)" class='sub btn-unfriend'>Unfriend</a>`); sub1.append(idUser);
			var sub2 = $("<a class='sub'>Chat</a>");
			var sub3 = $(`<a class='sub' href='/ambi/profile/${data.userUrl}' onclick="getProfile(this)">Profile</a>`);sub3.append($(`<input type='hidden' class='id-user' value='${data.userUrl}' >`));
			subContainer.append(sub1, sub2, sub3);
			option.append(op1, op2, op3);
			subMenu.append(option, subContainer);
			$(".friend-card").append(subMenu);*/
		}
	})
	
	
}

//get list friend
let dataResource = {};

//getFriend("vmd211099");
function getFriend(uri){
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		url : "http://localhost:8080/ambi/api/friend/"+uri,
		type: "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(data){
				dataResource = data;
				appendToList(dataResource);
		}
	});
}

function appendToList(data){
	//$("#body-profile  .friend-container").empty();
	$(".friend-list .row").empty();
	var divRow = $("<div class='row'></div>");
	var friendList = $("<div class='friend-list'></div>");
	for(let i = 0; i< data.length;i++){
		var idUser = $(`<input type='hidden' class='id-user' value='${data[i].userId}' >`);//id user
		
		var subMenu = $("<div class='sub-menu'></div>");
		var option = $("<div class='dot-more'></div>");
		var op1 = $("<span class='dot'></span>");
		var op2 = $("<span class='dot'></span>");
		var op3 = $("<span class='dot'></span>");
		
		var subContainer = $("<div class='sub-container'></div>");
		var sub1 = $(`<a onclick="confirmUnfriend(this)" class='sub btn-unfriend'>Unfriend</a>`); sub1.append(idUser);
		var sub2 = $("<a class='sub'>Chat</a>");
		var sub3 = $(`<a class='sub' href='/ambi/profile/${data[i].userUrl}' onclick="getProfile(this)">Profile</a>`);sub3.append($(`<input type='hidden' class='id-user' value='${data[i].userUrl}' >`));
		subContainer.append(sub1, sub2, sub3);
		option.append(op1, op2, op3);
		subMenu.append(option, subContainer);
		
		var curl = "'<c:url value='/albums/user/avt/"+data[i].useravt+"'></c:url>'";
		
		var name = $("<a href='timeline.html' class='profile-link'></a>").text(data[i].name);
		//var myFriend = $("<a href='#' class='pull-right text-green'></a>").text("My friend");
		
		var friendInfo = $("<div class='friend-info'></div");
		friendInfo.append(name);
		var imgAvt = $(`<img src='/ambi/albums/user/avt/${data[i].useravt}' alt='user' class='profile-photo-lg' />`);
		var cardInfo = $("<div class='card-info'></div>").append(imgAvt, friendInfo);
		
		var imgBgr = $(`<img src='/ambi/images/covers/1.jpg' alt="profile-cover"
				class="img-responsive cover" />`);
		var friendCard = $("<div class='friend-card'></div>").append(imgBgr, cardInfo, subMenu);
		
		var item = $("<div class='col-md-6 col-sm-6'></div>").append(friendCard);
		
		//divRow.append(item);
		$(".friend-list .row").append(item);
	}
	//friendList.append(divRow);
	//$("#body-profile .friend-container").append(friendList);
}
function compareInputToData(value, data){
	var filteredData = [];
	for(let i = 0; i <data.length;i++){
		value = value.toLowerCase();
		var name = data[i].name.toLowerCase();
		if(name.includes(value)){
			filteredData.push(data[i]);
		}
	}
	return filteredData;
}
$(".search-friend").on('keyup', function(){
	var value = $("#search-friend-value").val();
	var data = compareInputToData(value, dataResource);
	appendToList(data);
})

//unfriend


function confirmUnfriend(event){
	let ok = confirm("A du sua?");
	if(ok){
		$.ajax({
			url: "http://localhost:8080/ambi/api/friend/delete/"+event,
			method: "PUT",
			headers: { 'Authorization': localStorage.getItem('token') },
			success: function(){
				alert("Successful");
				window.location.reload();
			}
		})
		
	}
}
//get list friend


function getProfile(parent){
	let uri = parent.children[0].value;
	alert(uri);
	getFriend(uri);
}
//show bgr or avt
function showImg(){
	src = $('.img-bgr').attr('src');
	img = $(`<img id="show-img" src="${src}" alt="">`);
	closeBtn = $("<i class='fa fa-close close-icon' onclick='closeShowImg'></i>");
	showImgContainer = $("<div id='show-img-container' onclick='closeShowImg()'></div>");
	showImgContainer.append(img, closeBtn);
	$('body').append(showImgContainer);
}
function closeShowImg(){
	$("#show-img-container").remove();
}
//show bgr or avt

//
function sendRequest(id){
	$.ajax({
		url: "http://localhost:8080/ambi/api/send-friend-request/"+id,
		method: "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(){
			window.location.reload();
		},
		error: function(){

		}
	})
}

function sendHomeRequest(id){
	$.ajax({
		url: "http://localhost:8080/ambi/api/send-friend-request/"+id,
		method: "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(){
			$(`#home-request-${id}`).css('display','none')
			$(`#home-cancel-${id}`).css('display','block')
		}
	})
}

function cancelHomeRequest(id) {
	$.ajax({
		url : "http://localhost:8080/ambi/api/pending/delete/"+id,
		method : "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success : function(noti) {
			$(`#home-request-${id}`).css('display','block')
			$(`#home-cancel-${id}`).css('display','none')
		}
	});
}


//show post
function showPost(id){
	window.location.href = "http://localhost:8080/ambi/post?id="+id;
}
//show post

//notification//
function directToRequestList(){
	alert("direct to list pending");
}
function deleteNoti(id){

	$.ajax({
		url: "http://localhost:8080/ambi/api/noti/del/"+id,
		method: "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(){
		}
	})
}
function readNoti(id){
	alert(id);
	$.ajax({
		url: "http://localhost:8080/ambi/api/noti/read/"+id,
		method: "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(){
		}
	})
}
function markAsUnread(id){
	//this.parent().parent().removeClass("unread");
	$.ajax({
		url: "http://localhost:8080/ambi/api/noti/unread/"+id,
		method: "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(){
			$('this').parent().parent().addClass("unread");
		}
	})
}
//notification//

//about
function getAbout(id){
	$.ajax({
		url: "http://localhost:8080/ambi/api/getAbout/"+id,
		method: "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(data){
			$("#bio").val(data.bio);
			$("#education").val(data.education);
			$("#company").val(data.company);
			$("#country").val(data.country);
			$("#lives").val(data.lives);
			$("#comeFrom").val(data.comeFrom);
			$("#birthday").val(data.birthday);
		}
	})
}

function updateAbout(){
	$("#birthday").datepicker();
	var about = {
		education : $("#education").val(),
		country : $("#country").val(),
		lives : $("#lives").val(),
		birthday : $("#birthday").val(),
		bio : $("#bio").val(),
		comeFrom : $("#comeFrom").val(),
		company : $("#company").val()
	}

	$.ajax({
		url : "http://localhost:8080/ambi/api/update-about",
		headers: { 'Authorization': localStorage.getItem('token') },
		type : "POST",
		data : JSON.stringify(about),
        contentType: "application/json; charset=utf-8",
		
		success : function(data) {
			var arr = jQuery.makeArray($(".about-info"));
			if(about.bio == ""){
				$(".bio").children().remove();
				//$(".bio").te
				xt("");
			}else{
				//$(".bio").text(about.bio);
				$(".bio").children().remove();
				$(".bio").append($(`<strong>${about.bio}</strong>`));
			}
			if(about.education == ""){
				arr[0].children.empty;
			}
			else{
				arr[0].children.empty;
				arr[0].append($(`<strong>${about.bio}</strong>`));
			}
			/*
			arr[0].text = about.education;
			arr[1].text = about.company;
			arr[2].text = about.country;
			arr[3].text = about.lives;
			arr[4].text = about.comeFrom;
			arr[5].text = about.birthday;*/
			window.location.reload();
		},
		error: function(){
			alert("not ok");
		}
	})
}


function editInfo(uri){
	$.ajax({
		url: "http://localhost:8080/ambi/api/profile/edit-info/"+uri,
		method: "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(data){

			$("#img-edit-avt").attr("src",`http://localhost:8080/ambi/albums/user/avt/${data.useravt}`);
			$("#name-edit").val(data.name);
			$("#phone-edit").val(data.phone);
		}
	});
}
//about