/**
 * 
 */
package saiwei.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import saiwei.dao.IPhotoDAO;
import saiwei.model.Photo;
import saiwei.service.IPhotoService;

import common.AbstractTemplateService;
import common.factory.ImageFactory;
import common.factory.StringFactory;
import common.factory.WriteToDiskFactory;

/**
 * @author sai
 *
 */
@Service("photoService")
public class PhotoServiceImpl extends
		AbstractTemplateService<IPhotoDAO, Photo> implements IPhotoService {
	
	private static final Logger logger = Logger.getLogger(PhotoServiceImpl.class);
	
	private static final Class<?> PHOTOCLASS = Photo.class;
	
	private static final String PARENT_IMAGE_OLD = "F:/PhotoSystem_Photo_OLD";
	private static final String PARENT_IMAGE_NEW = "F:/PhotoSystem_Photo_NEW";
	private static final String PARENT_HEAD_PHOTO = "F:/PhotoSystem_Head_PHOTO";
	
	
	private static final Integer HEAD_PHOTO_WIDTH = 110;
	private static final Integer HEAD_PHOTO_HEIGHT = 110;
	private static final Integer CUT_WIDTH = 300;
	private static final Integer CUT_HEIGHT = 300;
	
	@Resource(name="photoDAO")
	@Override
	public void setDao(IPhotoDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	/**
	 * @param file
	 * 		source file
	 * @param fileName
	 * 		target file name,but exclude file path.
	 * 	
	 * @return filepath
	 * 		return absolute file path
	 */
	public String saveToDisk(File file,String fileName){
		String filepath = WriteToDiskFactory.writetodisk(PARENT_IMAGE_OLD, file, fileName);
//		logger.info(filepath);
		return filepath;
	}
	
	/**
	 * 
	 * @param imagePath
	 * 		source image file path
	 * 
	 */
	public String zoomImage(String imagePath){
		String newImagePath = StringFactory.MergerString(PARENT_IMAGE_NEW,File.separator,
				imagePath.substring(imagePath.lastIndexOf(File.separator)));
		if(ImageFactory.zoomImage(imagePath, newImagePath, CUT_WIDTH, CUT_HEIGHT)){
			return newImagePath;
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * @param imagePath
	 * @return
	 */
	public String zoomtoHeadPhoto(String imagePath){
		String newImagePath = StringFactory.MergerString(PARENT_HEAD_PHOTO,File.separator,
				imagePath.substring(imagePath.lastIndexOf("/")),Integer.toString(HEAD_PHOTO_HEIGHT),"*",Integer.toString(HEAD_PHOTO_WIDTH));
		if(ImageFactory.zoomImage(imagePath, newImagePath, HEAD_PHOTO_WIDTH, HEAD_PHOTO_HEIGHT)){
			return newImagePath;
		}else
			return null;
	}
	
	/**
	 * 
	 * @param imagePath
	 * 		source image path
	 * @param width
	 * 		the width of photo you want
	 * @param height
	 * 		the height of photo you want
	 * @return
	 */
	public String zoomPhoto(String imagePath, int width, int height){
		String newImagePath = StringFactory.MergerString(PARENT_IMAGE_NEW,File.separator,
				imagePath.substring(imagePath.lastIndexOf("/")));
		if(ImageFactory.zoomImage(imagePath, newImagePath, width, height)){
			return newImagePath;
		}else
			return null;
	}
	
	/**
	 * @param photo
	 * 
	 */
	public void saveToDB(Photo photo){
		super.save(photo);
	}
	
	/**
	 * 
	 * @param files
	 * 		file list
	 * @param fileName
	 * 		file name list,but exclude file path.
	 * @return photos
	 * 		
	 */
	public List<Photo> savePhotosByList(File[] files,String[] fileNames){
		List<Photo> photos = new ArrayList<Photo>();
		for(int i  = 0; i < fileNames.length;i++){
			String filepath = this.saveToDisk(files[i], fileNames[i]);
			String modifyFilepath = this.zoomImage(filepath);
			Photo photo = new Photo();
			photo.setOriginalPhotoURL(filepath);
			photo.setAutomodifyPhotoURL(modifyFilepath);
			photos.add(photo);
		}
		return photos;
	}
	
	/**
	 * 
	 * @param Filepath
	 * 		file path is absolute path
	 * 
	 */
	public boolean deleteInDisk(String Filepath){
		return new File(Filepath).delete();
	}
	
	/**
	 * 
	 * @param photoId
	 * 		photo id in the database
	 * @return
	 */
	public boolean deletephoto(String photoId){
		boolean flag = false ;
		Photo photo = dao.findById(photoId, PHOTOCLASS);
		flag = this.deleteInDisk(photo.getAutomodifyPhotoURL()) 
				&& this.deleteInDisk(photo.getOriginalPhotoURL());
		try{
			dao.delete(photo);
			logger.info("delete photo success");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("delete photo fail",e);
			flag = false;
		}
		return flag;
	}
}
