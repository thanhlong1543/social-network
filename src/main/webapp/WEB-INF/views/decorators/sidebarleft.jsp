<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-3 static">
	<div class="profile-card">
		<img src='<c:url value="/albums/user/avt/${user.useravt}"></c:url>'
			alt="user" class="profile-photo" />
		<h5>
			<a href="${routes.host }" class="text-white">${user.name}</a>
		</h5>
		<a href="#" class="text-white"><i
			class="ion ion-android-person-add"></i> 1,299 followers</a>
	</div>
	<!--profile card ends-->
	<ul class="nav-news-feed">
		<li><i class="icon ion-ios-paper"></i>
		<div>
				<a href="${routes.host }">My Newsfeed</a>
			</div></li>
		<li><i class="icon ion-ios-people-outline"></i>
		<div>
				<a href="${routes.friend}">Friends</a>
			</div></li>
		<li><i class="icon ion-chatboxes"></i>
		<div>
				<a href="${routes.message}">Messages</a>
			</div></li>
		<li><i class="icon ion-images"></i>
		<div>
				<a href="#">Images</a>
			</div></li>
	</ul>
	<!--news-feed links ends-->
	
	<!--chat block ends-->
	<div id="chat-block">
		<div class="title">Chat online</div>
		<ul id = "chatonline" class="online-users list-inline">
			
		</ul>
	</div>
</div>