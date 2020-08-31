package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.LikeDao;
import tp.kits3.ambi.vo.Like;


@Repository
public class LikeDaoImpl extends GenericDaoImpl<Like> implements LikeDao {
	public LikeDaoImpl() {
		super("likeMapper");
	}
	
	
	
}
