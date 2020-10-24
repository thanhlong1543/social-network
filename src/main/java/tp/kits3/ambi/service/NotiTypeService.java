package tp.kits3.ambi.service;

import tp.kits3.ambi.vo.NotiType;

public interface NotiTypeService {
	void getTypeById(int id);

	NotiType selectOne(Integer notiTypeId);
}
