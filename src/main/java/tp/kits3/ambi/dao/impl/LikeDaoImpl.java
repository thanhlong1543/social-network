package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.LikeDao;
import tp.kits3.ambi.vo.Like;


@Repository
public class LikeDaoImpl extends GenericDaoImpl<Like> implements LikeDao {
	public LikeDaoImpl() {
		super("likeMapper");
	}

	@Override
	public List<Like> selectByPostid(Integer postId) {
		SqlSession session = getInstance().openSession();
		List<Like> like = session.selectList("mappers.likeMapper.selectByPostid",postId);
		session.close();
		return like;
	}

	@Override
	public void deleteByPostIdAndUserId(Like like) {
		SqlSession session = getInstance().openSession();
		session.delete("mappers.likeMapper.deleteByPostIdAndUserId",like);
		session.commit();
		session.close();
	}

	@Override
	public List<Like> selectByUserId(Integer userId) {
		SqlSession session = getInstance().openSession();
		List<Like> like = session.selectList("mappers.likeMapper.selectByPostid",userId);
		session.close();
		return like;
	}

	@Override
	public Like selectByUseridAndPostid(Like like) {
		SqlSession session = getInstance().openSession();
		Like likee = session.selectOne("mappers.likeMapper.selectByUseridAndPostid",like);
		session.close();
		return likee;
	}
	
	
	
}
