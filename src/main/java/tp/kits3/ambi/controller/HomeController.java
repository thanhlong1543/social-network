package tp.kits3.ambi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.LikeService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Like;


@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	private NotificationsService notiService;
	@Autowired
	private UserService userService;
	@Autowired
	private LikeService likeService;
	/**
	 *@author Pham Thanh Tam
	 */
	@RequestMapping(value = Route.home, method = RequestMethod.GET)
	public String home(Model model) {
//		User user = (User) session.getAttribute("user");
		model = getModelAttribute(model);
		List<PostDto> postDtos = postService.selectPostInfoUserAndFriendByUserid(userInfomation.getIdUser());
		List<Like> like = likeService.selectByUserId(userInfomation.getIdUser());
		model.addAttribute("likes",like);
		List<UserDto> userDto = userService.selectMutualFriend(userInfomation.getIdUser());
		model.addAttribute("posts", postDtos);
		model.addAttribute("mutual", userDto);
		return "user/home/newsfeed";
    }
	/**
	 *@author Duc
	 */
	@RequestMapping(value = Route.home+"/post", method = RequestMethod.GET)
	public String post(@RequestParam ("id") int id, Model model) {
		List<PostDto> postDtos = postService.selectPostByIdPost(id);
		model.addAttribute("posts", postDtos);
		model = getModelAttribute(model);
		return "user/home/newsfeed";
	}
	
	public Model getModelAttribute(Model model) {
		List<NotificationDto> noti = notiService.getListNotiByUser(userInfomation.getIdUser());
		model.addAttribute("notiCount", notiService.getNumberOfNotiByUserId(userInfomation.getIdUser(), false));
		model.addAttribute("noti", noti);
		model.addAttribute("routes", Route.getRoutes());
		model.addAttribute("username", userInfomation.getUri());
		model.addAttribute("user", userInfomation.getUser());
		return model;
	}
	

	
}
