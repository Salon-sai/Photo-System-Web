/**
 * 
 */
package saiwei.service;

import java.util.Set;

import saiwei.bean.CommentBean;
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

	public boolean saveLikePost(String userNum,String postId);
	
	public boolean deleteLikePost(String userNum,String postId);

	public boolean deleteCollectPost(String userNum,String postId);
	
	public boolean saveCollectPost(String userNum,String postId);

	public Set<CommentBean> getCommentsByPost(String postId);
}
