package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_duty_time_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_duty_time_master"
 */

public abstract class BaseHrDutyTimeMaster implements Serializable {

	public static String REF = "HrDutyTimeMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_DUTY_SHIFT_TYPE = "DutyShiftType";
	public static String PROP_DUTY_NAME = "DutyName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DUTY_TO_TIME = "DutyToTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DUTY = "Duty";
	public static String PROP_ID = "Id";
	public static String PROP_DUTY_FROM_TIME = "DutyFromTime";
	public static String PROP_DUTY_CODE = "DutyCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VALID_ON = "ValidOn";

	// constructors
	public BaseHrDutyTimeMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrDutyTimeMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dutyCode;
	private java.lang.String dutyFromTime;
	private java.lang.String dutyToTime;
	private java.lang.String dutyName;
	private java.lang.String dutyShiftType;
	private java.lang.String validOn;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.HrDutyMaster duty;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrOrderlyDutyEntry> hrOrderlyDutyEntries;
	private java.util.Set<jkt.hms.masters.business.HrDutyEntry> hrDutyEntries;
	private java.util.Set<jkt.hms.masters.business.HrGuardDutyEntry> hrGuardDutyEntries;
	private java.util.Set<jkt.hms.masters.business.HrWardDutyEntry> hrWardDutyEntries;
	private java.util.Set<jkt.hms.masters.business.HrDailyRoutineDutyEntry> hrDailyRoutineDutyEntries;

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
	 * Return the value associated with the column: duty_code
	 */
	public java.lang.String getDutyCode() {
		return dutyCode;
	}

	/**
	 * Set the value related to the column: duty_code
	 * 
	 * @param dutyCode
	 *            the duty_code value
	 */
	public void setDutyCode(java.lang.String dutyCode) {
		this.dutyCode = dutyCode;
	}

	/**
	 * Return the value associated with the column: duty_from_time
	 */
	public java.lang.String getDutyFromTime() {
		return dutyFromTime;
	}

	/**
	 * Set the value related to the column: duty_from_time
	 * 
	 * @param dutyFromTime
	 *            the duty_from_time value
	 */
	public void setDutyFromTime(java.lang.String dutyFromTime) {
		this.dutyFromTime = dutyFromTime;
	}

	/**
	 * Return the value associated with the column: duty_to_time
	 */
	public java.lang.String getDutyToTime() {
		return dutyToTime;
	}

	/**
	 * Set the value related to the column: duty_to_time
	 * 
	 * @param dutyToTime
	 *            the duty_to_time value
	 */
	public void setDutyToTime(java.lang.String dutyToTime) {
		this.dutyToTime = dutyToTime;
	}

	/**
	 * Return the value associated with the column: duty_name
	 */
	public java.lang.String getDutyName() {
		return dutyName;
	}

	/**
	 * Set the value related to the column: duty_name
	 * 
	 * @param dutyName
	 *            the duty_name value
	 */
	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	/**
	 * Return the value associated with the column: duty_shift_type
	 */
	public java.lang.String getDutyShiftType() {
		return dutyShiftType;
	}

	/**
	 * Set the value related to the column: duty_shift_type
	 * 
	 * @param dutyShiftType
	 *            the duty_shift_type value
	 */
	public void setDutyShiftType(java.lang.String dutyShiftType) {
		this.dutyShiftType = dutyShiftType;
	}

	/**
	 * Return the value associated with the column: valid_on
	 */
	public java.lang.String getValidOn() {
		return validOn;
	}

