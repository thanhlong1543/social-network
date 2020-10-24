package tp.kits3.ambi.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Vu Thanh Long
 */
@SuppressWarnings("serial")
public class CustomUserDetails extends User implements UserDetails{

	
	public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {
		
		super(email, password, authorities);
	}
	
}
