package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Menu;

public interface MenuService {
	List<Menu> selectAll();
	Menu selectOne(int id);
	void update(Menu menu);
	List<Menu> selectByCategoryId(int id);

}
