/**
 * 
 */
package test.factory;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import common.factory.ImageFiltersFactory;

/**
 * @author sai
 *
 */
public class TestImageFilterFactory {
	
	private static final Logger logger = Logger.getLogger(TestImageFilterFactory.class);
	
//	@Test
	public void testChrome(){
		logger.info("test begin");
		try {
			ImageFiltersFactory.ChromeFilter("/home/sai/1384480949246.jpg", "/home/sai/1384480949246_chrome.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("fail", e);
			TestCase.fail();
		}
		
	}
	
	@Test
	public void testGrayFilter(){
		logger.info("test begin");
		try {
			ImageFiltersFactory
				.GrayscaleFilter("/home/sai/6597578840542108209.jpg", "/home/sai/6597578840542108209_gray.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("fail", e);
			TestCase.fail();
		}
	}
	
}
