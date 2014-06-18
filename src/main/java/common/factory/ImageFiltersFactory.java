/**
 * 
 */
package common.factory;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

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
	public static void chromeFilter(String src,String dest,String format) throws IOException{
		ImageFiltersFactory.chromeFilter(new File(src), new File(dest),format);
	}
	
	public static void chromeFilter(File srcImageFile,File targetImageFile,String format) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);
		BufferedImage chromeImage = null;
		
		com.jhlabs.image.ChromeFilter chromeFilter = new com.jhlabs.image.ChromeFilter();
		
		chromeImage = chromeFilter.filter(srcimage, chromeImage);
		
		ImageIO.write(chromeImage, format, targetImageFile);
	}
	
	public static void chromeFilter(File srcImageFile,OutputStream out) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);
		BufferedImage chromeImage = null;
		
		com.jhlabs.image.ChromeFilter chromeFilter = new com.jhlabs.image.ChromeFilter();
		
		chromeFilter.filter(srcimage, chromeImage);
		
		ImageIO.write(chromeImage, "jpg", out);
	}
	
	public static void grayFilter(String src,String target) throws IOException{
		String format = StringFactory.getFileNamesuffix(src);
		ImageFiltersFactory.grayFilter(new File(src), new File(target), format);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param format
	 * @throws IOException
	 */
	public static void grayFilter(File srcImageFile,File targetImageFile,String format) throws IOException{
		BufferedImage originalPic = ImageIO.read(srcImageFile);
		int width = originalPic.getWidth();
		int height = originalPic.getHeight();
		
		BufferedImage newPic = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		ColorConvertOp cco = new ColorConvertOp(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), null);
		
		cco.filter(originalPic, newPic);
		
		ImageIO.write(newPic, format, targetImageFile);
	}
	
	
}
