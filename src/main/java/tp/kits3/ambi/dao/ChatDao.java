package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Chat;

public interface ChatDao extends GenericDao<Chat> {

	List<Chat> selectByConid(String conid);
	
}
