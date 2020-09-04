var btns = document.getElementsByClassName("tab");
    var current = document.getElementsByClassName("active-tab");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
        
        current[0].className = current[0].className.replace(" active-tab", "");
        this.className += " active-tab";
    });
    }
    z = document.getElementById("tab-indicator");
    
    function login(){
        z.style.left = "0";
    }
    function register(){
        z.style.left = "calc(100%/2)";
        dialog = document.getElementsByClassName("dialog-bgr");
        dialog[0].style.display = "flex";
        
        dialog[0].style.opacity = "1";
    }
    formStep1 = document.getElementsByClassName("form-regist");
    step2 = document.getElementsByClassName("step-2");
    step3 = document.getElementsByClassName("step-3");

    stepIndicator = document.getElementsByClassName("step-indicator");//step indicator id
    function toStep2(){
    	var email = document.getElementById("email");
        var pass1 = document.getElementById("password1");
        var pass2 = document.getElementById("password2");
            formStep1[0].style.left = "-650px";
            step2[0].style.left = "50px";
            stepIndicator[0].style.left = `calc(100%/3)`;
    }
    function toStep3(){
        step2[0].style.left = "-650px";
        step3[0].style.left = "50px";
        stepIndicator[0].style.left = `calc(100%*2/3)`;
    }
    function preStep1(){
        formStep1[0].style.left = "50px";
        step2[0].style.left = "650px";
        stepIndicator[0].style.left = `0`;
    }
    function closeSignUpForm(){
        dialog = document.getElementsByClassName("dialog-bgr");
        dialog[0].style.opacity = "0";
        dialog[0].style.display = "none";
        z.style.left = "0";//tab indicator
        tab = document.getElementsByClassName("tab");
        tab[0].className += " active-tab";
        tab[1].className = tab[1].className.replace(" active-tab", "");
		//reset step
		formStep1[0].style.left = "50px";
		step2[0].style.left = "650px";
        step3[0].style.left = "650px";
		stepIndicator[0].style.left = "0";

    }

$(document).ready(function() {
  $.ajaxSetup({
    headers: { 'Authorization':  localStorage.getItem('token')}
	});
});

    $("#form-signup").submit(function(e){
    	e.preventDefault();
    	form = $(this);
    	/* $.ajax({
    		url: "http://localhost:8080/ambi/api/signup",
    		type: "POST",
    		dataType: 'json',
    		data: JSON.stringify(form.serialize()),
    		success: function(data){
    			console.log(data);
    		}
    	}); */
    	/* $.ajax({
    		url: "http://localhost:8080/ambi/api/signup",
    		type: "POST",
    		dataType: 'json',
    		contentType: 'application/json',
    		data: JSON.stringify(form.serialize()),
    		success: function(data){
    			console.log(data);
    		},
    		
    	}); */
 
		    var data = {}
 			
		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
			console.log(data);
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: "POST",
            url: "http://localhost:8080/ambi/api/signup/",
            data : JSON.stringify(data),
            success : function(callback){
				console.log("success");
				toStep2();
				/*window.location.replace('http://localhost:8080/livedinner/menu');*/
            },
            error : function(e){
            	
            	console.log(e.responseJSON)
				$("#alert-signup").css("opacity","1");
				setInterval(function(){
					$("#alert-signup").css("opacity","0");
				}, 5000);
            }
        });
    });
$("#form-login").submit(function(e){
    	e.preventDefault();
    	form = $(this);
 
			e.preventDefault();
 
		    var data = {}
 			
		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
			console.log(data);
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: "POST",
            url: "http://localhost:8080/ambi/api/login",
            data : JSON.stringify(data),//send data
            success : function(data){
				localStorage.setItem('token', "Bearer " + data);
				window.location.replace('http://localhost:8080/ambi/');
            },
            error : function(e){
            	console.log(e.responseJSON)
				$("#alert-login").css("opacity","1");
				setInterval(function(){
					$("#alert-login").css("opacity","0");
				}, 5000);
            }
        });
    });


    function getCount(){
        time = 9;
        a = document.getElementById("verify-code");
        x = document.getElementById("spin-container");
        a.style.display = 'none';
        y = document.getElementById("count-display");
        count = setInterval(function(){

            x.style.display = "inline-block";
            y.innerHTML = time;
            if (time > 0) time--;
            else {
                y.innerHTML = "";
                clearInterval(count);
                a.style.display = "inline-block";
                x.style.display = "none";
            }
        }, 1000);
        $.ajax({
        	 contentType : 'application/json; charset=utf-8',
             type: "POST",
             url: "http://localhost:8080/ambi/api/sendmail",
             success : function(callback){
 				console.log("success");
 				/*window.location.replace('http://localhost:8080/livedinner/menu');*/
             },
             error : function(e){
             }
        });
        
    }