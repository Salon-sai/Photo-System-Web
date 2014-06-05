/**
 * 
 */
package saiwei.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.bean.CommentBean;
import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;
import saiwei.model.User;
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
	
	public Comment save(String content,String posterId,String recipientId,String postId){
		Comment comment = new Comment();
		comment.setPostdate(new Date());
		comment.setContent(content);
		dao.save(comment, posterId, recipientId, postId);
		return comment;
	}

	public Set<CommentBean> getOwnSendComments(User user){
		Set<Comment> comments = user.getSend_comments();
		Set<CommentBean> beans = new HashSet<CommentBean>();
		for(Comment comment : comments){
			CommentBean bean = new CommentBean(comment);
			beans.add(bean);
		}
		return beans;
	}
}
