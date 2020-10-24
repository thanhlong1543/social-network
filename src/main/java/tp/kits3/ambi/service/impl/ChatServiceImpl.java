package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.ChatDao;
import tp.kits3.ambi.service.ChatService;
import tp.kits3.ambi.vo.Chat;

@Service
public class ChatServiceImpl implements ChatService{
@Autowired
private  ChatDao chatDao;
	@Override
	public void insert(Chat chat) {
		chatDao.insert(chat);
	}
	@Override
	public void update(Chat chat) {
		chatDao.update(chat);
		
	}
	@Override
	public List<Chat> selectByConid(String conid) {
		return chatDao.selectByConid(conid);
	}

}
