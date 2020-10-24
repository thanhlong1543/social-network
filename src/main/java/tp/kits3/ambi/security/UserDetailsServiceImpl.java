package tp.kits3.ambi.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.CustomUserDetails;
import tp.kits3.ambi.vo.User;

/**
 * @author Vu Thanh Long
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao dao;
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


		User user = dao.selectByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		List<String> listRole =userService.selectAllRole(user.getUserId());
		for (String string : listRole) {
			authorities.add(new SimpleGrantedAuthority(string));
		}
		
		CustomUserDetails userDetail = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);

		return userDetail;

	}

}
