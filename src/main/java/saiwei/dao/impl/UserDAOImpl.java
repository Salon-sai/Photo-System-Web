/**
 * 
 */
package saiwei.dao.impl;

import java.lang.reflect.Method;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import saiwei.dao.IUserDAO;
import saiwei.model.Profile;
import saiwei.model.User;

import common.BaseDAO;
import common.factory.StringFactory;

/**
 * @author sai
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {
	
	private static final Class<?> classType = User.class;
	
	public Profile updateProfileByUser(Map<String, Object> params,String IdNumber){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(classType);
		criteria.add(Restrictions.eq("IdNumber", IdNumber));
		User user = (User)criteria.list().get(0);
		Profile profile = user.getProfile();
		try{
			for(String key : params.keySet()){
				if(params.get(key) != null){
					String methodName = StringFactory.buildSetterName(key);
					Method setMethod = profile.getClass().getMethod(methodName, params.get(key).getClass());
					setMethod.invoke(profile, params.get(key));
				}
			}	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		session.saveOrUpdate(user);
		return profile;
	}
	
}
