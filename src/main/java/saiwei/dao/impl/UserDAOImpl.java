/**
 * 
 */
package saiwei.dao.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import saiwei.dao.IUserDAO;
import saiwei.model.Profile;
import saiwei.model.RelationShip;
import saiwei.model.RelationShipType;
import saiwei.model.User;

import common.BaseDAO;
import common.factory.StringFactory;

/**
 * @author sai
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {
	
	@SuppressWarnings("unused")
	private static final Class<?> classType = User.class;
	
	public Profile updateProfileByUser(Map<String, Object> params,User user){
		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(classType);
//		criteria.add(Restrictions.eq("IdNumber", IdNumber));
//		User user = (User)criteria.list().get(0);
		Profile profile = user.getProfile();
		if(profile.getHead_photo() != null && params.get("photo") != null){
			session.delete(profile.getHead_photo());
		}
		if(params.get("name") != null){
			user.setName((String)params.get("name"));
		}
		try{
			for(String key : params.keySet()){
				if(params.get(key) != null && params.get(key) != ""){
					String methodName = StringFactory.buildSetterName(key);
					Method setMethod = profile.getClass().getMethod(methodName, params.get(key).getClass());
					setMethod.invoke(profile, params.get(key));
				}
			}	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return profile;
	}
	
	public List<User> findfollowing(String IdNum){
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> findfollowingINCriteria(Session session,String userIdNum){
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("IdNum", userIdNum));
		User user = (User)criteria.uniqueResult();
		
		Criteria criteria2 = session.createCriteria(RelationShip.class);
		criteria2.add(Restrictions.eq("name", "following"));
		RelationShipType type = (RelationShipType)criteria2.uniqueResult();
		
		Criteria criteria3 = session.createCriteria(RelationShip.class);
		criteria3.add(Restrictions.eq("founder", user)).add(Restrictions.eq("relationship", type));
		List<RelationShip> relationships = criteria3.list();
		
		List<User> followings = new ArrayList<User>();
		
		for(RelationShip relationship : relationships){
			followings.add(relationship.getLinked_person());
		}
		return followings;
	}
	
	/**
	 * 
	 * @param session
	 * 		hibernate session create before execute this function
	 * @param IdNum
	 * 		Id number is one of identifications in user
	 * @return
	 */
	public static User findByIdNum(Session session,String IdNum){
		return (User)session.createQuery("from User as model where model.IdNumber=:IdNumber")
			.setParameter("IdNumber", IdNum).uniqueResult();
	}
	
}
