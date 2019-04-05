package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_leave_type_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_leave_type_master"
 */

public abstract class BaseHrLeaveTypeMaster implements Serializable {

	public static String REF = "HrLeaveTypeMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DETAILS = "Details";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DAYS = "Days";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseHrLeaveTypeMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrLeaveTypeMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String leaveType;
	private java.lang.String details;
	private java.lang.Integer days;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

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
	 * Return the value associated with the column: leave_type
	 */
	public java.lang.String getLeaveType() {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type
	 * 
	 * @param leaveType
	 *            the leave_type value
	 */
	public void setLeaveType(java.lang.String leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * Return the value associated with the column: details
	 */
	public java.lang.String getDetails() {
		return details;
	}

	/**
	 * Set the value related to the column: details
	 * 
	 * @param details
	 *            the details value
	 */
	public void setDetails(java.lang.String details) {
		this.details = details;
	}

	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.Integer getDays() {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * 
	 * @param days
	 *            the days value
	 */
	public void setDays(java.lang.Integer days) {
		this.days = days;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrLeaveTypeMaster))
			return false;
		else {
			jkt.hms.masters.business.HrLeaveTypeMaster hrLeaveTypeMaster = (jkt.hms.masters.business.HrLeaveTypeMaster) obj;
			if (null == this.getId() || null == hrLeaveTypeMaster.getId())
				return false;
			else
				return (this.getId().equals(hrLeaveTypeMaster.getId()));
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