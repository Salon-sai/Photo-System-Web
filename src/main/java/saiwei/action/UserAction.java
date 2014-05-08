/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

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

}
