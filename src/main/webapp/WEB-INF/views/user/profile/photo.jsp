<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-photo">
		<c:forEach items="${photos }" var="item">
				<div class="photo-item">
					<img onclick="showPost(${item.postId})" src='<c:url value="/albums/imagesOfPost/${item.image.imgName }"></c:url>' alt="">
				</div>
			
		</c:forEach>
        
    </div>
<script>
function testClick(e){
	alert(e);
}
</script>

