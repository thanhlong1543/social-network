<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Chat Room
            ================================================= -->
	<div class="chat-room">
              <div  class="row">
                <div class="col-md-5">

                  <!-- Contact List in Left-->
                  <ul class="nav nav-tabs contact-list scrollbar-wrapper scrollbar-outer">
                    <li class="active">
                      <a href="#contact-${conversationDtos.get(0).conId}" data-toggle="tab">
                        <div class="contact">
                        	<img src="/ambi/albums/user/avt/${conversationDtos.get(0).user.useravt}" alt="" class="profile-photo-sm pull-left"/>
                        	<div class="msg-preview">
                        		<h6>${conversationDtos.get(0).user.name}</h6>
                        		<p class="text-muted">${conversationDtos.get(0).chats.get(conversationDtos.get(0).chats.size()-1).content}</p>
                        	</div>
                        </div>
                      </a>
                    </li>
                 <c:forEach items= "${conversationDtos}" var="conversationDto" begin="1" end="${conversationDtos.size()-1}">   
                  	<li>
                      <a href="#contact-${conversationDto.conId}" data-toggle="tab">
                        <div class="contact">
                        	<img src="/ambi/albums/user/avt/${conversationDto.user.useravt}" alt="" class="profile-photo-sm pull-left"/>
                        	<div class="msg-preview">
                        		<h6>${conversationDto.user.name}</h6>
                        		<p class="text-muted">${conversationDto.chats.get(conversationDto.chats.size()-1).content}</p>
                        	</div>
                        </div>
                      </a>
                    </li>
                  </c:forEach>  
                  </ul><!--Contact List in Left End-->

                </div>
                <div class="col-md-7">

                  <!--Chat Messages in Right-->
                  
                  <div class="tab-content scrollbar-wrapper wrapper scrollbar-outer">
                  <c:forEach items= "${conversationDtos}" var="conversationDto">
                    <div class="tab-pane active" id="contact-${conversationDto.conId}">
                      <div class="chat-body">
                      	<ul class="chat-message">
                      	
                      		<c:forEach items= "${conversationDto.chats}" var="chat" >
		                      		<c:if test="${chat.userId != user.userId}">
		                      			<li class="left">
			                      			<img src="/ambi/albums/user/avt/${chat.user.useravt}"  alt="" class="profile-photo-sm pull-left" />
			                      			<div class="chat-item">
			                              		<div class="chat-item-header">
			                              			<h5>${chat.user.name}</h5>
			                             		</div>
			                             		<p>${chat.content}</p>
			                            	</div>
		                      			</li>
		                      		</c:if>
		                      		<c:if test="${chat.userId == user.userId}">
			                          	<li class="right">
				                      		<img src="/ambi/albums/user/avt/${user.useravt}" alt="" class="profile-photo-sm pull-right" />
				                      		<div class="chat-item">
				                              	<div class="chat-item-header">
				                              		<h5>${user.name}</h5>
				                              	</div>
				                             	<p>${chat.content}</p>
				                            </div>
			                      		</li>
		                      		</c:if>
		                     </c:forEach>
                      	</ul>
                      </div>
                    </div>
                   </c:forEach>
                  </div><!--Chat Messages in Right End-->

                  <div class="send-message">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Type your message">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Send</button>
                      </span>
                    </div>
                  </div>
                </div>
                <div class="clearfix"></div>
              </div>
            </div>