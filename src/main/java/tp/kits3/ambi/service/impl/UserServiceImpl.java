package tp.kits3.ambi.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

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
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		// TODO Auto-generated method stub
		
	}



}
