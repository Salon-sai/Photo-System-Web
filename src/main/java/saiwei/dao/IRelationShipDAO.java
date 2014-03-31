/**
 * 
 */
package saiwei.dao;

import java.util.List;

import saiwei.model.RelationShip;
import saiwei.model.User;

import common.IDAOTemplate;

/**
 * @author sai
 *
 */
public interface IRelationShipDAO extends IDAOTemplate<RelationShip> {

	public boolean foundrelationship(String founderId,String linked_persionId,String typeName);
	
	public List<User> findUserRelationship(String userId,String typeName);
}
