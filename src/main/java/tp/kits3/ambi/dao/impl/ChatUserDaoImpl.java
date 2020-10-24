package tp.kits3.ambi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ChatUserDao;
import tp.kits3.ambi.vo.ChatUser;

@Repository
public class ChatUserDaoImpl extends GenericDaoImpl<ChatUser> implements ChatUserDao{

	public ChatUserDaoImpl() {
		super("chatUserMapper");
	}

	@Override
	public ChatUser selectByChatid(Integer chatId) {
		SqlSession session = getInstance().openSession();
		ChatUser chatUser = session.selectOne("mappers.chatUserMapper.selectByChatId",chatId);
		session.close();
		return chatUser;
	}

}
