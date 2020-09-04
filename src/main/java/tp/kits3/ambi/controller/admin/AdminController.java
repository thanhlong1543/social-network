package tp.kits3.ambi.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import tp.kits3.ambi.service.MenuService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.Menu;
import tp.kits3.ambi.vo.User;

/**
 * @author Chuc Kim Thien
 */
@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="/admin/notifications", method = RequestMethod.GET)
	public String notifications( Model model) {
		List<Menu> lsMenu = menuService.selectByCategoryId(1);
		model.addAttribute("menu",lsMenu);
		return "/admin/home/notifications";
	}
	
//	@RequestMapping(value="/admin/post", method = RequestMethod.GET)
//	public String post( Model model) {
//		return "/admin/home/post";
//	}
	
	@RequestMapping(value="/admin/user", method = RequestMethod.GET)
	public String user( Model model) {
		List<Menu> lsMenu = menuService.selectByCategoryId(1);
		model.addAttribute("menu",lsMenu);
		model.addAttribute("update-user", new User());
		model.addAttribute("userlist", userService.selectAll());
		return "/admin/home/user";
	}
	@RequestMapping(value="/admin/user", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("update-user") User user, BindingResult result, SessionStatus status ) {

		userService.update(user);
		status.setComplete();
		
		return "redirect: user";
		
	}
	
	@RequestMapping(value="/admin/dashboard", method = RequestMethod.GET)
	public String dashboard( Model model) {
		List<Menu> lsMenu = menuService.selectByCategoryId(1);
		model.addAttribute("menu",lsMenu);
		return "/admin/home/dashboard";
	}
	
	@RequestMapping(value="/admin/map", method = RequestMethod.GET)
	public String map( Model model) {
		return "/admin/home/map";
	}
	
	@RequestMapping(value="/admin/post", method = RequestMethod.GET)
	public String tables( Model model) {
		List<Menu> lsMenu = menuService.selectByCategoryId(1);
		model.addAttribute("menu",lsMenu);
		model.addAttribute("postlist",postService.selectAll());
		return "/admin/home/post";
	}
	
	
	@RequestMapping(value="/admin/setting", method=RequestMethod.POST)
	public String updateMenu(@ModelAttribute("update-menu") Menu menu, BindingResult result, SessionStatus status ) {

		menuService.update(menu);
		status.setComplete();
		
		return "redirect: setting";
		
	}
	
	@RequestMapping(value="/admin/setting", method = RequestMethod.GET)
	public String setting( Model model) {
		List<Menu> lsMenu = menuService.selectByCategoryId(1);
		model.addAttribute("menu",lsMenu);
		model.addAttribute("update-menu", new Menu());
		model.addAttribute("menulist", menuService.selectAll());
		return "/admin/home/setting";
	}
	
	
}

