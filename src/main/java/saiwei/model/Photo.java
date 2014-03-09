/**
 * 
 */
package saiwei.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import common.BaseModel;

/**
 * @author sai
 *
 */
@Entity
@Table(name="photo",catalog="photosystem")
public class Photo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="original_photo_url")
	private String originalPhotoURL;

	@Column(name="automodify_photo_url")
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
