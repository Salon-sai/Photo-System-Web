/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.ITagDAO;
import saiwei.model.Tag;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("tagDAO")
public class TagDAOImpl extends BaseDAO<Tag> implements ITagDAO {

}
