/**
 * 
 */
package saiwei.service;

import java.util.Set;

import saiwei.dao.IPostDAO;
import saiwei.model.Photo;
import saiwei.model.Post;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IPostService extends IServiceTemplate<IPostDAO, Post> {
	
	public void save(Post post,String posterId,Set<Photo> photos);
	
	public boolean deletePost(String postId);
}
