/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IRelationShipTypeDAO;
import saiwei.model.RelationShipType;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("relationshipTypeDAO")
public class RelationShipTypeDAOImpl extends BaseDAO<RelationShipType>
		implements IRelationShipTypeDAO {
	
}
