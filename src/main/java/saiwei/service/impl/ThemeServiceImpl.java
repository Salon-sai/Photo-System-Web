/**
 * 
 */
package saiwei.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import saiwei.dao.IThemeDAO;
import saiwei.model.Theme;
import saiwei.service.IThemeService;
import common.AbstractTemplateService;
import common.factory.OSInfo;
import common.factory.WriteToDiskFactory;

/**
 * @author sai
 *
 */
@Service("themeService")
public class ThemeServiceImpl extends AbstractTemplateService<IThemeDAO, Theme>
		implements IThemeService {
	
	private static final Logger logger = Logger.getLogger(ThemeServiceImpl.class);
	
	private static final String THEME_WIN_PATH = "";	
	private static final String THEME_LINUX_PATH = "";
	
	/**
	 * 
	 * @param theme_file
	 * @param fileName
	 * @return
	 */
	public boolean save(File theme_file,String fileName){
		boolean flag = false;
		try{
			Theme theme = new Theme();
			String filePath = this.saveToDisk(theme_file, fileName);
			theme.setHome_page_url(filePath);
			this.dao.save(theme);
			flag = true;
		}catch(Exception e){
			logger.error("fail to save theme", e);
		}
		return flag;
	}
	
	/**
	 * 
	 * @param file
	 * @param fileName
	 * @return
	 */
	public String saveToDisk(File file,String fileName){
		String filePath = null;
		if(OSInfo.isLinux()){
			filePath = WriteToDiskFactory.writetodisk(THEME_LINUX_PATH, file, fileName);
		}else if(OSInfo.isWindows()){
			filePath = WriteToDiskFactory.writetodisk(THEME_WIN_PATH, file, fileName);
		}
		return filePath;
	}

	@Override
	@Resource(name="themeDAO")
	public void setDao(IThemeDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
