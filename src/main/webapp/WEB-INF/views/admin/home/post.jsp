<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Chuc Kim Thien -->
	
      <div class="content">
        	 <div class = "manager-content">
			<table class="table table-dark" border="1"  style="border: 1px;width: 100%;color: #fff;" >
				<thead>
					<tr>
						<td scope="col"><b>STT</b></td>
							<td scope="col"><b>postId</b></td>
							<td scope="col"><b>content</b></td>
							<td scope="col"><b>postDate</b></td>
							<td scope="col"><b>totalLike</b></td>
							<td scope="col"><b>userId</b></td>
							<td scope="col"><b>privacyId</b></td>
					</tr>
					
				</thead>
				<tbody>
					<c:forEach items="${postlist }" var="item" varStatus="status">
						<tr>
							<td scope="row">${status.index+1 }</td>
							<td>${item.postId }</td>
							<td>${item.content }</td>
							<td>${item.postDate }</td>
							<td>${item.totalLike }</td>
							<td>${item.userId }</td>
							<td>${item.privacyId }</td>
							<td>${item.isdelete }</td>
							<td><a href="javascript:void()" class="btn-delete"><button><b>Delete</b></button></a><input type="hidden" class="id-delete" value="${item.postId }"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
      </div>

    <content tag="scripts">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    	<script type="text/javascript">
			$(document).ready(function() {
				let allbtndelete = document.querySelectorAll('.btn-delete');
				allbtndelete.forEach(function(el,index) {
					el.addEventListener('click', function() {
						let input = el.parentNode.querySelector('.id-delete');
						deletePost(input.value);
					});
					
				});
			});
			
			deletePost = function(id) {
				$.ajax({
					type: "PUT",
					url: "http://localhost:8080/ambi/api/post/"+id,
					success : function() {
						alert('Deleted');
						window.location.reload();
					}
				});									
			}
		</script>
    
 		<script scr='<c:url value="/resources/admin/js/post.js"/>'> </script>
 	</content>  
  <style>
  		.btn-delete button:hover{
  			color:#fff;
  			background-color: #40A798;
  		}
  </style>