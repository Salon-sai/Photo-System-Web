/**
 * 
 */
package saiwei.service;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IRelationShipService extends
		IServiceTemplate<IRelationShipDAO, RelationShip> {

	public boolean addrelationship(String founderId,String linked_persionId,String typeName);
	
}
