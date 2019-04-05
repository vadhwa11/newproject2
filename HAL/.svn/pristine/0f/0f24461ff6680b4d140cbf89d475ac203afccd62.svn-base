package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_leave_maintenance
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_leave_maintenance"
 */

public abstract class BaseHrLeaveMaintenance implements Serializable {

	public static String REF = "HrLeaveMaintenance";
	public static String PROP_DATE_OF_REPORTING = "DateOfReporting";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_APPROVED_STATUS = "ApprovedStatus";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LEAVE_FROM = "LeaveFrom";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_APPLICATION_DATE = "ApplicationDate";
	public static String PROP_RECOMMENDED_STATUS = "RecommendedStatus";
	public static String PROP_TOTAL_LEAVE = "TotalLeave";

	// constructors
	public BaseHrLeaveMaintenance() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrLeaveMaintenance(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date leaveFrom;
	private java.util.Date dateOfReporting;
	private java.math.BigDecimal totalLeave;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String recommendedStatus;
	private java.lang.String approvedStatus;
	private java.util.Date approvedDate;
	private java.util.Date applicationDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HrLeaveTypeMaster leaveType;
	private jkt.hms.masters.business.MasEmployee employee;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="leave_maintenance_id"
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
	 * Return the value associated with the column: leave_from
	 */
	public java.util.Date getLeaveFrom() {
		return leaveFrom;
	}

	/**
	 * Set the value related to the column: leave_from
	 * 
	 * @param leaveFrom
	 *            the leave_from value
	 */
	public void setLeaveFrom(java.util.Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	/**
	 * Return the value associated with the column: date_of_reporting
	 */
	public java.util.Date getDateOfReporting() {
		return dateOfReporting;
	}

	/**
	 * Set the value related to the column: date_of_reporting
	 * 
	 * @param dateOfReporting
	 *            the date_of_reporting value
	 */
	public void setDateOfReporting(java.util.Date dateOfReporting) {
		this.dateOfReporting = dateOfReporting;
	}

	/**
	 * Return the value associated with the column: total_leave
	 */
	public java.math.BigDecimal getTotalLeave() {
		return totalLeave;
	}

	/**
	 * Set the value related to the column: total_leave
	 * 
	 * @param totalLeave
	 *            the total_leave value
	 */
	public void setTotalLeave(java.math.BigDecimal totalLeave) {
		this.totalLeave = totalLeave;
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
	 * Return the value associated with the column: recommended_status
	 */
	public java.lang.String getRecommendedStatus() {
		return recommendedStatus;
	}

	/**
	 * Set the value related to the column: recommended_status
	 * 
	 * @param recommendedStatus
	 *            the recommended_status value
	 */
	public void setRecommendedStatus(java.lang.String recommendedStatus) {
		this.recommendedStatus = recommendedStatus;
	}

	/**
	 * Return the value associated with the column: approved_status
	 */
	public java.lang.String getApprovedStatus() {
		return approvedStatus;
	}

	/**
	 * Set the value related to the column: approved_status
	 * 
	 * @param approvedStatus
	 *            the approved_status value
	 */
	public void setApprovedStatus(java.lang.String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	/**
	 * Return the value associated with the column: approved_date
	 */
	public java.util.Date getApprovedDate() {
		return approvedDate;
	}

	/**
	 * Set the value related to the column: approved_date
	 * 
	 * @param approvedDate
	 *            the approved_date value
	 */
	public void setApprovedDate(java.util.Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	/**
	 * Return the value associated with the column: application_date
	 */
	public java.util.Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * Set the value related to the column: application_date
	 * 
	 * @param applicationDate
	 *            the application_date value
	 */
	public void setApplicationDate(java.util.Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: leave_type_id
	 */
	public jkt.hms.masters.business.HrLeaveTypeMaster getLeaveType() {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type_id
	 * 
	 * @param leaveType
	 *            the leave_type_id value
	 */
	public void setLeaveType(
			jkt.hms.masters.business.HrLeaveTypeMaster leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrLeaveMaintenance))
			return false;
		else {
			jkt.hms.masters.business.HrLeaveMaintenance hrLeaveMaintenance = (jkt.hms.masters.business.HrLeaveMaintenance) obj;
			if (null == this.getId() || null == hrLeaveMaintenance.getId())
				return false;
			else
				return (this.getId().equals(hrLeaveMaintenance.getId()));
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