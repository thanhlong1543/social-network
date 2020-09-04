<!-- Nguyen Van Truong -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
      <link href="resources/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
<!-- Chuc Kim Thien -->
<div class="bg-modal" style="display: none;">
	<div class="modal-content">
		<div class="close" onclick="closeDialog()">X</div>
		<div class="menuedit">
		<div class="contentM">
		<h2>Edit Menu</h2>
		</div>
		<form:form action="" method="post" modelAttribute="update-menu">
			<div>
				<div>
					<form:label class="col-md-4" path="menuId"><b>MenuId</b></form:label>
					<form:input type="text" id="menuId" path="menuId"  readonly="true"/>
				</div> 
				<div>
					<form:label class="col-md-4" path="name"><b>Name</b></form:label>
					<form:input path="name" type="text" id="name"/>
				</div>
				<div>
					<form:label class="col-md-4" path=""><b>Description</b></form:label>
					<form:input path="description" type="text" id="description"/>
				</div>
				<div>
					<form:label class="col-md-4" path=""><b>CategoryId</b></form:label>
					<form:input path="categoryId" type="text" id="categoryId"/>
				</div>
				<form:input path="menuId" type="hidden" id="menuId"/>
			</div>
			<input type="submit" value="Update" class="submit"/>
		</form:form>
	</div>
	</div>
</div>
<style>
	.menuedit{
		margin: 0 auto;
	}
	.contentM{
		width:300px;
		height:50px;
		background-color: #40A798;
		text-align:center;
		margin-bottom:10px;
	}
	.contentM h2{
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
