package tp.kits3.ambi.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.RoleDao;
import tp.kits3.ambi.service.RoleService;
import tp.kits3.ambi.vo.Role;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void insert(Role role) {
		roleDao.insert(role);
	}

	@Override
	public void update(Role role) {

	}
}
