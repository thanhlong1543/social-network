<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <div class="content">
            <div id="chart" style="width:auto; height:500px;"></div>
             <span class="title-chart" style="position: absolute; right: 5%; top: 52%; z-index: 10; display: inline-block;">Post Date</span>  
            <div id="chart_user" style="width:800px; height:500px; margin-top: 50px; margin-left: 400px;">                   
    		  </div>
 			<span class="title-user-chart" style="position: absolute; right: 31%; top: 108%; z-index: 10; display: inline-block;">User Id</span>
 			
      </div>
      

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 	<script type="text/javascript">
		
 		/* @author: Truong */
 		  
 		// Visualization API with the 'corechart' package.
 		google.charts.load('visualization', {packages : ['corechart'] });
 		google.charts.setOnLoadCallback(drawLineChart);
 		
 		function drawLineChart() {
 			$.ajax({
 				headers: { 'Authorization': localStorage.getItem('token') },
 				url:"http://localhost:8080/ambi/api/postlist/",
 				dateType: "json",
 				type:"GET",
 				contentType: "application/json; charset=utf-8",
 				success : function(data) {
 					var arrLikes = [['postDate','totalLike','userId']];
 				// Define an array and assign columns for the chart.

 	                // Loop through each data and populate the array.
 					$.each(data, function(index,value) {
 						value.postDate = value.postDate.split(" ")[0];

 						arrLikes.push([value.postDate,value.totalLike, value.userId]);
 					});
 					  // Set chart Options.
 					var options = {
 							title: 'Total Likes',
 							curveType : 'function',
 							legend: {position: 'top',
 							textStyle : { color: '#555', fontSize : 14} }	 // You can position the legend on 'top' or at the 'bottom'.
 							};
 				   // Create DataTable and add the array to it.
 					var figures = google.visualization.arrayToDataTable(arrLikes);
 				// Define the chart type (LineChart) and the container (a DIV in our case).
 					var chart = new google.visualization.LineChart(document.getElementById('chart'));
 					
 					chart.draw(figures, options);  // Draw the chart with Options.
 					},
 					error: function(XMLHttpRequest, textStatus, errorThrown) {
 						alert('Got an Error');
 					}
 			});
 		}


 		// Visualization API with the 'corechart' package.
 		google.charts.load('visualization', {packages : ['corechart'] });
 		google.charts.setOnLoadCallback(drawLineChartUser);
 		
 		function drawLineChartUser() {
 			$.ajax({
 				headers: { 'Authorization': localStorage.getItem('token') },
 				url:"http://localhost:8080/ambi/api/userlist",
 				dateType: "json",
 				type:"GET",
 				contentType: "application/json; charset=utf-8",
 				success : function(data) {
 					var arrUserActive = [['userId','isactive']];
 				// Define an array and assign columns for the chart.

 	                // Loop through each data and populate the array.
 					$.each(data, function(index,value) {
 						if(value.isactive == true){
 							value.isactive = 100;
 							arrUserActive.push([value.userId,value.isactive]);
 						} else if( value.isactive == null) {
 							value.isactive = 0;
 							arrUserActive.push([value.userId,value.isactive]);
 						}
 						
 					});
 					  // Set chart Options.
 					var options = {
 							title: 'User Active',
 							curveType : 'function',
 							legend: {position: 'top',
 							textStyle : { color: '#555', fontSize : 14} }	 // You can position the legend on 'top' or at the 'bottom'.
 							};
 				   // Create DataTable and add the array to it.
 					var figures = google.visualization.arrayToDataTable(arrUserActive);
 				// Define the chart type (LineChart) and the container (a DIV in our case).
 					var chart = new google.visualization.LineChart(document.getElementById('chart_user'));
 					
 					chart.draw(figures, options);  // Draw the chart with Options.
 					},
 					error: function(XMLHttpRequest, textStatus, errorThrown) {
 						alert('Got an Error');
 					}
 			});
 		}
 		</script>
 		<script scr='<c:url value="/resources/admin/js/dashboard.js"/>'> </script>

  