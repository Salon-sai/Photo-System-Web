/**
 * 
 */
package saiwei.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import common.BaseModelHasName;

/**
 * @author sai
 *
 */
@Entity
@Table(name="tag",catalog="photosystem")
public class Tag extends BaseModelHasName {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(
			cascade={CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy="tags",
			targetEntity=saiwei.model.User.class
	)
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
