/**
 * 
 */
package saiwei.service;

import java.io.File;
import java.util.List;

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
	
	public void saveToDB(Photo photo);
	
	public String zoomPhoto(String imagePath, int width, int height);
	
	public List<Photo> savePhotosByList(File[] files,String[] fileNames);
}
