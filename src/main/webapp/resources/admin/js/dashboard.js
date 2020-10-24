/**
 * @author : truong
 */
/* start chart*/
 		// Visualization API with the 'corechart' package.
/* 		google.charts.load('visualization', {packages : ['corechart'] });
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
 		}*/

/* end chart*/



    $(document).ready(function() {
      $().ready(function() {
        $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        $('.fixed-plugin .img-holder').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).parent('li').siblings().removeClass('active');
          $(this).parent('li').addClass('active');


          var new_image = $(this).find("img").attr('src');

          if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
              $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
              $sidebar_img_container.fadeIn('fast');
            });
          }

          if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
              $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
              $full_page_background.fadeIn('fast');
            });
          }

          if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
          }
        });

        $('.switch-sidebar-image input').change(function() {
          $full_page_background = $('.full-page-background');

          $input = $(this);

          if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
              $sidebar_img_container.fadeIn('fast');
              $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
              $full_page_background.fadeIn('fast');
              $full_page.attr('data-image', '#');
            }

            background_image = true;
          } else {
            if ($sidebar_img_container.length != 0) {
              $sidebar.removeAttr('data-image');
              $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
              $full_page.removeAttr('data-image', '#');
              $full_page_background.fadeOut('fast');
            }

            background_image = false;
          }
        });

        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');

              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
 
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
 