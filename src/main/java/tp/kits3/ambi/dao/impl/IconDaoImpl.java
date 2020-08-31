package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.IconDao;
import tp.kits3.ambi.vo.Icon;

@Repository
public class IconDaoImpl extends GenericDaoImpl<Icon> implements IconDao{

	public IconDaoImpl() {
		super("iconMapper");
	}

}
