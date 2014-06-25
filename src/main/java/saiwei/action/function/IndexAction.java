/**
 * 
 */
package saiwei.action.function;

import java.util.List;

import saiwei.bean.PostBean;
import saiwei.service.IRelationShipService;
import saiwei.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PostBean> postBeans;
	private IUserService userService;
	private IRelationShipService relationshipService;
	
	public String index(){
		return null;
	}
	
	public List<PostBean> getPostBeans() {
		return postBeans;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setRelationshipService(IRelationShipService relationshipService) {
		this.relationshipService = relationshipService;
	}
}
