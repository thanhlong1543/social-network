package tp.kits3.ambi.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.FriendService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.service.impl.NotificationsServiceImpl;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Friend;
import tp.kits3.ambi.vo.Notifications;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@RestController
public class ApiFriend {
	@Autowired
	FriendService friendService;
	@Autowired
	UserService userService;
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	NotificationsServiceImpl notiService;
	Friend fr;
	@GetMapping("/api/pending/accept/{id}")
	public Object acceptFriend(@PathVariable("id") int user2Id) {
		try {
			fr = friendService.getIdFriendByTwoUsersId(userInfomation.getIdUser(), user2Id);
			fr.setReId(2);
			friendService.updateFriend(fr);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@PutMapping("/api/pending/delete/{id}")
	public Object denyFriend(@PathVariable("id") int user2Id) {
		Friend fr;
		try {
			fr = friendService.getIdFriendByTwoUsersId(userInfomation.getIdUser(), user2Id);
			friendService.deleteFriend(fr.getFriendId());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("api/friend/{uri}")
	public Object getFriend(@PathVariable("uri") String uri) {
		
		try {
			User user = userService.selectByUri(uri);
			List<User> listFriends = friendService.selectByUserId(user.getUserId(),2);
			return new ResponseEntity<List<User>>(listFriends, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("api/friend/delete/{id}")
	public Object deleteFriend(@PathVariable("id") int user2Id) {
		try {
			fr = friendService.getIdFriendByTwoUsersId(userInfomation.getIdUser(), user2Id);
			friendService.deleteFriend(fr.getFriendId());
		return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@PutMapping("api/send-friend-request/{id}")
	public Object sendFriendRequest(@PathVariable("id") int id) {
		try {
			
			friendService.sendFriendRequest(userInfomation.getIdUser(), id, 1);
			notiService.sendFriendRequestNoti(id, "", userInfomation.getIdUser(), 2);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("api/t/{id}")
	public Object t(@PathVariable("id") int id) {
		try {
			List<Notifications> nl = notiService.getListByIdUser(id);
			return new ResponseEntity<List<Notifications>>(nl, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

}
