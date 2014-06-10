package saiwei.action;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String photo_id;
	
	public String viewImage(){
		HttpServletResponse respone = null;
		ServletOutputStream out = null;
		try{
			respone = ServletActionContext.getResponse();
			respone.setContentType("multipart/form-data");
			out = respone.getOutputStream();
			Photo photo = service.get(photo_id, Photo.class);
			File image = new File(photo.getAutomodifyPhotoURL());
			FileInputStream is = new FileInputStream(image);
			byte[] buffer = new byte[1024];
			int length = 0;
			while(-1 != (length = is.read(buffer))){
				out.write(buffer, 0, length);
			}
			is.close();
			out.flush();
		}catch(Exception e){
			logger.error("view image fail",	e);
		}
		return null;
	}

	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	@Override
	@Resource(name="photoService")
	public void setService(IPhotoService service) {
		// TODO Auto-generated method stub
		super.setService(service);
	}
}
