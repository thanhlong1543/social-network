<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Post Create Box
            ================================================= -->

<%-- <div class="create-post">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<div class="form-group">
					<img src='<c:url value="/images/users/user-1.jpg" ></c:url>' alt="" class="profile-photo-md" />
					<textarea name="texts" id="exampleTextarea" cols="30" rows="1"
						class="form-control" placeholder="Write what you wish"></textarea>
				</div>
			</div>
			<div class="col-md-5 col-sm-5">
				<div class="tools">
					<ul class="publishing-tools list-inline">
						<li><a href="#"><i class="ion-compose"></i></a></li>
						<li><a href="#"><i class="ion-images"></i></a></li>
						<li><a href="#"><i class="ion-ios-videocam"></i></a></li>
						<li><a href="#"><i class="ion-map"></i></a></li>
					</ul>
					<button class="btn btn-primary pull-right">Publish</button>
				</div>
			</div>
		</div>
	</div> --%>
<!-- Post Create Box End -->
<div class="search-friend">
	<div class="row">
		<div class="col-md-6">
			<form>
				<div class="form-group">
					<input type="text" class="form-control" id="search-friend-value"
						placeholder="Search here">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Friend List
            ================================================= -->
<div class="friend-list">
	<div class="row">

		<c:forEach items="${listFriends }" var="item">

			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<c:if test="${personalUri.equals(uri) }">
						<div class='sub-menu action-top'>
							<div class='dot-more'>
								<span class='dot'></span> <span class='dot'></span> <span
									class='dot'></span>
							</div>
							<div class='sub-container'>
								<a class='sub btn-unfriend' onclick="confirmUnfriend(${item.userId})">Unfriend</a>
								<a class='sub'>Chat</a>
								<a class='sub' href='<c:url value="/profile/${item.userUrl}"></c:url>'>Profile</a>
							</div>
						</div>
					</c:if>
					
					<img src='<c:url value="/albums/user/bgr/${item.userbgr }"></c:url>'
						alt="profile-cover" class="img-responsive cover" />
					<div class="card-info">
						<img
							src='<c:url value="/albums/user/avt/${item.useravt }"></c:url>'
							alt="user" class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href='<c:url value="/profile/${item.userUrl}"></c:url>' class="profile-link">${item.name} </a>
							</h5>
							<p>Student at Harvard</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>


	</div>
</div>
