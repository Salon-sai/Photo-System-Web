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
	private String userId;
	private List<PostBean> posts;
	
	@Action(value="*home",params={"userId","{1}"},
			results={
			@Result(name=SUCCESS,type=""),
			@Result(name=INPUT,type="")})
	public String otherhomePost(){
		posts = userService.getOwnPosts(userId);
		return SUCCESS;
	}
	
	@Action(value="home",
			results={
			@Result(name=SUCCESS,type=""),
			@Result(name=INPUT,type="")})
	public String homePost(){
		User user = (User)session.get("user");
		posts = userService.getOwnPosts(user);
		return SUCCESS;
	}

	/**
	 * getter and setter
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<PostBean> getPosts() {
		return posts;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
