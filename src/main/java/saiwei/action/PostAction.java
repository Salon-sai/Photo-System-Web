/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Post;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/post")
@Action("postAction")
public class PostAction extends BaseAction<Post> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
