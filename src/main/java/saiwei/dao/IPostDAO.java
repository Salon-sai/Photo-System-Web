/**
 * 
 */
package saiwei.dao;

import saiwei.model.Post;

import common.IDAOTemplate;

/**
 * @author sai
 *
 */
public interface IPostDAO extends IDAOTemplate<Post> {

	public void save(String posterId,Post post);
	
	public boolean saveLikePost(String userNum,String postId);
	
	public boolean removeLikePost(String userNum,String postId);
}
