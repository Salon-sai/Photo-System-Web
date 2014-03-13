/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("relationshipDAO")
public class RelationShipDAOImpl extends BaseDAO<RelationShip> implements
		IRelationShipDAO {

}
