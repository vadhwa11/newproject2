package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_accruel_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_accruel_record"
 */

public abstract class BaseHrAccruelRecord  implements Serializable {

	public static String REF = "HrAccruelRecord";
	public static String PROP_MONTH = "Month";
	public static String PROP_YEAR = "Year";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_EMP = "Emp";
	public static String PROP_ID = "Id";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_ACCRUED = "Accrued";


	// constructors
	public BaseHrAccruelRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrAccruelRecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accrued;
	private java.lang.String month;
	private java.lang.String year;

	// many to one
	private jkt.hms.masters.business.HrMasLeaveTypeMediator leaveType;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrEmployeeBalanceNew balance;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="accrual_id"
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
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.String month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.String year) {
		this.year = year;
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
	 * Return the value associated with the column: balance_id
	 */
	public jkt.hms.masters.business.HrEmployeeBalanceNew getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: balance_id
	 * @param balance the balance_id value
	 */
	public void setBalance (jkt.hms.masters.business.HrEmployeeBalanceNew balance) {
		this.balance = balance;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrAccruelRecord)) return false;
		else {
			jkt.hms.masters.business.HrAccruelRecord hrAccruelRecord = (jkt.hms.masters.business.HrAccruelRecord) obj;
			if (null == this.getId() || null == hrAccruelRecord.getId()) return false;
			else return (this.getId().equals(hrAccruelRecord.getId()));
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