package saiwei.model;

import java.util.Set;

import javax.persistence.OneToMany;

import common.BaseModel;

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
