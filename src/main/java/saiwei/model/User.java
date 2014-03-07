/**
 * 
 */
package saiwei.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	private Profile profile;
	
	private RelationShip relationship_net;
	
	private Set<Tag> tags;
	
	private Set<Post> like_posts;
	
	private Set<Post> collect_posts;
	
	private Set<Post> own_posts;
	
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

	public RelationShip getRelationship_net() {
		return relationship_net;
	}

	public void setRelationship_net(RelationShip relationship_net) {
		this.relationship_net = relationship_net;
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

	public Set<Post> getLike_posts() {
		return like_posts;
	}

	public void setLike_posts(Set<Post> like_posts) {
		this.like_posts = like_posts;
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
