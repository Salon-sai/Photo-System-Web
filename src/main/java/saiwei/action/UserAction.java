/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.User;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/user")
@Action("userAction")
public class UserAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
