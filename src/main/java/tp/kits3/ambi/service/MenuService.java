package tp.kits3.ambi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.MenuDao;
import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.vo.Menu;
import tp.kits3.ambi.vo.User;

@Service
public class MenuService {
	@Autowired
	private MenuDao dao;
	public List<Menu> selectAll() {
		return dao.selectAll();
	}
	public Menu selectOne(int id) {
		return dao.selectOne(id);
	}
	public void insert(Menu param) {
		dao.insert(param);
	}
	public void update(Menu param) {
		dao.update(param);
	}
	public void delete(int id) {
		dao.delete(id);
	}
	
	
}
