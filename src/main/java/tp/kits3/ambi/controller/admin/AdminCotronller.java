package tp.kits3.ambi.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCotronller {
	@RequestMapping(value="/admin/menu", method = RequestMethod.GET)
	public String menu( Model model) {
		return "/admin/home/menu";
	}
	
	@RequestMapping(value="/admin/notifications", method = RequestMethod.GET)
	public String notifications( Model model) {
		return "/admin/home/notifications";
	}
	
	@RequestMapping(value="/admin/post", method = RequestMethod.GET)
	public String post( Model model) {
		return "/admin/home/post";
	}
	
	@RequestMapping(value="/admin/user", method = RequestMethod.GET)
	public String user( Model model) {
		return "/admin/home/user";
	}
}

