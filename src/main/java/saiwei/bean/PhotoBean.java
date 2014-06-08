/**
 * 
 */
package saiwei.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import saiwei.model.Photo;

/**
 * @author sai
 *
 */
public class PhotoBean extends Photo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InputStream is;
	private OutputStream os;
	
	public PhotoBean(Photo photo) throws FileNotFoundException{
		is = new FileInputStream(new File(photo.getAutomodifyPhotoURL()));
		
	}
	
	public OutputStream getOs() {
		return os;
	}
	public void setOs(OutputStream os) {
		this.os = os;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}	
}
