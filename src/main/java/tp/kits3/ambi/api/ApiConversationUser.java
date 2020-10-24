package tp.kits3.ambi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.ConversationUserService;
import tp.kits3.ambi.vo.ConversationUser;

/*
 * @author: Pham Thanh Tam
 * */
@RestController
public class ApiConversationUser {
	@Autowired
	ConversationUserService conversationUserService;

	@GetMapping("/api/conversationuser/get")
	public Object get(@RequestParam(name = "userid") String UserId, @RequestParam(name = "userfriendid") String userFriendId) {
		try {
			List<ConversationUser> conUser = conversationUserService.selectByUserId(Integer.parseInt(UserId));
			for (int i = 0; i < conUser.size(); i++) {
				List<ConversationUser> con = conversationUserService.selectByConId(conUser.get(i).getConId());
				if (con.size() == 1) {
					return new ResponseEntity<String>(con.get(0).getConId().toString(),HttpStatus.OK);
				}
				else {
					if (con.stream().filter(c -> c.getUserId().equals(Integer.parseInt(userFriendId))).findFirst().isPresent()) {
						return new ResponseEntity<String>(con.get(0).getConId().toString(),HttpStatus.OK);
					}
				}
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
}
