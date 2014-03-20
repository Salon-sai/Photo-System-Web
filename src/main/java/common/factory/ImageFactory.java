package common.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;

public class ImageFactory {
	
	public static int getSize(String imagePath) {
		    int size = 0;
		    FileInputStream inputStream = null;
		    try {
		        inputStream = new FileInputStream(imagePath);
		        size = inputStream.available();
		        inputStream.close();
		        inputStream = null;
		    } catch (FileNotFoundException e) {
		        size = 0;
		        System.out.println("文件未找到!");
		    } catch (IOException e) {
		        size = 0;
		        System.out.println("读取文件大小错误!");
		    } finally {
		        // 可能异常为关闭输入流,所以需要关闭输入流
		        if (null != inputStream) {
		            try {
		                inputStream.close();
		            } catch (IOException e) {
		                System.out.println("关闭文件读入流异常");
		            }
		            inputStream = null;
		        }
		    }
		    return size;
	}
	
	public static int getWidth(String imagePath) {
		    int line = 0;
		    try {
		        IMOperation op = new IMOperation();
		        op.format(" %w"); // 设置获取宽度参数
		        op.addImage(1);
		        IdentifyCmd identifyCmd = new IdentifyCmd(true);
		        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
		        identifyCmd.setOutputConsumer(output);
		        identifyCmd.run(op, imagePath);
		        ArrayList<String> cmdOutput = output.getOutput();
		        assert cmdOutput.size() == 1;
		        line = Integer.parseInt(cmdOutput.get(0).substring(1));
		    } catch (Exception e) {
		        line = 0;
		        System.out.println("运行指令出错!");
		        e.printStackTrace();
		    }
		    return line;
		}
	
	/**
	 * 图片信息
	 *
	 * @param imagePath
	 * @return
	 */
	public static String getImageInfo(String imagePath) {
	    String line = null;
	    try {
	        IMOperation op = new IMOperation();
	        op.format("width:%w, height:%h, path:%d%f, size:%b% [EXIF:DateTimeOriginal]");
	        op.addImage(1);
	        IdentifyCmd identifyCmd = new IdentifyCmd(true);
	        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
	        identifyCmd.setOutputConsumer(output);
	        identifyCmd.run(op, imagePath);
	        ArrayList<String> cmdOutput = output.getOutput();
	        assert cmdOutput.size() == 1;
	        line = cmdOutput.get(0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return line;
	}
	
	/**
	 * 根据尺寸缩放图片[等比例缩放:参数height为null,按宽度缩放比例缩放;参数width为null,按高度缩放比例缩放]
	 * 
	 * @param imagePath
	 *            源图片路径
	 * @param newPath
	 *            处理后图片路径
	 * @param width
	 *            缩放后的图片宽度
	 * @param height
	 *            缩放后的图片高度
	 * @return 返回true说明缩放成功,否则失败
	 */
	public static boolean zoomImage(String imagePath, String newPath, Integer width,
	        Integer height) {
	    boolean flag = false;
	    try {
	        IMOperation op = new IMOperation();
	        op.addImage(imagePath);
	        if (width == null) {// 根据高度缩放图片
	            op.resize(null, height);
	        } else if (height == null) {// 根据宽度缩放图片
	            op.resize(width);
	        } else {
	            op.resize(width, height);
	        }
	        op.addImage(newPath);
	        ConvertCmd convert = new ConvertCmd(true);
	        convert.run(op);
	        flag = true;
	    } catch (IOException e) {
	        System.out.println("文件读取错误!");
	        flag = false;
	    } catch (InterruptedException e) {
	        flag = false;
	    } catch (IM4JavaException e) {
	        flag = false;
	        e.printStackTrace();
	    } finally {

	    }
	    return flag;
	}
	
//	public static String createThumbnail(String path, int width,int height,String type)throws Exception{
//		IMOperation op = new IMOperation();
//		ConvertCmd cmd = new ConvertCmd(true);
//		String newFileName = null;
//		String prevFileName = null;
//		try{
//			op.addImage();
//			String raw = "";
//			if("1".equals(type)){
//				raw = width+"x"+height+"!";
//				prevFileName = width + "x" + height + "_";
//			}else{
//				raw = width + "%x" + height + "%";
//				prevFileName = width + "%x" + height + "%_";
//			}
//			op.addRawArgs("-thumbnail", raw);
//			op.addRawArgs("-quality", "100");
//			String osName = System.getProperty("os.name").toLowerCase();
//			if(osName.indexOf("win") != -1){
//				
//			}
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return null;
//	}

	
}
