package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.vo.Notifications;
import tp.kits3.ambi.vo.Post;
/*
 * @author Duc
 * */
public interface NotificationsService {
	void sendFriendRequestNoti(int idUser, String content, int idUserActor, int notiTypeId);
	List<Notifications> getListByIdUser(int idUser);
	List<NotificationDto> getListNotiByUser(int idUser);
	void deleteNoti(int id);
	void updateNoti(int id, boolean b);
	List<Notifications> sendCommentNoti(PostDto post);
	Notifications selectOne(int id);
	
	Notifications sendLikeNoti(Post post);
	
	int getNumberOfNotiByUserId(int id, boolean b);
}
