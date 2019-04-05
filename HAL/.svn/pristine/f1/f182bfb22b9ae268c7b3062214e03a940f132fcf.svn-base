package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_other_earning table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_other_earning"
 */

public abstract class BaseHrEmployeeOtherEarning  implements Serializable {

	public static String REF = "HrEmployeeOtherEarning";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_INCOME_AMOUNT = "IncomeAmount";
	public static String PROP_INCOME_CODE = "IncomeCode";
	public static String PROP_INCOME_DATE = "IncomeDate";
	public static String PROP_EMP = "Emp";
	public static String PROP_CHECK_CODE = "CheckCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrEmployeeOtherEarning () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeOtherEarning (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal incomeAmount;
	private java.util.Date incomeDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrMasItaxIncomeCode incomeCode;
	private jkt.hms.masters.business.MasStoreFinancial financialYear;
	private jkt.hms.masters.business.HrMasItaxCheckCode checkCode;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: income_amount
	 */
	public java.math.BigDecimal getIncomeAmount () {
		return incomeAmount;
	}

	/**
	 * Set the value related to the column: income_amount
	 * @param incomeAmount the income_amount value
	 */
	public void setIncomeAmount (java.math.BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}



	/**
	 * Return the value associated with the column: income_date
	 */
	public java.util.Date getIncomeDate () {
		return incomeDate;
	}

	/**
	 * Set the value related to the column: income_date
	 * @param incomeDate the income_date value
	 */
	public void setIncomeDate (java.util.Date incomeDate) {
		this.incomeDate = incomeDate;
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
	 * Return the value associated with the column: income_code
	 */
	public jkt.hms.masters.business.HrMasItaxIncomeCode getIncomeCode () {
		return incomeCode;
	}

	/**
	 * Set the value related to the column: income_code
	 * @param incomeCode the income_code value
	 */
	public void setIncomeCode (jkt.hms.masters.business.HrMasItaxIncomeCode incomeCode) {
		this.incomeCode = incomeCode;
	}

	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(
			jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}

	



	/**
	 * Return the value associated with the column: check_code
	 */
	public jkt.hms.masters.business.HrMasItaxCheckCode getCheckCode () {
		return checkCode;
	}

	/**
	 * Set the value related to the column: check_code
	 * @param checkCode the check_code value
	 */
	public void setCheckCode (jkt.hms.masters.business.HrMasItaxCheckCode checkCode) {
		this.checkCode = checkCode;
	}



	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param hospital the location_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeOtherEarning)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeOtherEarning hrEmployeeOtherEarning = (jkt.hms.masters.business.HrEmployeeOtherEarning) obj;
			if (null == this.getId() || null == hrEmployeeOtherEarning.getId()) return false;
			else return (this.getId().equals(hrEmployeeOtherEarning.getId()));
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