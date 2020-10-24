package tp.kits3.ambi.api;
/* @author: Truong*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;

@RestController
public class ApiUser {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "update_user/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public User greeting(@PathVariable("id")int id) {
		System.out.println(userService.selectOne(id).getName());
		return userService.selectOne(id);
	}
	
	@RequestMapping(value="api/userlist", method=RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public Object greetingpost() {
		List<User> list = userService.selectAll();	
		return 	new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@GetMapping("api/user")
	public Object getUser(@RequestParam(value = "userid") String userId) {
		User user = userService.selectOne(Integer.parseInt(userId));	
		return 	new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
