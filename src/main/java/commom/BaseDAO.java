/**
 * 
 */
package commom;

import java.io.Serializable;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sai
 *
 */
@MappedSuperclass
public abstract class BaseDAO<E> implements IDAOTemplate<E> {

	private static final Logger logger = Logger.getLogger(BaseDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

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
	 */
	@Override
	public void attachDirty(E instance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findById(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> E findById(java.io.Serializable id,Class<T> className) {
		// TODO Auto-generated method stub
		return (E) sessionFactory.getCurrentSession().get(className, id);
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

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#attachClean(java.lang.Object)
	 */
	@Override
	public void attachClean(E instance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findByExample(java.lang.Object)
	 */
	@Override
	public List<?> findByExample(E instance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findAll()
	 */
	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#findByProperties(java.lang.String[], java.lang.Object[], java.lang.Class)
	 */
	@Override
	public List<?> findByProperties(String[] names, Object[] objects,
			Class<?> ClassType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see commom.IDAOTemplate#load(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public E load(Class<?> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * getter and setter
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
