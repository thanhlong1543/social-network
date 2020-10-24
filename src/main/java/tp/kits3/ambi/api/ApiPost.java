package tp.kits3.ambi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.service.ImageService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.vo.Post;

/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiPost {
	@Autowired
	private PostService postService;

	@Autowired
	private ImageService imageService;

	/* insert post */
	@PostMapping(value = "api/post", headers = ("content-type=multipart/*"))
	public Object add(@RequestParam(value = "inputFile",required = false) MultipartFile inputFile,
			@RequestParam String postString) {

		try {
			Post post  = new ObjectMapper().readValue(postString, Post.class);
			post.setPostDate(java.time.LocalDateTime.now().toString());
			postService.insert(post);
			if(inputFile!=null) {				
				imageService.insert(inputFile,post.getPostId());
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("3");
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

	/* update post */
	@PostMapping(value = "api/post/update", headers = ("content-type=multipart/*"))
	public Object update(@RequestParam(value = "inputFile",required = false) MultipartFile inputFile,
			@RequestParam String postString) {

		try {
			Post post  = new ObjectMapper().readValue(postString, Post.class);
			post.setPostDate(java.time.LocalDateTime.now().toString());
			postService.update(post);
			if(inputFile!=null) {				
				imageService.insert(inputFile,post.getPostId());
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	/* delete post like set isdelete = 1 */
	@DeleteMapping("api/post/{id}")
	public Object delete(@PathVariable int id) {
		try {
			postService.isdelete(id, 1);
			return new ResponseEntity<String>("this is delete ", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("api/post/test")
	public Object test() {
		List<PostDto> list = postService.selectPostInfoUserAndFriendByUserid(1);
		for (PostDto postDto : list) {
			System.out.println("id is: "+postDto.getPostId());
		}
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
	}
}
