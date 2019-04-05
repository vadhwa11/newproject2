package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the machine_activity table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="machine_activity"
 */

public abstract class BaseMachineActivity implements Serializable {

	public static String REF = "MachineActivity";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ACTIVITY_DATE = "ActivityDate";
	public static String PROP_TIME_OFF = "TimeOff";
	public static String PROP_TIME_ON = "TimeOn";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TOTAL_HRS = "TotalHrs";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_MACHINE = "Machine";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMachineActivity() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMachineActivity(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.util.Date activityDate;
	private java.lang.String timeOn;
	private java.lang.String timeOff;
	private java.lang.String totalHrs;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasLaundryMachine machine;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="entry_id"
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
	 * Return the value associated with the column: activity_date
	 */
	public java.util.Date getActivityDate() {
		return activityDate;
	}

	/**
	 * Set the value related to the column: activity_date
	 * 
	 * @param activityDate
	 *            the activity_date value
	 */
	public void setActivityDate(java.util.Date activityDate) {
		this.activityDate = activityDate;
	}

	/**
	 * Return the value associated with the column: time_on
	 */
	public java.lang.String getTimeOn() {
		return timeOn;
	}

	/**
	 * Set the value related to the column: time_on
	 * 
	 * @param timeOn
	 *            the time_on value
	 */
	public void setTimeOn(java.lang.String timeOn) {
		this.timeOn = timeOn;
	}

	/**
	 * Return the value associated with the column: time_off
	 */
	public java.lang.String getTimeOff() {
		return timeOff;
	}

	/**
	 * Set the value related to the column: time_off
	 * 
	 * @param timeOff
	 *            the time_off value
	 */
	public void setTimeOff(java.lang.String timeOff) {
		this.timeOff = timeOff;
	}

	/**
	 * Return the value associated with the column: total_hrs
	 */
	public java.lang.String getTotalHrs() {
		return totalHrs;
	}

	/**
	 * Set the value related to the column: total_hrs
	 * 
	 * @param totalHrs
	 *            the total_hrs value
	 */
	public void setTotalHrs(java.lang.String totalHrs) {
		this.totalHrs = totalHrs;
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
	 * Return the value associated with the column: machine_id
	 */
	public jkt.hms.masters.business.MasLaundryMachine getMachine() {
		return machine;
	}

	/**
	 * Set the value related to the column: machine_id
	 * 
	 * @param machine
	 *            the machine_id value
	 */
	public void setMachine(jkt.hms.masters.business.MasLaundryMachine machine) {
		this.machine = machine;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MachineActivity))
			return false;
		else {
			jkt.hms.masters.business.MachineActivity machineActivity = (jkt.hms.masters.business.MachineActivity) obj;
			if (null == this.getId() || null == machineActivity.getId())
				return false;
			else
				return (this.getId().equals(machineActivity.getId()));
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