/**
 * 
 */
package saiwei.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import saiwei.model.RelationShip;
import saiwei.model.User;
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
	private String IdNumber;
	private boolean addflag;
	private boolean removeflag;
	
	@Action(value="addfollowing",results={
			@Result(name=SUCCESS,type="json",params={"excludeNullProperties","ture"}),
			@Result(name=INPUT,type="json",params={"excludeNullProperties","ture"})
	})
	public String addfollow(){
		User user = (User)session.get("user");
		addflag = service.addrelationship(user.getIdNumber(), IdNumber, "following");
		return addflag ? SUCCESS : INPUT;
	}
	
	@Action(value="removefollowing",results={
			@Result(name=SUCCESS,type="json",params={"excludeNullProperties","ture"}),
			@Result(name=INPUT,type="json",params={"excludeNullProperties","ture"})
	})
	public String removefollow(){
		User user = (User)session.get("user");
		removeflag = service.deleteUserRelationship(user, IdNumber);
		return SUCCESS;
	}
	
	@Override
	@Resource(name="relationshipService")
	public void setService(IRelationShipService service) {
		// TODO Auto-generated method stub
		super.setService(service);
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	public boolean isAddflag() {
		return addflag;
	}
	public boolean isRemoveflag() {
		return removeflag;
	}
}
