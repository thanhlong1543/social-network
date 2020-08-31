package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.PrivacyDao;
import tp.kits3.ambi.vo.Privacy;



@Repository
public class PrivacyDaoImpl extends GenericDaoImpl<Privacy> implements PrivacyDao{
	public PrivacyDaoImpl() {
		super("privacyMapper");
	}
}
