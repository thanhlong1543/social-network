package tp.kits3.ambi.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.dto.LoginDto;
import tp.kits3.ambi.route.Route;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AboutDao aboutDao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		model.addAttribute("login", new LoginDto());
		return "login";
	}
	
	@RequestMapping(value = Route.home, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("routes.home", Route.getRoutes());
		return "home/newsfeed";
	}
	
	@RequestMapping(value = Route.friend, method = RequestMethod.GET)
	public String friend(Model model) {
		model.addAttribute("routes.home", Route.getRoutes());
		return "home/friend";
	}
	
}
