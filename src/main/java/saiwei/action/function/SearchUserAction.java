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

import saiwei.bean.UserBean;
import saiwei.model.User;
import saiwei.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/search")
public class SearchUserAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userKey;
	private List<UserBean> userbeans;
	private IUserService userService;
	private Map<String, Object> session;

	@Action(value="searchUser",results={
		@Result(name=SUCCESS,location="/user/search.jsp"),
		@Result(name=INPUT,location="/")
	})
	public String searchUser(){
		User user = (User)session.get("user");
		userbeans = userService.searchUser(userKey,user);
		return SUCCESS;
	}
	
	
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<UserBean> getUserbeans() {
		return userbeans;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
