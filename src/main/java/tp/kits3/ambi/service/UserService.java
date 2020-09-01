package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Conversation;
import tp.kits3.ambi.vo.User;

public interface UserService {
	List<User> selectAll();
	Conversation selectOne(int id);
	void update(User user);
	void insert(User user);
	void delete(int id);
}
