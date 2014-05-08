/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Manager;
import saiwei.service.IManagerService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/manager")
@Action("managerAction")
public class ManagerAction extends BaseAction<Manager,IManagerService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
