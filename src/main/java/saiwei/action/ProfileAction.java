/**
 * 
 */
package saiwei.action;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.model.Photo;
import saiwei.model.Profile;
import saiwei.model.User;
import saiwei.service.IPhotoService;
import saiwei.service.IProfileService;
import saiwei.service.IUserService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/profile")
@Action("profileAction")
public class ProfileAction extends BaseAction<Profile,IProfileService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String headphotoFileName;
	private File headphoto;
	private String updateName;
	private String updateCompany;
	private String updatelocation;
	private String updateemail;
	
	private IUserService userservice;
	private IPhotoService photoService;
	
	@Action(value="updateProfile",results={
			@Result(name=SUCCESS,type="redirect",location="/user/home.jsp")
	})
	public String update(){
		Photo photo = null;
		try {
			if(headphoto != null){
				photo = photoService.saveHeadPhoto(headphoto, headphotoFileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return INPUT;
		}
		userservice.saveOrupdateProfile(updateemail, updateName,
				updatelocation, updateCompany, photo, (User)session.get("user"));
		return SUCCESS;
	}
	
	public void setHeadphotoFileName(String headphotoFileName) {
		this.headphotoFileName = headphotoFileName;
	}
	public void setHeadphoto(File headphoto) {
		this.headphoto = headphoto;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public void setUpdateCompany(String updateCompany) {
		this.updateCompany = updateCompany;
	}
	public void setUpdatelocation(String updatelocation) {
		this.updatelocation = updatelocation;
	}
	@Resource(name="userService")
	public void setUserservice(IUserService userservice) {
		this.userservice = userservice;
	}
	public void setUpdateemail(String updateemail) {
		this.updateemail = updateemail;
	}
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
}
