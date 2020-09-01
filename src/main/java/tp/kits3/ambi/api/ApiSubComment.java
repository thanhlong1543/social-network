package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.SubcommentService;
import tp.kits3.ambi.vo.Subcomment;
/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiSubComment {
	@Autowired
	SubcommentService subcommentService;
	@PostMapping("api/subcomment")
	public Object add(@RequestBody Subcomment subcomment) {	
		try {
			subcommentService.insert(subcomment);
			return new ResponseEntity<Subcomment>(subcomment,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PutMapping("api/subcomment")
	public Object update(@RequestBody Subcomment subcomment) {
		
		try {
			subcommentService.update(subcomment);
			return new ResponseEntity<Subcomment>(subcomment,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PutMapping("api/subcomment/{id}")
	public Object isdelete(@PathVariable int id) {
		
		try {
			subcommentService.isdelete(id, 1);
			return new ResponseEntity<String>("this is delete",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
}
