package tp.kits3.ambi.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.util.CustomUserDetails;
import tp.kits3.ambi.vo.User;

/**
 * @author Vu Thanh Long
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


		User user = dao.selectByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		CustomUserDetails userDetail = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);

		return userDetail;

	}

}
