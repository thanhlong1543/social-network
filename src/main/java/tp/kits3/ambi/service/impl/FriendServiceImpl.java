package tp.kits3.ambi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.FriendDao;
import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.service.FriendService;
import tp.kits3.ambi.vo.Friend;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendDao friendDao;
	@Autowired
	UserDao userDao;
	@Override
	public List<User> selectByUserId(int id, int rela) {
		List<User> listFriend = new ArrayList<User>();
		try {
			listFriend = userDao.selectListFriendById(id, rela);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < listFriend.size(); i++) {
			if (listFriend.get(i).getUserId() == id) {
				listFriend.remove(i);
				break;
			}
		}
		return listFriend;
	}

	@Override
	public Friend getIdFriendByTwoUsersId(int id1, int id2) {
		return friendDao.getIdFriendByTwoUsersId(id1, id2);
	}

	@Override
	public void updateFriend(Friend friend) {
		friendDao.update(friend);
		
	}

	@Override
	public void deleteFriend(int id) {
		friendDao.delete(id);

	}

	@Override
	public boolean checkExistingFriend(int id1, int id2) {
		Friend fr = friendDao.getIdFriendByTwoUsersId(id1, id2);
		if(fr == null) return false;
		else return true;
	}

	@Override
	public void sendFriendRequest(int id1, int id2, int rela) {
		friendDao.insert(new Friend(id1, id2, rela));
		
	}

	@Override
	public List<User> getListPending(int id, int reid) {
		List<User> listPending = userDao.selectListPending(id, reid);
		for (int i = 0; i < listPending.size(); i++) {
			if (listPending.get(i).getUserId() == id) {
				listPending.remove(i);
				break;
			}
		}
		return listPending;
	}

	@Override
	public int getRelationshipId(int id1, int id2) {
		Friend fr = friendDao.getIdFriendByTwoUsersId(id1, id2);
		if(fr == null) return 0;
		else return fr.getReId();
		
	}

	@Override
	public String checkWhoIsSendingRequest(int id1, int id2) {
		Friend fr = friendDao.getIdFriendByTwoUsersId(id1, id2);
		if(fr.getUser1Id() == id1)
			return "You send";
		return "You receive";
	}
	
}

