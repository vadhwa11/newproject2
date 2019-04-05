package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_leave_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_leave_details"
 */

public abstract class BaseHrLeaveDetails  implements Serializable {

	public static String REF = "HrLeaveDetails";
	public static String PROP_DELETE_REASON = "DeleteReason";
	public static String PROP_COMPANY = "Company";
	public static String PROP_MODIFIED_ON = "ModifiedOn";
	public static String PROP_LEAVE_TYPE = "leaveType";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_REASON = "Reason";
	public static String PROP_CONTACT_PHONE = "ContactPhone";
	public static String PROP_SUGGESTION = "Suggestion";
	public static String PROP_JOINING_DATE = "JoiningDate";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_SHORT_LEAVE_HALF_DAY = "ShortLeaveHalfDay";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CONTACT_ADDRESS = "ContactAddress";
	public static String PROP_EMP_ID_BAL = "empIdBal";
	public static String PROP_HALF_DAY = "HalfDay";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NO_OF_WORKING_DAYS = "NoOfWorkingDays";
	public static String PROP_HR_MAS_LEAVE_TYPE_NEW = "HrMasLeaveTypeNew";
	public static String PROP_APPROVED_ON = "ApprovedOn";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ALTERNATE_EMAIL_ID = "AlternateEmailId";
	public static String PROP_DISAPPROVE_REASON = "DisapproveReason";
	public static String PROP_LEAVE_STATUS = "leaveStatus";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LEAVE_APPROVED_BY = "leaveApprovedBy";
	public static String PROP_ID = "Id";
	public static String PROP_APPLIED_ON = "AppliedOn";
	public static String PROP_REC_STATUS = "RecStatus";


	// constructors
	public BaseHrLeaveDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrLeaveDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String noOfWorkingDays;
	private java.util.Date approvedOn;
	private java.util.Date joiningDate;
	private java.lang.String reason;
	private java.lang.String contactAddress;
	private java.lang.String contactPhone;
	private java.util.Date appliedOn;
	private java.lang.String suggestion;
	private java.lang.Integer modifiedBy;
	private java.util.Date modifiedOn;
	private java.lang.String disapproveReason;
	private java.lang.String alternateEmailId;
	private java.lang.String halfDay;
	private java.lang.String shortLeaveHalfDay;
	private java.lang.String deleteReason;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String recStatus;

	// many to one
	private jkt.hms.masters.business.MasEmployee leaveApprovedBy;
	private jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType;
	private jkt.hms.masters.business.HrEmployeeBalanceNew empIdBal;
	private jkt.hms.masters.business.HrMasLeaveStatus leaveStatus;
	private jkt.hms.masters.business.MasEmployee empId;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.HrMasLeaveTypeNew hrMasLeaveTypeNew;



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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: no_of_working_days
	 */
	public java.lang.String getNoOfWorkingDays () {
		return noOfWorkingDays;
	}

