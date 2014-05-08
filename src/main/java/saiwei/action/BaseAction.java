/**
 * 
 */
package saiwei.action;

import saiwei.service.ICommentService;
import saiwei.service.IManagerService;
import saiwei.service.IPhotoService;
import saiwei.service.IPostService;
import saiwei.service.IProfileService;
import saiwei.service.IRelationShipService;
import saiwei.service.IRelationShipTypeService;
import saiwei.service.ITagService;
import saiwei.service.ITitleService;
import saiwei.service.IUserService;
import saiwei.service.IUserTypeService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ICommentService commentService;
	protected IManagerService managerService;
	protected IPhotoService photoService;
	protected IPostService postService;
	protected IProfileService profileService;
	protected IRelationShipService relationShipService;
	protected IRelationShipTypeService relationShipTypeService;
	protected ITagService tagService;
	protected ITitleService titleService;
	protected IUserService userService;
	protected IUserTypeService userTypeService;
	
	public ICommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	public IManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
	}
	public IPhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
	public IPostService getPostService() {
		return postService;
	}
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
	public IProfileService getProfileService() {
		return profileService;
	}
	public void setProfileService(IProfileService profileService) {
		this.profileService = profileService;
	}
	public IRelationShipService getRelationShipService() {
		return relationShipService;
	}
	public void setRelationShipService(IRelationShipService relationShipService) {
		this.relationShipService = relationShipService;
	}
	public IRelationShipTypeService getRelationShipTypeService() {
		return relationShipTypeService;
	}
	public void setRelationShipTypeService(
			IRelationShipTypeService relationShipTypeService) {
		this.relationShipTypeService = relationShipTypeService;
	}
	public ITagService getTagService() {
		return tagService;
	}
	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}
	public ITitleService getTitleService() {
		return titleService;
	}
	public void setTitleService(ITitleService titleService) {
		this.titleService = titleService;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IUserTypeService getUserTypeService() {
		return userTypeService;
	}
	public void setUserTypeService(IUserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}
}
