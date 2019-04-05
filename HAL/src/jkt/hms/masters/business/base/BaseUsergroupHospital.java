package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the usergroup_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="usergroup_hospital"
 */

public abstract class BaseUsergroupHospital  implements Serializable {

	public static String REF = "UsergroupHospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GROUP = "Group";


	// constructors
	public BaseUsergroupHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsergroupHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.UserGroups group;

	// collections
	private java.util.Set<jkt.hms.masters.business.UsergroupApplications> usergroupApplications;
	private java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications;
	private java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="group_hospital_id"
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



	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.UserGroups getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.UserGroups group) {
		this.group = group;
	}



	/**
	 * Return the value associated with the column: UsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupApplications> getUsergroupApplications () {
		return usergroupApplications;
	}

	/**
	 * Set the value related to the column: UsergroupApplications
	 * @param usergroupApplications the UsergroupApplications value
	 */
	public void setUsergroupApplications (java.util.Set<jkt.hms.masters.business.UsergroupApplications> usergroupApplications) {
		this.usergroupApplications = usergroupApplications;
	}

	public void addToUsergroupApplications (jkt.hms.masters.business.UsergroupApplications usergroupApplications) {
		if (null == getUsergroupApplications()) setUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UsergroupApplications>());
		getUsergroupApplications().add(usergroupApplications);
	}



	/**
	 * Return the value associated with the column: UserUsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> getUserUsergroupApplications () {
		return userUsergroupApplications;
	}

	/**
	 * Set the value related to the column: UserUsergroupApplications
	 * @param userUsergroupApplications the UserUsergroupApplications value
	 */
	public void setUserUsergroupApplications (java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications) {
		this.userUsergroupApplications = userUsergroupApplications;
	}

	public void addToUserUsergroupApplications (jkt.hms.masters.business.UserUsergroupApplication userUsergroupApplication) {
		if (null == getUserUsergroupApplications()) setUserUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupApplication>());
		getUserUsergroupApplications().add(userUsergroupApplication);
	}



	/**
	 * Return the value associated with the column: UserUsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> getUserUsergroupHospitals () {
		return userUsergroupHospitals;
	}

	/**
	 * Set the value related to the column: UserUsergroupHospitals
	 * @param userUsergroupHospitals the UserUsergroupHospitals value
	 */
	public void setUserUsergroupHospitals (java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals) {
		this.userUsergroupHospitals = userUsergroupHospitals;
	}

	public void addToUserUsergroupHospitals (jkt.hms.masters.business.UserUsergroupHospital userUsergroupHospital) {
		if (null == getUserUsergroupHospitals()) setUserUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupHospital>());
		getUserUsergroupHospitals().add(userUsergroupHospital);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UsergroupHospital)) return false;
		else {
			jkt.hms.masters.business.UsergroupHospital usergroupHospital = (jkt.hms.masters.business.UsergroupHospital) obj;
			if (null == this.getId() || null == usergroupHospital.getId()) return false;
			else return (this.getId().equals(usergroupHospital.getId()));
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