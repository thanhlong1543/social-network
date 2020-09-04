package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.User;

public interface UserService {
	List<User> selectAll();
	User selectOne(int userId);
	void insert(User user);
}
