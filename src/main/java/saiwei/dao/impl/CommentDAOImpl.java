/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.ICommentDAO;
import saiwei.model.Comment;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("commentDAO")
public class CommentDAOImpl extends BaseDAO<Comment> implements ICommentDAO {

}
