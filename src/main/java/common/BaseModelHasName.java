/**
 * 
 */
package common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author sai
 *
 */
@MappedSuperclass
public abstract class BaseModelHasName extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
