package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Friend;
import tp.kits3.ambi.vo.User;
/*
 * @author: Duc
 * */
public interface FriendService {
	List<User> selectByUserId(int id, int rela);
	Friend getIdFriendByTwoUsersId(int id1, int id2);
	void updateFriend(Friend friend);
	void deleteFriend(int id);
	boolean checkExistingFriend(int id1, int id2);
	void sendFriendRequest(int id1, int id2, int rela);
	List<User> getListPending(int id, int reid);
	int getRelationshipId(int id1, int id2);
	String checkWhoIsSendingRequest(int id1, int id2);
}
