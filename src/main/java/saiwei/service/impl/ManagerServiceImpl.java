/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IManagerDAO;
import saiwei.model.Manager;
import saiwei.service.IManagerService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("managerDAO")
public class ManagerServiceImpl extends
		AbstractTemplateService<IManagerDAO, Manager> implements IManagerService {

	@Resource(name="managerDAO")
	@Override
	public void setDao(IManagerDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}

}
