package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.vo.User;

public interface UserDao extends GenericDao<User> {
    
	User selectByEmail(String email);
	public List<User> selectListFriendById(int id, int rela);
	User selectByUri(String uri);
	List<User> selectListPending(int id, int rela);
	List<UserDto> selectMutualFriend(int id);
	List<User> selectListMutual(int myid, int fid);
	List<String> selectNameByPostId(int id);
}
