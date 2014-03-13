/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.ITagDAO;
import saiwei.model.Tag;
import saiwei.service.ITagService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("tagService")
public class TagServiceImpl extends AbstractTemplateService<ITagDAO, Tag>
		implements ITagService {

	@Resource(name="tagDAO")
	@Override
	public void setDao(ITagDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
