package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_usergroup_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_usergroup_hospital"
 */

public abstract class BaseUserUsergroupHospital  implements Serializable {

	public static String REF = "UserUsergroupHospital";
	public static String PROP_USER = "User";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VALID_UPTO = "ValidUpto";
	public static String PROP_GROUP_HOSPITAL = "GroupHospital";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseUserUsergroupHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserUsergroupHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserUsergroupHospital (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date validUpto;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.UsergroupHospital groupHospital;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: valid_upto
	 */
	public java.util.Date getValidUpto () {
		return validUpto;
	}

	/**
	 * Set the value related to the column: valid_upto
	 * @param validUpto the valid_upto value
	 */
	public void setValidUpto (java.util.Date validUpto) {
		this.validUpto = validUpto;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
	}



	/**
	 * Return the value associated with the column: group_hospital_id
	 */
	public jkt.hms.masters.business.UsergroupHospital getGroupHospital () {
		return groupHospital;
	}

	/**
	 * Set the value related to the column: group_hospital_id
	 * @param groupHospital the group_hospital_id value
	 */
	public void setGroupHospital (jkt.hms.masters.business.UsergroupHospital groupHospital) {
		this.groupHospital = groupHospital;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UserUsergroupHospital)) return false;
		else {
			jkt.hms.masters.business.UserUsergroupHospital userUsergroupHospital = (jkt.hms.masters.business.UserUsergroupHospital) obj;
			if (null == this.getId() || null == userUsergroupHospital.getId()) return false;
			else return (this.getId().equals(userUsergroupHospital.getId()));
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