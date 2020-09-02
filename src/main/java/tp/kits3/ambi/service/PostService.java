package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.dto.PostDto;
import tp.kits3.ambi.vo.Post;

public interface PostService {

	List<Post> selectAll();

	List<Post> selectByUserid(int userId);

	List<PostDto> selectPostInfoByUserid(int userId);

	void insert(Post post);

	void update(Post post);

	void isdelete(int id, int i);
	
}
