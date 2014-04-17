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
	
	/**
	 * @param founderId
	 * 		user of committed relationship id
	 * @param linked_persionId
	 *		user of linked relationship id
	 * @param typeName
	 * 		relationship type
	 * 		
	 */
	public boolean addrelationship(String founderId,String linked_persionId,String typeName){
		return this.dao.foundrelationship(founderId, linked_persionId, typeName);
	}
	
	/**
	 * @param userId
	 * 		user id
	 * @return
	 * 		users of list by committing relationship type and your id.
	 */
	public List<User> findUserRelationShip(String userId,String relationshipType){
		return this.dao.findUserRelationship(userId, relationshipType);
	}
	
	/**
	 * 	@param userId
	 * 		user id
	 * 	@param relationshipType
	 * 		relationship type name
	 * 	@return
	 * 		posts of list by your committing relationship type and your id.
	 */
	public List<Post> findPostByRelationship(String userId,String relationshipType){
		return this.dao.findPostByRelathiship(userId, relationshipType);
	}
}
