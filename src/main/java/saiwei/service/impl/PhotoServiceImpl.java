/**
 * 
 */
package saiwei.service.impl;

import java.io.File;

import javax.annotation.Resource;

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
	
	private static final String PARENT_IMAGE_OLD = "F:/PhotoSystem_Photo_OLD";
	private static final String PARENT_IMAGE_NEW = "F:/PhotoSystem_Photo_NEW";
	private static final int CUT_WIDTH = 100;
	private static final int CUT_HEIGHT = 100;
	
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
		return filepath;
	}
	
	public String zoomImage(String imagePath){
		String newImagePath = StringFactory.MergerString(PARENT_IMAGE_NEW,File.separator,
				imagePath.substring(imagePath.lastIndexOf("/")));
		if(ImageFactory.zoomImage(imagePath, newImagePath, CUT_WIDTH, CUT_HEIGHT)){
			return newImagePath;
		}else{
			return null;
		}
		
	}
}
