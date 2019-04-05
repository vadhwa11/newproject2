package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the leave_restriction_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="leave_restriction_entry"
 */

public abstract class BaseLeaveRestrictionEntry implements Serializable {

	public static String REF = "LeaveRestrictionEntry";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_MAX_LEAVE_DAYS = "MaxLeaveDays";
	public static String PROP_TO_PERIOD = "ToPeriod";
	public static String PROP_FROM_PERIOD = "FromPeriod";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_ID = "Id";
	public static String PROP_LEAVE = "Leave";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseLeaveRestrictionEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeaveRestrictionEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLeaveRestrictionEntry(java.lang.Integer id,
			java.util.Date entryDate, java.util.Date fromPeriod,
			java.util.Date toPeriod, java.lang.Integer maxLeaveDays,
			java.lang.String lastChangedBy, java.util.Date lastChangedDate,
			java.lang.String status, java.lang.String entryNo) {

		this.setId(id);
		this.setEntryDate(entryDate);
		this.setFromPeriod(fromPeriod);
		this.setToPeriod(toPeriod);
		this.setMaxLeaveDays(maxLeaveDays);
		this.setLastChangedBy(lastChangedBy);
		this.setLastChangedDate(lastChangedDate);
		this.setStatus(status);
		this.setEntryNo(entryNo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.util.Date fromPeriod;
	private java.util.Date toPeriod;
	private java.lang.Integer maxLeaveDays;
	private java.lang.String remarks;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String status;
	private java.lang.String entryNo;

	// many to one
	private jkt.hms.masters.business.HrLeaveTypeMaster leave;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="leave_restriction_id"
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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: from_period
	 */
	public java.util.Date getFromPeriod() {
		return fromPeriod;
	}

	/**
	 * Set the value related to the column: from_period
	 * 
	 * @param fromPeriod
	 *            the from_period value
	 */
	public void setFromPeriod(java.util.Date fromPeriod) {
		this.fromPeriod = fromPeriod;
	}

	/**
	 * Return the value associated with the column: to_period
	 */
	public java.util.Date getToPeriod() {
		return toPeriod;
	}

	/**
	 * Set the value related to the column: to_period
	 * 
	 * @param toPeriod
	 *            the to_period value
	 */
	public void setToPeriod(java.util.Date toPeriod) {
		this.toPeriod = toPeriod;
	}

	/**
	 * Return the value associated with the column: max_leave_days
	 */
	public java.lang.Integer getMaxLeaveDays() {
		return maxLeaveDays;
	}

	/**
	 * Set the value related to the column: max_leave_days
	 * 
	 * @param maxLeaveDays
	 *            the max_leave_days value
	 */
	public void setMaxLeaveDays(java.lang.Integer maxLeaveDays) {
		this.maxLeaveDays = maxLeaveDays;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: leave_id
	 */
	public jkt.hms.masters.business.HrLeaveTypeMaster getLeave() {
		return leave;
	}

	/**
	 * Set the value related to the column: leave_id
	 * 
	 * @param leave
	 *            the leave_id value
	 */
	public void setLeave(jkt.hms.masters.business.HrLeaveTypeMaster leave) {
		this.leave = leave;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LeaveRestrictionEntry))
			return false;
		else {
			jkt.hms.masters.business.LeaveRestrictionEntry leaveRestrictionEntry = (jkt.hms.masters.business.LeaveRestrictionEntry) obj;
			if (null == this.getId() || null == leaveRestrictionEntry.getId())
				return false;
			else
				return (this.getId().equals(leaveRestrictionEntry.getId()));
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