	/**
	 * Set the value related to the column: valid_on
	 * 
	 * @param validOn
	 *            the valid_on value
	 */
	public void setValidOn(java.lang.String validOn) {
		this.validOn = validOn;
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
	 * Return the value associated with the column: duty_id
	 */
	public jkt.hms.masters.business.HrDutyMaster getDuty() {
		return duty;
	}

	/**
	 * Set the value related to the column: duty_id
	 * 
	 * @param duty
	 *            the duty_id value
	 */
	public void setDuty(jkt.hms.masters.business.HrDutyMaster duty) {
		this.duty = duty;
	}

	/**
	 * Return the value associated with the column: HrOrderlyDutyEntries
	 */
	public java.util.Set<jkt.hms.masters.business.HrOrderlyDutyEntry> getHrOrderlyDutyEntries() {
		return hrOrderlyDutyEntries;
	}

	/**
	 * Set the value related to the column: HrOrderlyDutyEntries
	 * 
	 * @param hrOrderlyDutyEntries
	 *            the HrOrderlyDutyEntries value
	 */
	public void setHrOrderlyDutyEntries(
			java.util.Set<jkt.hms.masters.business.HrOrderlyDutyEntry> hrOrderlyDutyEntries) {
		this.hrOrderlyDutyEntries = hrOrderlyDutyEntries;
	}

	public void addToHrOrderlyDutyEntries(
			jkt.hms.masters.business.HrOrderlyDutyEntry hrOrderlyDutyEntry) {
		if (null == getHrOrderlyDutyEntries())
			setHrOrderlyDutyEntries(new java.util.TreeSet<jkt.hms.masters.business.HrOrderlyDutyEntry>());
		getHrOrderlyDutyEntries().add(hrOrderlyDutyEntry);
	}

	/**
	 * Return the value associated with the column: HrDutyEntries
	 */
	public java.util.Set<jkt.hms.masters.business.HrDutyEntry> getHrDutyEntries() {
		return hrDutyEntries;
	}

	/**
	 * Set the value related to the column: HrDutyEntries
	 * 
	 * @param hrDutyEntries
	 *            the HrDutyEntries value
	 */
	public void setHrDutyEntries(
			java.util.Set<jkt.hms.masters.business.HrDutyEntry> hrDutyEntries) {
		this.hrDutyEntries = hrDutyEntries;
	}

	public void addToHrDutyEntries(
			jkt.hms.masters.business.HrDutyEntry hrDutyEntry) {
		if (null == getHrDutyEntries())
			setHrDutyEntries(new java.util.TreeSet<jkt.hms.masters.business.HrDutyEntry>());
		getHrDutyEntries().add(hrDutyEntry);
	}

	/**
	 * Return the value associated with the column: HrGuardDutyEntries
	 */
	public java.util.Set<jkt.hms.masters.business.HrGuardDutyEntry> getHrGuardDutyEntries() {
		return hrGuardDutyEntries;
	}

	/**
	 * Set the value related to the column: HrGuardDutyEntries
	 * 
	 * @param hrGuardDutyEntries
	 *            the HrGuardDutyEntries value
	 */
	public void setHrGuardDutyEntries(
			java.util.Set<jkt.hms.masters.business.HrGuardDutyEntry> hrGuardDutyEntries) {
		this.hrGuardDutyEntries = hrGuardDutyEntries;
	}

	public void addToHrGuardDutyEntries(
			jkt.hms.masters.business.HrGuardDutyEntry hrGuardDutyEntry) {
		if (null == getHrGuardDutyEntries())
			setHrGuardDutyEntries(new java.util.TreeSet<jkt.hms.masters.business.HrGuardDutyEntry>());
		getHrGuardDutyEntries().add(hrGuardDutyEntry);
	}

	/**
	 * Return the value associated with the column: HrWardDutyEntries
	 */
	public java.util.Set<jkt.hms.masters.business.HrWardDutyEntry> getHrWardDutyEntries() {
		return hrWardDutyEntries;
	}

	/**
	 * Set the value related to the column: HrWardDutyEntries
	 * 
	 * @param hrWardDutyEntries
	 *            the HrWardDutyEntries value
	 */
	public void setHrWardDutyEntries(
			java.util.Set<jkt.hms.masters.business.HrWardDutyEntry> hrWardDutyEntries) {
		this.hrWardDutyEntries = hrWardDutyEntries;
	}

	public void addToHrWardDutyEntries(
			jkt.hms.masters.business.HrWardDutyEntry hrWardDutyEntry) {
		if (null == getHrWardDutyEntries())
			setHrWardDutyEntries(new java.util.TreeSet<jkt.hms.masters.business.HrWardDutyEntry>());
		getHrWardDutyEntries().add(hrWardDutyEntry);
	}

	/**
	 * Return the value associated with the column: HrDailyRoutineDutyEntries
	 */
	public java.util.Set<jkt.hms.masters.business.HrDailyRoutineDutyEntry> getHrDailyRoutineDutyEntries() {
		return hrDailyRoutineDutyEntries;
	}

	/**
	 * Set the value related to the column: HrDailyRoutineDutyEntries
	 * 
	 * @param hrDailyRoutineDutyEntries
	 *            the HrDailyRoutineDutyEntries value
	 */
	public void setHrDailyRoutineDutyEntries(
			java.util.Set<jkt.hms.masters.business.HrDailyRoutineDutyEntry> hrDailyRoutineDutyEntries) {
		this.hrDailyRoutineDutyEntries = hrDailyRoutineDutyEntries;
	}

	public void addToHrDailyRoutineDutyEntries(
			jkt.hms.masters.business.HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry) {
		if (null == getHrDailyRoutineDutyEntries())
			setHrDailyRoutineDutyEntries(new java.util.TreeSet<jkt.hms.masters.business.HrDailyRoutineDutyEntry>());
		getHrDailyRoutineDutyEntries().add(hrDailyRoutineDutyEntry);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrDutyTimeMaster))
			return false;
		else {
			jkt.hms.masters.business.HrDutyTimeMaster hrDutyTimeMaster = (jkt.hms.masters.business.HrDutyTimeMaster) obj;
			if (null == this.getId() || null == hrDutyTimeMaster.getId())
				return false;
			else
				return (this.getId().equals(hrDutyTimeMaster.getId()));
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