package tp.kits3.ambi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.vo.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public List<User> selectAll() {
		return dao.selectAll();
	}
	public User selectOne(int id) {
		return dao.selectOne(id);
	}
	public void insert(User param) {
		dao.insert(param);
	}
	public void update(User param) {
		dao.update(param);
	}
	public void delete(int id) {
		dao.delete(id);
	}
	
	
}
