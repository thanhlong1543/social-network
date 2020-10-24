package tp.kits3.ambi.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.vo.About;


@Repository
public class AboutDaoImpl extends GenericDaoImpl<About> implements AboutDao {
	public AboutDaoImpl() {
		super("aboutMapper");
	}

	@Override
	public About getUserAboutByUserId(int id) {
		SqlSession session = getInstance().openSession();
		About about = session.selectOne("mappers.aboutMapper.selectOneByUser", id);
		session.close();
		return about;
	}
	
}
