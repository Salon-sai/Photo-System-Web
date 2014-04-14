/**
 * 
 */
package saiwei.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;
import saiwei.service.ICommentService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
@Service("commentService")
public class CommentServiceImpl extends
		AbstractTemplateService<ICommentDAO, Comment> implements
		ICommentService {

	@Override
	@Resource(name="commentDAO")
	public void setDao(ICommentDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	public void save(String content,String posterId,String recipientId,String postId){
		Comment comment = new Comment();
		comment.setPostdate(new Date());
		comment.setContent(content);
		dao.save(comment, posterId, recipientId, postId);
	}

}
