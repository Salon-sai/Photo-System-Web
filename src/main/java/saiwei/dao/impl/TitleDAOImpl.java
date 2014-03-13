/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.ITitleDAO;
import saiwei.model.Title;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("titleDAO")
public class TitleDAOImpl extends BaseDAO<Title> implements ITitleDAO {

}
