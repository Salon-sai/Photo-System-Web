package test.factory;

import org.apache.log4j.Logger;
import org.junit.Test;

import common.factory.ImageFactory;

public class TestImageFactory {
	
	private static final Logger logger = Logger.getLogger(TestImageFactory.class);
	
	@Test
	public void getinfobyImage(){
		logger.info(ImageFactory.getImageInfo("C:/Users/sai/Desktop/20120604789.jpg"));
		ImageFactory.zoomImage("C:/Users/sai/Desktop/20120604789.jpg", "C:/Users/sai/Desktop/20120604789a.jpg", 70, 70);
	}
	
}
