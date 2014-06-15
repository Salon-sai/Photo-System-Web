/**
 * 
 */
package saiwei.dao;

import java.util.Map;

import saiwei.model.Profile;
import saiwei.model.User;
import common.IDAOTemplate;

/**
 * @author sai
 *
 */
public interface IUserDAO extends IDAOTemplate<User> {

	public Profile updateProfileByUser(Map<String, Object> params,User user);
}
