package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.dao.PostDao;
import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.Post;


@Repository
public class PostDaoImpl extends GenericDaoImpl<Post> implements PostDao {
	public PostDaoImpl() {
		super("postMapper");
	}
	
	
	
}
