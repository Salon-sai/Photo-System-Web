package saiwei.bean;

import java.util.HashSet;
import java.util.Set;

import saiwei.model.Comment;
import saiwei.model.User;

public class CommentBean extends Comment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String posterName;
	private String posterNumber;
	private String poster_headphotoId;
	private String recipientName;
	private String recipientNumber;
	private String postId;
	private Set<CommentBean> recipientComments;
	
	public CommentBean(Comment comment){
		this.id = comment.getId();
		this.content = comment.getContent();
		this.postdate = comment.getPostdate();
		
		User poster = comment.getPoster();
		User recipient = comment.getRecipients();
		
		this.posterNumber = poster.getIdNumber();
		this.posterName = poster.getName();
		this.poster_headphotoId = poster.getProfile().getHead_photo().getId();
		
		this.recipientNumber = recipient.getIdNumber();
		this.recipientName = recipient.getName();
		
		Set<Comment> comments = comment.getReplyComments();
		if(comments != null && !comments.isEmpty()){
			this.recipientComments = new HashSet<CommentBean>();
			for(Comment replycomment : comments){
				CommentBean bean = new CommentBean(replycomment);
				recipientComments.add(bean);
			}
		}
	}
	
	public CommentBean(){
		
	}
	
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPosterNumber() {
		return posterNumber;
	}
	public void setPosterNumber(String posterNumber) {
		this.posterNumber = posterNumber;
	}
	public String getRecipientNumber() {
		return recipientNumber;
	}
	public void setRecipientNumber(String recipientNumber) {
		this.recipientNumber = recipientNumber;
	}
	public Set<CommentBean> getRecipientComments() {
		return recipientComments;
	}
	public void setRecipientComments(Set<CommentBean> recipientComments) {
		this.recipientComments = recipientComments;
	}
	public String getPoster_headphotoId() {
		return poster_headphotoId;
	}
	public void setPoster_headphotoId(String poster_headphotoId) {
		this.poster_headphotoId = poster_headphotoId;
	}
}
