package tp.kits3.ambi.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class LoginDto {
	@Email(message = "Invalid email")
	private String email;
	@Length(min = 8,max = 20,message = "Password is 8-20 characters")
	private String password;
	public LoginDto() {

	}
	public LoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
