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
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src='<c:url value="resources/images/covers/1.jpg"></c:url>' alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src='<c:url value="resources/images/users/user-3.jpg"></c:url>' alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">Sophia Lee</a>
							</h5>
							<p>Student at Harvard</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/3.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-4.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">John Doe</a>
							</h5>
							<p>Traveler</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/4.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-10.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="timeline.html" class="pull-right text-green">My
								Friend</a>
							<h5>
								<a href="#" class="profile-link">Julia Cox</a>
							</h5>
							<p>Art Designer</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/5.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-7.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timelime.html" class="profile-link">Robert Cook</a>
							</h5>
							<p>Photographer at Photography</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/6.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-8.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">Richard Bell</a>
							</h5>
							<p>Graphic Designer at Envato</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/7.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-2.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">Linda Lohan</a>
							</h5>
							<p>Software Engineer</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/8.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-9.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">Anna Young</a>
							</h5>
							<p>Musician</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/9.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-6.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">James Carter</a>
							</h5>
							<p>CEO at IT Farm</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="friend-card">
					<img src="images/covers/10.jpg" alt="profile-cover"
						class="img-responsive cover" />
					<div class="card-info">
						<img src="images/users/user-5.jpg" alt="user"
							class="profile-photo-lg" />
						<div class="friend-info">
							<a href="#" class="pull-right text-green">My Friend</a>
							<h5>
								<a href="timeline.html" class="profile-link">Alexis Clark</a>
							</h5>
							<p>Traveler</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>