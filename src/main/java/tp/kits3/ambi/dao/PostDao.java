package tp.kits3.ambi.dao;


import java.util.List;

import tp.kits3.ambi.vo.Post;

public interface PostDao extends GenericDao<Post>{

	List<Post> selectByUserid(int userId);

	void isdelete(int id, int i);
	
}
