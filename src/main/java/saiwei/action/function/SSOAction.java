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


@ParentPackage("basePackage")
@Namespace("/sso")
public class SSOAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
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
		session.put("user", user);
		if(user == null)
			return INPUT;
		return SUCCESS;
	}

	@Action(value="loginUser",
			results={
			@Result(name="success",type="redirect",location="/user/home.jsp"),
			@Result(name="input",type="redirect",location="/")})
	public String login(){
		user = (User)session.get("user");
		return user == null ? INPUT : SUCCESS;
	}
	
	@Action(value="logout",
			results={
			@Result(name=SUCCESS,type="redirect",location="/")
	})
	public String logout(){
		session.remove("user");
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
