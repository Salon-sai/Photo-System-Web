/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="comment",catalog="photosystem")
public class Comment extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="poster_id")
	private User poster;
	
	@ManyToOne
	@JoinColumn(name="recipients_id")
	private User recipients;
	
	@Column(name="content")
	private String content;

	/**
	 * getter and setter
	 */
	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public User getRecipients() {
		return recipients;
	}

	public void setRecipients(User recipients) {
		this.recipients = recipients;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
