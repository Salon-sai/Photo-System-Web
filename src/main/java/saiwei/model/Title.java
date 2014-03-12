package saiwei.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import common.BaseModel;

@Entity
@Table(name="title",catalog="photosystem")
public class Title extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="title")
	private Set<Manager> managersOftitle;

	public Set<Manager> getManagersOftitle() {
		return managersOftitle;
	}

	public void setManagersOftitle(Set<Manager> managersOftitle) {
		this.managersOftitle = managersOftitle;
	}
}
