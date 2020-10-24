package tp.kits3.ambi.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;

/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiHome {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	/* insert post */
	@GetMapping(value = "api/home")
	public Object getpost() {
		Map<String,Object> map=new HashMap<>();
		try {
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			User userId = userService.selectByEmail(name);
			String[] username = name.split("@");
			List<PostDto> postDtos = postService.selectPostInfoByUserid(userId.getUserId());
			
			map.put("username", username[0]);
			map.put("posts", postDtos);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}
}
