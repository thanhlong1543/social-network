package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Comment;

public interface CommentDao extends GenericDao<Comment>  {

	List<Comment> selectByPostid(Integer postId);

	void isdelete(int id, int i);

}
