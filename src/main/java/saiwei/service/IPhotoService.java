/**
 * 
 */
package saiwei.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import saiwei.dao.IPhotoDAO;
import saiwei.model.Photo;
import saiwei.model.Post;
import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IPhotoService extends IServiceTemplate<IPhotoDAO, Photo> {

	public String zoomImagestand(String imagePath);
	
	public String saveToDisk(File file,String fileName);
	
	public void saveToDB(Photo photo);
	
	public String zoomPhoto(String imagePath, int width, int height);
	
	public List<Photo> savePhotosByList(File[] files,String[] fileNames);
	
	public boolean deletephoto(String photoId);
	
	public boolean savePhotoWithPost(Post post,File[] files,String[] fileNames);
	
	public void photowriteToOutStream(Serializable id,OutputStream out) throws IOException;
}
