package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.User;

public interface UserDao extends GenericDao<User> {
	public List<User> selectListFriendById(int id, int rela);
}
