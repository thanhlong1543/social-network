package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.RoleUserDao;
import tp.kits3.ambi.vo.RoleUser;



@Repository
public class RoleUserDaoImpl extends GenericDaoImpl<RoleUser> implements RoleUserDao {

	public RoleUserDaoImpl() {
		super("roleUserMapper");
		// TODO Auto-generated constructor stub
	}

}
