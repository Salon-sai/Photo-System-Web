package commom;

import java.io.Serializable;
import java.util.List;

public interface IServiceTemplate<D extends IDAOTemplate<E>,E>{
	
	public D getDao() ;
	
	public void setDao(D dao) ;
	
	public void save(E e) ;
	
	public void delete(java.io.Serializable id,Class<?> className) ;
	
	public void delete(E e);
	
	public E get(Serializable id,Class<?> className) ;
	
	public void update(E e) ;
	
	public E findByName(String name) ;
	
	public List<?> findByProperty(String propertyName,Object value,Class<?> classType);
	
	public List<?> findByProperties(String[] names,Object[] values,String Entity) ;
}
