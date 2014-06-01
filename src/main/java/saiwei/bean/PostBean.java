/**
 * 
 */
package saiwei.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import saiwei.model.Post;
import saiwei.model.User;

/**
 * @author sai
 *
 */
public class PostBean extends Post {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String posterName;
	private String posterNumber;
	// key is userId , value is user name
	private Map<String,Object> favoriter;
	
	/**
	 * 
	 */
	public PostBean() {
		
	}
	
	/**
	 * 
	 * @param post
	 */
	public PostBean(Post post){
		this.id = post.getId();
		this.content = post.getContent();
		this.postdate = post.getPostdate();
		
		this.favoriter = new HashMap<String, Object>();
		Set<User> favorite = post.getFavorite();
		for(User user : favorite){
			favoriter.put(user.getId(), user.getName());
		}
		this.posterName = post.getPoster().getName();
		this.posterNumber = post.getPoster().getId();
	}
	
	/**
	 * 
	 * getter and setter
	 */
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	public String getPosterNumber() {
		return posterNumber;
	}
	public void setPosterNumber(String posterNumber) {
		this.posterNumber = posterNumber;
	}
	public Map<String, Object> getFavoriter() {
		return favoriter;
	}
	public void setFavoriter(Map<String, Object> favoriter) {
		this.favoriter = favoriter;
	}	
}