<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rock+Salt&display=swap" rel="stylesheet">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='resources/img/icon.png'></c:url>"/>
    <link rel="stylesheet" href="<c:url value='resources/css/login.css'></c:url>">
</head>
<body>
    <div class="dialog-bgr">
        <div class="dialog-regist">
            <div class="step-indicator"></div>
            <div class="dialog-body">
                <div class="form-regist">
                    <form:form id="form-signup" modelAttribute="login">
                        <h1>Sign up</h1>
                        <h2>New experiences</h2>
                        <!-- <img src="logoblack.png" alt=""> -->
                        <div>
                            <form:label path="email" for="email">Email</form:label>
                            <form:input type="text" path="email" id="email" ></form:input>
                            <form:errors path="email" cssClass="text-danger" />
                        </div>
                        <div>
                            <form:label path="password1">Password</form:label>
                            <form:input type="password" path="password1" id="password1"></form:input>
                        </div>
                        <div>
                            <form:label path="password2" >Password again</form:label>
                            <form:input type="password" path="password2" id="password2" ></form:input>
                        </div>
                        <input type="submit" value="Sign up" class="btn-general"  readonly>
                        
                    </form:form>
                </div>
                <div class="step-2">
                    <i class='fas fa-angle-left' style='font-size:50px;color:#40A798' onclick="preStep1()"></i>
                    <div>
                        <h1>The new social experiences</h1>
                        <p>We develop the new social network to connect people together. Your personalize will be not stored in web browsing</p>
                    </div>
                    <i class='fas fa-angle-right' style='font-size:50px;color:#40A798' onclick="toStep3()"></i>
                </div>
                <div class="step-3">
                    <h1>We sent you a code</h1>
                    <p>Enter it below to your email</p>
                    <form action="" class="verification">
                        <div>
                           
                            <label for="">Verify code</label>
                            <input type="text" pattern="[0-9]" placeholder="Verify code">
                        </div>
                        <input type="submit" value="Verify" class="btn-general">
                    </form>
                </div>
            </div>
            <i class="fas fa-times"onclick="closeSignUpForm()"></i>
        </div>
    </div>
    <div class="bgr">
        <img src="<c:url value='resources/img/logo.png'></c:url>" alt="">
        <div class="form">
            <div class="tab-header">
                <div class="tab-action">
                    <a  class="tab active-tab" onclick="login()">SIGN IN</a>
                    <a  class="tab" onclick="register()">SIGN UP</a>
                </div>
                <div id="tab-indicator"></div>
            </div>
            
            <div class="form-container">
                <div class="signin-container">
                    <form action="">
                        <h1>Login</h1>
                        <h2>New experiences</h2>
                        <!-- <img src="logoblack.png" alt=""> -->
                        <div>
                            <label for="">Input your email</label>
                            <input type="email" placeholder="Enter username">
                        </div>
                        <div>
                            <label for="">Input your password</label>
                            <input type="password" placeholder="Enter password">
                        </div>
                        
                        
                        <input type="submit" value="Sign in" class="btn-general">
        
                    </form>
                </div>
                
                
            </div>
            
        </div>
    </div>
    <div class="medal-signup">
        
    </div>
</body>

<script>
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

    stepIndicator = document.getElementsByClassName("step-indicator");
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
        z.style.left = "0";
        tab = document.getElementsByClassName("tab");
        tab[0].className += " active-tab";
        tab[1].className = tab[1].className.replace(" active-tab", "");
    }
    
    
    $("#form-signup").submit(function(e){
    	e.preventDefault();
    	form = $(this);
    	console.log(form);
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
			e.preventDefault();
 
		    var data = {}
		    var Form = this;
 			
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
				console.log("error"),
				console.log(e.responseText)
            }
        });
    });
    
</script>
</html>