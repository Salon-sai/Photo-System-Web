/**
 * 
 */
package saiwei.dao.impl;

import org.springframework.stereotype.Repository;

import saiwei.dao.IPhotoDAO;
import saiwei.model.Photo;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("photoDAO")
public class PhotoDAOImpl extends BaseDAO<Photo> implements IPhotoDAO {


	
}
