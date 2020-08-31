package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.RoleDao;
import tp.kits3.ambi.vo.Role;



@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao{

	public RoleDaoImpl() {
		super("roleMapper");
		// TODO Auto-generated constructor stub
	}

}
