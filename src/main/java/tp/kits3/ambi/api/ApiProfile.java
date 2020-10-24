package tp.kits3.ambi.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@RestController
public class ApiProfile {
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	UserService userService;
	@RequestMapping(value = "api/profile/{uri}", method = RequestMethod.GET)
	public Object profileTimeLine(@PathVariable("uri")int uri) {
		try {
			if(uri == userInfomation.getIdUser()) {
				return new ResponseEntity<User>(userInfomation.getUser(), HttpStatus.OK);
			}else {
				User user = userService.selectOne(uri);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "api/user-information", method = RequestMethod.GET)
	public Object userInfo() {
		try {
			
			return new ResponseEntity<User>(userInfomation.getUser(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "api/profile/friend/{id}", method = RequestMethod.GET)
	public Object profileFriendApi(@PathVariable("id")int id) {//api for friend
		try {
			if(id == userInfomation.getIdUser()) {
				return new ResponseEntity<User>(userInfomation.getUser(), HttpStatus.OK);
			}else {
				User user = userService.selectOne(id);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "api/profile/edit-info/{uri}", method = RequestMethod.GET)
	public Object editInfo(@PathVariable("uri")String uri) {//api for friend
		try {
			User user = userService.selectByUri(uri);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
