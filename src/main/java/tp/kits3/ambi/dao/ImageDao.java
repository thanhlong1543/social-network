package tp.kits3.ambi.dao;

import tp.kits3.ambi.vo.Image;

public interface ImageDao extends GenericDao<Image>{

	Image selectByPostid(Integer postId);
	
}
