package common;

import java.util.List;
import java.util.Map;

public interface IDAOTemplate<E> {
	
	public void save(E transientInstance) ;

	public void delete(E persistentInstance) ;
	
	public void attachDirty(E instance) ;
	
	public E findById(java.io.Serializable id,Class<?> classType) ;
	
	public E merge(E detachedInstance) ;
	
	public Object mergeAny(Object detachedInstance);

	public void attachClean(E instance) ;
	
	public void saveOrUpdate(E e);
	
//	public List<?> findAll(Class<?> classType);
	
	public E load(Class<?> entityClass, java.io.Serializable id) ;
	
	public List<E> findBySqlProperties(String[] paramNames, String Entity,Object[] values) ;

	public List<?> findNullProperties(String[] properties,Class<?> classType) ;
	
	public List<?> findNullProperties(Class<?> classType,String... propertyNames) ;
	
	public List<?> findNotNullProperties(Class<?> classType,String... propertyNames) ;
	
	public List<?> findNotNullProperties(String[] properties,Class<?> classType) ;
	
	public List<?> findExcludeProperties(String[] propertyNames,Object[][] values,Class<?> classType) ;

	public List<?> findByPropertiesInCriteria(Map<String,Object> params,Class<?> classType);
	
	public List<?> findByPropertiesInHql(Map<String,Object> params,String classType);
	
	public void lock(E e);
	
	public List<?> EntityLikeBy(Map<String, Object> params,Class<?> classType);
}
