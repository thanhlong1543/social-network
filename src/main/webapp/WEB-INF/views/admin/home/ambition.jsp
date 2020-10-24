<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="content">
    <div class="slideshow">
        <div class="slideshow-item">
            <img src="<c:url value="/images/1d561f77952347.5c96d8493dc20.jpg"/>" alt="">
            <div class="slideshow-item-text">
                <h5>Ambition</h5>
                <p>When we support small businesses, we support our communities
                </p>
            </div>
        </div>

        <div class="slideshow-item">
            <img src="<c:url value="/images/aba35777952347.5c96d8493e2e5.jpg"/>" alt="">
            <div class="slideshow-item-text">
                <h5>Ambition</h5>
                <p>We build technologies that help people connect with friends and family, find communities, and grow businesses.
                </p>
            </div>
        </div>

        <div class="slideshow-item">
            <img src="<c:url value="/images/f9b17b77952347.5c96d8493df9b.jpg"/>" alt="">
            <div class="slideshow-item-text">
                <h5>Ambition</h5>
                <p>Find and Share Support With People Near You
            </p>
            </div>
        </div>
    </div>
</div>


<style>
    *{
        padding:0;
        margin:0;
        box-sizing:border-box;
    }
    .main-panel>.content{
        margin-top: 0;
    	padding:0;
    }
    .slideshow{
        width:100%;
        height: 100vh;
        position:relative;
        overflow:hidden;
    }
    .slideshow-item{
        width: inherit;
        height: inherit;
        position: absolute;
        opacity:0;
        animation: cycleImages 31s infinite;
    }
    .slideshow-item:nth-child(1){
        animation-delay: 0s;
    }
    .slideshow-item:nth-child(2){
        animation-delay: 10s;
    }
    .slideshow-item:nth-child(3){
        animation-delay: 20s;
    }
    .slideshow-item img{
        width:100%;
        height: 100%;
        object-fit: cover;
    }
    .slideshow-item-text{
        max-width: 50%;
        position: absolute;
        top:50%;
        left:0;
        transform: translateY(-50%);
        background-color:rgba(0, 0, 0, .8);
        color:#fff;
        padding:10rem 5rem;
    }
    .slideshow-item-text h5{
        font-size: 5rem;
        font-family:'Raleway', sans-serif;
        text-transform: uppercase;
        letter-spacing: 3px;
        font-weight: 300;
    }
    .slideshow-item-text p{
        font-size: 1.6rem;
        font-family: 'Roboto',sans-serif;
        letter-spacing: 1px;
        font-weight: 300;
    }
    @keyframes cycleImages{
        25%{
            opacity:1;
        }
        40%{
            opacity:0;
        }
    }
</style>

