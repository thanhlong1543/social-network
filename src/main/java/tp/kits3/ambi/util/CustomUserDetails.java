package tp.kits3.ambi.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {

	private static final long serialVersionUID = 1L;
	
	
	public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {
		
		super(email, password, authorities);
	}
	
}
