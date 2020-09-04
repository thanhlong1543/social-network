package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.MenuDao;
import tp.kits3.ambi.service.MenuService;
import tp.kits3.ambi.vo.Menu;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuDao menuDao;

	@Override
	public List<Menu> selectAll() {
		// TODO Auto-generated method stub
		return menuDao.selectAll();
	}

	@Override
	public Menu selectOne(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectOne(id);
	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.update(menu);
	}

	@Override
	public List<Menu> selectByCategoryId(int id) {
		
		return menuDao.selectByCategoryId(id);
	}
}
