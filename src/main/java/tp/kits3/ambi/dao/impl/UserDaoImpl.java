package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.vo.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	public UserDaoImpl() {
		super("userMapper");
	}
	@Override
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
	@Override
	public User selectByEmail(String email) {
		SqlSession session = getInstance().openSession();
		User user = session.selectOne("mappers.userMapper.selectByEmail", email);
		session.close();
		return user;
	}

	@Override
	public User selectByUri(String uri) {
		SqlSession session = getInstance().openSession();
		User user = session.selectOne("mappers.userMapper.selectByUri", uri);
		session.close();
		return user;
	}
	@Override
	public List<User> selectListPending(int id, int rela) {
		SqlSession session = getInstance().openSession();
		//List<User> list = session.selectList("mappers.userMapper.selectListFriendById", id, rela);
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("userid", id);
		params.put("reid", rela);
		List<User> list = session.selectList("mappers.userMapper.selectListPending", params);
		session.close();
		return list;
	}
	@Override
	public List<UserDto> selectMutualFriend(int id) {
		List<UserDto> list;
		SqlSession session = getInstance().openSession();
		list = session.selectList("mappers.userMapper.selectMutualFriend", id);
		session.close();
		return list;
	}
	@Override
	public List<User> selectListMutual(int myid, int fid) {
		SqlSession session = getInstance().openSession();
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("myid", myid);
		params.put("fid", fid);
		List<User> list = session.selectList("mappers.userMapper.selectListMutual", params);
		session.close();
		return list;
	}
	@Override
	public List<String> selectNameByPostId(int id) {
		SqlSession session = getInstance().openSession();
		List<String> list;
		list = session.selectList("mappers.userMapper.selectNameByPostId",id);
		session.close();
		return list;
	}
	
}
