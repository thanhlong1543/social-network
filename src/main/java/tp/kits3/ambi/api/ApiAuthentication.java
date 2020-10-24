package tp.kits3.ambi.api;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tp.kits3.ambi.dto.LoginDto;
import tp.kits3.ambi.dto.SignupDto;
import tp.kits3.ambi.exception.EmailExistsException;
import tp.kits3.ambi.service.RoleUserService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.service.VerificationTokenService;
import tp.kits3.ambi.vo.RoleUser;
import tp.kits3.ambi.vo.User;
import tp.kits3.ambi.vo.VerificationToken;


/** 
 * @author Vu Thanh Long
 */
@RestController
@RequestMapping("api/auth")
public class ApiAuthentication {
	private String email;
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private VerificationTokenService verifyService;
	@Autowired
	private RoleUserService roleUserService;
	@PostMapping("/signup")
	public Object signUp(@Valid @RequestBody SignupDto dto) throws EmailExistsException{
		try {
			User user = new User();
			if(userService.selectByEmail(dto.getRegistEmail())!=null) {
				throw new EmailExistsException("Email already exists");
			}
			if(!dto.getPassword1().equals(dto.getPassword2())) {
				return new ResponseEntity<>("Confirm password does not match.",HttpStatus.EXPECTATION_FAILED);
			}
			user.setEmail(dto.getRegistEmail());
			user.setPassword(BCrypt.hashpw(dto.getPassword1(), BCrypt.gensalt(8)));
			email = dto.getRegistEmail();
			String uri = email.split("@")[0];
			user.setUserUrl(uri);
			user.setIsactive(false);
			int rd = (int) Math.round(Math.random()*7);
			if(rd==0) rd=1;
			user.setUseravt("avt"+rd+".jpg");
			user.setUserbgr(rd+".jpg");
			user.setName(email);
			userService.insert(user);
			roleUserService.insert(new RoleUser(user.getUserId(), new Integer(1)));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/login")
	public Object login(@Valid @RequestBody LoginDto dto, HttpSession session, HttpServletRequest request) {
		
		Authentication authentication = null;
		try {
			
			User user = userService.selectByEmail(dto.getEmail());
			
			if(user!=null&&!user.getIsactive()) {
				this.email = user.getEmail();
				sendMail();
				return new ResponseEntity<>("Your account is not verify. Please check your email!",HttpStatus.LOCKED);
			}
			
			UsernamePasswordAuthenticationToken checkToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
			
			checkToken.setDetails(new WebAuthenticationDetails(request));
			authentication = authenticationManager.authenticate(checkToken);
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);// log in successfully  set authen (get authen)
			session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
			Date dateNow = new Date();
			String token = Jwts.builder()
					.setSubject(dto.getEmail())
					.setIssuedAt(dateNow)
					.setExpiration(new Date(dateNow.getTime()+ 864000000L))
					.signWith(SignatureAlgorithm.HS512, "abcd")
					.compact();
			return new ResponseEntity<>(token,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/sendmail")
	public Object sendMail() {
		
		try {
			User user = userService.selectByEmail(email);
	        String token = UUID.randomUUID().toString();
	        VerificationToken veriToken = new VerificationToken(token,user.getUserId());
	        VerificationToken isExist = verifyService.findByUserId(user.getUserId());
	        if(isExist!=null) {
	        	isExist.setToken(token);
	        	System.out.println(isExist.getToken());
	        	verifyService.update(isExist);
	        } else {
	        	verifyService.insert(veriToken);
	        }
	        String verificationUrl  = "/registrationVerify?token=" + token;
	        System.out.println(email);
			Email emailSender = EmailBuilder.startingBlank()
				    .from("From", "asd.pham2@gmail.com")
				    .to("To", this.email)
				    .withSubject("Ambi Social network")
				    .withPlainText("Click this link to verify your email: " + "http://localhost:8080/ambi"+verificationUrl)
				    .buildEmail();
				MailerBuilder
					.withSMTPServer("smtp.gmail.com", 465, "asd.pham2@gmail.com", "grcasmxkbxoiqbun")
					.withTransportStrategy(TransportStrategy.SMTPS)
					.buildMailer()
					.sendMail(emailSender);

				return new ResponseEntity<>("Success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
		}
	}
	
}
