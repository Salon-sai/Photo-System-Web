package test.service;

import org.junit.Test;

import saiwei.service.IRelationShipService;
import test.common.CommonTester;

public class TestRelationshipService extends CommonTester{

	private IRelationShipService relationshipService ;
	
	@Test
	public void testfollowing(){
		long oldTime = System.currentTimeMillis();
		relationshipService = (IRelationShipService)context.getBean("relationshipService");
		relationshipService.addrelationship("a", "d", "following");
		logger.info(System.currentTimeMillis() - oldTime + "ms");
	}
	
	
}
