/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IPostDAO;
import saiwei.model.Post;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("postDAO")
public class PostDAOImpl extends BaseDAO<Post> implements IPostDAO {

}
