package tp.kits3.ambi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

public interface GenericDao<T> {
	SqlSessionFactory getInstance();
	List<T> selectAll();
	T selectOne(int id);
	void insert(T param);
	void update(T param);
	void delete(int id);
}
