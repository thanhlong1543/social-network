package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.ConversationDao;
import tp.kits3.ambi.service.ConversationService;
import tp.kits3.ambi.vo.Conversation;

@Service
public class ConversationServiceImpl implements ConversationService {
	
	@Autowired
	private ConversationDao converDao;

	@Override
	public List<Conversation> selectAll() {

		return converDao.selectAll();
	}

	@Override
	public Conversation selectOne(int id) {
		return converDao.selectOne(id);
	}

	@Override
	public void update(Conversation conversation) {
		converDao.update(conversation);
	}

	@Override
	public void insert(Conversation conversation) {
		converDao.insert(conversation);
	}

	@Override
	public void delete(int id) {
		converDao.delete(id);
	}

}
