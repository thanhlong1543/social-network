<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-7">
	<!-- Friend List
            ================================================= -->
	<div class="pending-list">
		<div class="row">
			<c:forEach items="${listPending }" var="item">
				<div class="col-md-12 col-sm-12">
					<div class="pending-card">
						<div class="pending-info">
							<div class="pending-bottom">

								<div class="pending-action">
										<a class="btn btn-success accept-friend">Accept</a>
										<a class="btn btn-del del-friend">Del</a>
								</div>
							</div>
							<img src='<c:url value="resources//albums/user/avt/${item.useravt }"></c:url>' alt="user" class="pending-img" />
							<a href="#" class="pending-name">${item.name }</a>
							<input type="hidden" class="id-user" value="${item.userId }">
						</div>
						
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</div>