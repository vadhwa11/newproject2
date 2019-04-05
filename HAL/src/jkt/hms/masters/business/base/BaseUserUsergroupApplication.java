package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * user_usergroup_application table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="user_usergroup_application"
 */

public abstract class BaseUserUsergroupApplication implements Serializable {

	public static String REF = "UserUsergroupApplication";
	public static String PROP_USER = "User";
	public static String PROP_STATUS = "Status";
	public static String PROP_GROUP_HOSPITAL = "GroupHospital";
	public static String PROP_UPDATE_STATUS = "UpdateStatus";
	public static String PROP_GROUP_APP = "GroupApp";
	public static String PROP_DELETE_STATUS = "DeleteStatus";
	public static String PROP_ID = "Id";
	public static String PROP_ADD_STATUS = "AddStatus";

	// constructors
	public BaseUserUsergroupApplication() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserUsergroupApplication(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserUsergroupApplication(java.lang.Integer id,
			jkt.hms.masters.business.Users user,
			jkt.hms.masters.business.UsergroupHospital groupHospital) {

		this.setId(id);
		this.setUser(user);
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
	private java.lang.String addStatus;
	private java.lang.String updateStatus;
	private java.lang.String deleteStatus;

	// many to one
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.UsergroupHospital groupHospital;
	private jkt.hms.masters.business.GroupApplication groupApp;

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
	 * Return the value associated with the column: add_status
	 */
	public java.lang.String getAddStatus() {
		return addStatus;
	}

	/**
	 * Set the value related to the column: add_status
	 * 
	 * @param addStatus
	 *            the add_status value
	 */
	public void setAddStatus(java.lang.String addStatus) {
		this.addStatus = addStatus;
	}

	/**
	 * Return the value associated with the column: update_status
	 */
	public java.lang.String getUpdateStatus() {
		return updateStatus;
	}

	/**
	 * Set the value related to the column: update_status
	 * 
	 * @param updateStatus
	 *            the update_status value
	 */
	public void setUpdateStatus(java.lang.String updateStatus) {
		this.updateStatus = updateStatus;
	}

	/**
	 * Return the value associated with the column: delete_status
	 */
	public java.lang.String getDeleteStatus() {
		return deleteStatus;
	}

	/**
	 * Set the value related to the column: delete_status
	 * 
	 * @param deleteStatus
	 *            the delete_status value
	 */
	public void setDeleteStatus(java.lang.String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser() {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * 
	 * @param user
	 *            the user_id value
	 */
	public void setUser(jkt.hms.masters.business.Users user) {
		this.user = user;
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

	/**
	 * Return the value associated with the column: group_app_id
	 */
	public jkt.hms.masters.business.GroupApplication getGroupApp() {
		return groupApp;
	}

	/**
	 * Set the value related to the column: group_app_id
	 * 
	 * @param groupApp
	 *            the group_app_id value
	 */
	public void setGroupApp(jkt.hms.masters.business.GroupApplication groupApp) {
		this.groupApp = groupApp;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserUsergroupApplication))
			return false;
		else {
			jkt.hms.masters.business.UserUsergroupApplication userUsergroupApplication = (jkt.hms.masters.business.UserUsergroupApplication) obj;
			if (null == this.getId()
					|| null == userUsergroupApplication.getId())
				return false;
			else
				return (this.getId().equals(userUsergroupApplication.getId()));
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