/**
 * 
 */
package saiwei.service;

import java.util.List;

import saiwei.bean.PostBean;
import saiwei.dao.IUserDAO;
import saiwei.model.Profile;
import saiwei.model.User;
import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IUserService extends IServiceTemplate<IUserDAO,User> {
	
	public User login(String idNum, String password);
	
	public Profile saveOrupdateProfile(String email,String name,String location,String company,String IdNumber);
	
	public List<PostBean> getOwnPosts(String userId);
	
	public List<PostBean> getOwnPosts(User user);
}
