/**
 * 
 */
package saiwei.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import saiwei.dao.IPhotoDAO;
import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.service.IPhotoService;
import common.AbstractTemplateService;
import common.factory.ImageFiltersFactory;
import common.factory.ImageUtils;
import common.factory.OSInfo;
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
	
	private static final String PARENT_IMAGE_OLD_WIN = "F:\\PhotoSystem_Photo_OLD";
	private static final String PARENT_IMAGE_NEW_WIN = "F:\\PhotoSystem_Photo_NEW";
	private static final String PARENT_HEAD_PHOTO_WIN = "F:\\PhotoSystem_Head_PHOTO";
	
	private static final String PARENT_IMAGE_OLD_LINUX = "/home/sai/photosystem_old";
	private static final String PARENT_IMAGE_NEW_LINUX = "/home/sai/photoSystem_new";
	private static final String PARENT_HEAD_PHOTO_LINUX = "/home/sai/photoSystem_headphoto";
	
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
		String filepath = null;
		if(OSInfo.isWindows()){
			filepath = WriteToDiskFactory.writetodisk(PARENT_IMAGE_OLD_WIN, file, fileName);
		}else if(OSInfo.isLinux()){
			filepath = WriteToDiskFactory.writetodisk(PARENT_IMAGE_OLD_LINUX, file, fileName);
		}
