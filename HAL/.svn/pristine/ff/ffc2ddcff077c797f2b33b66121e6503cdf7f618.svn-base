package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_balance_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_balance_history"
 */

public abstract class BaseHrEmployeeBalanceHistory  implements Serializable {

	public static String REF = "HrEmployeeBalanceHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_CLOSING_BALANCE = "ClosingBalance";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_OPENING_BALANCE = "OpeningBalance";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_EMP = "Emp";
	public static String PROP_TAKEN = "Taken";
	public static String PROP_ID = "Id";
	public static String PROP_EARNED = "Earned";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrEmployeeBalanceHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeBalanceHistory (java.lang.Integer id) {
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

	// many to one
	private jkt.hms.masters.business.HrMasLeaveType leaveType;
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
	 * Return the value associated with the column: leave_type
	 */
	public jkt.hms.masters.business.HrMasLeaveType getLeaveType () {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type
	 * @param leaveType the leave_type value
	 */
	public void setLeaveType (jkt.hms.masters.business.HrMasLeaveType leaveType) {
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
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeBalanceHistory)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeBalanceHistory hrEmployeeBalanceHistory = (jkt.hms.masters.business.HrEmployeeBalanceHistory) obj;
			if (null == this.getId() || null == hrEmployeeBalanceHistory.getId()) return false;
			else return (this.getId().equals(hrEmployeeBalanceHistory.getId()));
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