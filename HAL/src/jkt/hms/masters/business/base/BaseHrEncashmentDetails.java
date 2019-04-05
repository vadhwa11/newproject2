package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_encashment_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_encashment_details"
 */

public abstract class BaseHrEncashmentDetails  implements Serializable {

	public static String REF = "HrEncashmentDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMP_ID_BAL = "empIdBal";
	public static String PROP_LEAVE_TO_ENCASH = "LeaveToEncash";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DELETE_REASON = "DeleteReason";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_EMP = "Emp";
	public static String PROP_REASON = "Reason";
	public static String PROP_APPROVED_ON = "ApprovedOn";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_LEAVE_STATUS = "LeaveStatus";
	public static String PROP_ID = "Id";
	public static String PROP_APPLIED_ON = "AppliedOn";
	public static String PROP_ENCASH_YEAR = "EncashYear";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrEncashmentDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEncashmentDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String leaveToEncash;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.lang.String encashYear;
	private java.lang.String deleteReason;
	private java.lang.String reason;
	private java.util.Date approvedOn;
	private java.util.Date appliedOn;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrMasLeaveStatus leaveStatus;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.HrEmployeeBalanceNew empIdBal;



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
	 * Return the value associated with the column: leave_to_encash
	 */
	public java.lang.String getLeaveToEncash () {
		return leaveToEncash;
	}

	/**
	 * Set the value related to the column: leave_to_encash
	 * @param leaveToEncash the leave_to_encash value
	 */
	public void setLeaveToEncash (java.lang.String leaveToEncash) {
		this.leaveToEncash = leaveToEncash;
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: encash_year
	 */
	public java.lang.String getEncashYear () {
		return encashYear;
	}

	/**
	 * Set the value related to the column: encash_year
	 * @param encashYear the encash_year value
	 */
	public void setEncashYear (java.lang.String encashYear) {
		this.encashYear = encashYear;
	}



	/**
	 * Return the value associated with the column: delete_reason
	 */
	public java.lang.String getDeleteReason () {
		return deleteReason;
	}

	/**
	 * Set the value related to the column: delete_reason
	 * @param deleteReason the delete_reason value
	 */
	public void setDeleteReason (java.lang.String deleteReason) {
		this.deleteReason = deleteReason;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: approved_on
	 */
	public java.util.Date getApprovedOn () {
		return approvedOn;
	}

	/**
	 * Set the value related to the column: approved_on
	 * @param approvedOn the approved_on value
	 */
	public void setApprovedOn (java.util.Date approvedOn) {
		this.approvedOn = approvedOn;
	}



	/**
	 * Return the value associated with the column: applied_on
	 */
	public java.util.Date getAppliedOn () {
		return appliedOn;
	}

	/**
	 * Set the value related to the column: applied_on
	 * @param appliedOn the applied_on value
	 */
	public void setAppliedOn (java.util.Date appliedOn) {
		this.appliedOn = appliedOn;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: leave_type
	 */
	public jkt.hms.masters.business.HrMasLeaveTypeMediator getLeaveType () {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type
	 * @param leaveType the leave_type value
	 */
	public void setLeaveType (jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType) {
		this.leaveType = leaveType;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}



	/**
	 * Return the value associated with the column: leave_status
	 */
	public jkt.hms.masters.business.HrMasLeaveStatus getLeaveStatus () {
		return leaveStatus;
	}

	/**
	 * Set the value related to the column: leave_status
	 * @param leaveStatus the leave_status value
	 */
	public void setLeaveStatus (jkt.hms.masters.business.HrMasLeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: balance_id
	 */
	public jkt.hms.masters.business.HrEmployeeBalanceNew getEmpIdBal () {
		return empIdBal;
	}

	/**
	 * Set the value related to the column: balance_id
	 * @param empIdBal the balance_id value
	 */
	public void setEmpIdBal (jkt.hms.masters.business.HrEmployeeBalanceNew empIdBal) {
		this.empIdBal = empIdBal;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEncashmentDetails)) return false;
		else {
			jkt.hms.masters.business.HrEncashmentDetails hrEncashmentDetails = (jkt.hms.masters.business.HrEncashmentDetails) obj;
			if (null == this.getId() || null == hrEncashmentDetails.getId()) return false;
			else return (this.getId().equals(hrEncashmentDetails.getId()));
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