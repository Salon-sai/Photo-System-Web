/**
 * 
 */
package saiwei.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;
import saiwei.model.User;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("relationshipDAO")
public class RelationShipDAOImpl extends BaseDAO<RelationShip> implements
		IRelationShipDAO {
	
	public boolean foundfollowing(String founderId,String followingId){
		Session session = sessionFactory.getCurrentSession();
		
		User founder = (User)session.createQuery("").uniqueResult();
		User following = (User)session.createQuery("").uniqueResult();
		
		
		return false;
	}
	
}
