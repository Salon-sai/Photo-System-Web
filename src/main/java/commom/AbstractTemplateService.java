package commom;

import java.io.Serializable;
import java.util.List;

/**
 * @author sai
 *
 */
public abstract class AbstractTemplateService<D extends IDAOTemplate<E>,E>{
	
	protected D dao = null ;

	public D getDao() {
		return dao;
	}
	
	public void save(E e) {
		dao.save(e) ;
	}
	
	public void delete(java.io.Serializable id,Class<?> className) {
		dao.delete(get(id,className)) ;
	}
	
	
	public void delete(E e){
		dao.delete(e) ;
	}
	
	public E get(Serializable id,Class<?> className) {
		// TODO Auto-generated method stub
		return dao.findById(id,className) ;
	}
	
	public void update(E e) {
		dao.merge(e) ;
	}
	
	@SuppressWarnings("unchecked")
	public E findByName(String name,Class<?> classType){
		List<?> list = dao.findByProperty("name", name,classType);
		if(list.isEmpty()){
			return null ;
		}
		return (E) list.get(0) ;
	}
	
	public List<?> findByProperty(String propertyName,Object value,Class<?> classType){
		return dao.findByProperty(propertyName, value,classType) ;
	}
	
	public List<?> findByProperties(String[] names,Object[] values,String Entity){
		return dao.findBySqlProperties(names, Entity, values) ;
	}

}
