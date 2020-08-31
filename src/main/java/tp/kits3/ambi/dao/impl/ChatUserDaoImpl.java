package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ChatUserDao;
import tp.kits3.ambi.vo.ChatUser;

@Repository
public class ChatUserDaoImpl extends GenericDaoImpl<ChatUser> implements ChatUserDao{

	public ChatUserDaoImpl() {
		super("chatUserMapper");
	}

}
