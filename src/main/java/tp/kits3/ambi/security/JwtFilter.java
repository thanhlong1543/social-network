package tp.kits3.ambi.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

/**
 * @author Vu Thanh Long
 */
public class JwtFilter extends BasicAuthenticationFilter {
	
	
	private UserDetailsService userDetailService;
	
	public JwtFilter(AuthenticationManager authenticationManager,UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailService = userDetailsService;
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String tokenbearer = request.getHeader("Authorization");
		
		if(tokenbearer !=null && tokenbearer.startsWith("Bearer ")) {
			String token = tokenbearer.replace("Bearer ", "");
			
			String email = Jwts
					.parser()
					.setSigningKey("abcd")
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			
			UserDetails userDetails = userDetailService.loadUserByUsername(email);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null,userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			chain.doFilter(request, response);
		} else {
			response.sendError(401, "Authenticate fail");
		}
		
	}
}
