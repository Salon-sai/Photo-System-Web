package test.service;

import org.junit.Test;

import saiwei.model.Post;
import saiwei.model.Profile;
import saiwei.model.User;
import saiwei.service.IPostService;
import saiwei.service.IUserService;
import test.common.CommonTester;

public class TestUserService extends CommonTester {
	
//	@Test
	public void testsave(){
		User user = new User();
		user.setName("a");
		user.setPassword("a");
		user.setIdNumber("b");
		
		Profile profile = new Profile();
		user.setProfile(profile);

		IUserService userservice = (IUserService)context.getBean("userService");
		userservice.save(user);
		
		user.setIdNumber("c");
		user.setProfile(new Profile());
		userservice.save(user);
		
		user.setIdNumber("d");
		user.setProfile(new Profile());
		userservice.save(user);
	}
	
	@Test
	public void testlogin(){
		IUserService userservice = (IUserService)context.getBean("userService");
		User user = userservice.login("a", "a");
		logger.info("user name : " +user.getName());
	}
	
//	@Test
	public void deleteuser(){
		IUserService userservice = (IUserService)context.getBean("userService");
		User user = userservice.login("a", "a");
		userservice.delete(user);
	}
	
//	@Test
	public void userpostPost(){
		IUserService userservice = (IUserService)context.getBean("userService");
		User user = userservice.login("a", "a");
		
		Post post = new Post();
		post.setContent("bbb");
		
		IPostService postservice = (IPostService)context.getBean("postService");
		postservice.save(post,user,null);
	}
	
	public void likethispost(){
		
	}
	
	

}
