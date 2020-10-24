package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.CommentDao;
import tp.kits3.ambi.service.CommentService;
import tp.kits3.ambi.vo.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> selectByPostid(Integer postId) {
		return commentDao.selectByPostid(postId);
	}

	@Override
	public void insert(Comment comment) {
		commentDao.insert(comment);		
	}

	@Override
	public void update(Comment comment) {
		commentDao.update(comment);		
	}

	@Override
	public void isdelete(int id, int i) {
		commentDao.isdelete(id, i);
		
	}

	@Override
	public Comment selectByIdComment(int id) {
		
		return commentDao.selectOne(id);
	}

}
