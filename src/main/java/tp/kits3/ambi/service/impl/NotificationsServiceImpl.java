package tp.kits3.ambi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.converter.NotificationConverter;
import tp.kits3.ambi.dao.NotiTypeDao;
import tp.kits3.ambi.dao.NotificationsDao;
import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.dto.CommentDto;
import tp.kits3.ambi.dto.NotificationDto;
import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.dto.SubCommentDto;
import tp.kits3.ambi.service.NotificationsService;
import tp.kits3.ambi.service.PostService;
import tp.kits3.ambi.util.ConverterStringToDate;
import tp.kits3.ambi.util.TimeCalculation;
import tp.kits3.ambi.util.UserAuthentication;
import tp.kits3.ambi.vo.NotiType;
import tp.kits3.ambi.vo.Notifications;
import tp.kits3.ambi.vo.Post;

/*
 * @author: Duc
 * */
@Service
public class NotificationsServiceImpl implements NotificationsService{
	@Autowired
	NotificationsDao notificationsDao;
	@Autowired
	NotificationConverter notiConverter;
	@Autowired
	NotiTypeDao notiTypeDao;
	@Autowired
	UserDao userDao;
	@Autowired
	UserAuthentication userInformation;
	@Autowired
	private PostService postService;
	@Autowired
	private ConverterStringToDate converterStringToDate;
	
	@Override
	public void sendFriendRequestNoti(int idUser,String content, int idUserActor, int notiTypeId) {
		Notifications noti = new Notifications(idUser, false, TimeCalculation.getCurrentTime(), content, 0, notiTypeId, 0, idUserActor);
		notificationsDao.insert(noti);
		//notificationsDao.test(noti);
		
	}

	@Override
	public List<Notifications> getListByIdUser(int idUser) {
		return notificationsDao.getListNotificationById(idUser);
	}

