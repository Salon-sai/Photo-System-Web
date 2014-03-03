package saiwei.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("basePackage")
@Namespace("/")
@Action("testAction")
public class TestAction {
	
	private static final Logger logger = Logger.getLogger(TestAction.class);
	
	public void test(){
		logger.info("invoke testAction");
	}
	
	
}
