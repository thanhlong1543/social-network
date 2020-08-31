package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.FriendDao;
import tp.kits3.ambi.vo.Friend;

@Repository
public class FriendDaoImpl extends GenericDaoImpl<Friend> implements FriendDao {

	public FriendDaoImpl() {
		super("friendMapper");
	}

	
	
}
