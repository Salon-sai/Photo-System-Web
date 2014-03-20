/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="relationship_type",catalog="photosystem")
public class RelationShipType extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name",unique=true)
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
