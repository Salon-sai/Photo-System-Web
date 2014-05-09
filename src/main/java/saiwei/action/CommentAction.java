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

	private String posterId;
	private String content;
	private String recipientId;
	private String postId;
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		entity = service.save(content, posterId, recipientId, postId);
		if(entity == null){
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPosterId() {
		return posterId;
	}
	public void setPosterId(String posterId) {
		this.posterId = posterId;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
}
