package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.CategoryDao;
import tp.kits3.ambi.vo.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
	public CategoryDaoImpl() {
		super("categoryMapper");
	}
}
