package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.vo.User;


@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	public UserDaoImpl() {
		super("userMapper");
	}
	
	public List<User> selectListFriendById(int id){
		SqlSession session = getInstance().openSession();
		List<User> list = session.selectList("mappers.userMapper.selectListFriendById", id);
		session.close();
		return list;
	}
	
	public User selectByEmail(String email) {
		SqlSession session = getInstance().openSession();
		User user = session.selectOne("mappers.userMapper.selectByEmail", email);
		session.close();
		return user;
	}
	
	
}
