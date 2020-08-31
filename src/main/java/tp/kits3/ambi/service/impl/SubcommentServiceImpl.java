package tp.kits3.ambi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.SubcommentDao;
import tp.kits3.ambi.service.SubcommentService;
import tp.kits3.ambi.vo.Subcomment;
@Service
public class SubcommentServiceImpl implements SubcommentService {
@Autowired
SubcommentDao subcommentDao;
	@Override
	public List<Subcomment> selectByCommentid(Integer commentId) {
		return subcommentDao.selectByCommentid(commentId);
	}

}
