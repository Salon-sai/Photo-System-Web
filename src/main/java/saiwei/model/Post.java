/**
 * 
 */
package saiwei.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="post",catalog="photosystem")
public class Post extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="content")
	protected String content;
	
	@ManyToOne
	@JoinColumn(name="poster_id")
	private User poster;
	
	@Column(name="postdate",nullable=false)
	@OrderBy("asc")
	protected Date postdate;
	
	@OneToMany(mappedBy="post")
	private Set<Comment> comments;

	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private Set<Photo> photos;
	
	@ManyToMany(
			cascade={CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy="favorite_posts",
			targetEntity=saiwei.model.User.class
	)
	private Set<User> favorite;
	
	@ManyToMany(
			cascade={CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy="collect_posts",
			targetEntity=saiwei.model.User.class
	)
	private Set<User> collecters;
	
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

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public Set<User> getCollecters() {
		return collecters;
	}

	public void setCollecters(Set<User> collecters) {
		this.collecters = collecters;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
}
