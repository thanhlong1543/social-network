package tp.kits3.ambi.controller.admin;

/**
 * @author Nguyen Van Truong
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.vo.Post;

@RestController
public class PostController {
	
	
	@Autowired 
	PostService postService;
	
	@RequestMapping(value="api/postlist", method=RequestMethod.GET)
	public Object greetingpost() {
		List<Post> list = postService.selectAll();	
		return 	new ResponseEntity<List<Post>>(list, HttpStatus.OK);
	}
}
