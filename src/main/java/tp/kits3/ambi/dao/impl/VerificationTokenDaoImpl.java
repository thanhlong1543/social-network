package tp.kits3.ambi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.VerificationTokenDao;
import tp.kits3.ambi.vo.VerificationToken;
@Repository
public class VerificationTokenDaoImpl extends GenericDaoImpl<VerificationToken> implements VerificationTokenDao {

	public VerificationTokenDaoImpl( ) {
		super("verificationTokenMapper");
	}
	
	@Override
	public VerificationToken findByVerificationToken(String token) {
		SqlSession session = getInstance().openSession();
		VerificationToken verifyToken = session.selectOne("mappers.verificationTokenMapper.selectByToken", token);
		session.close();
		return verifyToken;
	}

	@Override
	public VerificationToken findByUserId(int userId) {
		SqlSession session = getInstance().openSession();
		VerificationToken verifyToken = session.selectOne("mappers.verificationTokenMapper.selectByUserId", userId);
		session.close();
		return verifyToken;
	}
}
