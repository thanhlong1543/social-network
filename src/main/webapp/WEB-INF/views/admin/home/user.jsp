<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Chuc Kim Thien -->

      <div class="content">
       	   <div class = "manager-content" style="padding-top: 100px">
       	<jsp:include page="../home/editUser.jsp"></jsp:include>
       	<div class="input-group no-border" style="width: 100%">
                    <input type="text" value=""id="myInput" class="form-control" placeholder="Search..." >
                  </div>
			<table class="table table-dark" border="1" style="border: 1px;width: 100%;color: #fff;" >
				<thead class="indigo white-text">
					<tr>
						<td scope="col"><b>STT</b></td>
							<td scope="col"><b>name</b></td>
							<td scope="col"><b>phone</b></td>
							<td scope="col"><b>email</b></td>
							<td scope="col"><b>isactive</b></td>
							<td scope="col"><b>roleid</b></td>
							<td scope="col"><b>userurl</b></td>
							<td scope="col"><b>useravt</b></td>
							<td scope="col"><b>userbgr</b></td>
							<td scope="col"><b>Edit</b></td>
					</tr>
					
				</thead>
				<tbody id="myTable">
					<c:forEach items="${userlist}" var="item" varStatus="status">
						<tr>
							<td scope="row">${status.index+1 }</td>
							<td>${item.name }</td>
							<td>${item.phone }</td>
							<td>${item.email }</td>
							<td>${item.isactive}</td>
							<td>${item.roleId }</td>
							<td>${item.userUrl}</td>
							<td>${item.useravt}</td>
							<td>${item.userbgr }</td>
							<td><a href="javascript:void()" class="btn-edit"><button><b>Edit</b></button></a><input type="hidden" class="id-edit" name="name-edit" value="${item.userId }"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
      
     <content tag="scripts">
     <script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
		
		 $(document).ready(function(){
				let allbtnedit = document.querySelectorAll('.btn-edit');
				console.log(allbtnedit);
				allbtnedit.forEach(function(el,index){
			        el.addEventListener('click', function() {
			           let input = el.parentNode.querySelector('.id-edit');
			           showDialogUpdateUser(input.value);
			        });
			        
			        
			    });
				
			});
			showDialogUpdateUser = function(id) {
			    		element = document.querySelector(".bg-modal");
			    		element.style.display = "flex";
			    		$.ajax({
			    			type:"GET",
			    			url : "http://localhost:8080/ambi/update_user/"+id,
			    			success : function(result) {
			    				$('#userId').val(result.userId);
			    				$('#name').val(result.name);
			    				$('#phone').val(result.phone);
								$('#email').val(result.email);
								$('#password').val(result.password);
								$('#isactive').val(result.isactive);
								$('#roleId').val(result.roleId);
								$('#userUrl').val(result.userUrl);
								$('#useravt').val(result.useravt);
								$('#userbgr').val(result.userbgr);
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
      	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
 		<script scr='<c:url value="/resources/admin/js/user.js"/>'> </script>
 	</content>

<style>
	
	.btn-edit button:hover{
		background-color: #40A798;
		color:#fff;
	}
</style>