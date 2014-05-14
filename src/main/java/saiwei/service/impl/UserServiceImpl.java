/**
 * 
 */
package saiwei.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IUserDAO;
import saiwei.model.Profile;
import saiwei.model.User;
import saiwei.service.IUserService;

import common.AbstractTemplateService;
import common.factory.MD5Factory;

/**
 * @author sai
 *
 */
@Service("userService")
public class UserServiceImpl extends AbstractTemplateService<IUserDAO, User>
		implements IUserService {

//	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	@Resource(name="userDAO")
	public void setDao(IUserDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	public User login(String idNum, String password){
		Map<String, Object> params = new HashMap<String, Object>();
		User user ;
		params.put("IdNumber", idNum);
		//change to MD5
		params.put("password", MD5Factory.getMD5(password.getBytes()));
		List<User> list = (List<User>)this.findByProperties(params, User.class);
		if(list.isEmpty() || list == null){
			return null;
		}else{
			user = list.get(0);
			user.setCollect_posts(null);
			user.setFavorite_posts(null);
			user.setFound_relationship(null);
			user.setLinked_relationship(null);
			user.setOwn_posts(null);
			user.setTags(null);
			user.setReceive_comments(null);
			user.setSend_comments(null);
			user.setProfile(null);
		}
		return user;
	}
	
	
	public Profile saveOrupdateProfile(String email,String name,String location,String company,String IdNumber){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("e_mail", email);
		params.put("name", name);
		params.put("location", location);
		params.put("company", company);
		return dao.updateProfileByUser(params, IdNumber);
	}
	

}
