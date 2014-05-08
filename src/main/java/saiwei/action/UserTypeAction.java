/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.UserType;

import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/usertype")
@Action("userTypeAction")
public class UserTypeAction extends BaseAction<UserType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
