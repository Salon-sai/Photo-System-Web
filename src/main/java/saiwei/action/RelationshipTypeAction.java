/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.RelationShipType;
import saiwei.service.IRelationShipTypeService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/relationshipType")
@Action("realtionshipTypeAction")
public class RelationshipTypeAction extends
	BaseAction<RelationShipType,IRelationShipTypeService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
