/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Title;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/title")
@Action("titleAction")
public class TitleAction extends BaseAction<Title> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
