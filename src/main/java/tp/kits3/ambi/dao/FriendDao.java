package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Friend;

public interface FriendDao extends GenericDao<Friend>{
	List<Friend> selectByUserId(int id);
	Friend getIdFriendByTwoUsersId(int id1, int id2);
}
