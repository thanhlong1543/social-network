package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.dao.SubcommentDao;
import tp.kits3.ambi.vo.About;
import tp.kits3.ambi.vo.Subcomment;


@Repository
public class SubCommentDaoImpl extends GenericDaoImpl<Subcomment> implements SubcommentDao {
	public SubCommentDaoImpl() {
		super("subcommentMapper");
	}
	
	
	
}
