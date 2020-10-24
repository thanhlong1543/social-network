package tp.kits3.ambi.api;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.service.CommentService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.Comment;
import tp.kits3.ambi.vo.Notifications;
/**
 * @author Pham Thanh Tam
 */
@RestController
public class ApiComment {
	@Autowired
	private CommentService commentService;
	@Autowired
	private PostService postService;
	@Autowired
	private NotificationsService notiService;
	@Autowired
	private UserAuthentication userAuthen;
	@PostMapping("api/comment")
	public Object add(@RequestBody Comment comment) {	
		try {
			comment.setCommentDate(java.time.LocalDateTime.now().toString());
			comment.setUserId(userAuthen.getIdUser());
			commentService.insert(comment);
			PostDto post = postService.selectPostByIdPost(comment.getPostId()).get(0);
			List<Notifications> notifications = notiService.sendCommentNoti(post);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("comment", comment);
			data.put("notifications", notifications);

			return new ResponseEntity<>(data,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
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
