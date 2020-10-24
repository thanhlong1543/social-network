 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Chuc Kim Thien -->

<!-- Post Create Box
            ================================================= -->

		<div class="create-post">
			<div class="row">
				
					<div>
						<div class="form-box">
							<img
								src='<c:url value="/albums/user/avt/${user.useravt}"></c:url>'
								alt="" class="profile-photo-md" />
								<textarea name="texts"  cols="30" rows="1"
								class="form-text" data-target="#postStatus" data-toggle="modal" placeholder="What's on your mind?"></textarea>
						</div>
					</div>
				
				<div  class="modal fade "  id="postStatus" 
				tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div id="postDiv" class="modal-dialog">
						<div id="postForm" class="postForm">
							<div class="content-post">
								<h1>Create Post</h1>
							</div>
							<form id="post-form" class="post-form">
								<div class="user-info">
									<a href=""><img class="avatar"
										src='<c:url value="/albums/user/avt/${user.useravt}"></c:url>'
										alt=""></a>
									<div class="user-priva">
										<a href="${routes.profile }/${user.userUrl}"><h4>${user.name}</h4></a> <select name="privacy"
											id="privacy" class="privacy">
											<option value="1">Public</option>
											<option value="2">Private</option>
										</select>
									</div>
								</div>
									<textarea name="content" id="exampleTextarea" class="postTextarea" cols="30" rows="1"
										class="form-control" placeholder="What's on your mind?"></textarea>
										  <label class="upImg" for="imgInp" class="btn"><i class="fas fa-images"></i> Upload Image</label>
									<input type='text' hidden name="userId" value="${user.userId}"/> 
									<input type='file' id="imgInp" class="imgInp" accept='image/*'/> 
									<div id="blockImg" class="blockImg">
										<img id="blah" class="blah"src="#" /> 
										<div class="positionClose imageClose" id="imgClose">
										<i class="fa">&#xf00d</i>
										</div>
									</div>
								<input class="submit-post" type="submit" value="POST" >
									
							</form>
							<div class="positionClose" data-target="#postStatus" data-toggle="modal">
								<i class="fa">&#xf00d</i>
							</div>
						</div>
					</div>
				</div>
				
				<div  class="modal fade " id="editStatus" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div id="postDiv" class="modal-dialog">
						<div id="editForm" class="postForm">
							<div class="content-post">
								<h1>Edit Post</h1>
							</div>
							<form id="edit-form" class="post-form">
								<div class="user-info">
									<a href=""><img class="avatar"
										src='<c:url value="/albums/user/avt/${user.useravt}"></c:url>'
										alt=""></a>
									<div class="user-priva">
										<a href="${routes.profile }/${user.userUrl}"><h4>${user.name}</h4></a> <select name="privacy"
											id="editprivacy" class="privacy">
											<option value="1">Public</option>
											<option value="2">Private</option>
										</select>
									</div>
								</div>
								<div id="postContent">
									
								</div>
							</form>
							<div class="positionClose" id="closeEdit" data-target="#editStatus" data-toggle="modal">
								<i class="fa">&#xf00d</i>
							</div>
						</div>
					</div>
				</div>
				
			
			</div>
		</div>
	
<!-- Post Create Box End-->

<!-- Post Content
            ================================================= -->
