package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.vo.About;


@Repository
public class AboutDaoImpl extends GenericDaoImpl<About> implements AboutDao {
	public AboutDaoImpl() {
		super("aboutMapper");
	}
	
	
	
}
