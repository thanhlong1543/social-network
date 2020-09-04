<!-- Nguyen Van Truong -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
      <link href="resources/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />

<div class="bg-modal" style="display: none;">
	<div class="modal-content">
		<div class="close" onclick="closeDialog()">X</div>
		<h2>Edit Menu</h2>
		<form:form action="" method="post" modelAttribute="update-menu">
			<div>
				<div>
					<form:label path="menuId">MenuId</form:label>
					<form:input type="text" id="menuId" path="menuId"  readonly="true"/>
				</div> 
				<div>
					<form:label path="name">Name</form:label>
					<form:input path="name" type="text" id="name"/>
				</div>
				<div>
					<form:label path="">Description</form:label>
					<form:input path="description" type="text" id="description"/>
				</div>
				<div>
					<form:label path="">CategoryId</form:label>
					<form:input path="categoryId" type="text" id="categoryId"/>
				</div>
				<form:input path="menuId" type="hidden" id="menuId"/>
			</div>
			<input type="submit" value="Update" class="submit"/>
		</form:form>
	</div>
</div>