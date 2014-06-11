/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Theme;
import saiwei.service.IThemeService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/theme")
public class ThemeAction extends BaseAction<Theme, IThemeService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
