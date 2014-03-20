package common.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class WriteToDiskFactory {
	
	public static String writetodisk(String parentFileName,File file){
		File parentFile = new File(parentFileName);
		if(!parentFile.exists()){
			parentFile.mkdirs();
		}try{
			InputStream is = new FileInputStream(file);
			File targetFile = new File(parentFileName,file.getName());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}
