package saiwei.bean;

import saiwei.model.Comment;

public class CommentBean extends Comment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String posterName;
	private String recipientName;
	private String postId;
	

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
}
