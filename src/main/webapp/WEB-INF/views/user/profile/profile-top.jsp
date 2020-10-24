<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row profile-top">
	<div class="col-md-12 col-sm-12">
		<div class="bgr">
			<img class="img-profile img-bgr"
				src='<c:url value="/albums/user/bgr/${user.userbgr }"></c:url>' alt="">
			<c:if test="${personalUri.equals(uri) }">
				<div class='action action-top sub-menu'>
					<button>
						<span class="far fa-edit"></span>Edit photo
					</button>
					<div class='sub-container'>
						<a class='sub' onclick="showImg()">View</a> <a class='sub'>Edit</a> <a class='sub'
							href='' onclick="getProfile(this)">Delete</a>
					</div>
				</div>
			</c:if>
			<c:if test="${!personalUri.equals(uri) }">
				<div class='action action-top'>
					<button onclick="showImg()">
						<span class="far fa-eye"></span>View photo
					</button>
					
				</div>
				
					<c:if test="${mode.equals('isFriend')}">
						
						<div class='action action-bottom sub-menu'>
							<button>
								<span class="fas fa-user-check"></span>My friend
							</button>
							<div class='sub-container'>
								<a class='sub' onclick="confirmUnfriend(${user.userId})">Unfriend</a>
								<a class='sub' >Block</a>
							</div>
						</div>
					</c:if>
					<c:if test="${mode.equals('waiting')}">
						
						<div class='action action-bottom'>
							<button onclick="cancelRequest(${user.userId})">
								<span class="fas fa-user-times"></span>Cancel Request
							</button>
						</div>
					</c:if>
					<c:if test="${mode.equals('response')}">
						
						<div class='action action-bottom sub-menu'>
							<button onclick="cancelRequest(${user.userId})">
								<span class="fas fa-user-times"></span>Cancel Request
							</button>
							<div class='sub-container'>
								<a class='sub' onclick="confirmRequest(${user.userId})">Confirm</a> 
								<a class='sub' onclick="cancelRequest(${user.userId})">Delete request</a> 
							</div>
						</div>
					</c:if>
					<c:if test="${mode.equals('isNotFriend')}">
						<div class='action action-bottom sub-menu'>
							<button onclick="sendRequest(${user.userId})">
								<span class="fas fa-user-plus"></span>Add friend
							</button>
						</div>
						
					</c:if>
			</c:if>
		</div>
		<div class="menu-profile">
			<div class="avt-name">
				<div class="avt">
					<img class="img-profile img-avt"
						src='<c:url value="/albums/user/avt/${user.useravt }"></c:url>'
						alt="">
					<div class="edit-info"  data-toggle="modal" data-target="#modal-edit-info" onclick="editInfo('${personalUri}')">
						<p>Edit</p>
					</div>
				</div>
				<h2 id="profile-name">${user.name }<a href=""></a></h2>
				
			</div>
			<ul>
				<li class="tab-profile"><a 
					href="${routes.profile }/${uri}">Timeline</a></li>
				<li class="tab-profile"><a
					href="${routes.profileFriend }/${uri}">Friends</a></li>
				<li class="tab-profile"><a
					href="${routes.profilePhoto }/${uri}">Photo</a></li>
				
			</ul>
		</div>
	</div>

</div>
<div class="modal fade" id="modal-edit-info" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h5 style="display: inline-block; font-size: 40px" class="modal-title">Edit user information</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div>
				<div class="modal-body modal-body-edit-info">
					<div class="edit-avt">
						<img id="img-edit-avt">
					</div>
					<form action="">
						<!-- <img src="logoblack.png" alt=""> -->
						<div>
							<label for="">Choose avt</label> <input type="file" id="avt-edit">
						</div>
						<div>
							<label for="">Name</label> <input type="text" id="name-edit">
						</div>
						<div>
							<label for="">Phone</label> <input type="text" id="phone-edit">
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button> -->
					<button onclick="updateAbout()" type="button" class="btn-cuaduc" data-dismiss="modal">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>
</div>