package test.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import saiwei.service.IUserService;
import test.common.CommonTester;

public class TestUserDAO extends CommonTester{
	
	@Test
	public void testupdateProfileByUser(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", "aaa@1.com");
		params.put("name", "bb");
		IUserService userService = (IUserService)context.getBean("userService");
		userService.saveOrupdateProfile("", "", null, null, null, null);
	}
	
}
