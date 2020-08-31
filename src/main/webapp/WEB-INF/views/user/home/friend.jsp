<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-7">

	<!-- Post Create Box
            ================================================= -->
	<div class="create-post">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<div class="form-group">
					<img src='<c:url value="resources/images/users/user-1.jpg" ></c:url>' alt="" class="profile-photo-md" />
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
	</div>
	<!-- Post Create Box End -->

	<!-- Friend List
            ================================================= -->
	<div class="friend-list">
		<div class="row">
			<c:forEach items="${listFriends }" var="item">
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src='<c:url value="resources/images/covers/1.jpg"></c:url>' alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src='<c:url value="resources//albums/user/avt/${item.useravt }"></c:url>' alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">${item.name} </a>
							</h5>
							<p>Student at Harvard</p>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			
			
		</div>
	</div>
</div>