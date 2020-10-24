package tp.kits3.ambi.controller;
/**
 *@author Pham Thanh Tam
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.converter.ChatConverter;
import tp.kits3.ambi.dto.ChatDto;
import tp.kits3.ambi.dto.ConversationDto;
import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.ChatService;
import tp.kits3.ambi.service.ChatUserService;
import tp.kits3.ambi.service.ConversationUserService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Chat;
import tp.kits3.ambi.vo.ChatUser;
import tp.kits3.ambi.vo.ConversationUser;


@Controller
public class MessageController {
	@Autowired
	private NotificationsService notiService;
	@Autowired
	private UserAuthentication userInfomation;
	@Autowired
	ConversationUserService conversationUserService;
	@Autowired
	private UserService userService;
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatUserService chatUserService;
	@Autowired
	private ChatConverter chatConverter;
	@RequestMapping(value = Route.message, method = RequestMethod.GET)
	public String home(Model model) {
		List<ConversationDto> conversationDtos = new ArrayList<ConversationDto>();
		List<NotificationDto> noti = notiService.getListNotiByUser(userInfomation.getIdUser());
		List<UserDto> userDto = userService.selectMutualFriend(userInfomation.getIdUser());
		List<ConversationUser> conversations = conversationUserService.selectConByUserid(userInfomation.getIdUser());
		for (ConversationUser conversationUser : conversations) {
			List<Chat> chats = chatService.selectByConid(conversationUser.getConId().toString());
			List<ChatDto> chatDtos = new ArrayList<ChatDto>();
			ConversationDto conversationDto = new ConversationDto();
			for (Chat chat : chats) {
				ChatDto chatDto = new ChatDto();
				ChatUser chatUser = chatUserService.selectByChatid(chat.getChatId());
				chatDto = chatConverter.toDto(chat);
				chatDto.setUserId(chatUser.getUserId());
				chatDto.setUser(userService.selectOne(chatUser.getUserId()));
				chatDtos.add(chatDto);
				if(userInfomation.getIdUser() != chatDto.getUserId() && conversationDto.getUser() == null ) {
					conversationDto.setUser(chatDto.getUser());
				}
			}
			
			conversationDto.setChats(chatDtos);
			conversationDto.setConId(conversationUser.getConId());
			
			conversationDtos.add(conversationDto);
		}
		model.addAttribute("noti", noti);
		model.addAttribute("user", userInfomation.getUser());
		model.addAttribute("mutual", userDto);
		model.addAttribute("conversationDtos", conversationDtos);
		model.addAttribute("routes", Route.getRoutes());
		return "user/home/message";
    }

	
}
