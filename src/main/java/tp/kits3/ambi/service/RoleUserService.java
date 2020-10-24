package tp.kits3.ambi.service;

import java.util.List;

import tp.kits3.ambi.vo.RoleUser;

public interface RoleUserService {
	List<RoleUser> selectByUserId(int id);
	void insert(RoleUser roleUser);
}
