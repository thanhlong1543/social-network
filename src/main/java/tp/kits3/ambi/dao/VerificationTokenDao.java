package tp.kits3.ambi.dao;

import tp.kits3.ambi.vo.VerificationToken;

public interface VerificationTokenDao extends GenericDao<VerificationToken>{
	VerificationToken findByVerificationToken(String token);
	VerificationToken findByUserId(int userId);
}
