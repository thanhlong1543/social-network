package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.VerificationTokenDao;
import tp.kits3.ambi.service.VerificationTokenService;
import tp.kits3.ambi.vo.VerificationToken;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService{

	
	@Autowired
	private VerificationTokenDao dao;

	@Override
	public VerificationToken findByVerificationToken(String token) {
		return dao.findByVerificationToken(token);
	}

	@Override
	public void insert(VerificationToken token) {
		dao.insert(token);
	}

	@Override
	public VerificationToken findByUserId(int userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public void update(VerificationToken token) {
		dao.update(token);
	}
}
