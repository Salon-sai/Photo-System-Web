/**
 * 
 */
package test.service;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import saiwei.service.IPhotoService;
import test.common.CommonTester;

/**
 * @author sai
 *
 */
public class TestPhotoService extends CommonTester {

	/**
	 * Tester test photoService generate photo of fit scale.
	 * If the path is null or not exists , Test  is fail;
	 */
//	@Test
	public void testzoomphoto(){
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		String path = photoService.zoomImage("C:/Users/sai/Desktop/20120604789.jpg");
		if(path == null){
			TestCase.fail("is null");
		}else if(!(new File(path).exists())){
			TestCase.fail("it does not generated");
		}
	}
	
	/**
	 * Tester test photoService save photo to disk.
	 * If the path is null or not exists , Test  is fail;
	 */
	@Test
	public void testsaveToDisk() throws IOException{
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		File sourceFile = new File("C:/Users/sai/Desktop/20120604789.jpg");
		String newpath = photoService.saveToDisk(sourceFile, sourceFile.getName());
		if(newpath == null){
			TestCase.fail("is null");
		}else if(!(new File(newpath).exists())){
			TestCase.fail("it does not save");
		}
	}
	
}
