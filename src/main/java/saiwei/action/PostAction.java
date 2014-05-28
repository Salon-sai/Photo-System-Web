/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Post;
import saiwei.service.IPostService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/post")
@Action("postAction")
public class PostAction extends BaseAction<Post,IPostService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
