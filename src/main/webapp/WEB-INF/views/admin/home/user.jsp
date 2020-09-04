<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <div class="content">
       	   <div class = "manager-content" style="padding-top: 100px">
       	<div class="input-group no-border" style="width: 10%">
                    <input type="text" value=""id="myInput" class="form-control" placeholder="Search..." >
                  </div>
			<table border="1" style="border: 1px;width: 100%;color: #fff;" >
				<thead>
					<tr>
						<td>STT</td>
							<td>userid</td>
							<td>name</td>
							<td>phone</td>
							<td>email</td>
							<td>roleid</td>
						
					</tr>
					
				</thead>
				<tbody id="myTable">
					<c:forEach items="${userlist }" var="item" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td>${item.userId }</td>
							<td>${item.name }</td>
							<td>${item.phone }</td>
							<td>${item.email }</td>
							<td>${item.roleId }</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
      </div>
      
     <content tag="scripts">
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
