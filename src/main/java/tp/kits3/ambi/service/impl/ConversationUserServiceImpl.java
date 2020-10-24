package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.ConversationUserDao;
import tp.kits3.ambi.service.ConversationUserService;
import tp.kits3.ambi.vo.ConversationUser;

@Service
public class ConversationUserServiceImpl implements ConversationUserService{
@Autowired
ConversationUserDao conversationUserDao;
	@Override
	public List<ConversationUser> selectByConId(int parseInt) {
		return conversationUserDao.selectByConId(parseInt);
	}
	@Override
	public List<ConversationUser> selectByUserId(int parseInt) {

		return conversationUserDao.selectByUserId(parseInt);
	}
	@Override
	public List<ConversationUser> selectConByUserid(int idUser) {
		return conversationUserDao.selectConByUserid(idUser);
	}
	@Override
	public void insert(ConversationUser conversationUser) {
		conversationUserDao.insert(conversationUser);
	}

}
