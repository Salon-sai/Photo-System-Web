/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IThemeDAO;
import saiwei.model.Theme;
import saiwei.service.IThemeService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("themeService")
public class ThemeServiceImpl extends AbstractTemplateService<IThemeDAO, Theme>
		implements IThemeService {

	@Override
	@Resource(name="themeDAO")
	public void setDao(IThemeDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
