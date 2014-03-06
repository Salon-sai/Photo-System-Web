package commom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		List<?> list = dao.findByPropertiesInCriteria(params ,classType);
		if(list.isEmpty()){
			return null ;
		}
		return (E) list.get(0) ;
	}
	
	public List<?> findByProperties(String[] names,Object[] values,String Entity){
		return dao.findBySqlProperties(names, Entity, values) ;
	}
	
	public List<?> findByProperties(Map<String, Object> params,
			Class<?> classType){
		return dao.findByPropertiesInCriteria(params, classType);
	}

}
