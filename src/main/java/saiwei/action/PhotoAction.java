package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.Photo;
import saiwei.service.IPhotoService;
import common.BaseAction;

/**
 * 
 * @author sai
 *
 */
@Namespace("/photo")
@Action("photoAction")
public class PhotoAction extends BaseAction<Photo,IPhotoService>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
