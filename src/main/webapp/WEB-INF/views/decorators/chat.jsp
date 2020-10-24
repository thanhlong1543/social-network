<!-- Chuc Kim Thien -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id ="chat" class="box-chat">
   
</div>
    
    <style>
    .box-chat{
   		position: fixed;
    	right: 0;
   		bottom: 0;
   		z-index: 9;
    }
    .box-chat .chat{
        width:300px;
        display: inline-block;
        background-color: #c2f1e2;
        -webkit-box-shadow: -7px -6px 16px 1px rgba(0,0,0,0.39);
        -moz-box-shadow: -7px -6px 16px 1px rgba(0,0,0,0.39);
        box-shadow: -4px -1px 19px 1px rgba(0,0,0,0.39);
        border-top-left-radius:10px;
        border-top-right-radius:10px;
        
    }
    .box-chat .chat .header{
        height: 40px;
        background-color:#40A798;
        border-top-left-radius:10px;
        border-top-right-radius:10px;
    }
    .box-chat .chat .header .hide-detail{
        display: none;
        position: absolute;
        background-color: #323232;
        top: -20px;
        right: 32px;
        border-radius: 10px;
        height: 30px;
    }
    .box-chat .chat .header .hide-detail p{
        font-size:10px;
        color:#fff;
        padding:0 10px;
        line-height: 30px;
    }
    .box-chat .chat .header .close-detail{
        display: none;
        position: absolute;
        background-color: #323232;
        top: -20px;
        right: 0;
        border-radius: 10px;
        height: 30px;
    }
    .box-chat .chat .header .close-detail p{
        font-size:10px;
        color:#fff;
        padding:0 10px;
        line-height: 30px;
    }
    .box-chat .chat .header .avatar{
        height: 100%;
        width: 10%;
        display: inline-block;
        float: left;
        position: relative;
        margin-left: 10px;
    }
    .box-chat .chat .header .avatar img{
        border-radius: 50%;
        width: 100%;
    	height: auto;
        margin-top: 3px;
    }
    .box-chat .chat .header .avatar .active{
        height: 10px;
        width: 10px;
        background-color: #31a24c;
        position: absolute;
        bottom:3px;
        right:0;
        border-radius:50%;
        border:1px solid #fff;
    }
    .box-chat .chat .header .name{
        height: 100%;
        width:60%;
        display: inline-block;
        float: left;
        padding-left: 20px;
        padding-top:10px;
        cursor: pointer;
    }
    .box-chat .chat .header .name a{
        color: white;
        text-decoration:none;
        font-weight: bold;
        font-size: 15px;
    }
    .box-chat .chat .header .name a:hover{
    	color:#bce0ee;
    }
    .box-chat .chat .header .event{
        width: 20%;
        height: 100%;
        display: inline-block;
        float: left;
        padding-top:10px;
    }
    .box-chat .chat .header .event .closee{
        width: 20%;
        height: 100%;
        float: right;
        cursor: pointer;
    }
    .box-chat .chat .header .event .closee .closeeee{
        color:#fff;
        font-weight: bold;
        float:right;
        font-size: 15px;
    }
    .box-chat .chat .header .event .closee .closeeee:hover{
    	color:#bce0ee;
    }
    .box-chat .chat .header .event .hidee{
        width: 20%;
        height: 100%;
        float: left;
        cursor: pointer;
    }
    .box-chat .chat .header .event .hidee .hideeee{
    	margin-bottom:10px;
    	font-size:22px;
        color: #fff;
        font-weight: bold;
        float:left;
        margin: -7px 0px 0px 14px;
        text-shadow: 0 1px 0 #fff;
    }
    .box-chat .chat .header .event .hidee .hideeee:hover{
    	color:#bce0ee;
    }
    .box-chat .chat .content{
        margin-left: 10px;
        height: 300px;
        width: 93%;
        background-color:#fff;
        overflow:auto;
        position:relative;
    }
    .box-chat .chat .content .host{
	   	display:inline-flex;
	   	width:95%;
	   	flex-flow: row-reverse;
    }
    .box-chat .chat .content .host img{
		height:30px;
		width:30px;
        border-radius: 50%;	
        display:inline-block;
        float:right;
        margin-left:5px;
    }
    .box-chat .chat .content .host .host-mess{
    	float:right;
        background-color: #dcdcdc;
        border-radius: 10px;
        margin: 2px 0;
        display:flex;
    }
    .box-chat .chat .content .host .host-mess p{
        font-size:14px;
        margin:0;
    	padding: 5px 10px;
    	word-wrap: break-word;
    	max-width: 175px;
	}
    
    .box-chat .chat .content .friend{
	   	display:inline-flex;
	   	width:95%;
	   	margin-left:12px;
    }
    .box-chat .chat .content .friend img{
        height:30px;
        width:30px;
        border-radius: 50%;
        display:inline-block;
        float:left;
        margin-right:5px;
    }
    .box-chat .chat .content .friend .friend-mess{
    	display:flex;
    	float: left;
        background-color: #40A798;
        border-radius:10px;
        margin: 2px 0;
    }
    .box-chat .chat .content .friend .friend-mess p{
        font-size:14px;
        margin: 8px;
        color:#fff;
    	word-wrap: break-word;
    	max-width:175px;
	}
    
    .box-chat .chat .form{
        height: 60px;
        width: 100%;
        position: relative;
        overflow:hidden;
    }
    .box-chat .chat .form #content{
        height: 80%;
        width: 80%;
        display: inline-block;
        float: left;
    }
    .box-chat .chat .form #content textarea{
        height: 90%;
        width: 95%;
        margin-left: 10px;
        margin-top:7px;
        border:none;
        line-height: 20px;
        padding: 0 10px;
        font-size: 15px;
    }
    .box-chat .chat .form #content textarea:focus{
        outline-style: none;
        -webkit-box-shadow: inset 1px 3px 29px 14px rgba(0,0,0,0.15);
        -moz-box-shadow: inset 1px 3px 29px 14px rgba(0,0,0,0.15);
        box-shadow: inset -1px 1px 10px 1px rgb(0 0 0 / 20%);
    }
    .box-chat .chat .form #submit{
        position: absolute;
        height:30px;
        width:30px;
        bottom: 15px;
    	right: 15px;
    	background-color:#40A798;
    	border-radius:50%;
    }
    .box-chat .chat .form #submit i{
        color:#fff;
        font-size: 15px;
    	padding: 7px;
    }
    .box-chat .chat .form #submit:hover i{
    	color:#bce0ee;
    }
    .box-chat .chat .form .send-detail{
        display: none;
        position: absolute;
        background-color: #323232;
        top: -10px;
        right: 5px;
        border-radius: 10px;
        height: 30px;
    }
    .box-chat .chat .form .send-detail p{
        font-size:10px;
        color:#fff;
        padding:0 10px;
        line-height: 30px;
    }
   
</style>
<script>
   
</script>
