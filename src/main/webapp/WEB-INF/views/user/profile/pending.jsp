<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Friend List
            ================================================= -->
<c:if test="${personalUri.equals(uri) }">
	<h2>Friend requests</h2>
	<div class="pending-list">
		<div class="row">
			<c:forEach items="${listPending }" var="item">
				<div class="col-md-12 col-sm-12">
					<div class="pending-card">
						<div class="pending-info">
							<div class="pending-bottom">

								<div class="pending-action">
									<a class="btn btn-success accept-friend"
										onclick="confirmRequest(${item.userId})">Accept</a> <a
										class="btn btn-del deny-friend"
										onclick="cancelRequest(${item.userId})">Cancel</a>
								</div>
							</div>

							<img
								src='<c:url value="/albums/user/avt/${item.useravt }"></c:url>'
								alt="user" class="pending-img" /> <a href="#"
								class="pending-name">${item.name }</a> <input type="hidden"
								class="id-user" value="${item.userId }">

						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</c:if>
