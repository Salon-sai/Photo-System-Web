package test.service;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import saiwei.service.IUserService;
import test.dao.TestUserDAO;

public class TestCommonService {
	
	private static final Logger logger = Logger.getLogger(TestUserDAO.class);
	
	private ApplicationContext context;
	
	private IUserService userservice;
	
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
	
	@Test
	public void testAOP(){
		
	}
	
}
