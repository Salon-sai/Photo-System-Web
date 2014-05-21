/**
 * 
 */
package saiwei.action.function;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import saiwei.model.Post;
import saiwei.model.User;
import saiwei.service.IRelationShipService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
public class GetPostListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session ;
	private List<Post> posts;
	private String errorMessage;
	
	private IRelationShipService relationshipService;
	
	@Action(value="")
	public String followingPost(){
		User user = (User)session.get("user");
		posts = relationshipService.findPostByRelationship(user.getId(), "following");
		return SUCCESS;
	}
	
	/**
	 * 
	 * getter and setter
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setRelationshipService(IRelationShipService relationshipService) {
		this.relationshipService = relationshipService;
	}
}
