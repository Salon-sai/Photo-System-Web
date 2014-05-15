/**
 * 
 */
package common;

import java.util.Map;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@SuppressWarnings("rawtypes")
@MappedSuperclass
@ParentPackage("basePackage")
public class BaseAction<E,S extends IServiceTemplate> extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final Logger logger = Logger.getLogger(BaseAction.class);
	
	protected S service;
	protected E entity;
	protected Map<String, Object> session;
	
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

	/**
	 * 
	 * getter and setter
	 */
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
