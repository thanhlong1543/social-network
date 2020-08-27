package tp.kits3.ambi.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.dto.LoginDto;

@RestController
public class ApiLoginController {
	
	
	@PostMapping("api/signup")
	public Object login(@Valid @RequestBody LoginDto dto, Errors errors) {
		System.out.println(dto.toString());
		if(errors.hasErrors()) {
			return new ResponseEntity<>("invalid", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
