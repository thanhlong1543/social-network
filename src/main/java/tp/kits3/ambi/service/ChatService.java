package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Chat;

public interface ChatService {

	void insert(Chat chat);

	void update(Chat chat);

	List<Chat> selectByConid(String conid);

}
