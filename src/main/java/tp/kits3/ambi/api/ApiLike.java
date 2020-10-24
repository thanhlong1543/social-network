package tp.kits3.ambi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.LikeService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Like;
import tp.kits3.ambi.vo.Post;
/**
 * 
 * @author Chuc Kim Thien
 *
 */
@RestController
public class ApiLike {
	@Autowired
	private LikeService likeService;
	@Autowired
	private PostService postService;
	@Autowired
	UserAuthentication userInfomation;
	@Autowired
	NotificationsService notiService;
    @Autowired
	private UserService userService;
	@PostMapping("api/like")
	public Object add(@RequestBody Like like) {
		try {
			like.setUserId(userInfomation.getIdUser());
			likeService.insert(like);
			Post post = postService.selectOneByIdPost(like.getPostId());
			int totalLike = post.getTotalLike()+1;
			post.setTotalLike(totalLike);
			postService.update(post);
			notiService.sendLikeNoti(post);
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("api/like")
	public Object delete(@RequestBody Like like) {
		try {
			like.setUserId(userInfomation.getIdUser());
			likeService.deleteByPostIdAndUserId(like);
			Post post = postService.selectOneByIdPost(like.getPostId());
			int totalLike = post.getTotalLike()-1;
			post.setTotalLike(totalLike);
			postService.update(post);
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("api/like/{postId}")
	public Object getName(@PathVariable int postId) {
		try {
			List<String> name;
			name = userService.selectNameByPostId(postId);
			return new ResponseEntity<>(name,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
}
