package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.PostDao;
import tp.kits3.ambi.vo.Post;

@Repository
public class PostDaoImpl extends GenericDaoImpl<Post> implements PostDao {

	public PostDaoImpl() {
		super("postMapper");
	}

	@Override
	public List<Post> selectByUserid(int userId) {
		SqlSession session = getInstance().openSession();
		List<Post> posts = session.selectList("mappers.postMapper.selectByUserid", userId);
		session.close();
		return posts;
	}

	@Override
	public void isdelete(int id, int i) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("isdelete", i);
		params.put("postId", id);
		SqlSession session = getInstance().openSession();
		session.update("mappers.postMapper.isdelete", params);
		session.commit();
		session.close();
	}

	@Override
	public Post selectByIdPost(int id) {
		SqlSession session = getInstance().openSession();
		Post post = session.selectOne("mappers.postMapper.selectOne", id); 
		session.close();
		return post;
		
	}
}
