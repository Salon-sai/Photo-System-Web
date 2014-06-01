/**
 * 
 */
package saiwei.action.function;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import saiwei.model.User;
import saiwei.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/user")
public class HomeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	private Map<String,Object> session;
	
	@Action(value="*home",
			results={@Result(name=SUCCESS),@Result(name=INPUT)})
	public String homePost(){
		User user = (User)session.get("user");
		userService.getOwnPosts(user);
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
