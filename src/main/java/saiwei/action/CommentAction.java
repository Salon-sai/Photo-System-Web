/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Comment;
import saiwei.service.ICommentService;

import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/comment")
@Action("commentAction")
public class CommentAction extends 
	BaseAction<Comment,ICommentService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
