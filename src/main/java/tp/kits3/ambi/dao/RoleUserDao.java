package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.RoleUser;

public interface RoleUserDao extends GenericDao<RoleUser>{
	List<RoleUser> selectByUserId(int id);
}
