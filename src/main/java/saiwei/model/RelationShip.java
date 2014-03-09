/**
 * 
 */
package saiwei.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="relationship",catalog="photosystem")
public class RelationShip extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="founder_id")
	private User founder;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="linked_person_id")
	private User linked_person;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="relationship_type_id")
	private RelationShipType relationship;

	public User getFounder() {
		return founder;
	}

	public void setFounder(User founder) {
		this.founder = founder;
	}

	public User getLinked_person() {
		return linked_person;
	}

	public void setLinked_person(User linked_person) {
		this.linked_person = linked_person;
	}

	public RelationShipType getRelationship() {
		return relationship;
	}

	public void setRelationship(RelationShipType relationship) {
		this.relationship = relationship;
	}
}
