/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IUserTypeDAO;
import saiwei.model.UserType;
import saiwei.service.IUserTypeService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("userTypeService")
public class UserTypeServiceImpl extends
		AbstractTemplateService<IUserTypeDAO, UserType> implements
		IUserTypeService {
	
	@Resource(name="userTypeDAO")
	@Override
	public void setDao(IUserTypeDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
}
