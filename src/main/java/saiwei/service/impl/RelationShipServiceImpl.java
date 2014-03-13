/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.RelationShip;
import saiwei.service.IRelationShipService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("relationshipService")
public class RelationShipServiceImpl extends
		AbstractTemplateService<IRelationShipDAO, RelationShip> implements
		IRelationShipService {
	
	@Resource(name="relationshipDAO")
	@Override
	public void setDao(IRelationShipDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
}
