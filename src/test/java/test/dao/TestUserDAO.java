package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.factory.MD5Factory;

import saiwei.model.User;
import saiwei.service.IUserService;

public class TestUserDAO {
	
	private static final Logger logger = Logger.getLogger(TestUserDAO.class);
	
	private ApplicationContext context;
	
	private IUserService userservice;
	
	private User user;
	
//	@Test
	public void testcreateUser(){
			logger.info("begin to create user");
			user = new User();
			user.setName("c");
			user.setPassword("1111111");
			userservice.save(user);
	}
	
	public void testdeleteUser(){
		userservice.delete(user);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void findByName(){
		List<User> users = null ;
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "c");
		params.put("password", MD5Factory.getMD5("1111111".getBytes()));
		users = (List<User>)userservice.findByProperties(params, User.class);
		for(User user : users){
			logger.info(user.getId());
		}
	}
	
	@Test
	public void findById(){
		User user = userservice.get("8a8c902c4492e7fd014492e7fff80000", User.class);
		logger.info(user.getName());
	}
	
//	@Test
	@SuppressWarnings("unchecked")
	public void testdelete(){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "a");
		List<User> users = (List<User>)userservice.findByProperties(params, User.class);
		for(User user : users){
			userservice.delete(user);
		}
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	/**
	 * init ApplicationContext
	 */
	@Before
	public void init(){
		if(this.context == null){
			context = new ClassPathXmlApplicationContext(
					new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
			if(userservice == null){
				userservice = (IUserService)context.getBean("userService");
			}
		}
	}

}
