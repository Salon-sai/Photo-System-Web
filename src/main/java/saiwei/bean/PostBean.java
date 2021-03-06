/**
 * 
 */
package saiwei.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import saiwei.model.Photo;
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
	private String poster_headphotoId;
	// key is userId , value is user name
	private Map<String,Object> favoriter;
	private List<String> photo_id;
	
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
		
		photo_id = new ArrayList<String>();
		for(Photo photo : post.getPhotos()){
			photo_id.add(photo.getId());
		}
		
		this.poster_headphotoId = post.getPoster().getProfile().getHead_photo().getId();
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
	public List<String> getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(List<String> photo_id) {
		this.photo_id = photo_id;
	}
	public String getPoster_headphotoId() {
		return poster_headphotoId;
	}
	public void setPoster_headphotoId(String poster_headphotoId) {
		this.poster_headphotoId = poster_headphotoId;
	}
}
