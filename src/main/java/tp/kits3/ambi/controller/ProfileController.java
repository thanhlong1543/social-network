package tp.kits3.ambi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.AboutService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.service.impl.FriendServiceImpl;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@Controller
public class ProfileController {
	@Autowired
	private PostService postService;
	@Autowired
	FriendServiceImpl friendService;
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	UserService userService;
	@Autowired
	NotificationsService notiService;
	@Autowired
	AboutService aboutService;
	/*
	 * @RequestMapping(value = {"/profile","/profile/timeline"}, method =
	 * RequestMethod.GET) public String profileTimeLine(Model model) { int userId =
	 * 1; List<PostDto> postDtos = postService.selectPostInfoByUserid(userId);
	 * model.addAttribute("routes", Route.getRoutes()); model.addAttribute("posts",
	 * postDtos); return "user/home/newsfeed"; }
	 */
//	@RequestMapping(value = Route.profileFriend, method = RequestMethod.GET)
//	public String profileFriend(Model model) {
//
//		//get friend API
//		List<User> listPending = friendService.selectByUserId(userInfomation.getIdUser(), 1);
//		model.addAttribute("routes", Route.getRoutes());
//		model.addAttribute("uri", userInfomation.getUri());
//		model.addAttribute("listPending", listPending);
//		return "user/profile/friend";
//	}
	@RequestMapping(value = Route.profilePhoto+"/{uri}", method = RequestMethod.GET)
	public String profilePhoto(@PathVariable("uri")String uri,  Model model) {
		User user = userService.selectByUri(uri);
		List<PostDto> postDtos = postService.selectPostInfoByUserid(user.getUserId());
		
		List<PostDto> imgs = new ArrayList<PostDto>();
		for(PostDto p : postDtos) {
			if(p.getImage() !=  null)
				imgs.add(p);
		}
		model.addAttribute("photos", imgs);
		model = getModelAttribute(uri, model);
		return "user/profile/photo";
	}
	@RequestMapping(value = Route.profile+"/{uri}", method = RequestMethod.GET)
	public String profilePersonal(@PathVariable("uri")String uri,  Model model) {

		//model.addAttribute("user", user);
		model = getModelAttribute(uri, model);
		return "user/home/newsfeed";
	}
	
	@RequestMapping(value = Route.profileFriend+"/{uri}", method = RequestMethod.GET)
	public String profileFriend(@PathVariable("uri")String uri,  Model model) {
		User user = userService.selectByUri(uri);
		List<User> listFriends = friendService.selectByUserId(user.getUserId(), 2);// 2.friend
		model.addAttribute("listFriends", listFriends);
		model = getModelAttribute(uri, model);
		return "user/profile/friend";
	}
	@GetMapping(value = Route.profileEdit+"/{uri}")
	public String profileEdit(@PathVariable("uri")String uri,  Model model) {
		
		return "user/profile/edit";
	}
	public Model getModelAttribute(String uri, Model model) {
		User user = userService.selectByUri(uri);
		List<PostDto> postDtos = postService.selectPostInfoByUserid(user.getUserId());
		model.addAttribute("posts", postDtos);
		List<NotificationDto> noti = notiService.getListNotiByUser(userInfomation.getIdUser());
		model.addAttribute("noti", noti);
		List<User> listPending = friendService.getListPending(userInfomation.getIdUser(), 1);
		model.addAttribute("listPending", listPending);
		About about = aboutService.getUserAboutByUserId(user.getUserId());
		model.addAttribute("about", about);
		
		model.addAttribute("notiCount", notiService.getNumberOfNotiByUserId(userInfomation.getIdUser(), false));
		model.addAttribute("routes", Route.getRoutes());
		model.addAttribute("personalUri", userInfomation.getUri());
		model.addAttribute("uri", uri);
		model.addAttribute("user", user);
		if(userInfomation.getIdUser() != user.getUserId()) {
			if(friendService.getRelationshipId(userInfomation.getIdUser(), user.getUserId()) == 2)
				model.addAttribute("mode", "isFriend");
			else if(friendService.getRelationshipId(userInfomation.getIdUser(), user.getUserId()) == 1) {
				if(friendService.checkWhoIsSendingRequest(userInfomation.getIdUser(), user.getUserId()).equals("You send"))
					model.addAttribute("mode", "waiting");
				else model.addAttribute("mode", "response");
			}
				
			else model.addAttribute("mode", "isNotFriend");
		}
		return model;
	}
}
