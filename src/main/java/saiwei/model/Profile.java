/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class Profile extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
}
