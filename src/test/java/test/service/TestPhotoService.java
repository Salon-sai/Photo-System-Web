/**
 * 
 */
package test.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import saiwei.model.Photo;
import saiwei.model.Post;
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
//	@Test
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
	
//	@Test
	public void testDeletePhoto(){
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		boolean flag = photoService.deletephoto("8a8a1f79456a99d701456a99df530002");
		TestCase.assertEquals(true, flag);
	}
	
//	@Test
	public void testsavePhoto(){
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		photoService.delete("297e7ce8458ea70e01458ea713fb0000", Photo.class);
	}
	
	@Test
	public void testsavePostAndPhoto(){
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		
		Post post = new Post();
		post.setContent("test a");
		post.setPostdate(new Date());
		
		File[] files = {new File("C:/Users/sai/Desktop/1860268121180814475.jpg"),new File("C:/Users/sai/Desktop/2254896038529372747.jpg")};
		String[] fileNames = {"1860268121180814475.jpg","2254896038529372747.jpg"};
		
		photoService.savePhotoWithPost(post, files, fileNames);
	}
}
