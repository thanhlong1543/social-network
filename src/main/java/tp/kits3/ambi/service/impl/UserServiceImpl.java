package tp.kits3.ambi.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.RoleDao;
import tp.kits3.ambi.dao.RoleUserDao;
import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.dto.UserDto;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.RoleUser;
import tp.kits3.ambi.vo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleUserDao roleUserDao;
	
	@Override
	public User selectOne(int userId) {
		return userDao.selectOne(userId);
	}
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
    @Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	@Override
	public User selectByEmail(String email) {
		return userDao.selectByEmail(email);

	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	@Override
	public User selectByUri(String uri) {
		return userDao.selectByUri(uri);
	}

	/** 
	 * @author Vu Thanh Long
	 */
	@Override
	public List<String> selectAllRole(int userId) {
		List<RoleUser> listRoleUser = roleUserDao.selectByUserId(userId);
		List<String> result = new ArrayList<>();
		if(!listRoleUser.isEmpty()) {
			for (RoleUser item : listRoleUser) {
				result.add(roleDao.selectOne(item.getRoleId()).getName());
			}
		}
		return result;
	}
	/** 
	 * @author Vu Thanh Long
	 */
	@Override
	public List<UserDto> selectMutualFriend(int id) {
		List<UserDto> list = userDao.selectMutualFriend(id);
		for (UserDto userDto : list) {
			userDto.setListMutual(userDao.selectListMutual(id, userDto.getUserId()));
		}
		return list;
	}
	@Override
	public List<String> selectNameByPostId(int id) {
		return userDao.selectNameByPostId(id);
	}
	
	

}
