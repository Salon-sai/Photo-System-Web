package test.service;

import org.junit.Test;

import saiwei.model.RelationShipType;
import saiwei.service.IRelationShipTypeService;
import test.common.CommonTester;

public class TestRelationshipTypeService extends CommonTester{
	
	private IRelationShipTypeService service;
	
	@Test
	public void createRelationshipType(){
		service = (IRelationShipTypeService)context.getBean("relationshipTypeService");
		
		RelationShipType type1 = new RelationShipType();
		type1.setName("following");
		
		RelationShipType type2 = new RelationShipType();
		type2.setName("followed");
		
		RelationShipType type3 = new RelationShipType();
		type3.setName("friend");
		
		service.save(type1);
		service.save(type2);
		service.save(type3);
	}
	
}
