package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void isdelete(int id, int i) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("isdelete", i);
		params.put("subcommentId",id);
		SqlSession session = getInstance().openSession();
		session.update("mappers.subcommentMapper.isdelete",params);
		session.commit();
		session.close();
	}
}
