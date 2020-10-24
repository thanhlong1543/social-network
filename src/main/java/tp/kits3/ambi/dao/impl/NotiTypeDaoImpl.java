package tp.kits3.ambi.dao.impl;


import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.NotiTypeDao;
import tp.kits3.ambi.vo.NotiType;
@Repository
public class NotiTypeDaoImpl extends GenericDaoImpl<NotiType>implements NotiTypeDao{

	public NotiTypeDaoImpl() {
		super("notiTypeMapper");
		
	}
	

}
