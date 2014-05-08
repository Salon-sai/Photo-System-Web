/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Comment;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/comment")
@Action("commentAction")
public class CommentAction extends BaseAction<Comment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
