/**
 * 
 */
package saiwei.dao;

import saiwei.model.Comment;
import common.IDAOTemplate;

/**
 * @author sai
 *
 */
public interface ICommentDAO extends IDAOTemplate<Comment> {

	public void save(Comment transientInstance,String posterId,String recipientId,String postId,String recipentComment_id);
	
}
