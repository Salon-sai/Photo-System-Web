package saiwei.action.function;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import saiwei.model.User;
import saiwei.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("basePackage")
@Action(value="loginAction")
@Namespace("/login")
public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
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
		user = userService.login(idNum, password);
		if(user == null)
			return INPUT;
		return SUCCESS;
	}
	
	@Action(value="login",
			results={@Result(name="success",location="/WEB-INF/user/home.jsp")})
	public String login(){
		return SUCCESS;
	}
	
	/**
	 * getter and setter
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
