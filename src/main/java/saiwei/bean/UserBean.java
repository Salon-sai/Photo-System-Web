package saiwei.bean;

import saiwei.model.User;

public class UserBean extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String head_photoId;
	private boolean followingBewteenYour;
	
	public UserBean(User user){
		this.id = user.getId();
		this.Name = user.getName();
		this.IdNumber = user.getIdNumber();
		this.head_photoId = user.getProfile().getHead_photo().getId();
	}
	
	public UserBean(){
		
	}
	
	public String getHead_photoId() {
		return head_photoId;
	}
	public void setHead_photoId(String head_photoId) {
		this.head_photoId = head_photoId;
	}
	public boolean isFollowingBewteenYour() {
		return followingBewteenYour;
	}
	public void setFollowingBewteenYour(boolean followingBewteenYour) {
		this.followingBewteenYour = followingBewteenYour;
	}
}
