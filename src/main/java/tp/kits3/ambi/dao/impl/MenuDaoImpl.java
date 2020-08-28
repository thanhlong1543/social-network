package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.dao.MenuDao;
import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.Menu;


@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao {
	public MenuDaoImpl() {
		super("menuMapper");
	}
	
	
	
}
