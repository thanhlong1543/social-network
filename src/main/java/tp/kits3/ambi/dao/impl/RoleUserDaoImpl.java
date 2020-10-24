package tp.kits3.ambi.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import tp.kits3.ambi.dao.RoleUserDao;
import tp.kits3.ambi.vo.RoleUser;



@Repository
public class RoleUserDaoImpl extends GenericDaoImpl<RoleUser> implements RoleUserDao {

	public RoleUserDaoImpl() {
		super("roleUserMapper");
		
	}

	@Override
	public List<RoleUser> selectByUserId(int id) {
		SqlSession session = getInstance().openSession();
		List<RoleUser> list = session.selectList("mappers.roleUserMapper.selectByUserId",id);
		session.close();
		return list;
	}

}
