/**
 * 
 */
package saiwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.Post;
import saiwei.model.RelationShip;
import saiwei.model.User;
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
	
	public boolean addrelationship(String founderId,String linked_persionId,String typeName){
		return this.dao.foundrelationship(founderId, linked_persionId, typeName);
	}
	
	public List<User> findUserRelationShip(String userId,String relationshipType){
		return this.dao.findUserRelationship(userId, relationshipType);
	}
	
	public List<Post> findPostByRelationship(String userId,String relationshipType){
		return this.dao.findPostByRelathiship(userId, relationshipType);
	}
}
