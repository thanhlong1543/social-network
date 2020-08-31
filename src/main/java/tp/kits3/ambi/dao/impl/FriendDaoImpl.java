package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.FriendDao;
import tp.kits3.ambi.vo.Friend;

@Repository
public class FriendDaoImpl extends GenericDaoImpl<Friend> implements FriendDao {

	public FriendDaoImpl() {
		super("friendMapper");
	}

	@Override
	public List<Friend> selectByUserId(int id) {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		List<Friend> list = session.selectList("mappers.friendMapper.selectByUserId", id);
		session.close();
		return list;
	}

	
	
}
