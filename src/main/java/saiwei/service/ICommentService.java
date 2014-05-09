/**
 * 
 */
package saiwei.service;

import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;

import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface ICommentService extends IServiceTemplate<ICommentDAO, Comment> {

	public Comment save(String content,String posterId,String recipientId,String postId);
	
}
