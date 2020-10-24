package tp.kits3.ambi.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.converter.ChatConverter;
import tp.kits3.ambi.dto.ChatDto;
import tp.kits3.ambi.service.ChatService;
import tp.kits3.ambi.service.ChatUserService;
import tp.kits3.ambi.service.ConversationService;
import tp.kits3.ambi.service.ConversationUserService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Chat;
import tp.kits3.ambi.vo.ChatUser;
import tp.kits3.ambi.vo.Conversation;
import tp.kits3.ambi.vo.ConversationUser;
/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiChat {
	@Autowired
	private ChatService chatService;
	@Autowired
	private UserService userService;
	@Autowired
	private ChatUserService chatUserService;
	@Autowired
	private ChatConverter chatConverter;
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	private ConversationService conversationService;
	@Autowired
	private ConversationUserService conversationUserService;
	@GetMapping("api/chat")
	public Object get(@RequestParam(name = "conid") String conid,@RequestParam(name = "userfriend") String userfriend) {	
		try {
			if (conid.equals("undefined")) {
				Conversation conversation = new Conversation();
				conversation.setOwnerId(userInfomation.getIdUser());
				conversationService.insert(conversation);
				
				ConversationUser conversationUserOwner= new ConversationUser();
				conversationUserOwner.setConId(conversation.getConId());
				conversationUserOwner.setUserId(userInfomation.getIdUser());
				conversationUserService.insert(conversationUserOwner);
				
				ConversationUser conversationUserFriend = new ConversationUser();
				conversationUserFriend.setConId(conversation.getConId());
				conversationUserFriend.setUserId(userService.selectByUri(userfriend).getUserId());
				conversationUserService.insert(conversationUserFriend);
				List<ChatDto> chatDtos = new ArrayList<ChatDto>();
				ChatDto chatDto = new ChatDto();
				chatDto.setConId(conversation.getConId());
				chatDto.setUser(userService.selectByUri(userfriend));
				chatDtos.add(chatDto);
				return new ResponseEntity<List<ChatDto>>(chatDtos,HttpStatus.OK);
			}else {
				List<ChatDto> chatDtos = new ArrayList<ChatDto>();
				List<Chat> chats = chatService.selectByConid(conid);
				for (Chat chat : chats) {
					ChatDto chatDto = new ChatDto();
					ChatUser chatUser = chatUserService.selectByChatid(chat.getChatId());
					chatDto = chatConverter.toDto(chat);
					chatDto.setUserId(chatUser.getUserId());
					chatDto.setUser(userService.selectOne(chatUser.getUserId()));
					chatDtos.add(chatDto);
				}
				
				return new ResponseEntity<List<ChatDto>>(chatDtos,HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@PostMapping("api/chat")
	public Object add(@RequestBody ChatDto chatDto) {	
		try {
			Chat chat = chatConverter.toVo(chatDto);
			chat.setChatTime(java.time.LocalDateTime.now().toString());
			chatService.insert(chat);
			
			chatUserService.insert(chatDto.getUserId(),chat.getChatId());
			return new ResponseEntity<Chat>(chat,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PutMapping("api/chat")
	public Object update(@RequestBody Chat chat) {
		
		try {
			chatService.update(chat);
			return new ResponseEntity<Chat>(chat,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
}
