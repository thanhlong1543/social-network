package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ChatDao;
import tp.kits3.ambi.vo.Chat;

@Repository
public class ChatDaoImpl extends GenericDaoImpl<Chat> implements ChatDao {

	public ChatDaoImpl() {
		super("chatMapper");
	}

	@Override
	public List<Chat> selectByConid(String conid) {
		SqlSession session = getInstance().openSession();
		List<Chat> chats = session.selectList("mappers.chatMapper.selectByConid",Integer.parseInt(conid));
		session.close();
		return chats;
	}

}
