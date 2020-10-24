<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header
    ================================================= -->
<header id="header">
	<nav class="navbar navbar-default navbar-fixed-top menu">
		<div class="container">

          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${routes.host }"><img src='<c:url value="/images/logowhite.png"></c:url>' alt="logo" /></a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right main-menu">
              <li class="dropdown"><a href="${routes.home }"><span><i class="fas fa-house-user"></i></span></a></li>
              <li class="dropdown noti">
              	<div class="noti-num"><p>${notiCount }<p></div>
                <a href="/" class="dropdown-toggle noti" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                	<span><i class="far fa-bell"></i></span>
                </a>
                  <div id="noti" class="noti-box">
                  		<c:forEach items="${noti}" var="item">
                  			<c:if test="${!item.isread }">
	                  			<div id ="noti-${item.notiId}" class="noti-item unread">
	               					<div class="noti-action">
	               						<a onclick="deleteNoti(${item.notiId})"><i class="fas fa-times"></i></a>
										<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
	               					</div>
		                			<div class="img-box">
		                				<img src='<c:url value="/albums/user/avt/${item.user.useravt}"></c:url>' alt="user" />
		                			</div>
		                			<div class="right">
		                				<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
		                				<c:if test="${item.notiTypeId == 2 }">
		                					<p onclick="readNoti(${item.notiId})">${item.description}</p>
		                				</c:if>
		                				<c:if test="${item.notiTypeId == 3 || item.notiTypeId == 1}">
		                					<p onclick="showPost(${item.memo})">${item.description}</p>
		                				</c:if>
		                				<p class="font-time">${item.notiDate }</p>
		                			</div>
		                  		</div>
                  			</c:if>
                  			<c:if test="${item.isread }">
	                  			<div class="noti-item">
	               					<div class="noti-action">
	               						<a onclick="deleteNoti(${item.notiId})"><i class="fas fa-times"></i></a>
										<a id="tes" onclick="markAsUnread(${item.notiId})"><i class="fas fa-check"></i></a>
	               					</div>
		                			<div class="img-box">
		                				<img src='<c:url value="/albums/user/avt/${item.user.useravt}"></c:url>' alt="user" />
		                			</div>
		                			<div class="right">
		                				<a href="/ambi/profile/${item.user.userUrl }">${item.user.name}</a>
		                				<c:if test="${item.notiTypeId == 2 }">
		                					<p onclick="readNoti(${item.notiId})">${item.description}</p>
		                				</c:if>
		                				<c:if test="${item.notiTypeId == 3}">
		                					<p onclick="showPost(${item.memo})">${item.description}</p>
		                				</c:if>
		                				<p>${item.notiDate }</p>
		                			</div>
		                  		</div>
                  			</c:if>
                  		</c:forEach>
                		
                	</div>
              </li>
              <li class="dropdown">
                <a href="" id="id-profile"><span><i class="far fa-user"></i></span></a>
              </li>
              <li class="dropdown"><a href="/ambi/logout"><i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
            <form class="navbar-form navbar-right hidden-sm">
              <div class="form-group">
                <a href=""><i class="icon ion-android-search"></i></a>
                    <input type="text" name="search" id="searchAllPeople" autocomplete="off" placeholder="Search Friends" class="form-control" />  								
  				 <ul class="list-group" id="resultFriends">
  				 </ul>			
   				</div>                        
            </form>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
      </nav>
    </header>
<style>
 .list-group {
 position: absolute;
 height: 400px;
 width: 250px;
 overflow-y: auto;
 }
  .link-class:hover{
   background-color:#f1f1f1;
  }
  .img-thumbnail {
  	height : 64px;
  	width : 64px;
  	vertical-align: middle;
  	border-radius: 50%;
  	margin-right: 20px;
  }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/js/searchfriend.js'></c:url>"></script>
  


    <!--Header End-->


