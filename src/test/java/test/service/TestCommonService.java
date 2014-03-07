/**
 * 
 */
package test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.factory.MD5Factory;


import saiwei.model.User;
import saiwei.service.IUserService;

/**
 * @author sai
 *
 */
public class TestCommonService {

	private ApplicationContext context;
	private IUserService userservice;
	private static final Logger logger = Logger.getLogger(TestCommonService.class);
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		userservice = (IUserService)context.getBean("userService");
		logger.info("before to test userService");
	}
	
	@Test
	public void testSave(){
		logger.info("test save begin");
		User user = new User();
		user.setName("a");
		user.setPassword("111111");
		userservice.save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFind(){
		logger.info("test find begin");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "a");
		params.put("password", MD5Factory.getMD5("111111".getBytes()));
		List<User> users = (List<User>)userservice.findByProperties(params, User.class);
		for(User user : users){
			logger.info(user.getId());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindByHql(){
		logger.info("test find hql begin");
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "a");
		params.put("password", MD5Factory.getMD5("111111".getBytes()));
		List<User> users = (List<User>)userservice.findByPropertiesInHql(params, "User");
		for(User user : users){
			logger.info(user.getId());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testdelete(){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "a");
		List<User> users = (List<User>)userservice.findByProperties(params, User.class);
		for(User user : users){
			userservice.delete(user);
		}
	}
	
	
	@After
	public void after(){
		logger.info("after testing");
		logger.info("----------------------------------");
	}
	
	
	
	
	
	
	
}
