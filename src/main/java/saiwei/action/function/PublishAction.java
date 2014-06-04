/**
 * 
 */
package saiwei.action.function;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;

import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.model.User;
import saiwei.service.IPhotoService;
import saiwei.service.IPostService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/publish")
public class PublishAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File[] image;
	private String[] imageFilename;
	private String[] imageContentType;
	private String context;
	private Map<String,Object> session;
	private IPostService postService;
	private IPhotoService photoService;
	
	public String publishtext(){
		User user = (User)session.get("user");
		Set<Photo> photos = new HashSet<Photo>(photoService.savePhotosByList(image, imageFilename));
		Post post = new Post();
		postService.save(post, user.getIdNumber(), photos);
		return SUCCESS;
	}

	/**
	 * 
	 * getter and setter
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setImage(File[] image) {
		this.image = image;
	}
	public void setImageFilename(String[] imageFilename) {
		this.imageFilename = imageFilename;
	}
	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
