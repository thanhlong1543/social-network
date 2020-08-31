package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Subcomment;

public interface SubcommentService {

	List<Subcomment> selectByCommentid(Integer commentId);
	
}
