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
					<img
						src='<c:url value="/images/users/user-1.jpg"></c:url>'
						alt="" class="profile-photo-md" />
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
					<button class="btn btn-primary pull-right" onclick="insertPost()">Publish</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Post Create Box End-->

	<!-- Post Content
            ================================================= -->
    <div class="post-container">
	    <c:forEach items="${posts}" var="post">
	    	<div class="post-content">
			<img src='<c:url value="/images/post-images/1.jpg"></c:url>'
				alt="post-image" class="img-responsive post-image" />
			<div class="post-container">
				<img src='<c:url value="/albums/user/avt/${post.user.useravt}"></c:url>'
					alt="user" class="profile-photo-md pull-left" />
				<div class="post-detail">
					<div class="user-info">
						<h5>
							<a href="timeline.html" class="profile-link">${post.user.name}</a> <span
								class="following">following</span>
						</h5>
						<p class="text-muted">Published a photo about 3 mins ago</p>
					</div>
					<div class="reaction">
						<a class="btn text-green"><i class="icon ion-thumbsup"></i> ${post.totalLike}</a>
						<a class="btn text-red"><i class="fa fa-thumbs-down"></i> 0</a>
					</div>
					<div class="line-divider"></div>
					<div class="post-text">
						<p>
							${post.content}
							 <i class="em em-anguished"></i> <i class="em em-anguished"></i> <i
								class="em em-anguished"></i>
						</p>
					</div>
					<div class="line-divider"></div>
					<c:forEach items="${post.comments}" var="comment">
						<div class="row">
	                    	<div class="col-sm-2 col-md-2">
	                        	<img class="avt-comment" src='<c:url value="/albums/user/avt/${comment.user.useravt}"></c:url>' alt="">
	                    	</div>
		                    <div class="col-sm-10 col-md-10">
		                        <div class="comment-content">
		                            <span><a href="#">${comment.user.name}</a></span>
		                            <p>${comment.content} </p>
		                            <div class="row">
		                                <a href="#">Reply</a>
		                                <a href="" class="show-replies">Show more replies <i>---------</i></a>
		                            </div>
		                        </div>
		                        <c:forEach items="${comment.subComments}" var="subcomment">
			                        <div class="row sub-comment">
			                            <div class="col-sm-2 col-md-2">
			                                <img  class="avt-comment" src='<c:url value="/albums/user/avt/${subcomment.user.useravt}"></c:url>' alt="">
			                            </div>
			                            <div class="col-sm-10 col-md-10">
			                                <span><a href="#">${subcomment.user.name}</a></span>
			                                <p>${subcomment.content}</p>
			                            </div>
			                        </div>
								</c:forEach>
		
		                    </div>
	
	                	</div>
						<div class="row reply-comment">
                            <form action="">
                                <div class="col-sm-10 col-md-10">
                                    <textarea class="form-control reply-content" aria-label="With textarea"></textarea>
                                </div>
                                <div class="col-sm-2 col-md-2">
                                    <input type="submit" class="btn btn-danger">
                                </div>
                            </form>
                        </div>
					</c:forEach>
					
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-md-12 reply-comment">
                        <form action="">
                            <div class="col-sm-10 col-md-10">
                                <textarea class="form-control reply-content" aria-label="With textarea"></textarea>
                            </div>
                            <div class="col-sm-2 col-md-2">
                                <input type="submit" class="btn btn-danger">
                            </div>
                        </form>
        </div>
	    </c:forEach>        
    </div>
    
	
</div>
<style>
    .avt-comment {
        max-width: 80%;
        border-radius: 50%;
    }
    
    span {
        padding-right: 5px;
    }
    
    p {
        display: inline;
    }
    
    i {
        letter-spacing: -3px;
    }
    
    .sub-comment {}
    
    .show-replies {
        float: right;
    }
    
    .reply-content {
        width: 100%;
        height: 10vh;
    }
</style>
<script>
	function insertPost() {
		 $.ajax({
        	 contentType : 'application/json; charset=utf-8',
             type: "POST",
             url: "http://localhost:8080/ambi/api/sendmail",
             success : function(callback){
 				console.log("success");
 				/*window.location.replace('http://localhost:8080/livedinner/menu');*/
             },
             error : function(e){
             }
        });
	}	
</script>