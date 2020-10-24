package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.MenuDao;
import tp.kits3.ambi.vo.Menu;


@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao {
	public MenuDaoImpl() {
		super("menuMapper");
	}

	@Override
	public List<Menu> selectByCategoryId(int id) {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		List<Menu> list = session.selectList("mappers.menuMapper.selectByCategoryId", id);
		session.close();
		return list;
	}
	
	
	
}
