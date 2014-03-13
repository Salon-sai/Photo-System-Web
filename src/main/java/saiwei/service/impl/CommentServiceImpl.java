/**
 * 
 */
package saiwei.service.impl;

import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;
import saiwei.service.ICommentService;

import common.AbstractTemplateService;

/**
 * @author sai
 *
 */
public class CommentServiceImpl extends
		AbstractTemplateService<ICommentDAO, Comment> implements
		ICommentService {

	@Override
	public void setDao(ICommentDAO dao) {
		// TODO Auto-generated method stub
		
	}

}
