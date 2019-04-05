package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_daily_routine_duty_entry table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_daily_routine_duty_entry"
 */

public abstract class BaseHrDailyRoutineDutyEntry implements Serializable {

	public static String REF = "HrDailyRoutineDutyEntry";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DUTY = "Duty";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_DUTY_TIME = "DutyTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMP = "Emp";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DUTY_DATE = "DutyDate";

	// constructors
	public BaseHrDailyRoutineDutyEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrDailyRoutineDutyEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dutyDate;
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.HrDutyTimeMaster dutyTime;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrDutyMaster duty;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="duty_entry_id"
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
	 * Return the value associated with the column: duty_date
	 */
	public java.util.Date getDutyDate() {
		return dutyDate;
	}

	/**
	 * Set the value related to the column: duty_date
	 * 
	 * @param dutyDate
	 *            the duty_date value
	 */
	public void setDutyDate(java.util.Date dutyDate) {
		this.dutyDate = dutyDate;
	}

	/**
	 * Return the value associated with the column: entryNo
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entryNo
	 * 
	 * @param entryNo
	 *            the entryNo value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entryDate
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entryDate
	 * 
	 * @param entryDate
	 *            the entryDate value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
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
	 * Return the value associated with the column: duty_time_id
	 */
	public jkt.hms.masters.business.HrDutyTimeMaster getDutyTime() {
		return dutyTime;
	}

	/**
	 * Set the value related to the column: duty_time_id
	 * 
	 * @param dutyTime
	 *            the duty_time_id value
	 */
	public void setDutyTime(jkt.hms.masters.business.HrDutyTimeMaster dutyTime) {
		this.dutyTime = dutyTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp() {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * 
	 * @param emp
	 *            the emp_id value
	 */
	public void setEmp(jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrDailyRoutineDutyEntry))
			return false;
		else {
			jkt.hms.masters.business.HrDailyRoutineDutyEntry hrDailyRoutineDutyEntry = (jkt.hms.masters.business.HrDailyRoutineDutyEntry) obj;
			if (null == this.getId() || null == hrDailyRoutineDutyEntry.getId())
				return false;
			else
				return (this.getId().equals(hrDailyRoutineDutyEntry.getId()));
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