package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.NotiTypeDao;
import tp.kits3.ambi.service.NotiTypeService;
import tp.kits3.ambi.vo.NotiType;
@Service
public class NotiTypeServiceImpl implements NotiTypeService{
	@Autowired
	NotiTypeDao notiTypeDao;
	@Override
	public void getTypeById(int id) {
		notiTypeDao.selectOne(id);
		
	}
	@Override
	public NotiType selectOne(Integer notiTypeId) {
		return notiTypeDao.selectOne(notiTypeId);
	}

}
