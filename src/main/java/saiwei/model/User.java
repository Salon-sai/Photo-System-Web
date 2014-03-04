/**
 * 
 */
package saiwei.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import common.factory.MD5Factory;

/**
 * @author sai
 *
 */
@Entity
@Table(name="user",catalog="photosystem")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	@Column(name="id")
	private String id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	
	//change to MD5
	public void setPassword(String password) {
		this.password = MD5Factory.getMD5(password.getBytes());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
