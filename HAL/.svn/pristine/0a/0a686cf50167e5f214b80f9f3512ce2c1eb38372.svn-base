package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the major_work_status table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="major_work_status"
 */

public abstract class BaseMajorWorkStatus implements Serializable {

	public static String REF = "MajorWorkStatus";
	public static String PROP_STATUS = "status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_MAJOR_WORK_STATUS_DESCRIPTION = "MajorWorkStatusDescription";
	public static String PROP_MAJOR_WORK_STATUS_MESSAGE = "MajorWorkStatusMessage";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAJOR_WORK_STATUS_OPTIONAL = "MajorWorkStatusOptional";

	// constructors
	public BaseMajorWorkStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMajorWorkStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String majorWorkStatusMessage;
	private java.lang.String majorWorkStatusDescription;
	private java.lang.String majorWorkStatusOptional;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="major_work_status_id"
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
	 * Return the value associated with the column: major_work_status_message
	 */
	public java.lang.String getMajorWorkStatusMessage() {
		return majorWorkStatusMessage;
	}

	/**
	 * Set the value related to the column: major_work_status_message
	 * 
	 * @param majorWorkStatusMessage
	 *            the major_work_status_message value
	 */
	public void setMajorWorkStatusMessage(
			java.lang.String majorWorkStatusMessage) {
		this.majorWorkStatusMessage = majorWorkStatusMessage;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_status_description
	 */
	public java.lang.String getMajorWorkStatusDescription() {
		return majorWorkStatusDescription;
	}

	/**
	 * Set the value related to the column: major_work_status_description
	 * 
	 * @param majorWorkStatusDescription
	 *            the major_work_status_description value
	 */
	public void setMajorWorkStatusDescription(
			java.lang.String majorWorkStatusDescription) {
		this.majorWorkStatusDescription = majorWorkStatusDescription;
	}

	/**
	 * Return the value associated with the column: major_work_status_optional
	 */
	public java.lang.String getMajorWorkStatusOptional() {
		return majorWorkStatusOptional;
	}

	/**
	 * Set the value related to the column: major_work_status_optional
	 * 
	 * @param majorWorkStatusOptional
	 *            the major_work_status_optional value
	 */
	public void setMajorWorkStatusOptional(
			java.lang.String majorWorkStatusOptional) {
		this.majorWorkStatusOptional = majorWorkStatusOptional;
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
		if (!(obj instanceof jkt.hms.masters.business.MajorWorkStatus))
			return false;
		else {
			jkt.hms.masters.business.MajorWorkStatus majorWorkStatus = (jkt.hms.masters.business.MajorWorkStatus) obj;
			if (null == this.getId() || null == majorWorkStatus.getId())
				return false;
			else
				return (this.getId().equals(majorWorkStatus.getId()));
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