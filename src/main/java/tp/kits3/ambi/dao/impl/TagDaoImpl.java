package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.dao.TagDao;
import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.Tag;


@Repository
public class TagDaoImpl extends GenericDaoImpl<Tag> implements TagDao {
	public TagDaoImpl() {
		super("tagMapper");
	}
	
	
	
}
