package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.CommentService;
import tp.kits3.ambi.vo.Comment;
/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiComment {
	@Autowired
	CommentService commentService;
	@PostMapping("api/comment")
	public Object add(@RequestBody Comment comment) {	
		try {
			commentService.insert(comment);
			return new ResponseEntity<Comment>(comment,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PutMapping("api/comment")
	public Object update(@RequestBody Comment comment) {
		
		try {
			commentService.update(comment);
			return new ResponseEntity<Comment>(comment,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PutMapping("api/comment/{id}")
	public Object isdelete(@PathVariable int id) {
		
		try {
			commentService.isdelete(id, 1);
			return new ResponseEntity<String>("this is delete",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
}
