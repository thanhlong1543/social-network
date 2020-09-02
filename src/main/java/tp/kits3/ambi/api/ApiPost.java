package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tp.kits3.ambi.converter.PostConverter;
import tp.kits3.ambi.dto.PostFileDto;
import tp.kits3.ambi.service.ImageService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.vo.Post;

/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiPost {
	@Autowired
	PostService postService;
	@Autowired
	PostConverter postConverter;
	@Autowired
	ImageService imageService;

	/* insert post */
	@PostMapping(value = "api/post", headers = ("content-type=multipart/*"))
	public Object add(@RequestParam(value = "inputFile") MultipartFile inputFile,
			@RequestParam String postFileDto) {

		try {
			Post post  = new ObjectMapper().readValue(postFileDto, Post.class);
			postService.insert(post);

			ResponseEntity<PostFileDto> repEntity = imageService.insert(inputFile);

			return repEntity;
		} catch (Exception e) {
			System.out.println("3");
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);

		}

	}

	/* update post */
	@PutMapping("api/post")
	public Object update(@RequestBody Post post) {

		try {
			postService.update(post);
			return new ResponseEntity<Post>(post, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	/* delete post like set isdelete = 1 */
	@PutMapping("api/post/{id}")
	public Object delete(@PathVariable int id) {
		try {
			postService.isdelete(id, 1);
			return new ResponseEntity<String>("this is delete ", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}
}
