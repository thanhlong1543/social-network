package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ChatDao;
import tp.kits3.ambi.vo.Chat;

@Repository
public class ChatDaoImpl extends GenericDaoImpl<Chat> implements ChatDao {

	public ChatDaoImpl() {
		super("chatMapper");
	}

}
