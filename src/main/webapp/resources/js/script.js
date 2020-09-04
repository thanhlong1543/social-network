'use strict'

//Preloader
$.ajaxSetup({
    headers: { 'Authorization':  localStorage.getItem('token')}
});
var preloader = $('#spinner-wrapper');
$(window).on('load', function() {
    var preloaderFadeOutTime = 500;

    function hidePreloader() {
        preloader.fadeOut(preloaderFadeOutTime);
    }
    hidePreloader();
});

jQuery(document).ready(function($) {

    //Incremental Coutner
    if ($.isFunction($.fn.incrementalCounter))
        $("#incremental-counter").incrementalCounter();

    //For Trigering CSS3 Animations on Scrolling
    if ($.isFunction($.fn.appear))
        $(".slideDown, .slideUp").appear();

    $(".slideDown, .slideUp").on('appear', function(event, $all_appeared_elements) {
        $($all_appeared_elements).addClass('appear');
    });

    //For Header Appearing in Homepage on Scrolling
    var lazy = $('#header.lazy-load')

    $(window).on('scroll', function() {
        if ($(this).scrollTop() > 200) {
            lazy.addClass('visible');
        } else {
            lazy.removeClass('visible');
        }
    });

    //Initiate Scroll Styling
    if ($.isFunction($.fn.scrollbar))
        $('.scrollbar-wrapper').scrollbar();

    if ($.isFunction($.fn.masonry)) {

        // fix masonry layout for chrome due to video elements were loaded after masonry layout population
        // we are refreshing masonry layout after all video metadata are fetched.
        var vElem = $('.img-wrapper video');
        var videoCount = vElem.length;
        var vLoaded = 0;

        vElem.each(function(index, elem) {

            //console.log(elem, elem.readyState);

            if (elem.readyState) {
                vLoaded++;

                if (count == vLoaded) {
                    $('.js-masonry').masonry('layout');
                }

                return;
            }

            $(elem).on('loadedmetadata', function() {
                vLoaded++;
                //console.log('vLoaded',vLoaded, this);
                if (videoCount == vLoaded) {
                    $('.js-masonry').masonry('layout');
                }
            })
        });


        // fix masonry layout for chrome due to image elements were loaded after masonry layout population
        // we are refreshing masonry layout after all images are fetched.
        var $mElement = $('.img-wrapper img');
        var count = $mElement.length;
        var loaded = 0;

        $mElement.each(function(index, elem) {

            if (elem.complete) {
                loaded++;

                if (count == loaded) {
                    $('.js-masonry').masonry('layout');
                }

                return;
            }

            $(elem).on('load', function() {
                loaded++;
                if (count == loaded) {
                    $('.js-masonry').masonry('layout');
                }
            })
        });

    } // end of `if masonry` checking


    //Fire Scroll and Resize Event
    $(window).trigger('scroll');
    $(window).trigger('resize');

});

/**
 * function for attaching sticky feature
 **/

function attachSticky() {
    // Sticky Chat Block
    $('#chat-block').stick_in_parent({
        parent: '#page-contents',
        offset_top: 70
    });

    // Sticky Right Sidebar
    $('#sticky-sidebar').stick_in_parent({
        parent: '#page-contents',
        offset_top: 70
    });

}

// Disable Sticky Feature in Mobile
$(window).on("resize", function() {

    if ($.isFunction($.fn.stick_in_parent)) {
        // Check if Screen wWdth is Less Than or Equal to 992px, Disable Sticky Feature
        if ($(this).width() <= 992) {
            $('#chat-block').trigger('sticky_kit:detach');
            $('#sticky-sidebar').trigger('sticky_kit:detach');

            return;
        } else {

            // Enabling Sticky Feature for Width Greater than 992px
            attachSticky();
        }

        // Firing Sticky Recalculate on Screen Resize
        return function(e) {
            return $(document.body).trigger("sticky_kit:recalc");
        };
    }
});

// Fuction for map initialization
function initMap() {
  var uluru = {lat: 12.927923, lng: 77.627108};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 15,
    center: uluru,
    zoomControl: true,
    scaleControl: false,
    scrollwheel: false,
    disableDoubleClickZoom: true
  });
  
  var marker = new google.maps.Marker({
    position: uluru,
    map: map
  });
}

//function for accept friend

