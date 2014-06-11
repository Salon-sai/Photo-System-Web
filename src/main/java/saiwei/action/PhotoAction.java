package saiwei.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.bean.PhotoBean;
import saiwei.bean.PostBean;
import saiwei.model.Photo;
import saiwei.service.IPhotoService;

import common.BaseAction;

/**
 * 
 * @author sai
 *
 */
@Namespace("/photo")
@Action("photoAction")
public class PhotoAction extends BaseAction<Photo,IPhotoService>{

	private Set<PhotoBean> photos;
	private Set<PostBean> posts;
	private Photo image;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String photo_id;
	
	public String viewImage(){
		HttpServletResponse response = null;
		ServletOutputStream out = null;
		try{
			response = ServletActionContext.getResponse();
			response.setContentType("multipart/form-data");
			out = response.getOutputStream();
			service.photowriteToOutStream(photo_id, out);
			out.flush();
		}catch(Exception e){
			logger.error("view image fail",	e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Action(value="allphotolist",results={
			@Result(name=SUCCESS,location="/user/test_image.jsp"),
			@Result(name=INPUT,location="/")
	})
	public String allphotolist(){
		this.photos = new HashSet<PhotoBean>();
		
		posts = new HashSet<PostBean>();
		
		PostBean post1 = new PostBean();
		PostBean post2 = new PostBean();
		
		List<String> ids1 = new ArrayList<String>();
		ids1.add("a");
		ids1.add("v");
		ids1.add("c");
		post1.setPhoto_id(ids1);
		
		List<String> ids2 = new ArrayList<String>();
		ids2.add("ddd");
		ids2.add("vvvv");
		ids2.add("adsfasdfa");
		post2.setPhoto_id(ids2);
		
		posts.add(post2);
		posts.add(post1);
		
		Photo photo1 = service.get("ff808181468350f801468351b09e0000", Photo.class);
		
		PhotoBean bean1 = new PhotoBean(photo1);
		
		
		image = new Photo();
		image.setAutomodifyPhotoURL("a");
		image.setOriginalPhotoURL("b");
		image.setId("c");
		
		photos.add(bean1);
		photos.add(bean1);
		return SUCCESS;
	}

	/**
	 * 
	 * getter and setter
	 */
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public Set<PhotoBean> getPhotos() {
		return photos;
	}
	public Photo getImage() {
		return image;
	}
	public Set<PostBean> getPosts() {
		return posts;
	}

	@Override
	@Resource(name="photoService")
	public void setService(IPhotoService service) {
		// TODO Auto-generated method stub
		super.setService(service);
	}
}
