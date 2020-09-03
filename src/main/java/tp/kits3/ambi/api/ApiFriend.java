package tp.kits3.ambi.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.impl.FriendServiceImpl;
import tp.kits3.ambi.vo.Friend;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@RestController
public class ApiFriend {
	@Autowired
	FriendServiceImpl friendService;
	Friend fr;
	@GetMapping("/api/pending/accept/{id}")
	public Object acceptFriend(@PathVariable("id") int user2Id) {
		try {
//			try {
//				 fr = friendService.getIdFriendByTwoUsersId(2, user2Id);
//				 fr.setReId(2);
//					friendService.updateFriend(fr);
//			} catch (Exception e) {
//				fr = friendService.getIdFriendByTwoUsersId(user2Id, 2);
//				fr.setReId(2);
//				friendService.updateFriend(fr);
//			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/api/pending/deny")
	public String denyFriend(Model model) {

		return "";
	}
	@GetMapping("api/friend/{id}")
	public Object getFriend(@PathVariable("id") int idUser) {
		
		try {
			List<User> listFriends = friendService.selectByUserId(idUser,2);
			return new ResponseEntity<List<User>>(listFriends, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("api/friend/delete/{id}")
	public Object deleteFriend(@PathVariable("id") int user2Id) {
		try {
			try {
				fr = friendService.getIdFriendByTwoUsersId(2, user2Id);
				friendService.deleteFriend(fr.getFriendId());
			} catch (Exception e) {
				fr = friendService.getIdFriendByTwoUsersId(user2Id, 2);
				friendService.deleteFriend(fr.getFriendId());
		} 
		return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
		

}
