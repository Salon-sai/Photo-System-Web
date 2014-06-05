/**
 * 
 */
package saiwei.service;

import java.util.Set;

import saiwei.bean.CommentBean;
import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;
import saiwei.model.User;
import common.IServiceTemplate;

/**
 * @author sai
 *
 */
public interface ICommentService extends IServiceTemplate<ICommentDAO, Comment> {

	public Comment save(String content,String posterId,String recipientId,String postId);
	
	public Set<CommentBean> getOwnSendComments(User user);
}
