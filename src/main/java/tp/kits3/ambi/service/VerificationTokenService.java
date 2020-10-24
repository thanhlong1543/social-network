package tp.kits3.ambi.service;

import tp.kits3.ambi.vo.VerificationToken;

public interface VerificationTokenService {
	VerificationToken findByVerificationToken(String token);
	void insert(VerificationToken token);
	VerificationToken findByUserId(int userId);
	void update(VerificationToken token);
}
