/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.model.User;
import saiwei.service.IUserService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/user")
@Action("userAction")
public class UserAction extends BaseAction<User,IUserService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Action(value="loginUser",
			results={@Result(name="success",location="/user/home.jsp")})
	public String login(){
		user = (User)session.get("user");
		logger.info(user.getName());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
