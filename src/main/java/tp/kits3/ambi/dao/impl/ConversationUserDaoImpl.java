package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ConversationUserDao;
import tp.kits3.ambi.vo.ConversationUser;


@Repository
public class ConversationUserDaoImpl extends GenericDaoImpl<ConversationUser> implements ConversationUserDao {

	public ConversationUserDaoImpl() {
		super("conversationUserMapper");
	}

	@Override
	public List<ConversationUser> selectByConId(int parseInt) {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		List<ConversationUser> list = session.selectList( "mappers.conversationUserMapper.selectByConId",parseInt);
		session.close();
		return list;
	}

	@Override
	public List<ConversationUser> selectByUserId(int parseInt) {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		List<ConversationUser> list = session.selectList( "mappers.conversationUserMapper.selectByUserId",parseInt);
		session.close();
		return list;
	}

	@Override
	public List<ConversationUser> selectConByUserid(int idUser) {
		SqlSession session = getInstance().openSession();
		List<ConversationUser> conversationUsers = session.selectList("mappers.conversationUserMapper.selectConByUserid",idUser);
		session.close();
		return conversationUsers;
	}

}
