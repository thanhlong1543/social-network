package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.AboutService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.About;
/*
 * @author: Duc
 * */
@RestController
public class ApiAbout {
	@Autowired
	AboutService aboutService;
	@Autowired
	UserAuthentication userInformation;
	@GetMapping("/api/getAbout/{id}")
	public Object getAbout(@PathVariable("id") int userId) {
		try {
			About about = aboutService.getUserAboutByUserId(userId);
			return new ResponseEntity<About>(about, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@PostMapping("/api/update-about")
	public Object updateAbout(@RequestBody About about) {
		try {
			about.setUserId(userInformation.getIdUser());
			aboutService.updateAbout(about);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
}
