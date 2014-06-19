/**
 * 
 */
package saiwei.action.function;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

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

	private String userNum;
	private IUserService userService;

	public String searchUser(){
//		List<?> users = 
		return null;
	}
	
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
