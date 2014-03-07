/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;

import common.BaseModelHasName;

/**
 * @author sai
 *
 */
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
