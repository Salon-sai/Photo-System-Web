/**
 * 
 */
package saiwei.action.function;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import saiwei.bean.CommentBean;
import saiwei.model.Post;
import saiwei.service.IPostService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
public class GetPostInfomationAction extends ActionSupport implements
		SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(GetPostInfomationAction.class);

	private Map<String,Object> session;
	
	private String postId;
	private Post post;
	private Set<CommentBean> comments;
	
	private IPostService postService;
	
	@Action(value="getcomments",results={
			@Result(name=SUCCESS,type="json",
					params={"excludeNullProperties","ture"}),
			@Result(name=INPUT,type="json",
					params={"excludeNullProperties","ture"}),
	})
	public String getcommentsInPost(){
		try{
			comments = postService.getCommentsByPost(postId);
		}catch(Exception e){
			logger.error("cant get the comment", e);
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * getter and setter
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Post getPost() {
		return post;
	}
	public Set<CommentBean> getComments() {
		return comments;
	}
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
}
