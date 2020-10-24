<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- Chuc Kim Thien -->


   <div class="sidebar" data-color="purple" data-background-color="black" data-image="../admin/img/sidebar-2.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><a href="/ambi/" class="simple-text logo-normal">
          AMBI
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav" id="myDIV">
        <c:forEach items="${menu}" var="lsMenu">
          <li class="nav-item" id="changLi" onclick="changColor()">
            <a class="nav-link" href="${lsMenu.description}">
              <i class="material-icons">dashboard</i>
              <p>${lsMenu.name}</p>
            </a>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <script type="text/javascript">
 		 changeColor = function() {
 			element = document.querySelector("#changeLi");
			element.style.backgroundColor = "red"
 		}
	</script>
<style>
	.sidebar .sidebar-wrapper .nav-link{
		font-weight:bold;
	}
	.sidebar .sidebar-wrapper .nav-link:hover{
		color: #fff;
	}
</style>