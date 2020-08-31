package tp.kits3.ambi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.dto.LoginDto;
import tp.kits3.ambi.route.Route;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model) {
		model.addAttribute("login", new LoginDto());
		return "user/login";
	}
	
	@RequestMapping(value = Route.home, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("routes", Route.getRoutes());
		return "user/home/newsfeed";
	}
	
//	@RequestMapping(value = Route.friend, method = RequestMethod.GET)
//	public String friend(Model model) {
//		model.addAttribute("routes", Route.getRoutes());
//		return "user/home/friend";
//	}
	
}
