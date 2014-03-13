/**
 * 
 */
package saiwei.service.impl;

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

}
