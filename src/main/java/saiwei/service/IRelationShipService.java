/**
 * 
 */
package saiwei.service;

import java.util.List;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;
import saiwei.model.User;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IRelationShipService extends
		IServiceTemplate<IRelationShipDAO, RelationShip> {

	public boolean addrelationship(String founderId,String linked_persionId,String typeName);
	
	public List<User> findUserRelationShip(String userId,String relationshipType);
	
}
