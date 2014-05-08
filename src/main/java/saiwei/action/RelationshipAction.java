/**
 * 
 */
package saiwei.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import saiwei.model.RelationShip;
import saiwei.service.IRelationShipService;
import common.BaseAction;

/**
 * @author sai
 *
 */
@Namespace("/relationship")
@Action("relationshipAction")
public class RelationshipAction extends
	BaseAction<RelationShip,IRelationShipService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
