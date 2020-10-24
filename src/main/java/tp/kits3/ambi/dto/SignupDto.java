package tp.kits3.ambi.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class SignupDto {

	@Email(message = "Invalid email")
	private String registEmail;
	@Length(min = 8, max = 20, message = "Password is 8-20 numbers")
	private String password1;

	@Length(min = 8, max = 20, message = "Password is 8-20 numbers")
	private String password2;

	public SignupDto() {
		super();

	}

	public SignupDto(@Email(message = "Invalid email") String registEmail,
			@Length(min = 8, max = 20, message = "Password is 8-20 numbers") String password1,
			@Length(min = 8, max = 20, message = "Password is 8-20 numbers") String password2) {
		super();
		this.registEmail = registEmail;
		this.password1 = password1;
		this.password2 = password2;
	}

	public String getRegistEmail() {
		return registEmail;
	}

	public void setRegistEmail(String registEmail) {
		this.registEmail = registEmail;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
