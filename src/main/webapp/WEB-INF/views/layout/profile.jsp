<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="This is social network html5 template available in themeforest......" />
<meta name="keywords"
	content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
<meta name="robots" content="index, follow" />
<title>News Feed | Check what your friends are doing</title>
<!-- Stylesheets
    ================================================= -->

<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>' />
<link rel="stylesheet" href="<c:url value="/css/style.css"></c:url>" />
<link rel="stylesheet" href="<c:url value="/css/ionicons.min.css"></c:url>" />
<link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/loading.css'></c:url>">
<link rel="stylesheet" href="<c:url value='/css/mystyle.css'></c:url>">
<link rel="stylesheet" href="<c:url value='/css/profile.css'></c:url>">
<link href="<c:url value="/css/emoji.css"></c:url>" rel="stylesheet">
<!--Google Webfont-->
<link
	href='https://fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,300italic,400italic,500,500italic,600,600italic,700'
	rel='stylesheet' type='text/css'>
<!--Favicon-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="#">
</head>
<body onload="init('')">
	
	<jsp:include page="/WEB-INF//views/decorators/header.jsp" />
    <div class="container" style="margin-bottom: 50px">
    	<jsp:include page="/WEB-INF//views/user/profile/profile-top.jsp" />
    	<section>
    		<div class="row">
    			 <div class="col-lg-4">
    			 	<jsp:include page="/WEB-INF//views/user/profile/about.jsp" />
                 <div class="list-pending" >
                 
                 	<jsp:include page="/WEB-INF//views/user/profile/pending.jsp" />
                 </div>   
                </div>
                <div class="col-lg-8" id="body-profile">
                	<dec:body />
                	               	
                </div>
    			
    		</div>
		</section>
	</div>
	<jsp:include page="/WEB-INF//views/decorators/chat.jsp" />
	<jsp:include page="/WEB-INF//views/decorators/footer.jsp" />
	   
    <!--preloader-->
    <div id="spinner-wrapper">
      <div class="spinner"></div>
    </div>
    
    <!-- Scripts
    ================================================= -->
    <!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script> -->
    <script src='<c:url value="/js/jquery-3.1.1.min.js"></c:url>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
    <script src='<c:url value="/js/jquery.sticky-kit.min.js"></c:url>'></script>
    <script src='<c:url value="/js/jquery.scrollbar.min.js"></c:url>'></script>
    <script src='<c:url value="/js/custom.js"></c:url>'></script>
    <script src='<c:url value="/js/script.js"></c:url>'></script>
    <script src='<c:url value="/js/user-info.js"></c:url>'></script>
    <script src='<c:url value="/js/app.js"></c:url>'></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>