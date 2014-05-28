/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import saiwei.model.User;
import saiwei.service.IUserService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/user")
@Action(value="userAction",results={
		@Result(name="success",type="json",
				params={"excludeNullProperties","ture"}),
		@Result(name="input",type="json",
				params={"excludeNullProperties","ture"})
})
public class UserAction extends BaseAction<User,IUserService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String registerNumberId;
	private String registerName;
	private String registerPassword;
	
	private User user;

	public String register(){
		User user = new User();
		user.setIdNumber(registerNumberId);
		user.setIdNumber(registerName);
		user.setPassword(registerPassword);
		service.save(user);
		return SUCCESS;
	}
	
	/**
	 * 
	 * getter and setter
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@RequiredStringValidator(key="registerName.requried")
	@RegexFieldValidator(key="registerName.regex",
		regexExpression="\\w{7,25}",message="the length of name should be bewteen 7 and 25")
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	
	@RequiredStringValidator(key="registerPassword.requried")
	@RegexFieldValidator(key="registerPassword.regex",
		regexExpression="\\w{7,25}",message="the length of password should be bewteen 7 and 25")
	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	@RequiredStringValidator(key="registerNumberId.requried")
	@RegexFieldValidator(key="registerNumberId.regex",
		regexExpression="\\w{7,25}",message="the length of ID should be bewteen 7 and 25")
	public void setRegisterNumberId(String registerNumberId) {
		this.registerNumberId = registerNumberId;
	}
}
