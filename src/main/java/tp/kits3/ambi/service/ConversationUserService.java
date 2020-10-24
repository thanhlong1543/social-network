package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.ConversationUser;

public interface ConversationUserService {

	List<ConversationUser> selectByConId(int parseInt);

	List<ConversationUser> selectByUserId(int parseInt);

	List<ConversationUser> selectConByUserid(int idUser);

	void insert(ConversationUser conversationUser);

}
