<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Chuc Kim Thien -->
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
      <link href="resources/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
<div class="bg-modal" style="display: none;">
	<div class="modal-content">
		<div class="close" onclick="closeDialog()">X</div>
		<div class="useredit">
		<div class="contentU">
		<h2>Edit User</h2>
		</div>
		<form:form action="" method="post" modelAttribute="update-user">
			<div>
				<div>
					<form:label class="col-md-3" path="userId"><b>MenuId</b></form:label>
					<form:input type="text" id="userId" path="userId"  readonly="true"/>
				</div> 
				<div>
					<form:label class="col-md-3" path="name"><b>Name</b></form:label>
					<form:input path="name" type="text" id="name"/>
				</div>
				<div>
					<form:label class="col-md-3" path="phone"><b>Phone</b></form:label>
					<form:input path="phone" type="text" id="phone"/>
				</div>
				<div>
					<form:label class="col-md-3" path="email"><b>Email</b></form:label>
					<form:input path="email" type="text" id="email"/>
				</div>
				<div>
					<form:label class="col-md-3" path="password"><b>Pass</b></form:label>
					<form:input path="password" type="text" id="password"/>
				</div>
				<div>
					<form:label class="col-md-3" path="isactive"><b>Isactive</b></form:label>
					<form:input path="isactive" type="text" id="isactive"/>
				</div>
				<div>
					<form:label class="col-md-3" path="roleId"><b>RoleId</b></form:label>
					<form:input path="roleId" type="text" id="roleId"/>
				</div>
				<div>
					<form:label class="col-md-3" path="userUrl"><b>UserUrl</b></form:label>
					<form:input path="userUrl" type="text" id="userUrl"/>
				</div>
				<div>
					<form:label class="col-md-3" path="useravt"><b>Useravt</b></form:label>
					<form:input path="useravt" type="text" id="useravt"/>
				</div>
				<div>
					<form:label class="col-md-3" path="userbgr"><b>Userbgr</b></form:label>
					<form:input path="userbgr" type="text" id="userbgr"/>
				</div>
			</div>
			<input type="submit" value="Update" class="submit"/>
		</form:form>
		</div>
	</div>
</div>
<style>
	.useredit{
		margin: 0 auto;
	}
	.contentU{
		width:300px;
		height:50px;
		background-color: #40A798;
		text-align:center;
		margin-bottom:10px;
	}
	.contentU h2{
		color:#fff;
		font-family: cursive;
	}
	form .submit{
		width:100%;
		background-color: #40A798;
		font-weight:bold;
		border:1px solid #333;
	}
	form .submit:hover{
		background-color: #333;
		color:#fff;
	}
	label b{
		color:#000;
	}
	.close{
	 	color:#000;
	}
	.close:hover{
		color:#40A798;
	}
	form div div{
		padding-bottom:10px;
	}
	form input:active{
		border: 1px solid #40A798;
	}
</style>