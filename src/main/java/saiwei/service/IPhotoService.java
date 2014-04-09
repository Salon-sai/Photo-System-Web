/**
 * 
 */
package saiwei.service;

import java.io.File;

import saiwei.dao.IPhotoDAO;
import saiwei.model.Photo;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IPhotoService extends IServiceTemplate<IPhotoDAO, Photo> {

	public String zoomImage(String imagePath);
	
	public String saveToDisk(File file,String fileName);
}
