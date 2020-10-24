package tp.kits3.ambi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import tp.kits3.ambi.dto.LoginDto;
import tp.kits3.ambi.dto.SignupDto;
import tp.kits3.ambi.route.Route;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.service.VerificationTokenService;
import tp.kits3.ambi.vo.User;
import tp.kits3.ambi.vo.VerificationToken;
/**
 * @author Vu Thanh Long
 */
@Controller
public class AuthController {
	
	@Autowired
	private VerificationTokenService verifyService;
	@Autowired
	private UserService userService;
	
	@GetMapping(Route.login)
	public String login(Model model) {
		model.addAttribute("signup", new SignupDto());
		model.addAttribute("login", new LoginDto());
		return "user/login";
	}
	
	@GetMapping(Route.logout)
	public String logoutPage(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:"+Route.login;
	}
	
	@GetMapping(Route.verify)
	public String verifyRegistration(WebRequest request, Model model, 
		@RequestParam("token") String token,HttpSession session) {
	    try {
	    	System.out.println("test");
	    	VerificationToken verificationToken = verifyService.findByVerificationToken(token);
		    if (verificationToken == null) {
		    	session.setAttribute("message", "Registration link is wrong");
		    	session.setMaxInactiveInterval(10);
		        return "redirect:"+Route.login;
		    }
		    session.setAttribute("message", "Your account has been activated successfully");
	    	session.setMaxInactiveInterval(10);
		    int userId = verificationToken.getUserId();
		    User user = userService.selectOne(userId);
		    user.setIsactive(true);
		    userService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "redirect:"+Route.login;
	}
	
	@GetMapping("/403")
	public String forbidden() {
		return "403";
	}
}
