package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IManagerDAO;
import saiwei.model.Manager;

import common.BaseDAO;
/**
 * 
 * @author sai
 *
 */
@Repository("managerDAO")
public class ManagerDAOImpl extends BaseDAO<Manager> implements IManagerDAO{

}