	/**
	 * Set the value related to the column: no_of_working_days
	 * @param noOfWorkingDays the no_of_working_days value
	 */
	public void setNoOfWorkingDays (java.lang.String noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
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
	 * Return the value associated with the column: joining_date
	 */
	public java.util.Date getJoiningDate () {
		return joiningDate;
	}

	/**
	 * Set the value related to the column: joining_date
	 * @param joiningDate the joining_date value
	 */
	public void setJoiningDate (java.util.Date joiningDate) {
		this.joiningDate = joiningDate;
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
	 * Return the value associated with the column: contact_address
	 */
	public java.lang.String getContactAddress () {
		return contactAddress;
	}

	/**
	 * Set the value related to the column: contact_address
	 * @param contactAddress the contact_address value
	 */
	public void setContactAddress (java.lang.String contactAddress) {
		this.contactAddress = contactAddress;
	}



	/**
	 * Return the value associated with the column: contact_phone
	 */
	public java.lang.String getContactPhone () {
		return contactPhone;
	}

	/**
	 * Set the value related to the column: contact_phone
	 * @param contactPhone the contact_phone value
	 */
	public void setContactPhone (java.lang.String contactPhone) {
		this.contactPhone = contactPhone;
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
	 * Return the value associated with the column: suggestion
	 */
	public java.lang.String getSuggestion () {
		return suggestion;
	}

	/**
	 * Set the value related to the column: suggestion
	 * @param suggestion the suggestion value
	 */
	public void setSuggestion (java.lang.String suggestion) {
		this.suggestion = suggestion;
	}



	/**
	 * Return the value associated with the column: modified_by
	 */
	public java.lang.Integer getModifiedBy () {
		return modifiedBy;
	}

	/**
	 * Set the value related to the column: modified_by
	 * @param modifiedBy the modified_by value
	 */
	public void setModifiedBy (java.lang.Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	/**
	 * Return the value associated with the column: modified_on
	 */
	public java.util.Date getModifiedOn () {
		return modifiedOn;
	}

	/**
	 * Set the value related to the column: modified_on
	 * @param modifiedOn the modified_on value
	 */
	public void setModifiedOn (java.util.Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}



	/**
	 * Return the value associated with the column: disapprove_Reason
	 */
	public java.lang.String getDisapproveReason () {
		return disapproveReason;
	}

	/**
	 * Set the value related to the column: disapprove_Reason
	 * @param disapproveReason the disapprove_Reason value
	 */
	public void setDisapproveReason (java.lang.String disapproveReason) {
		this.disapproveReason = disapproveReason;
	}



	/**
	 * Return the value associated with the column: alternate_email_Id
	 */
	public java.lang.String getAlternateEmailId () {
		return alternateEmailId;
	}

	/**
	 * Set the value related to the column: alternate_email_Id
	 * @param alternateEmailId the alternate_email_Id value
	 */
	public void setAlternateEmailId (java.lang.String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}



	/**
	 * Return the value associated with the column: half_day
	 */
	public java.lang.String getHalfDay () {
		return halfDay;
	}

	/**
	 * Set the value related to the column: half_day
	 * @param halfDay the half_day value
	 */
	public void setHalfDay (java.lang.String halfDay) {
		this.halfDay = halfDay;
	}



	/**
	 * Return the value associated with the column: short_leave_half_type
	 */
	public java.lang.String getShortLeaveHalfDay () {
		return shortLeaveHalfDay;
	}

	/**
	 * Set the value related to the column: short_leave_half_type
	 * @param shortLeaveHalfDay the short_leave_half_type value
	 */
	public void setShortLeaveHalfDay (java.lang.String shortLeaveHalfDay) {
		this.shortLeaveHalfDay = shortLeaveHalfDay;
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
	 * Return the value associated with the column: rec_status
	 */
	public java.lang.String getRecStatus () {
		return recStatus;
	}

	/**
	 * Set the value related to the column: rec_status
	 * @param recStatus the rec_status value
	 */
	public void setRecStatus (java.lang.String recStatus) {
		this.recStatus = recStatus;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getLeaveApprovedBy () {
		return leaveApprovedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param leaveApprovedBy the approved_by value
	 */
	public void setLeaveApprovedBy (jkt.hms.masters.business.MasEmployee leaveApprovedBy) {
		this.leaveApprovedBy = leaveApprovedBy;
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



	/**
	 * Return the value associated with the column: status
	 */
	public jkt.hms.masters.business.HrMasLeaveStatus getLeaveStatus () {
		return leaveStatus;
	}

	/**
	 * Set the value related to the column: status
	 * @param leaveStatus the status value
	 */
	public void setLeaveStatus (jkt.hms.masters.business.HrMasLeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}



	/**
	 * Return the value associated with the column: empid
	 */
	public jkt.hms.masters.business.MasEmployee getEmpId () {
		return empId;
	}

	/**
	 * Set the value related to the column: empid
	 * @param empId the empid value
	 */
	public void setEmpId (jkt.hms.masters.business.MasEmployee empId) {
		this.empId = empId;
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
	 * Return the value associated with the column: hr_mas_leave_type_new_id
	 */
	public jkt.hms.masters.business.HrMasLeaveTypeNew getHrMasLeaveTypeNew () {
		return hrMasLeaveTypeNew;
	}

	/**
	 * Set the value related to the column: hr_mas_leave_type_new_id
	 * @param hrMasLeaveTypeNew the hr_mas_leave_type_new_id value
	 */
	public void setHrMasLeaveTypeNew (jkt.hms.masters.business.HrMasLeaveTypeNew hrMasLeaveTypeNew) {
		this.hrMasLeaveTypeNew = hrMasLeaveTypeNew;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrLeaveDetails)) return false;
		else {
			jkt.hms.masters.business.HrLeaveDetails hrLeaveDetails = (jkt.hms.masters.business.HrLeaveDetails) obj;
			if (null == this.getId() || null == hrLeaveDetails.getId()) return false;
			else return (this.getId().equals(hrLeaveDetails.getId()));
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