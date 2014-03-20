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

	@Override
	@Resource(name="userDAO")
	public void setDao(IUserDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	public User login(String idNum, String password){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IdNumber", idNum);
		//change to MD5
		params.put("password", MD5Factory.getMD5(password.getBytes()));
		List<User> list = (List<User>)this.findByProperties(params, User.class);
		if(list.isEmpty() || list == null)
			return null;
		else
			return list.get(0);
	}
}
