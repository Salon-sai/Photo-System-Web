package common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IServiceTemplate<D extends IDAOTemplate<E>,E>{
	
	public D getDao() ;
	
	public void setDao(D dao) ;
	
	public void save(E e) ;
	
	public void delete(java.io.Serializable id,Class<?> className) ;
	
	public void delete(E e);
	
	public E get(Serializable id,Class<?> className) ;
	
	public void update(E e) ;
	
	public E findByName(String name,Class<?> classType) ;

	public List<?> findByProperties(String[] names,Object[] values,String Entity) ;
	
	public List<?> findByPropertiesInHql(Map<String,Object> params,String classType);
}
