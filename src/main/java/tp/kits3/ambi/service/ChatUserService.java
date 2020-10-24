package tp.kits3.ambi.service;

import tp.kits3.ambi.vo.ChatUser;

public interface ChatUserService {

	void insert(Integer userId, Integer chatId);

	ChatUser selectByChatid(Integer chatId);

}
