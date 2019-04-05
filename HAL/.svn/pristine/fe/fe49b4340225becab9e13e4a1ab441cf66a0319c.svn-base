package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the usergroup_applications
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="usergroup_applications"
 */

public abstract class BaseUsergroupApplications implements Serializable {

	public static String REF = "UsergroupApplications";
	public static String PROP_STATUS = "Status";
	public static String PROP_APP = "App";
	public static String PROP_GROUP_HOSPITAL = "GroupHospital";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUsergroupApplications() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsergroupApplications(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsergroupApplications(java.lang.Integer id,
			jkt.hms.masters.business.MasApplication app,
			jkt.hms.masters.business.UsergroupHospital groupHospital) {

		this.setId(id);
		this.setApp(app);
		this.setGroupHospital(groupHospital);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasApplication app;
	private jkt.hms.masters.business.UsergroupHospital groupHospital;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: app_id
	 */
	public jkt.hms.masters.business.MasApplication getApp() {
		return app;
	}

	/**
	 * Set the value related to the column: app_id
	 * 
	 * @param app
	 *            the app_id value
	 */
	public void setApp(jkt.hms.masters.business.MasApplication app) {
		this.app = app;
	}

	/**
	 * Return the value associated with the column: group_hospital_id
	 */
	public jkt.hms.masters.business.UsergroupHospital getGroupHospital() {
		return groupHospital;
	}

	/**
	 * Set the value related to the column: group_hospital_id
	 * 
	 * @param groupHospital
	 *            the group_hospital_id value
	 */
	public void setGroupHospital(
			jkt.hms.masters.business.UsergroupHospital groupHospital) {
		this.groupHospital = groupHospital;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UsergroupApplications))
			return false;
		else {
			jkt.hms.masters.business.UsergroupApplications usergroupApplications = (jkt.hms.masters.business.UsergroupApplications) obj;
			if (null == this.getId() || null == usergroupApplications.getId())
				return false;
			else
				return (this.getId().equals(usergroupApplications.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}