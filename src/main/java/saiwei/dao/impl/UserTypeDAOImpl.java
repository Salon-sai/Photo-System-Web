/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IUserTypeDAO;
import saiwei.model.UserType;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("userTypeDAO")
public class UserTypeDAOImpl extends BaseDAO<UserType> implements IUserTypeDAO {

}
