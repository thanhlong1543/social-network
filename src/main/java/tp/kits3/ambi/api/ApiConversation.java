package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.ConversationService;
import tp.kits3.ambi.vo.Conversation;

/*
 * @author: Pham Thanh Tam
 * */
@RestController
public class ApiConversation {
	@Autowired
	ConversationService conversationService;

	@GetMapping("/api/conversation/get")
	public Object add(@RequestParam String conversationId) {
		try {
			Conversation conversation = conversationService.selectOne(Integer.parseInt(conversationId));
			return new ResponseEntity<Conversation>(conversation,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
}
