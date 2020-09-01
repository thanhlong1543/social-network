package tp.kits3.ambi.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value="/admin/icons", method = RequestMethod.GET)
	public String menu( Model model) {
		return "/admin/home/icons";
	}
	
	@RequestMapping(value="/admin/notifications", method = RequestMethod.GET)
	public String notifications( Model model) {
		return "/admin/home/notifications";
	}
	
//	@RequestMapping(value="/admin/post", method = RequestMethod.GET)
//	public String post( Model model) {
//		return "/admin/home/post";
//	}
	
	@RequestMapping(value="/admin/user", method = RequestMethod.GET)
	public String user( Model model) {
		return "/admin/home/user";
	}
	
	@RequestMapping(value="/admin/dashboard", method = RequestMethod.GET)
	public String dashboard( Model model) {
		return "/admin/home/dashboard";
	}
	
	@RequestMapping(value="/admin/map", method = RequestMethod.GET)
	public String map( Model model) {
		return "/admin/home/map";
	}
	
	@RequestMapping(value="/admin/tables", method = RequestMethod.GET)
	public String tables( Model model) {
		return "/admin/home/tables";
	}
	
	@RequestMapping(value="/admin/typography", method = RequestMethod.GET)
	public String typography( Model model) {
		return "/admin/home/typography";
	}
	
	@RequestMapping(value="/admin/upgrade", method = RequestMethod.GET)
	public String upgrade( Model model) {
		return "/admin/home/upgrade";
	}
}

