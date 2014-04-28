package common.factory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param scale
	 * @param suffix
	 * @throws IOException
	 */
	public static void scale(String srcImageFile,String targetImageFile,int scale,String suffix) throws IOException{
		ImageUtils.scale(new File(srcImageFile), new File(targetImageFile), scale,suffix);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param scale
	 * @param suffix
	 * @throws IOException
	 */
	public static void scale(File srcImageFile,File targetImageFile,int scale,String suffix) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);

		int width = srcimage.getWidth()*scale;
		int height = srcimage.getHeight()*scale;
	
		Image image = srcimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage targetimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = targetimage.getGraphics();
		graphics.drawImage(image, 0, 0, null);
		graphics.dispose();
		ImageIO.write(targetimage, suffix, targetImageFile);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param width
	 * @param height
	 * @param suffix
	 * @throws IOException
	 */
	public static void scale(File srcImageFile,File targetImageFile,int width,int height,String suffix) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);
		
		Image image = srcimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage targetImage = new BufferedImage(width, height, Image.SCALE_DEFAULT);
		
		Graphics graphics = targetImage.getGraphics();
		graphics.drawImage(image, width, height, null);
		graphics.dispose();
		ImageIO.write(targetImage, suffix, targetImageFile);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static void crop(String srcImageFile,String targetImageFile,int width, int height, int x, int y) throws IOException{
		ImageUtils.crop(new File(srcImageFile), new File(targetImageFile), width, height, x, y);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static void crop(File srcImageFile,File targetImageFile,int width,int height, int x,int y) throws IOException{
		BufferedImage srcimage = ImageIO.read(srcImageFile);
	}
}
