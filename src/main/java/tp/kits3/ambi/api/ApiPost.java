package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.vo.Post;

/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiPost {
	@Autowired
	PostService postService;

	/* insert post */
	@PostMapping("api/post")
	public Object add(@RequestBody Post post) {
		
		try {
			postService.insert(post);
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}

	/* update post */
	@PutMapping("api/post")
	public Object update(@RequestBody Post post) {
		
		try {
			postService.update(post);
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}

	/* delete post like set isdelete = 1 */
	@PutMapping("api/post/{id}")
	public Object delete(@PathVariable int id) {
		try {
			postService.isdelete(id , 1);
			return new ResponseEntity<String>("this is delete ",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
}
