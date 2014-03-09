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
@Table(name="tag",catalog="photosystem")
public class Tag extends BaseModelHasName {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
