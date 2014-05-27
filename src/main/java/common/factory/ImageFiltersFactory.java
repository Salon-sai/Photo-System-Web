/**
 * 
 */
package common.factory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author sai
 *
 */
public class ImageFiltersFactory {
	
	/**
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void ChromeFilter(String src,String dest) throws IOException{
		ImageFiltersFactory.ChromeFilter(new File(src), new File(dest));
	}
	
	public static void ChromeFilter(File srcImageFile,File targetImageFile) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);
		BufferedImage chromeImage = null;
		
		com.jhlabs.image.ChromeFilter chromeFilter = new com.jhlabs.image.ChromeFilter();
		
		chromeImage = chromeFilter.filter(srcimage, chromeImage);
		
		ImageIO.write(chromeImage, "jpg", targetImageFile);
	}
	
}
