package tp.kits3.ambi.controller;

/*
 * @author Duc
 * */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.service.impl.FriendServiceImpl;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.User;

@Controller
public class FriendController {
	// relationship params: 1.pending 2.friend 3.block
	@Autowired
	FriendServiceImpl friendService;
	@Autowired
	private UserAuthentication userInfomation;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/friend", method = RequestMethod.GET)
	public String getFriend(Model model) {
		model.addAttribute("routes", Route.getRoutes());
		model.addAttribute("user", userInfomation.getUser());
		
		List<User> listFriends = friendService.selectByUserId(2, 2);// 2.friend
		List<UserDto> userDto = userService.selectMutualFriend(userInfomation.getIdUser());
		model.addAttribute("mutual", userDto);
		model.addAttribute("listFriends", listFriends);
		return "user/profile/friend";
	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public String getPending(Model model) {

		List<User> listPending = friendService.selectByUserId(userInfomation.getIdUser(), 1);
		model.addAttribute("listPending", listPending);
		return "user/profile/pending";
	}

//	@RequestMapping(value = Route.friend, method = RequestMethod.GET)
//	public String getBlock(Model model) {
//		
//		List<User> listBlock = friendService.selectByUserId(2,3);
//		model.addAttribute("listFriends", listBlock);
//		return "user/home/block";
//	}
	
	
	
	
	
}
