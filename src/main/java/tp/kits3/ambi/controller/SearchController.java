package tp.kits3.ambi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;

@Controller
public class SearchController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/search", method= RequestMethod.GET)
	public String SearchFriends(Model model) {
		List<User> listUsers = userService.selectAll();
		model.addAttribute("listUsers", listUsers);
		return "user/home/search";
	}
}