<div class="row">
	<c:forEach items="${posts}" var="post">
		<div class="col-md-12 post-container">
			<div class='sub-menu action-top'>
							<div class='dot-more'>
								<span class='dot dot-home'></span> <span class='dot dot-home'></span> <span
									class='dot dot-home'></span>
							</div>
							<c:if test="${post.user.userId == user.userId }">
								<div class='sub-container sub-container-home'>
									<a class='sub sub-home' onclick='editPost(${post.postId },"${post.content}","${post.image.imgName}",${post.totalLike},${user.userId })' 
									data-target="#editStatus" data-toggle="modal">Edit post</a>							
									<a class='sub sub-home' onclick="deletePost(${post.postId})">Delete post</a>
								</div>
							</c:if>
							<c:if test="${post.user.userId != user.userId }">
								<div class='sub-container sub-container-home'>
									<a class='sub sub-home' onclick="hidePost(${post.postId})">Hide post</a>
								</div>
							</c:if>
						</div>
			<div class="post-top">
				<div class="img-box">
					<img src='<c:url value="/albums/user/avt/${post.user.useravt}"></c:url>' />
				</div>
				<h5><a href="${routes.profile }/${post.user.userUrl}">${post.user.name}</a></h5>

			</div>
			<div class="post-body">
				<c:if test="${not empty post.image.imgName}">
					<img src='<c:url value="/albums/imagesOfPost/${post.image.imgName}"/>'/>
				</c:if>
					
				<div class="post-content">
					<p>
						<span>${post.content}</span><br> ${post.postDate}
					</p>
				</div>
				<div class="like">
					<c:if test="${post.islike==true}"> 
						<i class="fa fa-thumbs-up fa-2x" onmouseover="loadName(${post.postId})" onmouseout="hideName(${post.postId})" 
						style="display:block;color:#40A798;" 
						id="like${post.postId}" onclick="unlike(${post.postId})" aria-hidden="true"></i>
						<i class="fa fa-thumbs-up fa-2x" style="display:none;color:#c8c8c8;"
						id="unlike${post.postId}" onmouseover="loadName(${post.postId})" onmouseout="hideName(${post.postId})"  onclick="like(${post.postId})" aria-hidden="true"></i>
					</c:if>	
					<c:if test="${post.islike==false}"> 
						<i class="fa fa-thumbs-up fa-2x" style="display:none;color:#40A798;" 
						id="like${post.postId}" onmouseover="loadName(${post.postId})" onmouseout="hideName(${post.postId})"  onclick="unlike(${post.postId})" aria-hidden="true"></i>
						<i class="fa fa-thumbs-up fa-2x" onmouseover="loadName(${post.postId})" onmouseout="hideName(${post.postId})" 
						style="display:block;color:#c8c8c8;"
						id="unlike${post.postId}" onclick="like(${post.postId})" aria-hidden="true"></i>
					</c:if>	
					<p id="totalLike${post.postId}">${post.totalLike}</p>				
					</div>
					<div class="hide-detail loadName" id="getName${post.postId}">	
					</div>
			</div>
			<div class="post-comment"  id="comment${post.postId}" class="line-divider">
				<c:forEach items="${post.comments}" var="comment">
					<div class="comment-line" id ="commentinput${comment.commentId}">
							<div class="avt-left">
								<div class="img-box">
									<img  src='<c:url value="/albums/user/avt/${comment.user.useravt}"></c:url>' alt="">
								</div>
							</div>
							<div class="comment-right" >
								<a href="">${comment.user.name}</a><span class="text-day">${comment.commentDate}</span>
								<p>${comment.content}</p>
								<a class="reply-btn" onclick='createSubCmtInput(${comment.commentId},"${user.name}","${user.useravt}","${user.userId}")'><i class="fas fa-reply"></i>Reply</a>
								<div id ="replycomment${comment.commentId}">
									<c:forEach items="${comment.subComments}" var="subcomment">
										<div class="sub-comment">
											<div class="avt-left">
												<div class="img-box">
													<img src='<c:url value="/albums/user/avt/${subcomment.user.useravt}"></c:url>' alt="">
												</div>
				
											</div>
											<div class="comment-right">
												<a href="">${subcomment.user.name}</a><span class="text-day">${subcomment.commentDate}</span>
												<p>${subcomment.content}</p>
											</div>
										</div>
									</c:forEach>
								</div>
								
								
							</div>
					</div>
				</c:forEach>
				
			</div>
			<div class="write-comment">
				<textarea id="inputcomment${post.postId}" placeholder="Write a comment..."></textarea>
				<button class="btn-cuaduc" onclick='sendComment(${post.postId},"${user.name}","${user.useravt}",${user.userId})'>Post</button>
			</div>
		</div>
	
	</c:forEach>
</div>
