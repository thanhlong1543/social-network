package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.User;

public interface FriendService {
	List<User> selectByUserId(int id);
}
