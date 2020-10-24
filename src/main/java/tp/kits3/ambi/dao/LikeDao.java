package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Like;

public interface LikeDao extends GenericDao<Like> {
	
	List<Like> selectByPostid(Integer postId);
	
	void deleteByPostIdAndUserId(Like like);
	
	List<Like> selectByUserId(Integer userId);
	
	Like selectByUseridAndPostid(Like like);
}
