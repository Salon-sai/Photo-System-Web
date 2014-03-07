/**
 * 
 */
package saiwei.model;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class Comment extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User poster;
	
	private User recipients;
	
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
}
