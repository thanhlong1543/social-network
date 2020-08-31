package tp.kits3.ambi.dao.impl;

import java.util.List;

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
	
}
