/**
 * 
 */
package saiwei.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IUserDAO;
import saiwei.model.User;
import saiwei.service.IUserService;

import commom.AbstractTemplateService;

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

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(User e) {
		// TODO Auto-generated method stub
		super.save(e);
	}
}
