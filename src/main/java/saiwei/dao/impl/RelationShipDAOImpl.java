/**
 * 
 */
package saiwei.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;
import saiwei.model.RelationShipType;
import saiwei.model.User;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("relationshipDAO")
public class RelationShipDAOImpl extends BaseDAO<RelationShip> implements
		IRelationShipDAO {
	
	private static final String CLASSTYPE_RELATIONSHIP = "RelationShip";
	
	public boolean foundfollowing(String founderId,String followingId){
		try{
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from User as model where model.IdNumber =: IdNumber";
			String queryString1 = "from RelationShipType as model where model.name =: name";
			RelationShip relationship = new RelationShip();
			
			User founder = (User)session.createQuery(queryString)
					.setParameter("IdNumber", founderId).uniqueResult();
			User linked_person = (User)session.createQuery(queryString)
					.setParameter("IdNumber", followingId).uniqueResult();
			RelationShipType type = (RelationShipType)session.createQuery(queryString1)
					.setParameter("name", "following").uniqueResult();
			
			relationship.setFounder(founder);
			relationship.setLinked_person(linked_person);
			relationship.setRelationship(type);
			
			session.save(relationship);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean foundrelationship(Session session,String founderId,String linked_persionId,RelationShipType type){
		return false;
	}
	
}
