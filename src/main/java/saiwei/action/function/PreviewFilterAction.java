/**
 * 
 */
package saiwei.action.function;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import saiwei.service.IPhotoService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author sai
 *
 */
@ParentPackage("basePackage")
@Namespace("/photo")
public class PreviewFilterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPhotoService photoService;
	private File image;
	
	@Action(value="previewChrome")
	public String previewFilter(){
		HttpServletResponse respone = null;
		ServletOutputStream out = null;
		try {
			respone = ServletActionContext.getResponse();
			respone.setContentType("multipart/form-data");
			out = respone.getOutputStream();
			photoService.ChromefilterInView(image, out);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
	public void setImage(File image) {
		this.image = image;
	}
}
