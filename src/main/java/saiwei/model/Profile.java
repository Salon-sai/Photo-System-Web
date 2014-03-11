/**
 * 
 */
package saiwei.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="profile",catalog="photosystem")
public class Profile extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="photo_id")
	private Photo head_photo;
	
	@OneToOne(mappedBy="profile",fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="e_mail")
	private String e_mail;
	
	@Column(name="company")
	private String Company;
	
	@Column(name="location")
	private String location;

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Photo getHead_photo() {
		return head_photo;
	}

	public void setHead_photo(Photo head_photo) {
		this.head_photo = head_photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
