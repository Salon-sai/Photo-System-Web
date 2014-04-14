/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IProfileDAO;
import saiwei.model.Profile;
import saiwei.service.IProfileService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("profileService")
public class ProfileServiceImpl extends
		AbstractTemplateService<IProfileDAO, Profile> implements IProfileService {

	@Resource(name="profileDAO")
	@Override
	public void setDao(IProfileDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}

	public String fitheadPhoto(String imagePath,String userId){
		return null;
	}
}
