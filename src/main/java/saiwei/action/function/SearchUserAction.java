/**
 * 
 */
package saiwei.action.function;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import saiwei.bean.UserBean;
import saiwei.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/search")
public class SearchUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userKey;
	private List<UserBean> beans;
	private IUserService userService;

	@Action(value="searchUser",results={
		@Result(name=SUCCESS,type="json"),
		@Result(name=INPUT,type="json")
	})
	public String searchUser(){
		beans = userService.searchUser(userKey);
		return SUCCESS;
	}
	
	
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<UserBean> getBeans() {
		return beans;
	}
}
