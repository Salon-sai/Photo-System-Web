package test.connection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.TestService;

public class TestSpring {
	
	@Test
	public void SpringConnection(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"});
		TestService testservice = (TestService)context.getBean("testService");
		testservice.testConnection();
	}
	
}
