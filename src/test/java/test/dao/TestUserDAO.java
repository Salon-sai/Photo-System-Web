package test.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import saiwei.model.User;
import saiwei.service.IUserService;

public class TestUserDAO {
	
	private static final Logger logger = Logger.getLogger(TestUserDAO.class);
	
	private ApplicationContext context;
	
	private IUserService userservice;
	
	@Test
	public void createUser(){
			logger.info("begin to create user");
			this.initApplicationContext();
			this.initUserDAO();
			User user = new User();
			user.setName("a");
			user.setPassword("1111111");
			userservice.save(user);
	}
	
	public void deleteUserByName(){
		this.initApplicationContext();
		this.initUserDAO();
		
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
	public void initApplicationContext(){
		if(this.context == null){
			context = new ClassPathXmlApplicationContext(
					new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
		}
	}
	
	public void initUserDAO(){
		userservice = (IUserService)context.getBean("userService");
	}
}
