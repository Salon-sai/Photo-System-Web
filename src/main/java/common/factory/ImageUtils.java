package common.factory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
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
	public static boolean scale(String srcImageFile,String targetImageFile,int scale,String suffix) throws IOException{
		return ImageUtils.scale(new File(srcImageFile), new File(targetImageFile), scale,suffix);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param scale
	 * @param suffix
	 * @throws IOException
	 */
	public static boolean scale(File srcImageFile,File targetImageFile,int scale,String suffix) throws IOException{
		boolean flag = true;
		BufferedImage srcimage = ImageIO.read(srcImageFile);

		int width = srcimage.getWidth()*scale;
		int height = srcimage.getHeight()*scale;
	
		Image image = srcimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage targetimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = targetimage.getGraphics();
		graphics.drawImage(image, 0, 0, null);
		graphics.dispose();
		flag = flag && ImageIO.write(targetimage, suffix, targetImageFile);
		
		return flag;
	}
	
	public static boolean scale(String srcImageFile,String targetImageFile,int width,int height,String suffix) throws IOException{
		return ImageUtils.scale(new File(srcImageFile), new File(targetImageFile), width, height, suffix);
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
	public static boolean scale(File srcImageFile,File targetImageFile,int width,int height,String suffix) throws IOException{
		boolean flag = true;
		BufferedImage srcimage = ImageIO.read(srcImageFile);
		
		Image image = srcimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage targetImage = new BufferedImage(width, height, Image.SCALE_DEFAULT);
		
		Graphics graphics = targetImage.getGraphics();
		graphics.drawImage(image, width, height, null);
		graphics.dispose();
		flag = flag && ImageIO.write(targetImage, suffix, targetImageFile);
		return flag;
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @param suffix
	 * @throws IOException
	 */
	public static void crop(String srcImageFile,String targetImageFile,int width, int height, int x, int y,String suffix) throws IOException{
		ImageUtils.crop(new File(srcImageFile), new File(targetImageFile), width, height, x, y,suffix);
	}
	
	/**
	 * 
	 * @param srcImageFile
	 * @param targetImageFile
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @param suffix
	 * @throws IOException
	 */
	public static void crop(File srcImageFile,File targetImageFile,int width,int height, int x,int y,String suffix) throws IOException{
		BufferedImage bufferedimage = ImageIO.read(srcImageFile);
		int srcWidth = bufferedimage.getWidth();
		int srcHeight = bufferedimage.getHeight();
		if(srcWidth > 0 && srcHeight > 0){
			Image image = bufferedimage.getScaledInstance(srcWidth, height, Image.SCALE_DEFAULT);
			
			ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
			Image cropImage = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
			
			BufferedImage bufferedtarget = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			Graphics graphics = bufferedtarget.getGraphics();
			graphics.drawImage(cropImage, 0, 0, width, height, null);
			graphics.dispose();
			
			ImageIO.write(bufferedtarget, suffix, targetImageFile);
		}
		
	}
}
