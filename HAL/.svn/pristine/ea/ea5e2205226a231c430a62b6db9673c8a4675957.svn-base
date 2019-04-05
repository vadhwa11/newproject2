package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_update_leave_balance_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_update_leave_balance_history"
 */

public abstract class BaseHrUpdateLeaveBalanceHistory  implements Serializable {

	public static String REF = "HrUpdateLeaveBalanceHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMPLOYEE_UPDATED = "EmployeeUpdated";
	public static String PROP_LEAVECOUNTER = "Leavecounter";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BALANCE_ADJUST_BY = "BalanceAdjustBy";
	public static String PROP_COMPANY = "Company";
	public static String PROP_NEW_ONSITE_BALANCE = "NewOnsiteBalance";
	public static String PROP_PREVIOUS_LEAVE_BALANCE_YEARLY = "PreviousLeaveBalanceYearly";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_HR_ID = "HrId";
	public static String PROP_FROMDATE = "Fromdate";
	public static String PROP_TODATE = "Todate";
	public static String PROP_USERS = "users";
	public static String PROP_MODIFIED_AT = "ModifiedAt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NEW_LEAVE_BALANCE = "NewLeaveBalance";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PREVIOUS_LEAVE_BALANCE = "PreviousLeaveBalance";
	public static String PROP_NEW_LEAVE_BALANCE_YEARLY = "NewLeaveBalanceYearly";
	public static String PROP_PREVOIUS_ONSITE_BALANCE = "PrevoiusOnsiteBalance";
	public static String PROP_ID = "Id";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrUpdateLeaveBalanceHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrUpdateLeaveBalanceHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hrId;
	private java.lang.Integer empId;
	private java.lang.String previousLeaveBalance;
	private java.lang.String newLeaveBalance;
	private java.lang.String previousLeaveBalanceYearly;
	private java.lang.String newLeaveBalanceYearly;
	private java.util.Date modifiedAt;
	private java.lang.String leavecounter;
	private java.lang.String remarks;
	private java.lang.String prevoiusOnsiteBalance;
	private java.lang.String newOnsiteBalance;
	private java.util.Date fromdate;
	private java.util.Date todate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String balanceAdjustBy;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.MasEmployee users;
	private jkt.hms.masters.business.MasEmployee employeeUpdated;
	private jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType;



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
	 * Return the value associated with the column: hr_id
	 */
	public java.lang.Integer getHrId () {
		return hrId;
	}

