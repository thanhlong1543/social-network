package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.RelationshipDao;
import tp.kits3.ambi.vo.Relationship;



@Repository
public class RelationshipDaoImpl extends GenericDaoImpl<Relationship> implements RelationshipDao{

	public RelationshipDaoImpl() {
		super("relationshipMapper");

	}

}
