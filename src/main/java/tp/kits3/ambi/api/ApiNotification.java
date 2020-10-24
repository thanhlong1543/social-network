package tp.kits3.ambi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.converter.NotificationConverter;
import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.service.NotiTypeService;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.NotiType;
import tp.kits3.ambi.vo.Notifications;

/*
 * @author: Duc
 * */
@RestController
public class ApiNotification {
	@Autowired
	NotificationsService notiService;

	@Autowired
	UserService userService;
	
	@Autowired
	NotiTypeService notiTypeService;
	
	@Autowired
	NotificationConverter notificationConverter;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	UserAuthentication userInformation;
	
	@PutMapping("api/noti/del/{id}")
	public Object deleteNoti(@PathVariable int id) {

		try {
			//notiService.deleteNoti(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}
	@PutMapping("api/noti/unread/{id}")
	public Object markAsUnread(@PathVariable int id) {

		try {
			notiService.updateNoti(id, false);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	@PutMapping("api/noti/read/{id}")
	public Object markAsRead(@PathVariable int id) {

		try {
			notiService.updateNoti(id, true);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	@PutMapping("api/noti/likepost/{id}")
	public Object likePostNoti(@PathVariable int id) {

		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("api/noti/get")
	public Object getNoti(@RequestParam(name = "notiid") int id) {

		try {
			Notifications noti = notiService.selectOne(id);
			NotificationDto notiDto = new NotificationDto();
			notiDto = notificationConverter.toDto(noti);
			NotiType notiType = notiTypeService.selectOne(noti.getNotiTypeId());//get type of notification
			notiDto.setUser(userService.selectOne(noti.getIdUserActor()));// set the latest user trigger notification
			
			
			if(noti.getNotiTypeId() == 2) {
				notiDto.setDescription(notiType.getDescription());
			}
			else if(noti.getNotiTypeId() == 3) {
				int idPostUser = postService.selectOneByIdPost(noti.getMemo()).getUserId();
				if(idPostUser == userInformation.getIdUser()) {
					
					notiDto.setDescription(notiDto.getContent()+notiType.getDescription());
				}
				else
					notiDto.setDescription(notiDto.getContent());
			}
			return new ResponseEntity<>(notiDto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
}
