/**
 * 
 */
package saiwei.action.function;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import saiwei.model.User;
import saiwei.service.IPostService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@Namespace("basePackage")
public class OpearePostAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String postId;
	
	private IPostService postService;
	private Map<String, Object> session;
	private String errorMessage;
	
	@Action(value="addFavorite",results={
			@Result(type="json",name=SUCCESS,
					params={"excludeNullProperties","ture"}),
			@Result(type="json",name=INPUT,
					params={"excludeNullProperties","ture"})
	})
	public String addToFavorite(){
		User user = (User)session.get("user");
		if(postService.saveLikePost(user.getIdNumber(), postId)){
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="removeFavoritePost",results={
			@Result(name=SUCCESS,type="json",
					params={"excludeNullProperties","ture"}),
			@Result(name=INPUT,type="json",
					params={"excludeNullProperties","ture"})
	})
	public String removeFavoritePost(){
		User user = (User)session.get("user");
		if(postService.deleteLikePost(user.getIdNumber(), postId)){
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="collectPost",results={
			@Result(name=SUCCESS,type="json",
					params={"excludeNullProperties","ture"}),
			@Result(name=INPUT,type="json",
					params={"excludeNullProperties","ture"})
	})
	public String collectPost(){
		User user = (User)session.get("user");
		if(postService.saveCollectPost(user.getIdNumber(), postId)){
			return SUCCESS;
		}
		return INPUT;
	}
	
	/**
	 *  
	 * getter and setter
	 */
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
