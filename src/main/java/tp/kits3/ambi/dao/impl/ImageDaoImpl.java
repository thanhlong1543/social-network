package tp.kits3.ambi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ImageDao;
import tp.kits3.ambi.vo.Image;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image> implements ImageDao {

	public ImageDaoImpl() {
		super("imageMapper");
	}

	@Override
	public Image selectByPostid(Integer postId) {
		SqlSession session = getInstance().openSession();
		Image image = session.selectOne("mappers.imageMapper.selectByPostid",postId);
		session.close();
		return image;
	}

}
