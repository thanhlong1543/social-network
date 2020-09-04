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
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
      </div>
    <content tag="scripts">
 		<script scr='<c:url value="/resources/admin/js/post.js"/>'> </script>
 	</content>  
  