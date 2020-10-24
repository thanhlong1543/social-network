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
    <title>Ambition</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='images/icon.png'></c:url>"/>
    <link rel="stylesheet" href="<c:url value='css/login.css'></c:url>">
    <link rel="stylesheet" href="<c:url value='css/loading.css'></c:url>">
</head>
<body>
    <div class="dialog-bgr">
        <div class="dialog-regist">
            <div class="step-indicator"></div>
            <div class="dialog-body">
                <div class="form-regist">
                    <form:form id="form-signup" modelAttribute="signup">
                        <h1>Sign up</h1>
                        <h2>New experiences</h2>
                        <%-- <img src="<c:url value='img/logoblack.png'></c:url>" alt=""> --%> 
                        <div>
                            <form:label path="registEmail" >Email</form:label>
                            <form:input type="text" path="registEmail" ></form:input>
                        </div>
                        <div>
                            <form:label path="password1">Password</form:label>
                            <form:input type="password" path="password1" id="password1"></form:input>
                        </div>
                        <div>
                            <form:label path="password2" >Password again</form:label>
                            <form:input type="password" path="password2" id="password2" ></form:input>
                        </div>
                        <button type="submit" value="Sign up" class="btn-cuaduc" >Sign up</button>
                        
                        <p id="alert-signup" class="text-alert">Please fill out the form</p>
                            
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
                	<h1>Activate account</h1>
                    <p>Please check your email and click the link below to activate your account</p>
                    <!-- <a href="https://mail.google.com/">Go to email</a> -->
                    
					<a id="verify-code" class="register-link" onclick="sendEmail()">Get email</a>
                    
                </div>
                <div id="spin-container">
	                   <div id="loader">
	                   </div>
	
	                   <h1 id="count-display"></h1>
               	</div>
            </div>
            <i class="fas fa-times"onclick="closeSignUpForm()"></i>
        </div>
    </div>
    <%-- <div class="bgr">
    	<h4 id="verify-message">${message}</h4>
        <img src="<c:url value='images/logoambi.png'></c:url>" alt="">
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
                    <form:form id="form-login" modelAttribute="login">
                        <h1>Login</h1>
                        <h2>New experiences</h2>
                        <!-- <img src="logoblack.png" alt=""> -->
                         <div>
                            <form:label path="email" >Input your email</form:label>
                            <form:input path="email" type="text" ></form:input>
                        </div>
                       <div>
                            <form:label path="password" placeholder="password">Input your password</form:label>
                            <form:input path="password" type="password"></form:input>
                        </div>
                        <input type="submit" value="Sign in" class="btn-general">
        				<p id="alert-login" class="text-alert">Email or password is incorrect!</p>
                    </form:form>
                </div>
                
                
            </div>
            
        </div>
    </div> --%>
    <div class="form-container">
          <div class="login-form">
              <div class="form-left">
                  <div>
                      <h1>Ambition Social Network</h1>
                      <h3>Coming together to create meaningful change</h3>
                  </div>
              </div>
              <div class="form-right">
                  <img src="<c:url value='images/logoambi.png'></c:url>" alt="">
                  <form:form id="form-login" modelAttribute="login">
                        <!-- <img src="logoblack.png" alt=""> -->
                         <div>
                            <form:label path="email" >Input your email</form:label>
                            <form:input path="email" type="text" ></form:input>
                        </div>
                       <div>
                            <form:label path="password" placeholder="password">Input your password</form:label>
                            <form:input path="password" type="password"></form:input>
                        </div>
                        <button type="submit" value="Sign in" class="btn btn-cuaduc">Sign in</button>
        				<p id="alert-login" class="text-alert">Email or password is incorrect!</p>
                  </form:form>
                  
                  <p>Dont have an account yet? <span><a onclick="register()" class="register-link">Register now</a></span></p>
              </div>
          </div>
    </div>
    <!-- <div class="medal-signup">
        
    </div> -->
</body>

<script src="<c:url value='/js/login.js'></c:url>"></script>
</html>