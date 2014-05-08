/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Manager;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/manager")
@Action("managerAction")
public class ManagerAction extends BaseAction<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
