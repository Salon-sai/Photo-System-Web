/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IUserDAO;
import saiwei.model.User;

import commom.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {
	
}
