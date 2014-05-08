/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Profile;
import saiwei.service.IProfileService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/profile")
@Action("profileAction")
public class ProfileAction extends BaseAction<Profile,IProfileService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
