/**
 * 
 */
package saiwei.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import saiwei.dao.IRelationShipDAO;
import saiwei.model.Post;
import saiwei.model.RelationShip;
import saiwei.model.RelationShipType;
import saiwei.model.User;

import common.BaseDAO;
import common.factory.SortFatory;

/**
 * @author sai
 *
 */
@Repository("relationshipDAO")
public class RelationShipDAOImpl extends BaseDAO<RelationShip> implements
		IRelationShipDAO {
	
	private static final String queryString = "from User as model where model.IdNumber=:IdNumber";
	private static final String queryString1 = "from RelationShipType as model where model.name=:name";
	
	/**
	 * 
	 * @param founderId
	 * @param linked_persionId
	 * @param typeName
	 * @return
	 */
	public boolean foundrelationship(String founderId,String linked_persionId,String typeName){
		try{
			Session session = sessionFactory.getCurrentSession();
			RelationShip relationship = new RelationShip();
			
			User founder = (User)session.createQuery(queryString)
					.setParameter("IdNumber", founderId).uniqueResult();
			User linked_person = (User)session.createQuery(queryString)
					.setParameter("IdNumber", linked_persionId).uniqueResult();
			RelationShipType type = (RelationShipType)session.createQuery(queryString1)
					.setParameter("name", typeName).uniqueResult();
			
			relationship.setFounder(founder);
			relationship.setLinked_person(linked_person);
			relationship.setRelationship(type);
			
			session.save(relationship);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param userId
	 * @param typeName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserRelationship(Session session,String userId,String typeName){
		User user = (User)session.createQuery(queryString)
				.setParameter("IdNumber", userId).uniqueResult();
		RelationShipType type = (RelationShipType)session.createQuery(queryString1)
				.setParameter("name", typeName).uniqueResult();
		
		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("relationship", type);
		params.put("founder", user);
		
		List<RelationShip> relationships =	
				(List<RelationShip>)this.getQueryByPropertiesInHql(session, params, RELATIONSHIP)
				.setMaxResults(10).list();
		
		List<User> linked_people = new ArrayList<User>();
		for(RelationShip relationship : relationships){
			linked_people.add(relationship.getLinked_person());
		}
		return linked_people;
	}
	
	public List<User> findUserRelationship(String userId,String typeName){
		return this.findUserRelationship(sessionFactory.getCurrentSession(), userId, typeName);
	}
	
	public List<Post> findPostByRelathiship(String userId,String typeName){
		Session session = sessionFactory.getCurrentSession();
		List<User> users = this.findUserRelationship(session, userId, typeName);
		List<Post> posts = new ArrayList<Post>();
		for(User user : users){
			Set<Post> userposts = user.getOwn_posts();
			int length = 10;
			Iterator<Post> iterator_posts = userposts.iterator();
			while(iterator_posts.hasNext() || length < 0){
				try {
					SortFatory.insertByDate(posts, iterator_posts.next(), "postdate");
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				posts.add(iterator_posts.next());
			}
		}
		return posts;
	}
	
}
