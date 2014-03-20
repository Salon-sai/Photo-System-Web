/**
 * 
 */
package saiwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IPostDAO;
import saiwei.model.Post;
import saiwei.service.IPostService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("postService")
public class PostServiceImpl extends
		AbstractTemplateService<IPostDAO, Post> implements IPostService {

	@Resource(name="postDAO")
	@Override
	public void setDao(IPostDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	@Override
	public void save(Post post) {
		// TODO Auto-generated method stub
		super.save(post);
	}
}
