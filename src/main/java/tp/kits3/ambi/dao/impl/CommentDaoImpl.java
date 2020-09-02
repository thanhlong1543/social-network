package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.CommentDao;
import tp.kits3.ambi.vo.Comment;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

	public CommentDaoImpl() {
		super("commentMapper");
	}

	@Override
	public List<Comment> selectByPostid(Integer postId) {
		SqlSession session = getInstance().openSession();
		List<Comment> comments = session.selectList("mappers.commentMapper.selectByPostid",postId);
		session.close();
		return comments;
	}

	@Override
	public void isdelete(int id, int i) {
		Map<String,Integer> params = new HashMap<String, Integer>();
		params.put("isdelete", i);
		params.put("commentId", id);
		SqlSession session = getInstance().openSession();
		session.update("mappers.commentMapper.isdelete", params);
		session.commit();
		session.close();
	}
	
}
