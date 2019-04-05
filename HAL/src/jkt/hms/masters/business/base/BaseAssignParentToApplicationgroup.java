package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the assign_parent_to_applicationgroup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="assign_parent_to_applicationgroup"
 */

public abstract class BaseAssignParentToApplicationgroup  implements Serializable {

	public static String REF = "AssignParentToApplicationgroup";
	public static String PROP_APP = "App";
	public static String PROP_ID = "Id";
	public static String PROP_APPLICATIONGROUP = "Applicationgroup";


	// constructors
	public BaseAssignParentToApplicationgroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAssignParentToApplicationgroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasApplication app;
	private jkt.hms.masters.business.MasApplicationgroup applicationgroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: app_id
	 */
	public jkt.hms.masters.business.MasApplication getApp () {
		return app;
	}

	/**
	 * Set the value related to the column: app_id
	 * @param app the app_id value
	 */
	public void setApp (jkt.hms.masters.business.MasApplication app) {
		this.app = app;
	}



	/**
	 * Return the value associated with the column: applicationGroup_id
	 */
	public jkt.hms.masters.business.MasApplicationgroup getApplicationgroup () {
		return applicationgroup;
	}

	/**
	 * Set the value related to the column: applicationGroup_id
	 * @param applicationgroup the applicationGroup_id value
	 */
	public void setApplicationgroup (jkt.hms.masters.business.MasApplicationgroup applicationgroup) {
		this.applicationgroup = applicationgroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AssignParentToApplicationgroup)) return false;
		else {
			jkt.hms.masters.business.AssignParentToApplicationgroup assignParentToApplicationgroup = (jkt.hms.masters.business.AssignParentToApplicationgroup) obj;
			if (null == this.getId() || null == assignParentToApplicationgroup.getId()) return false;
			else return (this.getId().equals(assignParentToApplicationgroup.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}