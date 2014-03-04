package test.connection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {

	@Test
	public void connection(){
		ApplicationContext context = new 
				ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
	}
	
	public void createUser(){
		
	}
	
}