	@Override
	public List<NotificationDto> getListNotiByUser(int idUser) {
		List<NotificationDto> listDto = new ArrayList<>();
		try {
			List<Notifications> list = notificationsDao.getListNotificationById(idUser);
			Collections.sort(list, new Comparator<Notifications>() {
				public int compare(Notifications o1, Notifications o2) {
					Date dtIn1 = converterStringToDate.stringToDate(o1.getNotiDate());
					Date dtIn2 = converterStringToDate.stringToDate(o2.getNotiDate());
					return dtIn2.compareTo(dtIn1);
				}
			});
			for(Notifications noti : list) {
				NotificationDto notiDto = new NotificationDto();
				notiDto = notiConverter.toDto(noti);
				NotiType notiType = notiTypeDao.selectOne(noti.getNotiTypeId());//get type of notification
				notiDto.setUser(userDao.selectOne(noti.getIdUserActor()));// set the latest user trigger notification
				
				
				if(noti.getNotiTypeId() == 2) {//friend request
					notiDto.setDescription(notiType.getDescription());
				}
				else if(noti.getNotiTypeId() == 3) {//comment on post
					int idPostUser = postService.selectOneByIdPost(noti.getMemo()).getUserId();
					if(idPostUser == userInformation.getIdUser()) {
						
						notiDto.setDescription(notiDto.getContent()+notiType.getDescription());
					}
					else
						notiDto.setDescription(notiDto.getContent());
				}
				else if(noti.getNotiTypeId() == 1) {//like post
					notiDto.setDescription(notiDto.getContent()+" "+notiType.getDescription());
				}
				listDto.add(notiDto);
				
				
			}
			for ( Notifications notification : list) {
				System.out.println(notification.getNotiDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listDto;
	}

	@Override
	public void deleteNoti(int id) {
		notificationsDao.delete(id);
	}

	@Override
	public void updateNoti(int id, boolean b) {
		Notifications noti = notificationsDao.selectOne(id);
		noti.setIsread(b);
		notificationsDao.update(noti);
	}

	@Override
	public List<Notifications> sendCommentNoti(PostDto post) {
		List<Integer> listUserId = new ArrayList<Integer>();
		
		List<Notifications> outputList = new ArrayList<Notifications>();// list noti of users
		listUserId.add(post.getUser().getUserId());
		
		for(CommentDto cmt : post.getComments()) {
			if(!listUserId.contains(cmt.getUser().getUserId()))
				listUserId.add(cmt.getUser().getUserId());
			for(SubCommentDto subCmt : cmt.getSubComments()) {
				if(!listUserId.contains(subCmt.getUser().getUserId()))
					listUserId.add(subCmt.getUser().getUserId());
			}
		}
		for(Integer userId : listUserId) {
			Notifications notiGet = notificationsDao.selectToCheckExistNoti(userId, post.getPostId(), 3);
			
			
			if(notiGet == null) {// no any noti before
				Notifications noti= new Notifications();
				noti.setUserId(userId);
				noti.setIsread(false);
				noti.setNotiDate(TimeCalculation.getCurrentTime());
				noti.setMemo(post.getPostId());
				noti.setNotiTypeId(3);
				noti.setQuant(1);
				noti.setIdUserActor(userInformation.getIdUser());
				if(userId == post.getUser().getUserId()) {
					noti.setContent(userInformation.getUser().getName());
				}
				else {
					noti.setContent(userInformation.getUser().getName()+" comment on "+post.getUser().getName()+"'s post");
				}
				if(userInformation.getIdUser() != userId)
					notificationsDao. insert(noti);
				if(!outputList.contains(noti) && noti.getUserId() != userInformation.getIdUser()) outputList.add(noti);
			}
			else {
				int quant = notiGet.getQuant();
				notiGet.setIsread(false);
				notiGet.setNotiDate(TimeCalculation.getCurrentTime());
				notiGet.setIdUserActor(userInformation.getIdUser());

				if(!listUserId.contains(userInformation.getIdUser())) {//check if current user havent comment yet
					notiGet.setQuant(quant+1);
					if(userId == post.getUser().getUserId()) {//check if user own the post, the noti must be :
						notiGet.setContent(userInformation.getUser().getName()+" and "+notiGet.getQuant()+" other people");
					}
					else {
						notiGet.setContent(userInformation.getUser().getName()+" and "+notiGet.getQuant()+" other people comment on "+post.getUser().getName()+"'s post");
					}
				}
				else {//check if user have been cmt before
					notiGet.setQuant(quant);
					if(userId == post.getUser().getUserId()) {
						notiGet.setContent(userInformation.getUser().getName()+" and "+notiGet.getQuant()+" other people");
					}
					else {
						notiGet.setContent(userInformation.getUser().getName()+" and "+notiGet.getQuant()+" other people comment on "+post.getUser().getName()+"'s post");
					}
				}
				
				if(userInformation.getIdUser() != userId)
					notificationsDao.update(notiGet);
				if(!outputList.contains(notiGet) && notiGet.getUserId() != userInformation.getIdUser()) outputList.add(notiGet);
			}
		}
		return outputList;
	}

	@Override
	public Notifications selectOne(int id) {
		return notificationsDao.selectOne(id);
	}

	@Override
	public Notifications sendLikeNoti(Post post) {
		//List<Integer> listUserId = new ArrayList<Integer>();
		int idUserPost = post.getUserId();
		Notifications notiGet = notificationsDao.selectToCheckExistNoti(idUserPost, post.getPostId(), 1);
		if(notiGet == null) {
			Notifications noti= new Notifications();
			noti.setUserId(idUserPost);
			noti.setIsread(false);
			noti.setNotiDate(TimeCalculation.getCurrentTime());
			noti.setMemo(post.getPostId());
			noti.setNotiTypeId(1);
			noti.setQuant(1);
			noti.setIdUserActor(userInformation.getIdUser());
			if(userInformation.getIdUser() != idUserPost) {
				noti.setContent(userInformation.getUser().getName());
				notificationsDao.insert(noti);
			}

			return noti;
				
		}else {
			
			notiGet.setQuant(notiGet.getQuant()+1);
			notiGet.setIsread(false);
			notiGet.setNotiDate(TimeCalculation.getCurrentTime());
			notiGet.setIdUserActor(userInformation.getIdUser());
			if(userInformation.getIdUser() != idUserPost) {
				notiGet.setContent(userInformation.getUser().getName()+" and "+notiGet.getQuant()+" other people ");
				notificationsDao.update(notiGet);
			}
			return notiGet;
		}
		//List<Notifications> outputList = new ArrayList<Notifications>();// list noti of users
		
	}

	@Override
	public int getNumberOfNotiByUserId(int id, boolean b) {
		return notificationsDao.getNumberOfNotiByUserId(id, b);
	}
	
}
