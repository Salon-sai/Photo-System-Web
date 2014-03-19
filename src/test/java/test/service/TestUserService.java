package test.service;

import org.junit.Test;

import saiwei.model.User;
import saiwei.service.IUserService;
import test.common.CommonTester;

public class TestUserService extends CommonTester {
	
	@Test
	public void testsave(){
		User user = new User();
		user.setName("a");
		user.setPassword("a");
		IUserService userservice = (IUserService)context.getBean("userService");
		userservice.save(user);
	}
	
	@Test
	public void testlogin(){
		IUserService userservice = (IUserService)context.getBean("userService");
		User user = userservice.login("a", "a");
		logger.info("user name : " +user.getName());
	}
	
}
