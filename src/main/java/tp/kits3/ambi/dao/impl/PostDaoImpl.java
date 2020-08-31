package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.PostDao;
import tp.kits3.ambi.vo.Post;

@Repository
public class PostDaoImpl extends GenericDaoImpl<Post> implements PostDao {

	public PostDaoImpl() {
		super("postMapper");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Post> selectByUserid(int userId) {
		SqlSession session = getInstance().openSession();
		List<Post> posts = session.selectList("mappers.postMapper.selectByUserid", userId);
		session.close();
		return posts;
	}

}
