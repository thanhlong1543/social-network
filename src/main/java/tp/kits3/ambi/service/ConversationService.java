package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Conversation;

public interface ConversationService {
	List<Conversation> selectAll();
	Conversation selectOne(int id);
	void update(Conversation conversation);
	void insert(Conversation conversation);
	void delete(int id);
}
