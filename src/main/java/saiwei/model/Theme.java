/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class Theme extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="home_page")
	private String home_page_url;
	
	@OneToOne(mappedBy="user",fetch=FetchType.LAZY)
	private User user;

	/**
	 * 
	 * getter and setter
	 */
	public User getUser() {
		return user;
	}
	public String getHome_page_url() {
		return home_page_url;
	}
	public void setHome_page_url(String home_page_url) {
		this.home_page_url = home_page_url;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
