package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.ChatUserDao;
import tp.kits3.ambi.service.ChatUserService;
import tp.kits3.ambi.vo.ChatUser;

@Service
public class ChatUserServiceImpl implements ChatUserService{
@Autowired
private ChatUserDao chatUserDao;
	@Override
	public void insert(Integer userId, Integer chatId) {
		ChatUser chatUser = new ChatUser();
		chatUser.setChatId(chatId);
		chatUser.setUserId(userId);
		chatUser.setIsdelete(false);
		chatUser.setIsread(false);
		chatUserDao.insert(chatUser);
	}
	@Override
	public ChatUser selectByChatid(Integer chatId) {
		return chatUserDao.selectByChatid(chatId);
	}

}
