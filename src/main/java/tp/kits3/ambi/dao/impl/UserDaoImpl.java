package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<User> selectListFriendById(int id, int rela){
		SqlSession session = getInstance().openSession();
		//List<User> list = session.selectList("mappers.userMapper.selectListFriendById", id, rela);
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("userid", id);
		params.put("reid", rela);
		List<User> list = session.selectList("mappers.userMapper.selectListFriendById", params);
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
