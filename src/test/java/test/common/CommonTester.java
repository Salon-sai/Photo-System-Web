package test.common;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@MappedSuperclass
public class CommonTester {
	
	protected ApplicationContext context;
	protected static final Logger logger = Logger.getLogger(CommonTester.class);
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		logger.info("before to test in Common Tester");
	}
	
	@After
	public void destory(){
		logger.info("after testing");
		logger.info("----------------------------------");
	}
	
}
