package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ConversationUserDao;
import tp.kits3.ambi.vo.ConversationUser;


@Repository
public class ConversationUserDaoImpl extends GenericDaoImpl<ConversationUser> implements ConversationUserDao {

	public ConversationUserDaoImpl() {
		super("conversationUserMapper");
	}

}