//		logger.info(filepath);
		return filepath;
	}
	
	/**
	 * 
	 * @param imagePath
	 * 		source image file path
	 * 
	 */
	public String zoomImagestand(String imagePath){
		return this.zoomPhoto(imagePath, CUT_WIDTH, CUT_HEIGHT);
//		String suffix = StringFactory.getFileNamesuffix(imagePath);
//		String newImagePath = null;
//		StringBuilder stringbuffer = new StringBuilder();
//		if(OSInfo.isWindows()){
//			stringbuffer.append(PARENT_IMAGE_NEW_WIN);
//		}else if(OSInfo.isLinux()){
//			stringbuffer.append(PARENT_IMAGE_NEW_LINUX);
//		}
//		newImagePath = StringFactory.builderMergeredAfter(stringbuffer, File.separator,
//				StringFactory.getFileNameWithNosuffix(imagePath.substring(imagePath.lastIndexOf(File.separator)+1))
//				,Integer.toString(CUT_WIDTH),"_",Integer.toString(CUT_HEIGHT),suffix);
//		
//		if(ImageFactory.zoomImage(imagePath, newImagePath, CUT_WIDTH, CUT_HEIGHT)){
//			return newImagePath;
//		}else{
//			return null;
//		}
	}
	
	/**
	 * 
	 * @param imagePath
	 * @return
	 */
	public String zoomtoHeadPhoto(String imagePath){
		String suffix = StringFactory.getFileNamesuffix(imagePath);
		String newImagePath = null;
		StringBuilder stringbuffer = new StringBuilder();
		if(OSInfo.isWindows()){
			stringbuffer.append(PARENT_HEAD_PHOTO_WIN);
		}else if(OSInfo.isLinux()){
			stringbuffer.append(PARENT_HEAD_PHOTO_LINUX);
		}
		newImagePath = StringFactory.builderMergeredBefore(stringbuffer,File.separator,
				StringFactory.getFileNameWithNosuffix(imagePath.substring(imagePath.lastIndexOf(File.separator)+1))
				,Integer.toString(HEAD_PHOTO_HEIGHT),"_",Integer.toString(HEAD_PHOTO_WIDTH),suffix);
		
		try {
			if(ImageUtils.scale(imagePath, newImagePath, HEAD_PHOTO_WIDTH, HEAD_PHOTO_HEIGHT, suffix)){
//		if(ImageFactory.zoomImage(imagePath, newImagePath, width, height)){
				return newImagePath;
			}else
				return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
		String suffix = StringFactory.getFileNamesuffix(imagePath);
		String newImagePath = this.filePathchange(imagePath, width, height);
		File newImage = new File(newImagePath);
		File oldImage = new File(imagePath);
		File newpath = newImage.getParentFile();
		if(!newpath.exists()){
			newpath.mkdirs();
		}
		try {
			if(ImageUtils.scale(oldImage, newImage, width, height, suffix)){
//		if(ImageFactory.zoomImage(imagePath, newImagePath, width, height)){
				return newImagePath;
			}else
				return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
			Photo photo = new Photo();
			dao.save(photo);
			
			String suffix = StringFactory.getFileNamesuffix(fileNames[i]);
			String fileSerializableName = StringFactory.MergerString(photo.getId(),".",suffix);
			
			String filepath = this.saveToDisk(files[i], fileSerializableName);
			String modifyFilepath = this.zoomImagestand(filepath);
			photo.setOriginalPhotoURL(filepath);
			photo.setAutomodifyPhotoURL(modifyFilepath);
			photos.add(photo);
		}
		return photos;
	}
	
	public List<Photo> savePhotosByList(File[] files,String[] fileNames,String filterType){
		
		return null;
	}
	
	/**
	 * 
	 * @param Filepath
	 * 		file path is absolute path
	 * 
	 */
	public static boolean deleteInDisk(String Filepath){
		return new File(Filepath).delete();
	}
	
	/**
	 * 
	 * @param photos
	 * @return
	 */
	public static boolean deletePhotosInDisk(Set<Photo> photos){
		boolean flag = true;
		for(Photo photo : photos){
			flag = flag && new File(photo.getAutomodifyPhotoURL()).delete()
				&& new File(photo.getOriginalPhotoURL()).delete();
		}
		return flag;
	}
	
	/**
	 * 
	 * @param photoId
	 * 		photo id in the database
	 * @return
	 */
	public boolean deletephoto(String photoId){
		boolean flag = true ;
		Photo photo = dao.findById(photoId, PHOTOCLASS);
		flag = PhotoServiceImpl.deleteInDisk(photo.getAutomodifyPhotoURL()) 
				&& PhotoServiceImpl.deleteInDisk(photo.getOriginalPhotoURL());
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
	
	/**
	 * spare method save the photo
	 * 
	 * @param post
	 * @param files
	 * @param fileNames
	 * @return
	 */
	public boolean savePhotoWithPost(Post post,File[] files,String[] fileNames){
		for(int i = 0; i < files.length; i++){
			Photo photo = new Photo();
			photo.setPost(post);
			save(photo);
			
			String suffix = StringFactory.getFileNamesuffix(fileNames[i]);
			String AUTOGeneratefileName = StringFactory.MergerString(fileNames[i],suffix);
			
			String sourcePath = this.saveToDisk(files[i], AUTOGeneratefileName);
			String modifyFilepath = this.zoomImagestand(sourcePath);
			
			photo.setOriginalPhotoURL(sourcePath);
			photo.setAutomodifyPhotoURL(modifyFilepath);
		}
		return false;
	}
	
	/**
	 * 
	 * @param imagePath
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public String cropImage(String imagePath, int x, int y, int width, int height){
		String newimageFileName = this.filePathchange(imagePath, width, height);
		try{
			ImageUtils.crop(imagePath, newimageFileName, width, height, x, y, StringFactory.getFileNamesuffix(imagePath));
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("", e);
		}
		return null;
	}
	
	private String filePathchange(String imagePath,int width, int height){
		String suffix = StringFactory.getFileNamesuffix(imagePath);
		StringBuilder stringbuffer = new StringBuilder();
		if(OSInfo.isWindows()){
			stringbuffer.append(PARENT_IMAGE_NEW_WIN);
		}else if(OSInfo.isLinux()){
			stringbuffer.append(PARENT_IMAGE_NEW_LINUX);
		}
		return StringFactory.builderMergeredBefore(stringbuffer,File.separator,
				StringFactory.getFileNameWithNosuffix(imagePath.substring(imagePath.lastIndexOf(File.separator)+1))
				,Integer.toString(width),"_",Integer.toString(height), ".",suffix);
	}
	
	/**
	 * 
	 * @param id
	 * @param out
	 * @throws IOException 
	 */
	public void photowriteToOutStream(Serializable id,OutputStream out) throws IOException{
		Photo photo = this.get(id, PHOTOCLASS);
		File image = new File(photo.getAutomodifyPhotoURL());
		InputStream is = new FileInputStream(image);
		byte[] buffer = new byte[1024];
		int length = 0;
		while(-1 != (length = is.read(buffer))){
			out.write(buffer, 0, length);
		}
		is.close();
	}
	
	public void ChromefilterInView(File image,OutputStream out){
		try {
			ImageFiltersFactory.ChromeFilter(image, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("fail to make filter",e);
		}
	}
}
