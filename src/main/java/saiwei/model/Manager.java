/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
