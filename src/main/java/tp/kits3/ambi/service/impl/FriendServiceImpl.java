package tp.kits3.ambi.service.impl;

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
	FriendDao friendDaoImpl;
	@Autowired
	UserDao userDaoImpl;

	@Override
	public List<User> selectByUserId(int id, int rela) {
		List<User> listFriend = userDaoImpl.selectListFriendById(id, rela);
		for (int i = 0; i < listFriend.size(); i++) {
			if (listFriend.get(i).getUserId() == id) {
				listFriend.remove(i);
				break;
			}
		}
		System.err.println(listFriend.size());
		return listFriend;
	}

	@Override
	public Friend getIdFriendByTwoUsersId(int id1, int id2) {
		return friendDaoImpl.getIdFriendByTwoUsersId(id1, id2);
	}

	@Override
	public void updateFriend(Friend friend) {
		friendDaoImpl.update(friend);
		
	}

	@Override
	public void deleteFriend(int id) {
		friendDaoImpl.delete(id);
		
	}}
