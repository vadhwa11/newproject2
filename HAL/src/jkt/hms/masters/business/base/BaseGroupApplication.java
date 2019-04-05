package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the group_application table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="group_application"
 */

public abstract class BaseGroupApplication implements Serializable {

	public static String REF = "GroupApplication";
	public static String PROP_STATUS = "Status";
	public static String PROP_APP = "App";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";

	// constructors
	public BaseGroupApplication() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGroupApplication(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGroupApplication(java.lang.Integer id,
			jkt.hms.masters.business.MasApplication app,
			jkt.hms.masters.business.UserGroups group) {

		this.setId(id);
		this.setApp(app);
		this.setGroup(group);
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
	private jkt.hms.masters.business.UserGroups group;

	// collections
	private java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="group_app_id"
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
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.UserGroups getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.UserGroups group) {
		this.group = group;
	}

	/**
	 * Return the value associated with the column: UserUsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> getUserUsergroupApplications() {
		return userUsergroupApplications;
	}

	/**
	 * Set the value related to the column: UserUsergroupApplications
	 * 
	 * @param userUsergroupApplications
	 *            the UserUsergroupApplications value
	 */
	public void setUserUsergroupApplications(
			java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications) {
		this.userUsergroupApplications = userUsergroupApplications;
	}

	public void addToUserUsergroupApplications(
			jkt.hms.masters.business.UserUsergroupApplication userUsergroupApplication) {
		if (null == getUserUsergroupApplications())
			setUserUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupApplication>());
		getUserUsergroupApplications().add(userUsergroupApplication);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.GroupApplication))
			return false;
		else {
			jkt.hms.masters.business.GroupApplication groupApplication = (jkt.hms.masters.business.GroupApplication) obj;
			if (null == this.getId() || null == groupApplication.getId())
				return false;
			else
				return (this.getId().equals(groupApplication.getId()));
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