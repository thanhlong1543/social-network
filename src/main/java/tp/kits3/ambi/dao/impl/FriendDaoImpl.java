package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.FriendDao;
import tp.kits3.ambi.vo.Friend;
/*
 * @author: Duc
 * */
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

	@Override
	public Friend getIdFriendByTwoUsersId(int id1, int id2) {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		Map<String, Integer> idUsers = new HashMap<String, Integer>();
		idUsers.put("id1", id1);
		idUsers.put("id2", id2);
		Friend fr = session.selectOne("mappers.friendMapper.getIdFriendByTwoUsersId", idUsers);

		session.close();
		return fr;
	}

}
