package tp.kits3.ambi.api;

import java.util.Date;
import java.util.Random;

import javax.validation.Valid;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tp.kits3.ambi.dto.LoginDto;
import tp.kits3.ambi.dto.SignupDto;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;


/** 
 * @author Vu Thanh Long
 */
@RestController
public class ApiAuthentication {
	private String email;
	private String verifyCode;
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@PostMapping("api/signup")
	public Object signUp(@Valid @RequestBody SignupDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(BCrypt.hashpw(dto.getPassword1(), BCrypt.gensalt(8)));
		user.setRoleId(1);
		userService.insert(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/api/login")
	public Object login(@RequestBody LoginDto dto) {
		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate
					(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			Date dateNow = new Date();
			String token = Jwts.builder()
					.setSubject(dto.getEmail())
					.setIssuedAt(dateNow)
					.setExpiration(new Date(dateNow.getTime()+ 864000000L))
					.signWith(SignatureAlgorithm.HS512, "abcd")
					.compact();
			return new ResponseEntity<String>(token,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/test")
	public Object test() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("api/sendmail")
	public String sendMail() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		String code = Integer.toString(n);
		verifyCode = code;
		Email emailSender = EmailBuilder.startingBlank()
			    .from("From", "asd.pham2@gmail.com")
			    .to("To", this.email)
			    .withSubject("Ambi Social network")
			    .withPlainText("your verification code: " + code)
			    .buildEmail();
			MailerBuilder
			 .withSMTPServer("smtp.gmail.com", 465, "asd.pham2@gmail.com", "elhqvidyxlfohdwx")
			  .withTransportStrategy(TransportStrategy.SMTPS)
			  .buildMailer()
			  .sendMail(emailSender);
		return verifyCode;
	}
	
}
