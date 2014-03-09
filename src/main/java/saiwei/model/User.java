/**
 * 
 */
package saiwei.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import common.BaseModelHasName;
import common.factory.MD5Factory;

/**
 * @author sai
 *
 */
@Entity
@Table(name="user",catalog="photosystem")
public class User extends BaseModelHasName {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Profile profile;
	
	@OneToMany
	private Set<RelationShip> relationship_links;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
			name="tag_user",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="tag")
	)
	private Set<Tag> tags;
	
	@ManyToMany(
			targetEntity=saiwei.model.Post.class,
			cascade={CascadeType.PERSIST,CascadeType.MERGE}
	)
	@JoinTable(
			name="users_favoritePosts",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="post_id")
	)
	private Set<Post> favorite_posts;
	
	@ManyToMany(
			targetEntity=saiwei.model.Post.class,
			cascade={CascadeType.PERSIST,CascadeType.MERGE}
	)
	@JoinTable(
			name="users_collectPosts",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="post_id")
	)
	private Set<Post> collect_posts;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
			name="own_posts",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="post_id")
	)
	private Set<Post> own_posts;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
			name="user_comments",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="comment_id")
	)
	private Set<Comment> comments;
	
	/**
	 * getter and setter
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	//change to MD5
	public void setPassword(String password) {
		this.password = MD5Factory.getMD5(password.getBytes());
	}

	public Set<RelationShip> getRelationship_links() {
		return relationship_links;
	}

	public void setRelationship_links(Set<RelationShip> relationship_links) {
		this.relationship_links = relationship_links;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Post> getFavorite_posts() {
		return favorite_posts;
	}

	public void setFavorite_posts(Set<Post> favorite_posts) {
		this.favorite_posts = favorite_posts;
	}

	public Set<Post> getCollect_posts() {
		return collect_posts;
	}

	public void setCollect_posts(Set<Post> collect_posts) {
		this.collect_posts = collect_posts;
	}

	public Set<Post> getOwn_posts() {
		return own_posts;
	}

	public void setOwn_posts(Set<Post> own_posts) {
		this.own_posts = own_posts;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}
