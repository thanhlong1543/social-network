package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.SubcommentDao;
import tp.kits3.ambi.vo.Subcomment;


@Repository
public class SubCommentDaoImpl extends GenericDaoImpl<Subcomment> implements SubcommentDao {
	public SubCommentDaoImpl() {
		super("subcommentMapper");
	}

	@Override
	public List<Subcomment> selectByCommentid(Integer commentId) {
		SqlSession session = getInstance().openSession();
		List<Subcomment> subcomments = session.selectList("mappers.subcommentMapper.selectByCommentid",commentId);
		session.close();
		return subcomments;
	}
}
