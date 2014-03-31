/**
 * 
 */
package saiwei.dao;

import saiwei.model.RelationShip;

import common.IDAOTemplate;

/**
 * @author sai
 *
 */
public interface IRelationShipDAO extends IDAOTemplate<RelationShip> {

	public boolean foundrelationship(String founderId,String linked_persionId,String typeName);
	
}
