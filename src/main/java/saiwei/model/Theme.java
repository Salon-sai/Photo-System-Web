/**
 * 
 */
package saiwei.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="theme",catalog="photosystem")
public class Theme extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="home_page")
	private String home_page_url;
	
	@OneToMany(mappedBy="theme")
	private Set<User> users;

	/**
	 * 
	 * getter and setter
	 */
	public String getHome_page_url() {
		return home_page_url;
	}
	public void setHome_page_url(String home_page_url) {
		this.home_page_url = home_page_url;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
