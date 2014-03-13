/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.ITitleDAO;
import saiwei.model.Title;
import saiwei.service.ITitleService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("titleService")
public class TitleServiceImpl extends AbstractTemplateService<ITitleDAO, Title>
		implements ITitleService {

	@Resource(name="titleDAO")
	@Override
	public void setDao(ITitleDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
}
