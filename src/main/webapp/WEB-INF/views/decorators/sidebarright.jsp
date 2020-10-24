<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Newsfeed Common Side Bar Right
          ================================================= -->
<div class="col-md-2 static">
	<div class="suggestions" id="sticky-sidebar">
              <h4 class="grey">People you may know</h4>
              <c:forEach items="${mutual}" var="item">
              	<div class="follow-user">
	                <img src="<c:url value='/albums/user/avt/${item.useravt}'></c:url>" alt="" class="profile-photo-sm pull-left" />
	                <div>
	                  <h5><a href="${routes.profile }/${item.userUrl}">${item.name}</a></h5>
	                  <c:if test="${item.mutual > 1}">
	                  	<p class="small mutual-text">(${item.mutual } mutual friends)</p>
	                  		<div class="hide-detail">
			                  	<c:forEach items="${item.listMutual}" var="item2">
			                  			<p >${item2.name }</p>
			                  	</c:forEach>
	                  		</div>
	                  </c:if>
	                  <c:if test="${item.mutual == 1}">
	                  	<p class="small mutual-text">(${item.mutual } mutual friend)</p>
	                  		<div class="hide-detail">
			                  	<c:forEach items="${item.listMutual}" var="item2">
			                  			<p >${item2.name }</p>
			                  	</c:forEach>
	                  		</div>
	                  </c:if>
	                  <a id="home-request-${item.userId}" onclick="sendHomeRequest(${item.userId})" class="text-green small">Add friend</a>
	                  <a id="home-cancel-${item.userId}" onclick="cancelHomeRequest(${item.userId})" class="text-grey small home-cancel">Cancel request</a>	                
	                </div>
              	</div>
              </c:forEach>
     </div>
</div>
