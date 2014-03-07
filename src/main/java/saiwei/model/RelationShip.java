/**
 * 
 */
package saiwei.model;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class RelationShip extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User founder;
	
	private User linked_person;
	
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
