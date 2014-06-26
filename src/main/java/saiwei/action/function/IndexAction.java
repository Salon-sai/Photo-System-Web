/**
 * 
 */
package saiwei.action.function;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import saiwei.bean.PostBean;
import saiwei.model.User;
import saiwei.service.IRelationShipService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/user")
public class IndexAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PostBean> postBeans;
	private IRelationShipService relationshipService;
	private Map<String, Object> session;
	
	@Action(value="index",results={
			@Result(name=SUCCESS,location="/user/home.jsp")
	})
	public String index(){
		User user = (User)session.get("user");
		postBeans = relationshipService.getPostbyRelationship(user.getIdNumber(), "following");
		return SUCCESS;
	}
	
	public List<PostBean> getPostBeans() {
		return postBeans;
	}
	public void setRelationshipService(IRelationShipService relationshipService) {
		this.relationshipService = relationshipService;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
