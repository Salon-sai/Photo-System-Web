/**
 * 
 */
package saiwei.dao;

import java.util.List;

import org.hibernate.Session;

import saiwei.model.Post;
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
	
	public List<User> findUserRelationship(Session session,String userId,String typeName);
	
	public List<Post> findPostByRelathiship(String userId,String typeName);
	
	public boolean deleteRelationshipByUser(User operator,String linker_IDNumber);
}
