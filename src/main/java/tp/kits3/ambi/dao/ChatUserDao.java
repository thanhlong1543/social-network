package tp.kits3.ambi.dao;

import tp.kits3.ambi.vo.ChatUser;

public interface ChatUserDao extends GenericDao<ChatUser> {

	ChatUser selectByChatid(Integer chatId);

}
