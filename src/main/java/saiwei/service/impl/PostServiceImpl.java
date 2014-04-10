/**
 * 
 */
package saiwei.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.IPostDAO;
import saiwei.model.Photo;
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
	
	/**
	 * user save the post with photos
	 * 
	 * @param post
	 * @param poster
	 * @param photos
	 */
	public void save(Post post,String posterId,Set<Photo> photos) {
		// TODO Auto-generated method stub
		post.setPhotos(photos);
		post.setPostdate(new Date());
		dao.save(posterId, post);
	}
	
	public List<Post> findPostByUserFollowing(){
		
		return null;
	}
	
}
