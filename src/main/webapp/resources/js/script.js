'use strict'

//Preloader

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

/*$.each($(".accept-friend"), function(idx){
	$(".accept-friend")[idx].addEventListener('click', function(){
		acceptFriend($(".id-user")[idx].value, idx);
	});
});*/
function itemFriendAnimation(idx){
	$(".pending-card")[idx].style.margin =  '-50px';
	$(".pending-card")[idx].style.opacity = '0';
	$(".pending-card")[idx].style.transition = 'all .4s';
	$(".pending-card")[idx].style.display = 'none';
}
function confirmRequest(id) {
	$.ajax({
		url : "http://localhost:8080/ambi/api/pending/accept/"+id,
		type : "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success : function(noti) {
			
			window.location.reload();
		//window.location.href = "http://localhost:8080/ambi/pending"; 
		}
	});
}
//end func accept friend

//function del friend
/*$.each($(".deny-friend"), function(idx){
	$(".deny-friend")[idx].addEventListener('click', function(){
		denyFriend($(".id-user")[idx].value, idx);
	});
});*/
function cancelRequest(id) {
	$.ajax({
		url : "http://localhost:8080/ambi/api/pending/delete/"+id,
		type : "PUT",
		headers: { 'Authorization': localStorage.getItem('token') },
		success : function(noti) {
			//itemFriendAnimation(idx);
			//idx--;
		//window.location.href = "http://localhost:8080/ambi/pending";
			window.location.reload();
		}
	});
}
//function del friend
		




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

/*$('#post-form').submit(function(e) {
		form = $(this);
		    var data = {}
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
		e.preventDefault();
   		var fd = new FormData();
   		console.log(data.content+":"+data.privacy);
   		var file = document.getElementById('imgInp').files[0];
   		var dataString = {
			   "privacyId": data.privacy,
			   "content": data.content,
			   "isdelete":false,
				"totalLike":0,
				"userId": user.userId,
				"postDate": ""
		   };
   		fd.append("postString",JSON.stringify(dataString));
   		fd.append("inputFile",file,file.name);
		for(var value of fd.values()){
			console.log(value);
		}
		$.ajax({
			 enctype:'multipart/form-data',
			 data:fd,
			 cache: false,
		     processData: false,
		     contentType: false,
			 headers: { 'Authorization': localStorage.getItem('token') },
             type: "POST",
             url: "http://localhost:8080/ambi/api/post",
             success : function(callback){
			window.location.replace('http://localhost:8080/ambi/');
             },
             error : function(e){
            	 
             }
        });
	});*/



//tab profile
/*var btns = document.getElementsByClassName("tab-profile");
    var current = document.getElementsByClassName("active-tab");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
       
        current[0].className = current[0].className.replace(" active-tab", "");
 		
        this.className += " active-tab";
    });
}*/
//getProfile();
//profile information
/*function getProfile(parent){
	let id = parent.children[0].value;
	
			alert(id);
	$.ajax({
		url: `http://localhost:8080/ambi/api/profile/${id}`,
		method: "GET",
		headers: { 'Authorization': localStorage.getItem('token') },
		success: function(data){
			//$(".avt img").attr("src", `/ambi/albums/user/avt/${data.useravt}`);
			//$(".bgr img").attr("src", `/ambi/images/covers/1.jpg`);
			//$("#profile-name").text(data.name);
		}
	})
}*/
//profile information

/*Post*/


/*	$('#post-form').submit(function(e) {
		form = $(this);
		    var data = {}
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
		e.preventDefault();
   		var fd = new FormData();
   		console.log(data);
   		var file = document.getElementById('imgInp').files[0];
   		var dataString = `{
			   "privacyId": ${data.privacy},
			   "content": ${data.content},
			   "isdelete":${false},
				"totalLike":0,
				"userId": ${user.userId},
				"postDate": ""
		   }`;
   		fd.append("post",dataString);
   		fd.append("inputFile",file,file.name);
		for(var value of fd.values()){
			console.log(value);
		}
		$.ajax({
			 enctype:'multipart/form-data',
			 data:fd,
			 cache: false,
		     processData: false,
		     contentType: false,
			 headers: { 'Authorization': localStorage.getItem('token') },
             type: "POST",
             url: "http://localhost:8080/ambi/api/post",
             success : function(callback){
 				console.log("success");
             },
             error : function(e){
            	 
             }
        });
	});
	
	function displayPostForm(){
		z = $('#postDiv');
		z.style.opacity = "1";
		z.style.display = 'flex';
	}
	
	function closePostForm(){
		z = $('#postDiv');
		z.style.display = 'none';
	}

	function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				
				reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
				console.log(e.target.result);
				}
				
				reader.readAsDataURL(input.files[0]); // convert to base64 string
			}
		}

		$("#imgInp").change(function() {
		readURL(this);
	});	
*/

