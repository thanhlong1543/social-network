package tp.kits3.ambi.dao.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.ambi.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T>{
	private SqlSessionFactory factory = null;
	String mapper;
	
	public GenericDaoImpl(String mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public SqlSessionFactory getInstance() {
		if (factory == null) {
			//create factory
			try {
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml");// user read text from xml file
				factory = new SqlSessionFactoryBuilder().build(resource);
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return factory;
	}
	
	@Override
	public List<T> selectAll() {
		SqlSession session = getInstance().openSession(); // your choice get return factory
		List<T> list = session.selectList( "mappers." +mapper + ".selectAll");
		session.close();
		return list;
	}
	
	@Override
	public T selectOne(int id) {
		SqlSession session = getInstance().openSession();
		T object = session.selectOne("mappers." + mapper  + ".selectOne",id);
		session.close();
		return object;
	}
	@Override
	public void insert(T param) {
		SqlSession session = getInstance().openSession();
		session.insert( "mappers." +mapper + ".insert", param);
		session.commit();
		session.close();
		
	}
	@Override
	public void update(T param) {
		SqlSession session = getInstance().openSession();
		session.update("mappers." +mapper + ".update", param);
		session.commit();
		session.close();
	}
	@Override
	public void delete(int id) {
		SqlSession session = getInstance().openSession();
		session.delete( "mappers." +mapper +".delete", id);
		session.commit();
		session.close();
	}
}
