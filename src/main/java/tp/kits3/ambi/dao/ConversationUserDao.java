package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.ConversationUser;

public interface ConversationUserDao extends GenericDao<ConversationUser>{

	List<ConversationUser> selectByConId(int parseInt);

	List<ConversationUser> selectByUserId(int parseInt);

	List<ConversationUser> selectConByUserid(int idUser);

}
