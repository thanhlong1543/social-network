package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ConversationDao;
import tp.kits3.ambi.vo.Conversation;

@Repository
public class ConversationDaoImpl extends GenericDaoImpl<Conversation> implements ConversationDao {

	public ConversationDaoImpl() {
		super("conversationMapper");
	}
	
	
	
}
