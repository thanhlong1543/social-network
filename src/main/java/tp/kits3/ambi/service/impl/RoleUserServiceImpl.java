package tp.kits3.ambi.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.RoleUserDao;
import tp.kits3.ambi.service.RoleUserService;
import tp.kits3.ambi.vo.RoleUser;

@Service
public class RoleUserServiceImpl implements RoleUserService{
	
	@Autowired
	private RoleUserDao roleUserDao;
	
	@Override
	public List<RoleUser> selectByUserId(int id) {
		return roleUserDao.selectByUserId(id);
	}
	
	
	@Override
	public void insert(RoleUser roleUser) {
		roleUserDao.insert(roleUser);
	}

}
