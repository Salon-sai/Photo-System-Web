package test.service;

import java.util.List;

import org.junit.Test;

import saiwei.model.User;
import saiwei.service.IRelationShipService;
import test.common.CommonTester;

public class TestRelationshipService extends CommonTester{

	private IRelationShipService relationshipService ;
	
//	@Test
	public void testfollowing(){
		long oldTime = System.currentTimeMillis();
		relationshipService = (IRelationShipService)context.getBean("relationshipService");
		relationshipService.addrelationship("b", "c", "following");
		logger.info(System.currentTimeMillis() - oldTime + "ms");
	}
	
	@Test
	public void testfindrelationship(){
		long oldTime = System.currentTimeMillis();
		relationshipService = (IRelationShipService)context.getBean("relationshipService");
		@SuppressWarnings("unused")
		List<User> users = relationshipService.findUserRelationShip("b", "following");
		logger.info(System.currentTimeMillis() - oldTime + "ms");		
	}
	
//	@Test
	public void testfindpostbyfollowing(){
		long oldTime = System.currentTimeMillis();
		relationshipService = (IRelationShipService)context.getBean("relationshipService");
		relationshipService.findPostByRelationship("b", "following");
		logger.info(System.currentTimeMillis() - oldTime + "ms");
	}
}
