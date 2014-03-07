/**
 * 
 */
package saiwei.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import common.BaseModelHasName;

/**
 * @author sai
 *
 */
@Entity
@Table(name="user-type",catalog="photosystem")
public class UserType extends BaseModelHasName {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
