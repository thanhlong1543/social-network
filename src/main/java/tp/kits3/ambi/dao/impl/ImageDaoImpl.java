package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.ImageDao;
import tp.kits3.ambi.vo.Image;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image> implements ImageDao {

	public ImageDaoImpl() {
		super("imageMapper");
	}

}
