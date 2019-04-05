package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the relegation_process table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="relegation_process"
 */

public abstract class BaseRelegationProcess implements Serializable {

	public static String REF = "RelegationProcess";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RELEGATION_TIME = "RelegationTime";
	public static String PROP_RELEGATION_TYPE = "RelegationType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RELEGATION_NO = "RelegationNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RELEGATION_DATE = "RelegationDate";
	public static String PROP_RELEGATION_FROM = "RelegationFrom";
	public static String PROP_RELEGATION_TO = "RelegationTo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VACATION = "Vacation";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_RELEGATION_COMPLETED = "RelegationCompleted";
	public static String PROP_ID = "Id";

	// constructors
	public BaseRelegationProcess() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRelegationProcess(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRelegationProcess(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String relegationNo,
			java.util.Date relegationDate, java.lang.String relegationTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setRelegationNo(relegationNo);
		this.setRelegationDate(relegationDate);
		this.setRelegationTime(relegationTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String relegationType;
	private java.util.Date relegationFrom;
	private java.util.Date relegationTo;
	private java.lang.String relegationCompleted;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String relegationNo;
	private java.util.Date relegationDate;
	private java.lang.String relegationTime;

	// many to one
	private jkt.hms.masters.business.SmqVacation vacation;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="relegation_id"
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
	 * Return the value associated with the column: relegation_type
	 */
	public java.lang.String getRelegationType() {
		return relegationType;
	}

	/**
	 * Set the value related to the column: relegation_type
	 * 
	 * @param relegationType
	 *            the relegation_type value
	 */
	public void setRelegationType(java.lang.String relegationType) {
		this.relegationType = relegationType;
	}

	/**
	 * Return the value associated with the column: relegation_from
	 */
	public java.util.Date getRelegationFrom() {
		return relegationFrom;
	}

	/**
	 * Set the value related to the column: relegation_from
	 * 
	 * @param relegationFrom
	 *            the relegation_from value
	 */
	public void setRelegationFrom(java.util.Date relegationFrom) {
		this.relegationFrom = relegationFrom;
	}

	/**
	 * Return the value associated with the column: relegation_to
	 */
	public java.util.Date getRelegationTo() {
		return relegationTo;
	}

	/**
	 * Set the value related to the column: relegation_to
	 * 
	 * @param relegationTo
	 *            the relegation_to value
	 */
	public void setRelegationTo(java.util.Date relegationTo) {
		this.relegationTo = relegationTo;
	}

	/**
	 * Return the value associated with the column: relegation_completed
	 */
	public java.lang.String getRelegationCompleted() {
		return relegationCompleted;
	}

	/**
	 * Set the value related to the column: relegation_completed
	 * 
	 * @param relegationCompleted
	 *            the relegation_completed value
	 */
	public void setRelegationCompleted(java.lang.String relegationCompleted) {
		this.relegationCompleted = relegationCompleted;
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
	 * Return the value associated with the column: relegation_no
	 */
	public java.lang.String getRelegationNo() {
		return relegationNo;
	}

	/**
	 * Set the value related to the column: relegation_no
	 * 
	 * @param relegationNo
	 *            the relegation_no value
	 */
	public void setRelegationNo(java.lang.String relegationNo) {
		this.relegationNo = relegationNo;
	}

	/**
	 * Return the value associated with the column: relegation_date
	 */
	public java.util.Date getRelegationDate() {
		return relegationDate;
	}

	/**
	 * Set the value related to the column: relegation_date
	 * 
	 * @param relegationDate
	 *            the relegation_date value
	 */
	public void setRelegationDate(java.util.Date relegationDate) {
		this.relegationDate = relegationDate;
	}

	/**
	 * Return the value associated with the column: relegation_time
	 */
	public java.lang.String getRelegationTime() {
		return relegationTime;
	}

	/**
	 * Set the value related to the column: relegation_time
	 * 
	 * @param relegationTime
	 *            the relegation_time value
	 */
	public void setRelegationTime(java.lang.String relegationTime) {
		this.relegationTime = relegationTime;
	}

	/**
	 * Return the value associated with the column: vacation_id
	 */
	public jkt.hms.masters.business.SmqVacation getVacation() {
		return vacation;
	}

	/**
	 * Set the value related to the column: vacation_id
	 * 
	 * @param vacation
	 *            the vacation_id value
	 */
	public void setVacation(jkt.hms.masters.business.SmqVacation vacation) {
		this.vacation = vacation;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.RelegationProcess))
			return false;
		else {
			jkt.hms.masters.business.RelegationProcess relegationProcess = (jkt.hms.masters.business.RelegationProcess) obj;
			if (null == this.getId() || null == relegationProcess.getId())
				return false;
			else
				return (this.getId().equals(relegationProcess.getId()));
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