<!--Nguyen Van Truong  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <div class="content">
       		 <div id="list-menu">
		<jsp:include page="../home/editMenu.jsp"/>
		<div class = "manager-content">
			<table class="table table-dark" border="1" style="width: 100%; border: 1px; color:#fff;">
				<thead>
					<tr>
						<td scope="col"><b>STT</b></td>
						<td scope="col"><b>MenuID</b></td>
						<td scope="col"><b>Name</b></td>
						<td scope="col"><b>Description</b></td>
						<td scope="col"><b>CategoryId</b></td>
						<td scope="col" colspan="3"><b>Action</b></td>
					</tr>
					
				</thead>
				<tbody>
					<c:forEach items="${menulist }" var="item" varStatus="status">
						<tr>
							<td scope="row">${status.index+1 }</td>
							<td>${item.menuId }</td>
							<td>${item.name }</td>
							<td>${item.description }</td>
							<td>${item.categoryId }</td>
							<td><a href="javascript:void()" class="btn-edit"><button><b>Edit</b></button></a><input type="hidden" class="id-edit" name="name-edit" value="${item.menuId }"></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
      </div>
     <content tag="scripts">
     <!-- 
     @author: Truong
      -->
      	<script type="text/javascript">
		 $(document).ready(function(){
				let allbtnedit = document.querySelectorAll('.btn-edit');
				console.log(allbtnedit);
				allbtnedit.forEach(function(el,index){
			        el.addEventListener('click', function() {
			           let input = el.parentNode.querySelector('.id-edit');
			           showDialogUpdateMenu(input.value);
			        });
			        
			        
			    });
				
			});
			showDialogUpdateMenu = function(id) {
			    		element = document.querySelector(".bg-modal");
			    		element.style.display = "flex";
			    		$.ajax({
			    			headers: { 'Authorization': localStorage.getItem('token') },
			    			type:"GET",
			    			url : "http://localhost:8080/ambi/api/update/"+id,
			    			success : function(result) {
			    				$('#menuId').val(result.menuId);
			    				$('#name').val(result.name);
			    				$('#description').val(result.description);
								$('#categoryId').val(result.categoryId);
			    				console.log(result.name);
			    			}
			    		});
			    	
			    }
		  closeDialog = function() {
			    element = document.querySelector(".bg-modal");
			    element.style.display = "none";
			}

		  
		</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 		<script scr='<c:url value="/resources/admin/js/menu.js"/>'> </script>
 	</content>
 <style>
	
	.btn-edit button:hover{
		background-color: #40A798;
		color:#fff;
	}
</style>
 