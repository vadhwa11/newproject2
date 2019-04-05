package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the user_groups table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="user_groups"
 */

public abstract class BaseUserGroups implements Serializable {

	public static String REF = "UserGroups";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CODE = "Code";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUserGroups() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserGroups(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupName;
	private java.lang.String status;
	private java.lang.String code;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.GroupApplication> groupApplications;
	private java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals;
	private java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="group_id"
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
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getGroupName() {
		return groupName;
	}

	/**
	 * Set the value related to the column: group_name
	 * 
	 * @param groupName
	 *            the group_name value
	 */
	public void setGroupName(java.lang.String groupName) {
		this.groupName = groupName;
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
	 * Return the value associated with the column: code
	 */
	public java.lang.String getCode() {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * 
	 * @param code
	 *            the code value
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: GroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.GroupApplication> getGroupApplications() {
		return groupApplications;
	}

	/**
	 * Set the value related to the column: GroupApplications
	 * 
	 * @param groupApplications
	 *            the GroupApplications value
	 */
	public void setGroupApplications(
			java.util.Set<jkt.hms.masters.business.GroupApplication> groupApplications) {
		this.groupApplications = groupApplications;
	}

	public void addToGroupApplications(
			jkt.hms.masters.business.GroupApplication groupApplication) {
		if (null == getGroupApplications())
			setGroupApplications(new java.util.TreeSet<jkt.hms.masters.business.GroupApplication>());
		getGroupApplications().add(groupApplication);
	}

	/**
	 * Return the value associated with the column: UsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupHospital> getUsergroupHospitals() {
		return usergroupHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupHospitals
	 * 
	 * @param usergroupHospitals
	 *            the UsergroupHospitals value
	 */
	public void setUsergroupHospitals(
			java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals) {
		this.usergroupHospitals = usergroupHospitals;
	}

	public void addToUsergroupHospitals(
			jkt.hms.masters.business.UsergroupHospital usergroupHospital) {
		if (null == getUsergroupHospitals())
			setUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupHospital>());
		getUsergroupHospitals().add(usergroupHospital);
	}

	/**
	 * Return the value associated with the column:
	 * UsergroupAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> getUsergroupAccessrightsHospitals() {
		return usergroupAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupAccessrightsHospitals
	 * 
	 * @param usergroupAccessrightsHospitals
	 *            the UsergroupAccessrightsHospitals value
	 */
	public void setUsergroupAccessrightsHospitals(
			java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals) {
		this.usergroupAccessrightsHospitals = usergroupAccessrightsHospitals;
	}

	public void addToUsergroupAccessrightsHospitals(
			jkt.hms.masters.business.UsergroupAccessrightsHospital usergroupAccessrightsHospital) {
		if (null == getUsergroupAccessrightsHospitals())
			setUsergroupAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupAccessrightsHospital>());
		getUsergroupAccessrightsHospitals().add(usergroupAccessrightsHospital);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserGroups))
			return false;
		else {
			jkt.hms.masters.business.UserGroups userGroups = (jkt.hms.masters.business.UserGroups) obj;
			if (null == this.getId() || null == userGroups.getId())
				return false;
			else
				return (this.getId().equals(userGroups.getId()));
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