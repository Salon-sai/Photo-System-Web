package test.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {
	
	private static final Logger logger = Logger.getLogger(TestService.class);
	
	public void testConnection(){
		logger.info("web connect spring configuration");
	}
	
}
