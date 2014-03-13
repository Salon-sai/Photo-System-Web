/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IRelationShipTypeDAO;
import saiwei.model.RelationShipType;
import saiwei.service.IRelationShipTypeService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("relationshipTypeService")
public class RelationShipTypeServiceImpl extends
		AbstractTemplateService<IRelationShipTypeDAO, RelationShipType>
		implements IRelationShipTypeService {
	
	@Override
	@Resource(name="relationshipTypeDAO")
	public void setDao(IRelationShipTypeDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
