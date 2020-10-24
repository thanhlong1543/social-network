package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.LikeDao;
import tp.kits3.ambi.service.LikeService;
import tp.kits3.ambi.vo.Like;
@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	LikeDao likeDao;

	@Override
	public List<Like> selectByPostid(Integer postId) {
		return likeDao.selectByPostid(postId);
	}
	
	@Override
	public void insert(Like like) {
		likeDao.insert(like);
	}

	@Override
	public void delete(int id) {
		likeDao.delete(id);
	}

	@Override
	public void deleteByPostIdAndUserId(Like like) {
		likeDao.deleteByPostIdAndUserId(like);
	}

	@Override
	public List<Like> selectByUserId(Integer userId) {
		return likeDao.selectByUserId(userId);
	}

	@Override
	public Like selectByUseridAndPostid(Like like) {
		return likeDao.selectByUseridAndPostid(like);
	}

	
}
