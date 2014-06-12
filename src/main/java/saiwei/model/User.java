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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name="IdNumber",nullable=false,unique=true)
	private String IdNumber;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="profile_pk")
	private Profile profile;
	
	@ManyToOne
	@JoinColumn(name="theme_id")
	private Theme theme;
	
	@OneToMany(mappedBy="founder")
	private Set<RelationShip> found_relationship;
	
	@OneToMany(mappedBy="linked_person")
	private Set<RelationShip> linked_relationship;
	
	@ManyToMany(
			targetEntity=saiwei.model.Tag.class,
			cascade={CascadeType.PERSIST,CascadeType.MERGE}
	)
	@JoinTable(
			name="tags_users",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="tag_id")
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
	
	@OneToMany(mappedBy="poster")
	private Set<Post> own_posts;
	
	@OneToMany(mappedBy="poster")
	private Set<Comment> send_comments;
	
	@OneToMany(mappedBy="recipients")
	private Set<Comment> receive_comments;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private UserType userType;
	
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
	public Set<RelationShip> getFound_relationship() {
		return found_relationship;
	}
	public void setFound_relationship(Set<RelationShip> found_relationship) {
		this.found_relationship = found_relationship;
	}
	public Set<RelationShip> getLinked_relationship() {
		return linked_relationship;
	}
	public void setLinked_relationship(Set<RelationShip> linked_relationship) {
		this.linked_relationship = linked_relationship;
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
	public Set<Comment> getSend_comments() {
		return send_comments;
	}
	public void setSend_comments(Set<Comment> send_comments) {
		this.send_comments = send_comments;
	}
	public Set<Comment> getReceive_comments() {
		return receive_comments;
	}
	public void setReceive_comments(Set<Comment> receive_comments) {
		this.receive_comments = receive_comments;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
