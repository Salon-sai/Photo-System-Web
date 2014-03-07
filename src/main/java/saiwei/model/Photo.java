/**
 * 
 */
package saiwei.model;

import common.BaseModel;

/**
 * @author sai
 *
 */
public class Photo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String originalPhotoURL;

	private String AutomodifyPhotoURL;

	public String getOriginalPhotoURL() {
		return originalPhotoURL;
	}

	public void setOriginalPhotoURL(String originalPhotoURL) {
		this.originalPhotoURL = originalPhotoURL;
	}

	public String getAutomodifyPhotoURL() {
		return AutomodifyPhotoURL;
	}

	public void setAutomodifyPhotoURL(String automodifyPhotoURL) {
		AutomodifyPhotoURL = automodifyPhotoURL;
	}
}
