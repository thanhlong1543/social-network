package tp.kits3.ambi.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*
	 * @RequestMapping(value="/api/changPass/{id}", method = RequestMethod.POST)
	 * public User changePass(@PathVariable("id") int id) {
	 * 
	 * return userService.selectOne(id); }
	 */

}
