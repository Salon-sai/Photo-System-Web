/**
 * 
 */
package saiwei.service;

import saiwei.dao.IUserDAO;
import saiwei.model.User;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IUserService extends IServiceTemplate<IUserDAO,User> {
	
	public User login(String idNum, String password);
	
	public boolean saveOrupdateProfile(String email,String name,String location,String company,String IdNumber);
	
}
