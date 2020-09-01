package tp.kits3.ambi.controller;


<<<<<<< src/main/java/tp/kits3/ambi/controller/HomeController.java
=======
import java.util.List;

>>>>>>> src/main/java/tp/kits3/ambi/controller/HomeController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.dto.LoginDto;
<<<<<<< src/main/java/tp/kits3/ambi/controller/HomeController.java
import tp.kits3.ambi.dto.SignupDto;
=======
import tp.kits3.ambi.dto.PostDto;
>>>>>>> src/main/java/tp/kits3/ambi/controller/HomeController.java
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.PostService;

/** 
 * @author Vu Thanh Long
 */
@Controller
public class HomeController {
<<<<<<< src/main/java/tp/kits3/ambi/controller/HomeController.java
	
	@Autowired
	private UserDao dao;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = Route.login, method = RequestMethod.GET)
	public String login( Model model) {
		model.addAttribute("signup", new SignupDto());
		model.addAttribute("login", new LoginDto());
		return "user/login";
	}
	/**
	 *@author Pham Thanh Tam
	 */
	@RequestMapping(value = Route.home, method = RequestMethod.GET)
	public String home(Model model) {
		int userId = 1;
		List<PostDto> postDtos = postService.selectPostInfoByUserid(userId);
		model.addAttribute("routes", Route.getRoutes());
		model.addAttribute("posts", postDtos);
		return "user/home/newsfeed";
	}
	
//	@RequestMapping(value = Route.friend, method = RequestMethod.GET)
//	public String friend(Model model) {
//		model.addAttribute("routes", Route.getRoutes());
//		return "user/home/friend";
//	}
	
}
