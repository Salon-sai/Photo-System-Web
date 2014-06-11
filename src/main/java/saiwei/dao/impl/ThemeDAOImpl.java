/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IThemeDAO;
import saiwei.model.Theme;
import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("themeDAO")
public class ThemeDAOImpl extends BaseDAO<Theme> implements IThemeDAO {

}
