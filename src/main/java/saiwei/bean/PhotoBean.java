/**
 * 
 */
package saiwei.bean;

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
	
	public PhotoBean(Photo photo){
		this.id = photo.getId();
	}
}
