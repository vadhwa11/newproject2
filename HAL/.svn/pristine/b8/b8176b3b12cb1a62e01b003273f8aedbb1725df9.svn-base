package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_balance_new table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_balance_new"
 */

public abstract class BaseHrEmployeeBalanceNew  implements Serializable {

	public static String REF = "HrEmployeeBalanceNew";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMPANY = "Company";
	public static String PROP_OPENING_BALANCE = "OpeningBalance";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_CLOSING_BALANCE_YEARLY = "ClosingBalanceYearly";
	public static String PROP_EMP = "Emp";
	public static String PROP_TAKEN = "Taken";
	public static String PROP_BALANCE_ADJUSTED_BY = "BalanceAdjustedBy";
	public static String PROP_TOTAL_LEAVE_TAKEN = "TotalLeaveTaken";
	public static String PROP_ACCRUED = "Accrued";
	public static String PROP_CLOSING_BALANCE = "ClosingBalance";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ALREADY_AVAILED_PAT_MAT = "AlreadyAvailedPatMat";
	public static String PROP_ENTITLEMENT_ACC_JOIN_DATE = "EntitlementAccJoinDate";
	public static String PROP_ID = "Id";
	public static String PROP_EARNED = "Earned";
	public static String PROP_OPENING_BALANCE_YEARLY = "OpeningBalanceYearly";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrEmployeeBalanceNew () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeBalanceNew (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String openingBalance;
	private java.lang.String taken;
	private java.lang.String earned;
	private java.lang.String closingBalance;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lastChgBy;
	private java.lang.String status;
	private java.lang.String balanceAdjustedBy;
	private java.lang.String alreadyAvailedPatMat;
	private java.lang.String totalLeaveTaken;
	private java.lang.String accrued;
	private java.lang.String openingBalanceYearly;
	private java.lang.String closingBalanceYearly;
	private java.lang.String entitlementAccJoinDate;

	// many to one
	private jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.MasHospital company;



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
	 * Return the value associated with the column: opening_balance
	 */
	public java.lang.String getOpeningBalance () {
		return openingBalance;
	}

	/**
	 * Set the value related to the column: opening_balance
	 * @param openingBalance the opening_balance value
	 */
	public void setOpeningBalance (java.lang.String openingBalance) {
		this.openingBalance = openingBalance;
	}



	/**
	 * Return the value associated with the column: taken
	 */
	public java.lang.String getTaken () {
		return taken;
	}

	/**
	 * Set the value related to the column: taken
	 * @param taken the taken value
	 */
	public void setTaken (java.lang.String taken) {
		this.taken = taken;
	}



	/**
	 * Return the value associated with the column: earned
	 */
	public java.lang.String getEarned () {
		return earned;
	}

	/**
	 * Set the value related to the column: earned
	 * @param earned the earned value
	 */
	public void setEarned (java.lang.String earned) {
		this.earned = earned;
	}



	/**
	 * Return the value associated with the column: closing_balance
	 */
	public java.lang.String getClosingBalance () {
		return closingBalance;
	}

	/**
	 * Set the value related to the column: closing_balance
	 * @param closingBalance the closing_balance value
	 */
	public void setClosingBalance (java.lang.String closingBalance) {
		this.closingBalance = closingBalance;
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
	 * Return the value associated with the column: balance_adjusted
	 */
	public java.lang.String getBalanceAdjustedBy () {
		return balanceAdjustedBy;
	}

	/**
	 * Set the value related to the column: balance_adjusted
	 * @param balanceAdjustedBy the balance_adjusted value
	 */
	public void setBalanceAdjustedBy (java.lang.String balanceAdjustedBy) {
		this.balanceAdjustedBy = balanceAdjustedBy;
	}



	/**
	 * Return the value associated with the column: already_availed_pat_mat
	 */
	public java.lang.String getAlreadyAvailedPatMat () {
		return alreadyAvailedPatMat;
	}

	/**
	 * Set the value related to the column: already_availed_pat_mat
	 * @param alreadyAvailedPatMat the already_availed_pat_mat value
	 */
	public void setAlreadyAvailedPatMat (java.lang.String alreadyAvailedPatMat) {
		this.alreadyAvailedPatMat = alreadyAvailedPatMat;
	}



	/**
	 * Return the value associated with the column: total_leave_taken
	 */
	public java.lang.String getTotalLeaveTaken () {
		return totalLeaveTaken;
	}

	/**
	 * Set the value related to the column: total_leave_taken
	 * @param totalLeaveTaken the total_leave_taken value
	 */
	public void setTotalLeaveTaken (java.lang.String totalLeaveTaken) {
		this.totalLeaveTaken = totalLeaveTaken;
	}



	/**
	 * Return the value associated with the column: accrued
	 */
	public java.lang.String getAccrued () {
		return accrued;
	}

	/**
	 * Set the value related to the column: accrued
	 * @param accrued the accrued value
	 */
	public void setAccrued (java.lang.String accrued) {
		this.accrued = accrued;
	}



	/**
	 * Return the value associated with the column: opening_balance_yearly
	 */
	public java.lang.String getOpeningBalanceYearly () {
		return openingBalanceYearly;
	}

	/**
	 * Set the value related to the column: opening_balance_yearly
	 * @param openingBalanceYearly the opening_balance_yearly value
	 */
	public void setOpeningBalanceYearly (java.lang.String openingBalanceYearly) {
		this.openingBalanceYearly = openingBalanceYearly;
	}



	/**
	 * Return the value associated with the column: closing_balance_yearly
	 */
	public java.lang.String getClosingBalanceYearly () {
		return closingBalanceYearly;
	}

	/**
	 * Set the value related to the column: closing_balance_yearly
	 * @param closingBalanceYearly the closing_balance_yearly value
	 */
	public void setClosingBalanceYearly (java.lang.String closingBalanceYearly) {
		this.closingBalanceYearly = closingBalanceYearly;
	}



	/**
	 * Return the value associated with the column: entitlement_acc_join_date
	 */
	public java.lang.String getEntitlementAccJoinDate () {
		return entitlementAccJoinDate;
	}

	/**
	 * Set the value related to the column: entitlement_acc_join_date
	 * @param entitlementAccJoinDate the entitlement_acc_join_date value
	 */
	public void setEntitlementAccJoinDate (java.lang.String entitlementAccJoinDate) {
		this.entitlementAccJoinDate = entitlementAccJoinDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeBalanceNew)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeBalanceNew hrEmployeeBalanceNew = (jkt.hms.masters.business.HrEmployeeBalanceNew) obj;
			if (null == this.getId() || null == hrEmployeeBalanceNew.getId()) return false;
			else return (this.getId().equals(hrEmployeeBalanceNew.getId()));
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