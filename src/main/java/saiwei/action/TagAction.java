/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Tag;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/tag")
@Action("tagAction")
public class TagAction extends BaseAction<Tag> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
