package tp.kits3.ambi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@Component
public class UserAuthentication {
	@Autowired
	UserService userService;
	
	int id = 0;
	User user = new User();
	public UserAuthentication() {
		
	}
	public void init() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.selectByEmail(email);
		//id = user.getUserId();
	}
	public int getIdUser() {
		init();
		return this.user.getUserId();
	}
	public String getUri() {
		init();
		return this.user.getUserUrl();
	}
	public User getUser() {
		init();
		return this.user;
	}
}
