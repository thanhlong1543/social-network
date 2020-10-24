package tp.kits3.ambi.service;
import java.util.List;

import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.vo.User;

public interface UserService {
	List<User> selectAll();
	User selectOne(int userId);
	void insert(User user);
	User selectByEmail(String email);
	void update(User user);
	User selectByUri(String uri);
	List<String> selectAllRole(int userId);
	List<UserDto> selectMutualFriend(int id);
	List<String> selectNameByPostId(int id);
}
