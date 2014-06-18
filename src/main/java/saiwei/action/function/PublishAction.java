/**
 * 
 */
package saiwei.action.function;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
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
	private String[] imageFileName;
	private String content;
	private Map<String,Object> session;
	private String filterType;
	private IPostService postService;
	private IPhotoService photoService;
	
	@Action(value="publishPost",
			results={
				@Result(name=SUCCESS,type="json",
						params={"excludeNullProperties","ture"}),
				@Result(name=INPUT,type="json",
						params={"excludeNullProperties","ture"})})
	public String publishpost(){
		User user = (User)session.get("user");
		Set<Photo> photos = null;
		try {
			photos = new HashSet<Photo>(photoService.savePhotosByList(image, imageFileName,filterType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post post = new Post();
		post.setContent(content);
		postService.save(post, user.getIdNumber(), photos);
		return null;
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
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
	public void setPostService(IPostService postService) {
		this.postService = postService;
	}
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
}
