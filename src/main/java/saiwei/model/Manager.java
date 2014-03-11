/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import common.BaseModelHasName;

/**
 * @author sai
 *
 */
@Entity
@Table(name="manager",catalog="photosystem")
public class Manager extends BaseModelHasName {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="password")
	private String password ;
	
	@ManyToOne
	@JoinColumn(name="title_id")
	private Title title;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
}
