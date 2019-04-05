package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the group_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="group_master"
 */

public abstract class BaseGroupMaster  implements Serializable {

	public static String REF = "GroupMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_GROUP_CODE = "GroupCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RETIREMENT_AGE = "RetirementAge";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseGroupMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGroupMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupCode;
	private java.lang.String groupName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer retirementAge;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDesignation> masDesignations;



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
	 * Return the value associated with the column: group_code
	 */
	public java.lang.String getGroupCode () {
		return groupCode;
	}

	/**
	 * Set the value related to the column: group_code
	 * @param groupCode the group_code value
	 */
	public void setGroupCode (java.lang.String groupCode) {
		this.groupCode = groupCode;
	}



	/**
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getGroupName () {
		return groupName;
	}

	/**
	 * Set the value related to the column: group_name
	 * @param groupName the group_name value
	 */
	public void setGroupName (java.lang.String groupName) {
		this.groupName = groupName;
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
	 * Return the value associated with the column: retirement_age
	 */
	public java.lang.Integer getRetirementAge () {
		return retirementAge;
	}

	/**
	 * Set the value related to the column: retirement_age
	 * @param retirementAge the retirement_age value
	 */
	public void setRetirementAge (java.lang.Integer retirementAge) {
		this.retirementAge = retirementAge;
	}



	/**
	 * Return the value associated with the column: MasDesignations
	 */
	public java.util.Set<jkt.hms.masters.business.MasDesignation> getMasDesignations () {
		return masDesignations;
	}

	/**
	 * Set the value related to the column: MasDesignations
	 * @param masDesignations the MasDesignations value
	 */
	public void setMasDesignations (java.util.Set<jkt.hms.masters.business.MasDesignation> masDesignations) {
		this.masDesignations = masDesignations;
	}

	public void addToMasDesignations (jkt.hms.masters.business.MasDesignation masDesignation) {
		if (null == getMasDesignations()) setMasDesignations(new java.util.TreeSet<jkt.hms.masters.business.MasDesignation>());
		getMasDesignations().add(masDesignation);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.GroupMaster)) return false;
		else {
			jkt.hms.masters.business.GroupMaster groupMaster = (jkt.hms.masters.business.GroupMaster) obj;
			if (null == this.getId() || null == groupMaster.getId()) return false;
			else return (this.getId().equals(groupMaster.getId()));
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