function editPost(postId,postContent,postImg,totalLike,userId){
		$('#postContent').append(
				`
							<textarea name="content" id="editText" class="postTextarea" cols="30" rows="1"
								class="form-control" placeholder="What's on your mind?">${postContent}</textarea>
								  <label class="upImg" for="editImg" class="btn"><i class="fas fa-images"></i> Upload Image</label>
							<input type='text' name="postId" hidden value="${postId}" /> 
							<input type='text' name="totalLike" hidden value="${totalLike}" />  
							<input type='text' hidden name="userId" value="${userId}"/> 
							<input type='file' id="editImg" class="imgInp" accept='image/*'/> 
							<div id="blockEditImg" class="blockImg">
								<img id="editblah" class="blah" src='/ambi/albums/imagesOfPost/${postImg}' /> 
								<div class="positionClose imageClose" id="imgEditClose">
								<i class="fa">&#xf00d</i>
								</div>
							</div>
							<input class="submit-post" type="submit" value="EDIT" >
				`
				);
		$('#blockEditImg').css('display','block');
	}
$('#closeEdit').click(function(){
	$('#postContent').html("");
});

function deletePost(postId){
	$.ajax({
				headers: { 'Authorization': localStorage.getItem('token') },
    			type:"DELETE",
    			url : `http://localhost:8080/ambi/api/post/${postId}`,
    			success : function(result) {
    				 window.location.replace('http://localhost:8080/ambi/');
    			}
    		});
}
	
	
	
	function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				if($(input).attr('id')=='imgInp'){
					reader.onload = function(e) {
						$('#blah').attr('src', e.target.result);
						
						}
				} else {
					reader.onload = function(e) {
					$('#editblah').attr('src', e.target.result);
					}
				}
				reader.readAsDataURL(input.files[0]); // convert to base64 string
			}
	}

	$("#imgInp").change(function() {
		readURL(this);
		$('#blockImg').css('display','block');
	});	
	
	$('#imgClose').click(function(){
		$('#blockImg').css('display','none');
	});
	
	$(document.body).on('change','#editImg',function(){
		readURL(this);
		$('#blockEditImg').css('display','block');
	})
	
	$(document.body).on('click','#imgEditClose',function(){
		$('#blockEditImg').css('display','none');
	});

	function like(postId){
		var a = document.getElementById("like"+postId);
		var b = document.getElementById("unlike"+postId);
		b.style.display='none';
		a.style.display='block';
			var data = {
    				"postId":postId
			};
			$.ajax({
				headers: { 'Authorization': localStorage.getItem('token') },
    			type:"POST",
    			data: JSON.stringify(data),
    			contentType : 'application/json',
    			url : "http://localhost:8080/ambi/api/like",
    			success : function(result) {
    				$('#totalLike'+postId).html(result.totalLike);
    			}
    		});
	}
	
	function unlike(postId){
		var a = document.getElementById("unlike"+postId);
		var b = document.getElementById("like"+postId);
		b.style.display='none';
		a.style.display='block';
		var data = {
				"postId":postId
		};
		$.ajax({
			headers: { 'Authorization': localStorage.getItem('token') },
			type:"DELETE",
			data: JSON.stringify(data),
			contentType : 'application/json',
			url : "http://localhost:8080/ambi/api/like",
			success : function(result) {
				$('#totalLike'+postId).html(result.totalLike);
			}
		});
	}
	
	$('#post-form').submit(function(e) {
		    var data = {}
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
		e.preventDefault();
   		var fd = new FormData();
   		if($('#blockImg').css('display')=='block') {
   			var file = document.getElementById('imgInp').files[0];
   			fd.append("inputFile",file,file.name);
   		}
   		var dataString = {
			   "privacyId": data.privacy,
			   "content": data.content,
			   "isdelete":false,
				"totalLike":0,
				"userId": data.userId,
				"postDate": ""
		   };
   		
   		fd.append("postString",JSON.stringify(dataString));
		$.ajax({
			 enctype:'multipart/form-data',
			 data:fd,
			 cache: false,
		     processData: false,
		     contentType: false,
			 headers: { 'Authorization': localStorage.getItem('token') },
             type: "POST",
             url: "http://localhost:8080/ambi/api/post",
             success : function(callback){
			 window.location.replace('http://localhost:8080/ambi/');
             },
             error : function(e){
            	 
             }
        });
	});
	
	$('#edit-form').submit(function(e) {
	    var data = {}
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	e.preventDefault();
		var fd = new FormData();
	var file = document.getElementById('editImg');
		if(file.files.length!=0) {
			fd.append("inputFile",file.files[0],file.files[0].name);
		}
		var dataString = {
				"postId":data.postId,
		   "privacyId": data.privacy,
		   "content": data.content,
		   "isdelete":false,
			"totalLike":data.totalLike,
			"userId": data.userId,
			"postDate": ""
	   };
		
		fd.append("postString",JSON.stringify(dataString));
	$.ajax({
		 enctype:'multipart/form-data',
		 data:fd,
		 cache: false,
	     processData: false,
	     contentType: false,
		 headers: { 'Authorization': localStorage.getItem('token') },
         type: "POST",
         url: "http://localhost:8080/ambi/api/post/update",
         success : function(callback){
		 	window.location.replace('http://localhost:8080/ambi/');
         },
         error : function(e){
        	 
         }
    });
});
