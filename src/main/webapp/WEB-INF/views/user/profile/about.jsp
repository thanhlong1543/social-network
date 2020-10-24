<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="about-profile">
	<c:if test="${personalUri.equals(uri) }">
		<div class='action action-top sub-menu'>
			<button data-toggle="modal" data-target="#modal-edit-about" onclick="getAbout(${about.userId})">
				<span class="far fa-edit"></span>Edit
			</button>
		</div>
	</c:if>
	
	<h2>Introduce</h2>
	
	<p class="bio">
		<c:if test='${!about.bio.equals("") }'>
			<strong>${about.bio }</strong> 
		</c:if>
	</p>
	
	<p class="about-info">
		<c:if test='${!about.education.equals("")}'>
			<span><i class="fas fa-graduation-cap"></i> Studies at </span><a
				href="#">${about.education}</a>
		</c:if>
	</p>
	
	
	<p class="about-info">
		<span><i class="fas fa-briefcase"></i> Works at </span><a href="#">${about.company }</a>
	</p>
	<p class="about-info">
		<span><i class="fas fa-globe-asia"></i> Country </span><a href="#">${about.country }</a>
	</p>
	<p class="about-info">
		<span><i class="fas fa-building"></i> Lives in </span><a href="#">${about.lives }</a>
	</p>
	<p class="about-info">
		<span><i class="fas fa-map-marker-alt"></i> From </span><a href="#">${about.comeFrom }</a>
	</p>
	<p class="about-info">
		<span><i class="fas fa-birthday-cake"></i> Birthday </span><a href="#">${about.birthday }</a>
	</p>
</div>
<div class="modal fade" id="modal-edit-about" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h5 style="display: inline-block; font-size: 40px" class="modal-title">Edit profile</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div>
				<div class="modal-body">
					<form action="">
						<!-- <img src="logoblack.png" alt=""> -->
						<div>
							<label for="">Bio</label> <textarea class="input-style" id="bio"></textarea>
						</div>
						<div>
							<label for="">Studies at</label> <input type="text" id="education">
						</div>
						<div>
							<label for="">Works at</label> <input type="text" id="company">
						</div>
						<div>
							<label for="">Country</label> <input type="text" id="country">
						</div>
						<div>
							<label for="">Lives in</label> <input type="text" id="lives">
						</div>
						<div>
							<label for="">From</label> <input type="text" id="comeFrom">
						</div>
						<div>
							<label for="">Birthday</label> <input type="date" id="birthday">
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