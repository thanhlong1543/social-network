package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.UserDao;
import tp.kits3.ambi.vo.User;


@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	public UserDaoImpl() {
		super("userMapper");
	}
	
	
	
}
