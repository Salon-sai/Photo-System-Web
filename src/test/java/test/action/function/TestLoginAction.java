package test.action.function;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsTestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionProxy;

import test.common.CommonTester;

public class TestLoginAction extends StrutsTestCase{
	
	protected static ApplicationContext context;
	protected static final Logger logger = Logger.getLogger(CommonTester.class);
	
	@BeforeClass
	public void init(){
		context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		logger.info("before to test in Common Tester");
	}
	
	@Test
	public void testcheckloginaction(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("idNum", "b");
		params.put("password", "b");
		
		request.setParameters(params);
		ActionProxy actionproxy = getActionProxy("checklogin");
		
		try {
			String result = actionproxy.execute();
			TestCase.assertEquals("success", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			TestCase.fail();
		}
	}
}
