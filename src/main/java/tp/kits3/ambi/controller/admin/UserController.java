package tp.kits3.ambi.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "update_user/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public User greeting(@PathVariable("id")int id) {
		System.out.println(userService.selectOne(id).getName());
		return userService.selectOne(id);
	}
}
