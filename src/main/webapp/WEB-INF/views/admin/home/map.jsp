<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <div id="map"></div>
	<div class="content">

      	<div id="map" style="height: 500px; width: 100%;">
      	 </div>
      </div>	   

  <content tag="scripts">
   <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
  <script>
  <!--
	@author: Truong
	  -->
    function initMap(){
      // Map options
      var options = {
        zoom:8,
        center:{lat:10.802029,lng:106.649307}
      }

      // New map
      var map = new google.maps.Map(document.getElementById('map'), options);

      // Listen for click on map
      google.maps.event.addListener(map, 'click', function(event){
        // Add marker
        addMarker({coords:event.latLng});
      });



      // Array of markers
      var markers = [
        {
          coords:{lat:10.802029,lng:106.649307},
          iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
          content:'<h1>Lynn MA</h1>'
        },
        {
          coords:{lat:10.802029,lng:106.649307},
          content:'<h1>Amesbury MA</h1>'
        },
        {
          coords:{lat:10.802029,lng:106.649307}
        }
      ];

      // Loop through markers
      for(var i = 0;i < markers.length;i++){
        // Add marker
        addMarker(markers[i]);
      }

      // Add Marker Function
      function addMarker(props){
        var marker = new google.maps.Marker({
          position:props.coords,
          map:map,
          //icon:props.iconImage
        });

        // Check for customicon
        if(props.iconImage){
          // Set icon image
          marker.setIcon(props.iconImage);
        }

        // Check content
        if(props.content){
          var infoWindow = new google.maps.InfoWindow({
            content:props.content
          });

          marker.addListener('click', function(){
            infoWindow.open(map, marker);
          });
        }
      }
    }
  </script>
  <script async defer
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPJpjD-qcR_yIxJnS8maR5W9KB0E3EzYI&callback=initMap">
</script>
 		<script scr='<c:url value="/resources/admin/js/map.js"/>'> </script>
 </content>
  
