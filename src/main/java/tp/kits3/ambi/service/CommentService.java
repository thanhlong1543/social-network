package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.Comment;

public interface CommentService {

	List<Comment> selectByPostid(Integer postId);

}
