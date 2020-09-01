package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Subcomment;

public interface SubcommentDao extends GenericDao<Subcomment> {

	List<Subcomment> selectByCommentid(Integer commentId);

	void isdelete(int id, int i);
	
}
