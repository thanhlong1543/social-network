package tp.kits3.ambi.dao;

import tp.kits3.ambi.vo.About;

public interface AboutDao extends GenericDao<About> {
	About getUserAboutByUserId(int id);
}