	/**
	 * Set the value related to the column: hr_id
	 * @param hrId the hr_id value
	 */
	public void setHrId (java.lang.Integer hrId) {
		this.hrId = hrId;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public java.lang.Integer getEmpId () {
		return empId;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param empId the emp_id value
	 */
	public void setEmpId (java.lang.Integer empId) {
		this.empId = empId;
	}



	/**
	 * Return the value associated with the column: previous_leave_balance
	 */
	public java.lang.String getPreviousLeaveBalance () {
		return previousLeaveBalance;
	}

	/**
	 * Set the value related to the column: previous_leave_balance
	 * @param previousLeaveBalance the previous_leave_balance value
	 */
	public void setPreviousLeaveBalance (java.lang.String previousLeaveBalance) {
		this.previousLeaveBalance = previousLeaveBalance;
	}



	/**
	 * Return the value associated with the column: new_leave_balance
	 */
	public java.lang.String getNewLeaveBalance () {
		return newLeaveBalance;
	}

	/**
	 * Set the value related to the column: new_leave_balance
	 * @param newLeaveBalance the new_leave_balance value
	 */
	public void setNewLeaveBalance (java.lang.String newLeaveBalance) {
		this.newLeaveBalance = newLeaveBalance;
	}



	/**
	 * Return the value associated with the column: previous_leave_balance_yearly
	 */
	public java.lang.String getPreviousLeaveBalanceYearly () {
		return previousLeaveBalanceYearly;
	}

	/**
	 * Set the value related to the column: previous_leave_balance_yearly
	 * @param previousLeaveBalanceYearly the previous_leave_balance_yearly value
	 */
	public void setPreviousLeaveBalanceYearly (java.lang.String previousLeaveBalanceYearly) {
		this.previousLeaveBalanceYearly = previousLeaveBalanceYearly;
	}



	/**
	 * Return the value associated with the column: new_leave_balance_yearly
	 */
	public java.lang.String getNewLeaveBalanceYearly () {
		return newLeaveBalanceYearly;
	}

	/**
	 * Set the value related to the column: new_leave_balance_yearly
	 * @param newLeaveBalanceYearly the new_leave_balance_yearly value
	 */
	public void setNewLeaveBalanceYearly (java.lang.String newLeaveBalanceYearly) {
		this.newLeaveBalanceYearly = newLeaveBalanceYearly;
	}



	/**
	 * Return the value associated with the column: modified_at
	 */
	public java.util.Date getModifiedAt () {
		return modifiedAt;
	}

	/**
	 * Set the value related to the column: modified_at
	 * @param modifiedAt the modified_at value
	 */
	public void setModifiedAt (java.util.Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}



	/**
	 * Return the value associated with the column: leavecounter
	 */
	public java.lang.String getLeavecounter () {
		return leavecounter;
	}

	/**
	 * Set the value related to the column: leavecounter
	 * @param leavecounter the leavecounter value
	 */
	public void setLeavecounter (java.lang.String leavecounter) {
		this.leavecounter = leavecounter;
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
	 * Return the value associated with the column: prevoius_onsite_balance
	 */
	public java.lang.String getPrevoiusOnsiteBalance () {
		return prevoiusOnsiteBalance;
	}

	/**
	 * Set the value related to the column: prevoius_onsite_balance
	 * @param prevoiusOnsiteBalance the prevoius_onsite_balance value
	 */
	public void setPrevoiusOnsiteBalance (java.lang.String prevoiusOnsiteBalance) {
		this.prevoiusOnsiteBalance = prevoiusOnsiteBalance;
	}



	/**
	 * Return the value associated with the column: new_onsite_balance
	 */
	public java.lang.String getNewOnsiteBalance () {
		return newOnsiteBalance;
	}

	/**
	 * Set the value related to the column: new_onsite_balance
	 * @param newOnsiteBalance the new_onsite_balance value
	 */
	public void setNewOnsiteBalance (java.lang.String newOnsiteBalance) {
		this.newOnsiteBalance = newOnsiteBalance;
	}



	/**
	 * Return the value associated with the column: fromdate
	 */
	public java.util.Date getFromdate () {
		return fromdate;
	}

	/**
	 * Set the value related to the column: fromdate
	 * @param fromdate the fromdate value
	 */
	public void setFromdate (java.util.Date fromdate) {
		this.fromdate = fromdate;
	}



	/**
	 * Return the value associated with the column: todate
	 */
	public java.util.Date getTodate () {
		return todate;
	}

	/**
	 * Set the value related to the column: todate
	 * @param todate the todate value
	 */
	public void setTodate (java.util.Date todate) {
		this.todate = todate;
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
	 * Return the value associated with the column: balance_adjust_by
	 */
	public java.lang.String getBalanceAdjustBy () {
		return balanceAdjustBy;
	}

	/**
	 * Set the value related to the column: balance_adjust_by
	 * @param balanceAdjustBy the balance_adjust_by value
	 */
	public void setBalanceAdjustBy (java.lang.String balanceAdjustBy) {
		this.balanceAdjustBy = balanceAdjustBy;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: hr_id
	 */
	public jkt.hms.masters.business.MasEmployee getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: hr_id
	 * @param users the hr_id value
	 */
	public void setUsers (jkt.hms.masters.business.MasEmployee users) {
		this.users = users;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeUpdated () {
		return employeeUpdated;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param employeeUpdated the emp_id value
	 */
	public void setEmployeeUpdated (jkt.hms.masters.business.MasEmployee employeeUpdated) {
		this.employeeUpdated = employeeUpdated;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrUpdateLeaveBalanceHistory)) return false;
		else {
			jkt.hms.masters.business.HrUpdateLeaveBalanceHistory hrUpdateLeaveBalanceHistory = (jkt.hms.masters.business.HrUpdateLeaveBalanceHistory) obj;
			if (null == this.getId() || null == hrUpdateLeaveBalanceHistory.getId()) return false;
			else return (this.getId().equals(hrUpdateLeaveBalanceHistory.getId()));
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