package saiwei.bean;

import saiwei.model.User;

public class UserBean extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String IdNumber;
	private String head_photoId;
	
	public UserBean(User user){
		this.id = user.getId();
		this.Name = user.getName();
		this.IdNumber = user.getIdNumber();
		this.head_photoId = user.getProfile().getHead_photo().getId();
	}
	
	public UserBean(){
		
	}
	
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	public String getHead_photoId() {
		return head_photoId;
	}
	public void setHead_photoId(String head_photoId) {
		this.head_photoId = head_photoId;
	}
}
