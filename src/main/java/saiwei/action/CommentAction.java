/**
 * 
 */
package saiwei.action;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.bean.CommentBean;
import saiwei.model.Comment;
import saiwei.model.User;
import saiwei.service.ICommentService;
import saiwei.service.IPostService;

import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/comment")
public class CommentAction extends 
	BaseAction<Comment,ICommentService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String posterId;
	private String commentId;
	private String content;
	private String recipientId;
	private String postId;
	private Comment comment;
	private Set<CommentBean> comments;
	
	private IPostService postService;
	
	@Override
	@Action(value="saveComment",
		results={@Result(type="json",name="success",
			params={"excludeNullProperties","ture"}),
				@Result(type="json",name="input",
			params={"excludeNullProperties","ture"})
	})
	public String add() {
		// TODO Auto-generated method stub
		User poster = (User)session.get("user");
		comment = service.save(content, poster.getIdNumber(), recipientId, postId,commentId);
		if(entity == null){
			return INPUT;
		}
		return SUCCESS;
	}
	
	@Action(value="deteleComment",
			results={@Result(type="json",name="success",
			params={"excludeNullProperties","ture"}),
				@Result(type="json",name="input",
			params={"excludeNullProperties","ture"})
	})
	public String detele(){
		try{
			service.delete(commentId, Comment.class);
		}catch(Exception e){
			logger.error("comment action delete", e);
		}
		return SUCCESS;
	}
	
	@Action(value="getComments",results={
			@Result(name=SUCCESS,location="/user/comment.jsp"),
			@Result(name=INPUT,location="/user/comment.jsp")
	})
	public String getCommentsByPost(){
		comments = postService.getCommentsByPost(postId);
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
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Set<CommentBean> getComments() {
		return comments;
	}
	@Resource(name="postService")
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
}
