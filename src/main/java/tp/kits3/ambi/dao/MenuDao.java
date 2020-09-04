package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Menu;

public interface MenuDao extends GenericDao<Menu> {
	List<Menu> selectByCategoryId(int id);
}
