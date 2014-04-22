/**
 * 
 */
package test.service;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import saiwei.model.Post;
import saiwei.model.User;
import saiwei.service.IPostService;
import saiwei.service.IUserService;
import test.common.CommonTester;

/**
 * @author sai
 *
 */
public class TestPostService extends CommonTester {

//	@Test
	public void testSave(){
		IUserService userservice = (IUserService)context.getBean("userService");
		IPostService postservice = (IPostService)context.getBean("postService");
		
		User poster = userservice.login("b", "a");
		
		Post post = new Post();
		post.setPoster(poster);
		post.setContent("aaaaaaa");
		post.setPostdate(new Date());
		postservice.save(post);
		
		post.setContent("bbbbb");
		post.setPostdate(new Date());
		postservice.save(post);
		
		post.setContent("ccccc");
		post.setPostdate(new Date());
		postservice.save(post);
		
		
	}
	
//	@Test
	public void testsaveLikePost(){
		IPostService postService = (IPostService)context.getBean("postService");
		
		boolean flag = postService.saveLikePost("b", "8a8a1f79456a99d701456a99df470000");
		
		TestCase.assertEquals(true, flag);
	}
	
	@Test
	public void testdeleteLikePost(){
		IPostService postService = (IPostService)context.getBean("postService");
		
		boolean flag = postService.deleteLikePost("b", "8a8a1f79456a99d701456a99df470000");
		
		TestCase.assertEquals(true, flag);
	}
}
