package tp.kits3.ambi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.impl.FriendServiceImpl;
import tp.kits3.ambi.vo.User;

@Controller
public class FriendController {
	@Autowired
	FriendServiceImpl friendService;
	@RequestMapping(value = Route.friend, method = RequestMethod.GET)
	public String getFriend( Model model) {
		
		List<User> listFriends = friendService.selectByUserId(6);
		model.addAttribute("listFriends", listFriends);
		model.addAttribute("test", "1");
		return "user/home/friend";
	}
}
