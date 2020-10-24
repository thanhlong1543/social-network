package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.AboutDao;
import tp.kits3.ambi.service.AboutService;
import tp.kits3.ambi.vo.About;
/*
 * @author: Duc
 * */
@Service
public class AboutServiceImpl implements AboutService{
	@Autowired
	AboutDao aboutDao;
	@Override
	public About getUserAboutByUserId(int id) {
		return aboutDao.getUserAboutByUserId(id);
	}
	@Override
	public void updateAbout(About about) {
		aboutDao.update(about);
	}

}
