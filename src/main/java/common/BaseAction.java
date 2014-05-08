/**
 * 
 */
package common;

import javax.persistence.MappedSuperclass;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@MappedSuperclass
@ParentPackage("basePackage")
public class BaseAction<E> extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected IServiceTemplate<IDAOTemplate<E>, E> service;
	protected E entity;
	
	public String add(){
		service.save(entity);
		return SUCCESS;
	}
	
	public String delete(){
		service.delete(entity);
		return SUCCESS;
	}

	public IServiceTemplate<IDAOTemplate<E>, E> getService() {
		return service;
	}

	@Autowired
	public void setService(IServiceTemplate<IDAOTemplate<E>, E> service) {
		this.service = service;
	}
}
