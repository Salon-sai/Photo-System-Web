package saiwei.action.function;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import saiwei.model.User;
import saiwei.service.IUserService;

@Action(value="loginAction")
@Namespace("/")
public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private String idNum;
	private String password;
	
	@Action(value="checklogin",
			results={@Result(type="json",name=SUCCESS,
			params={"excludeNullProperties","ture","defaultEncoding","UTF-8"}),
			@Result(type="json",name=INPUT,
			params={"excludeNullProperties","ture","defaultEncoding","UTF-8"})}
	)
	public String checkLogin(){
		User user = userService.login(idNum, password);
		if(user == null)
			return INPUT;
		return SUCCESS;
	}
	
	public String login(){
		return SUCCESS;
	}
	
	/**
	 * getter and setter
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
