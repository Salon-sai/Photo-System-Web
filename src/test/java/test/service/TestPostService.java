/**
 * 
 */
package test.service;

import java.util.Date;

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

	@Test
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
	
}
