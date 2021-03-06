/**
 * 
 */
package common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import common.factory.StringFactory;

import saiwei.model.ModelClassType;

/**
 * @author sai
 *
 */
@MappedSuperclass
public abstract class BaseDAO<E> extends ModelClassType implements IDAOTemplate<E> {

	protected static final Logger logger = Logger.getLogger(BaseDAO.class);
	protected static final String FROMMODEL = "from ";
	protected static final String HQLMODEL = " as model ";
	protected static final String WHEREMODEL = " where ";
	
	
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#save(java.lang.Object)
	 */
	@Override
	public void save(E transientInstance) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transientInstance);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#delete(java.lang.Object)
	 */
	@Override
	public void delete(E persistentInstance) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(persistentInstance);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#attachDirty(java.lang.Object)
	 *  
	 * 将传入的对象持久化并保存。 
	 * 如果对象未保存（Transient状态），调用save方法保存。如果对象已保存
	 * （Detached状态），调用update方法将对象与Session重新关联。 
	 */
	@Override
	public void attachDirty(E instance) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(instance);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findById(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E findById(java.io.Serializable id,Class<?> classType) {
		// TODO Auto-generated method stub
		return (E) sessionFactory.getCurrentSession().get(classType, id);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#merge(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E merge(E detachedInstance) {
		// TODO Auto-generated method stub
		return (E) sessionFactory.getCurrentSession().merge(detachedInstance);
	}
	
	public Object mergeAny(Object detachedInstance){
		return sessionFactory.getCurrentSession().merge(detachedInstance);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#attachClean(java.lang.Object)
	 * 将传入的对象状态设置为Transient状态 
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void attachClean(E instance) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
	}

	public List<?> findAll(Class<?> classType){
		List<?> list = null;
		try{
			list = (List<?>) sessionFactory.getCurrentSession().createQuery("from "+classType.toString());
			logger.info("find all " + classType);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return list;
	}
	
	public List<?> findByPropertiesInHql(Map<String,Object> params,String classType){
		return findByPropertiesInHql(sessionFactory.getCurrentSession(), params, classType);
	}
	
	/**
	 * 
	 * @param session
	 * @param params
	 * @param classType
	 * @return
	 */
	public List<?> findByPropertiesInHql(Session session,Map<String,Object> params,String classType){
		return this.getQueryByPropertiesInHql(session, params, classType).list();
	}
	
	public Query getQueryByPropertiesInHql(Session session,Map<String,Object> params,String classType){
		Query query = null;
		String queryString = "from " + classType + " as model where ";
		try{
			for(String key : params.keySet()){
				queryString += "model." + key + "=:" + key + " and ";
			}
			queryString = queryString.substring(0, queryString.lastIndexOf("and "));
			query = session.createQuery(queryString).setProperties(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return query;
	}
	
	public List<?> findByPropertiesInCriteria(Map<String,Object> params,Class<?> classType){
		return findByPropertiesInCriteria(sessionFactory.getCurrentSession(),params,classType);
	}
	
	/**
		dao.
	 * 
	 * @param session
	 * @param params
	 * @param classType
	 * @return
	 */
	public List<?> findByPropertiesInCriteria(Session session,Map<String,Object> params,Class<?> classType){
		Criteria criteria = session.createCriteria(classType);
		List<?> list = null;
		try{
			if(params != null && !params.isEmpty()){
				for(String key : params.keySet()){
					criteria.add(Restrictions.eq(key, params.get(key)));
				}
				list = criteria.list();
			}
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param params
	 * @param classType
	 * @return
	 */
	public Object uniqueElement(Map<String,Object> params,String classType){
		return this.uniqueElement(sessionFactory.getCurrentSession(), params, classType);
	}
	
	/**
	 * 
	 * @param session
	 * @param params
	 * @param classType
	 * @return
	 */
	public Object uniqueElement(Session session,Map<String,Object> params,String classType){
		List<?> list  = this.findByPropertiesInHql(session, params, classType);
		int size = list.size();
		if(size == 0) return null;
		Object first = list.get(0);
		for(int i = 1;i < size; i++){
			if(list.get(i) != first){
				throw new NonUniqueResultException(size);
			}
		}
		return first;
	}
	
	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#load(java.lang.Class, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E load(Class<?> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (E)sessionFactory.getCurrentSession().load(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findBySqlProperties(java.lang.String[], java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<E> findBySqlProperties(String[] paramNames, String Entity,
			Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findNullProperties(java.lang.String[], java.lang.Class)
	 */
	@Override
	public List<?> findNullProperties(String[] properties, Class<?> classType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findNullProperties(java.lang.Class, java.lang.String[])
	 */
	@Override
	public List<?> findNullProperties(Class<?> classType,
			String... propertyNames) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findNotNullProperties(java.lang.Class, java.lang.String[])
	 */
	@Override
	public List<?> findNotNullProperties(Class<?> classType,
			String... propertyNames) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findNotNullProperties(java.lang.String[], java.lang.Class)
	 */
	@Override
	public List<?> findNotNullProperties(String[] properties, Class<?> classType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findExcludeProperties(java.lang.String[], java.lang.Object[][], java.lang.Class)
	 */
	@Override
	public List<?> findExcludeProperties(String[] propertyNames,
			Object[][] values, Class<?> classType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void saveOrUpdate(E e){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(e);
	}
	
	/**
	 * lock 将游离对象转换为持久化对象 (未实现)
	 */
	@SuppressWarnings("deprecation")
	public void lock(E e){
		Session session = sessionFactory.getCurrentSession();
		session.lock(e, LockMode.OPTIMISTIC);
	}
	
	/**
	 * 
	 * @param params
	 * @param classType
	 * @return
	 */
	public List<?> EntityLikeBy(Map<String, Object> params,Class<?> classType){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(classType);
		List<?> list = null;
		if(!params.isEmpty() && params != null){
			for(String key : params.keySet()){
				criteria.add(Restrictions.like(key, 
						StringFactory.MergerString("%",(String)params.get(key),"%")));
			}
			list = criteria.list();
		}
		return list;
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
