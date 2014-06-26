/**
 * 
 */
package saiwei.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="poster_id")
	private User poster;
	
	@Column(name="postDate")
	protected Date postdate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="recipients_id")
	private User recipients;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="recipient_comment_id")
	private Comment recipientComment;
	
	@OneToMany(mappedBy="recipientComment")
	private Set<Comment> replyComments;
	
	@Column(name="content")
	protected String content;

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
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Comment getRecipientComment() {
		return recipientComment;
	}
	public void setRecipientComment(Comment recipientComment) {
		this.recipientComment = recipientComment;
	}
	public Set<Comment> getReplyComments() {
		return replyComments;
	}
	public void setReplyComments(Set<Comment> replyComments) {
		this.replyComments = replyComments;
	}
}
