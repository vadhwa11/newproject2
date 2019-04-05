package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_advance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_advance"
 */

public abstract class BaseHrAdvance  implements Serializable {

	public static String REF = "HrAdvance";
	public static String PROP_ADVANCE_DATE = "AdvanceDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MONTHLY_DEDUCTION = "MonthlyDeduction";
	public static String PROP_RECOVERY_MODE = "RecoveryMode";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_RECOVERED_AMOUNT = "RecoveredAmount";
	public static String PROP_STATUS = "Status";
	public static String PROP_ADVANCE_CODE = "AdvanceCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ADVANCE_AMOUNT = "AdvanceAmount";
	public static String PROP_ID = "Id";
	public static String PROP_RECOVERY_PERIOD = "RecoveryPeriod";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrAdvance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrAdvance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String advanceCode;
	private java.util.Date advanceDate;
	private java.math.BigDecimal advanceAmount;
	private java.lang.String recoveryMode;
	private java.math.BigDecimal monthlyDeduction;
	private java.math.BigDecimal recoveredAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Float recoveryPeriod;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="advance_id"
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
	 * Return the value associated with the column: advance_code
	 */
	public java.lang.String getAdvanceCode () {
		return advanceCode;
	}

	/**
	 * Set the value related to the column: advance_code
	 * @param advanceCode the advance_code value
	 */
	public void setAdvanceCode (java.lang.String advanceCode) {
		this.advanceCode = advanceCode;
	}



	/**
	 * Return the value associated with the column: advance_date
	 */
	public java.util.Date getAdvanceDate () {
		return advanceDate;
	}

	/**
	 * Set the value related to the column: advance_date
	 * @param advanceDate the advance_date value
	 */
	public void setAdvanceDate (java.util.Date advanceDate) {
		this.advanceDate = advanceDate;
	}



	/**
	 * Return the value associated with the column: advance_amount
	 */
	public java.math.BigDecimal getAdvanceAmount () {
		return advanceAmount;
	}

	/**
	 * Set the value related to the column: advance_amount
	 * @param advanceAmount the advance_amount value
	 */
	public void setAdvanceAmount (java.math.BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}



	/**
	 * Return the value associated with the column: recovery_mode
	 */
	public java.lang.String getRecoveryMode () {
		return recoveryMode;
	}

	/**
	 * Set the value related to the column: recovery_mode
	 * @param recoveryMode the recovery_mode value
	 */
	public void setRecoveryMode (java.lang.String recoveryMode) {
		this.recoveryMode = recoveryMode;
	}



	/**
	 * Return the value associated with the column: monthly_deduction
	 */
	public java.math.BigDecimal getMonthlyDeduction () {
		return monthlyDeduction;
	}

	/**
	 * Set the value related to the column: monthly_deduction
	 * @param monthlyDeduction the monthly_deduction value
	 */
	public void setMonthlyDeduction (java.math.BigDecimal monthlyDeduction) {
		this.monthlyDeduction = monthlyDeduction;
	}



	/**
	 * Return the value associated with the column: recovered_amount
	 */
	public java.math.BigDecimal getRecoveredAmount () {
		return recoveredAmount;
	}

	/**
	 * Set the value related to the column: recovered_amount
	 * @param recoveredAmount the recovered_amount value
	 */
	public void setRecoveredAmount (java.math.BigDecimal recoveredAmount) {
		this.recoveredAmount = recoveredAmount;
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
	 * Return the value associated with the column: recovery_period
	 */
	public java.lang.Float getRecoveryPeriod () {
		return recoveryPeriod;
	}

	/**
	 * Set the value related to the column: recovery_period
	 * @param recoveryPeriod the recovery_period value
	 */
	public void setRecoveryPeriod (java.lang.Float recoveryPeriod) {
		this.recoveryPeriod = recoveryPeriod;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
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
		if (!(obj instanceof jkt.hms.masters.business.HrAdvance)) return false;
		else {
			jkt.hms.masters.business.HrAdvance hrAdvance = (jkt.hms.masters.business.HrAdvance) obj;
			if (null == this.getId() || null == hrAdvance.getId()) return false;
			else return (this.getId().equals(hrAdvance.getId()));
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