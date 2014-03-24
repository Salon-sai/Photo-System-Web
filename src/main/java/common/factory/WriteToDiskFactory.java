package common.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class WriteToDiskFactory {
	
	/**
	 * 
	 * @param parentFileName
	 * @param file
	 * @param fileName
	 * @return filetargetFile Name
	 * 
	 * save file to disk
	 */
	public static String writetodisk(String parentFileName,File file,String fileName){
		File parentFile = new File(parentFileName);
		File targetFile = null ;
		if(!parentFile.exists()){
			parentFile.mkdirs();
		}try{
			InputStream is = new FileInputStream(file);
			targetFile = new File(parentFileName,fileName);
			OutputStream os = new FileOutputStream(targetFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while(-1 != (length = is.read(buffer))){
				os.write(buffer,0,length);
			}
			is.close();
			os.close() ;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(targetFile == null || !targetFile.exists()){
			return null;
		}
		return targetFile.getName();
	}
	
}
