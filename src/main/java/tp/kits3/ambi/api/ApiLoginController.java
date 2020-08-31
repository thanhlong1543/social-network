package tp.kits3.ambi.api;

import java.util.Random;

import javax.validation.Valid;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.dto.LoginDto;

@RestController
public class ApiLoginController {
	private String email;
	private String verifyCode;
	
	@PostMapping("api/signup")
	public Object login(@Valid @RequestBody LoginDto dto) {
		System.out.println(dto.toString());
		email = dto.getEmail();

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
