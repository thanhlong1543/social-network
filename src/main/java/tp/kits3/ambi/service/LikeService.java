package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Like;

public interface LikeService {
	
	List<Like> selectByPostid(Integer postId);
	
	void insert(Like like);
	
	void delete(int id);
	
	void deleteByPostIdAndUserId(Like like);
	
	List<Like> selectByUserId(Integer userId);
	
	Like selectByUseridAndPostid(Like like);
}
