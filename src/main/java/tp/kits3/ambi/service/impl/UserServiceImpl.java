package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.service.SubcommentService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.Conversation;
import tp.kits3.ambi.vo.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> selectAll() {

		return null;
	}

	@Override
	public Conversation selectOne(int id) {

		return null;
	}

	@Override
	public void update(User user) {

		
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);	
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
