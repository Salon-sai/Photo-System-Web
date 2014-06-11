package saiwei.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.bean.PhotoBean;
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
	
	public String allphotolist(){
		this.photos = new HashSet<PhotoBean>();
		
		try {
			PhotoBean bean = new PhotoBean(null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}

	/**
	 * 
	 * getter and setter
	 */
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public void setPhotos(Set<PhotoBean> photos) {
		this.photos = photos;
	}

	@Override
	@Resource(name="photoService")
	public void setService(IPhotoService service) {
		// TODO Auto-generated method stub
		super.setService(service);
	}
}
