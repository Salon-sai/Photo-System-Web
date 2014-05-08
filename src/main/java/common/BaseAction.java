/**
 * 
 */
package common;

import javax.persistence.MappedSuperclass;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@SuppressWarnings("rawtypes")
@MappedSuperclass
@ParentPackage("basePackage")
public class BaseAction<E,S extends IServiceTemplate> extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected S service;
	protected E entity;
	
	@SuppressWarnings("unchecked")
	public String add(){
		service.save(entity);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String delete(){
		service.delete(entity);
		return SUCCESS;
	}

	public S getService() {
		return service;
	}

	public void setService(S service) {
		this.service = service;
	}

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}
}
