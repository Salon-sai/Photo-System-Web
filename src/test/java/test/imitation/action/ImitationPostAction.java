/**
 * 
 */
package test.imitation.action;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.service.IPhotoService;
import saiwei.service.IPostService;
import test.common.CommonTester;

/**
 * @author sai
 *
 */
public class ImitationPostAction extends CommonTester {

//	@Test
	public void testsavePostInWindows(){
		IPostService postService = (IPostService)context.getBean("postService");
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		Post post = new Post();
		post.setContent("Test post context with English,测试post提交中文aaaaa");
//		IUserService userService = (IUserService)context.getBean("userService");		
//		User use = (User)userService.login("b", "a");
		
		File[] files = {new File("C:/Users/sai/Desktop/1860268121180814475.jpg"),new File("C:/Users/sai/Desktop/2254896038529372747.jpg")};
		String[] fileNames = {"1860268121180814475.jpg","2254896038529372747.jpg"};
		
		Set<Photo> photos = new HashSet<Photo>(photoService.savePhotosByList(files, fileNames));
		
		postService.save(post, "a", photos);
		
		for(Photo photo : post.getPhotos()){
			TestCase.assertEquals(true, new File(photo.getAutomodifyPhotoURL()).exists());
		}
	}
	
//	@Test
	public void deletePost(){
		IPostService postService = (IPostService)context.getBean("postService");
		Post post = postService.get("8a8a1f79458da8fa01458da9015d0000", Post.class);
		postService.delete(post);
	}
	
	@Test
	public void testsavePostInLinux(){
		IPostService postService = (IPostService)context.getBean("postService");
		IPhotoService photoService = (IPhotoService)context.getBean("photoService");
		Post post = new Post();
		post.setContent("Test post context with English,测试post提交中文aaaaa");
		File[] files = {new File("/home/sai/1384480949246.jpg")};
		String[] fileNames = {"1384480949246.jpg"};
		
		Set<Photo> photos = new HashSet<Photo>(photoService.savePhotosByList(files, fileNames));
		
		postService.save(post, "b", photos);
		
		for(Photo photo : post.getPhotos()){
			TestCase.assertEquals(true, new File(photo.getAutomodifyPhotoURL()).exists());
		}
	}
	
}