$.each($(".accept-friend"), function(idx){
	$(".accept-friend")[idx].addEventListener('click', function(){
		acceptFriend($(".id-user")[idx].value, idx);
	});
});
function itemFriendAnimation(idx){
	$(".pending-card")[idx].style.margin =  '-50px';
	$(".pending-card")[idx].style.opacity = '0';
	$(".pending-card")[idx].style.transition = 'all .4s';
	$(".pending-card")[idx].style.display = 'none';
}
function acceptFriend(id, idx) {
	$.ajax({
		url : "http://localhost:8080/ambi/api/pending/accept/"+id,
		type : "GET",
		success : function(noti) {
			itemFriendAnimation(idx);
			idx--;
		//window.location.href = "http://localhost:8080/ambi/pending"; 
		}
	});
}
//end func accept friend

//function del friend
$.each($(".deny-friend"), function(idx){
	$(".deny-friend")[idx].addEventListener('click', function(){
		denyFriend($(".id-user")[idx].value, idx);
	});
});
function denyFriend(id, idx) {
	$.ajax({
		url : "http://localhost:8080/ambi/api/pending/delete/"+id,
		type : "GET",
		success : function(noti) {
			itemFriendAnimation(idx);
			idx--;
		//window.location.href = "http://localhost:8080/ambi/pending"; 
		}
	});
}
//function del friend
		
//get list friend
let dataResource = {};

getFriend();
function getFriend(){
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		url : "http://localhost:8080/ambi/api/friend/2",
		type: "GET",
		success: function(data){
				dataResource = data;
				appendToList(dataResource);
		}
	});
}

function appendToList(data){
	$(".friend-list .row").empty();
	for(let i = 0; i< data.length;i++){
		var idUser = $(`<input type='hidden' class='id-user' value='${data[i].userId}' >`);//id user
		
		var subMenu = $("<div class='sub-menu'></div>");
		var option = $("<div class='dot-more'></div>");
		var op1 = $("<span class='dot'></span>");
		var op2 = $("<span class='dot'></span>");
		var op3 = $("<span class='dot'></span>");
		
		var subContainer = $("<div class='sub-container'></div>");
		var sub1 = $(`<a onclick="confirmUnfriend(this)" class='sub btn-unfriend'>Unfriend</a>`); sub1.append(idUser);
		var sub2 = $("<a class='sub'>Chat</a>");
		var sub3 = $("<a class='sub'>Profile</a>");
		subContainer.append(sub1, sub2, sub3);
		option.append(op1, op2, op3);
		subMenu.append(option, subContainer);
		
		var curl = "'<c:url value='/albums/user/avt/"+data[i].useravt+"'></c:url>'";
		
		var name = $("<a href='timeline.html' class='profile-link'></a>").text(data[i].name);
		//var myFriend = $("<a href='#' class='pull-right text-green'></a>").text("My friend");
		
		var friendInfo = $("<div class='friend-info'></div");
		friendInfo.append(name);
		var imgAvt = $(`<img src='albums/user/avt/${data[i].useravt}' alt='user' class='profile-photo-lg' />`);
		var cardInfo = $("<div class='card-info'></div>").append(imgAvt, friendInfo);
		
		var imgBgr = $(`<img src='images/covers/1.jpg' alt="profile-cover"
				class="img-responsive cover" />`);
		var friendCard = $("<div class='friend-card'></div>").append(imgBgr, cardInfo, subMenu);
		
		var item = $("<div class='col-md-6 col-sm-6'></div>").append(friendCard);
		
		
		
		
		$(".friend-list .row").append(item);
	}
}
function compareInputToData(value, data){
	var filteredData = [];
	for(let i = 0; i <data.length;i++){
		value = value.toLowerCase();
		var name = data[i].name.toLowerCase();
		if(name.includes(value)){
			filteredData.push(data[i]);
		}
	}
	return filteredData;
}
$(".search-friend").on('keyup', function(){
	var value = $("#search-friend-value").val();
	console.log(value);
	var data = compareInputToData(value, dataResource);
	appendToList(data);
})

//unfriend


function confirmUnfriend(event){
	let ok = confirm("A du sua?");
	if(ok){
		let id = event.children[0].value;
		$.ajax({
			url: "http://localhost:8080/ambi/api/friend/delete/"+id,
			method: "PUT",
			success: function(){
				alert("Successful");
				window.location.reload();
			}
		})
		
	}
}
//get list friend



//auto load page when press back button
window.addEventListener( "pageshow", function ( event ) {
  var historyTraversal = event.persisted || 
                         ( typeof window.performance != "undefined" && 
                              window.performance.navigation.type === 2 );
  if ( historyTraversal ) {
    // Handle page restore.
    window.location.reload();
  }
//auto load page when press back button
});

//searching friend

//searching friend

