/**
 * 
 */
package saiwei.service;

import java.util.Set;

import saiwei.dao.IPostDAO;
import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.model.User;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface IPostService extends IServiceTemplate<IPostDAO, Post> {
	
	public void save(Post post,User poster,Set<Photo> photos);
	
}
