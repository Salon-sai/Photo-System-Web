/**
 * 
 */
package saiwei.service;

import java.util.List;
import java.util.Map;

import saiwei.dao.IUserDAO;
import saiwei.model.User;
import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IUserService extends IServiceTemplate<IUserDAO,User> {
	
	public List<?> findByProperties(Map<String,Object> params,Class<?> classType);
	
}
