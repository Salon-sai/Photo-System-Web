/**
 * 
 */
package saiwei.model;

import java.util.Set;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class Post extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String content;
	
	private User poster;
	
	private Set<Comment> comments;

	private Set<User> favorite;
	
	/**
	 * getter and setter
	 */
	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<User> getFavorite() {
		return favorite;
	}

	public void setFavorite(Set<User> favorite) {
		this.favorite = favorite;
	}
}
