/**
 * 
 */
package saiwei.action.function;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.model.User;
import saiwei.service.IPostService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@Namespace("basePackage")
public class OpearePostAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String postId;
	
	private IPostService postService;
	private Map<String, Object> sessions;
	
	@Action(value="addFavorite",results={
			@Result(type="json",name="success",
					params={"excludeNullProperties","ture"}),
			@Result(type="json",name="input",
					params={"excludeNullProperties","ture"})
	})
	public String addToFavorite(){
		User user = (User)sessions.get("user");
		if(postService.saveLikePost(user.getIdNumber(), postId)){
			return SUCCESS;
		}
		return INPUT;
	}
	
	/**
	 *  
	 * getter and setter
	 */
	public Map<String, Object> getSessions() {
		return sessions;
	}
	public void setSessions(Map<String, Object> sessions) {
		this.sessions = sessions;
	}
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
}
