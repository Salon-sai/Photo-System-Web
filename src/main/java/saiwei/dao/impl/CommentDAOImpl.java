/**
 * 
 */
package saiwei.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;
import saiwei.model.Post;
import saiwei.model.User;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("commentDAO")
public class CommentDAOImpl extends BaseDAO<Comment> implements ICommentDAO {

	/**
	 * 
	 * @param transientInstance
	 * 		comment instance creating in service
	 * @param posterId
	 * 		user posting comment
	 * @param recipientId
	 * 		recipient recipientting comment
	 */
	public void save(Comment transientInstance,String posterId,String recipientId,String postId,String recipentComment_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("IdNumber", posterId);
		User poster = (User)this.uniqueElement(params, USER);
		
		params.clear();
		
		if(recipientId != null){
			params.put("IdNumber", recipientId);
			User recipients = (User)this.uniqueElement(params, USER);
			transientInstance.setRecipients(recipients);
		}
		
		params.clear();
		
		params.put("id", postId);
		Post post = (Post)this.uniqueElement(params, POST);
		Comment recipentComment = null;
		if(recipentComment_id != null){
			recipentComment = this.load(Comment.class, recipentComment_id);
		}
		
		transientInstance.setPost(post);
		transientInstance.setPoster(poster);
		transientInstance.setRecipientComment(recipentComment);
		
		session.save(transientInstance);
	}
	
}
