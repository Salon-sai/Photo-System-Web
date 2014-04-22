/**
 * 
 */
package saiwei.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
	
	private static final Class<?> classType = Post.class;
	
	private static final Logger logger = Logger.getLogger(PostServiceImpl.class);

	@Resource(name="postDAO")
	@Override
	public void setDao(IPostDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	/**
	 * 		user save the post with photos.In the function, submitted post should
	 * have context.
	 * 
	 * @param post
	 * @param poster
	 * @param photos
	 */
	public void save(Post post,String posterId,Set<Photo> photos) {
		// TODO Auto-generated method stub
		post.setPhotos(photos);
		for(Photo photo : photos){
			photo.setPost(post);
		}
		post.setPostdate(new Date());
		dao.save(posterId, post);
	}
	
	public List<Post> findPostByUserFollowing(){
		
		return null;
	}
	
	/**
	 * delete post and delete photos of this post 
	 * @param postId
	 * @return
	 */
	public boolean deletePost(String postId){
		boolean flag = false ;
		Post post = dao.findById(postId, classType);
		flag = PhotoServiceImpl.deletePhotosInDisk(post.getPhotos());
		try{
			dao.delete(post);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("cannot delete in database",e);
			flag = false;
		}
		return flag ;
	}
	
	/**
	 * 
	 * @param userNum
	 * @param postId
	 * @return
	 */
	public boolean saveLikePost(String userNum,String postId){
		return dao.saveLikePost(userNum, postId);
	}
	
	/**
	 * 
	 * @param userNum
	 * @param postId
	 * @return
	 */
	public boolean deleteLikePost(String userNum,String postId){
		return dao.removeLikePost(userNum, postId);
	}
}
