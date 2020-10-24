<!-- Chuc Kim Thien -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content" style="width=100%">
	<div style="width=80%">
		<div class="about">
			<h1>OUR COMPANY</h1>
			<h3>"Coming together is a <span>beginning</span>, staying together is <span>progress</span>, and working together is <span>success</span>"</h3> 
		</div>
		<div class="row">
			<div class="col-md-2">
				<a href="https://www.facebook.com/profile.php?id=100011392674475"><img alt="" src="<c:url value="/albums/user/avt/84499919_1360549807668095_4174386437057150976_n.jpg"/>"><br>
				<h4>Nguyen Truong</h4></a>
				<p>Founder</p>
			</div>
			<div class="col-md-2">
				<a href="https://www.facebook.com/profile.php?id=100004633111732"><img alt="" src="<c:url value="/albums/user/avt/82631395_1484045415093215_1664493281116946432_o.jpg"/>"><br>
				<h4>Vu Manh Duc</h4></a>
				<p>CTO</p>
			</div>
			<div class="col-md-2">
				<a href="https://www.facebook.com/kimthienchuc/"><img alt="" src="<c:url value="/albums/user/avt/116442692_1216331545387883_1483374940740545334_o.jpg"/>"><br>
				<h4>Chuc Kim Thien</h4></a>
				<p>Founder</p>
			</div>
			<div class="col-md-2">
				<a href="https://www.facebook.com/long.ca1"><img alt="" src="<c:url value="/albums/user/avt/78355589_2505040122941805_6920204169496231936_o.jpg"/>"><br>
				<h4>Long Ca</h4></a>
				<p>CEO</p>
			</div>
			<div class="col-md-2">
				<a href="https://www.facebook.com/tain.pham96"><img alt="" src="<c:url value="/albums/user/avt/37947336_1236677303138662_3252476860931506176_n.jpg"/>"><br>
				<h4>Tain Pham</h4></a>
				<p>CEO<p>
			</div>
			</div>
		</div>
</div>
<style>	
	.about{
		margin:50px 0 100px 0;
	}
	.about h1{
		text-align:center;
		color:#40A798;
		font-family: serif;
	}
	.about h3{
		text-align:center;
		color:#fff;
		font-family: serif;
	}
	.about h3 span{
		color:#40A798;
	}
	.row{
		margin-left: 10%;
	}
	.content img{
		width:100%;
		border-radius:50%;
		border: 5px outset #ddd;
	}
	.content img:hover{
		border: 5px outset #40A798;
	}
	.content h4{
		padding-top:10px;
		text-align:center;
		color:#fff;
		font-family: inherit;
	}
	.content h4:hover{
		color:#40A798;
	}
	.content p{
		color:#fff;
		text-align:center;
		font-family: monospace;
	}
	
</style>