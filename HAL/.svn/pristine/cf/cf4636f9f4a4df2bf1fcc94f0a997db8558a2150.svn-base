package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_pay_structure table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_pay_structure"
 */

public abstract class BaseHrEmployeePayStructure  implements Serializable {

	public static String REF = "HrEmployeePayStructure";
	public static String PROP_PAYROLL = "Payroll";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PAYMENT_MODE = "PaymentMode";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BASIC_PAY = "BasicPay";
	public static String PROP_ID = "Id";
	public static String PROP_PF_PERCENTAGE = "PfPercentage";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrEmployeePayStructure () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeePayStructure (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal basicPay;
	private java.lang.String paymentMode;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.Float pfPercentage;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.HrMasPayroll payroll;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: basic_pay
	 */
	public java.math.BigDecimal getBasicPay () {
		return basicPay;
	}

	/**
	 * Set the value related to the column: basic_pay
	 * @param basicPay the basic_pay value
	 */
	public void setBasicPay (java.math.BigDecimal basicPay) {
		this.basicPay = basicPay;
	}



	/**
	 * Return the value associated with the column: payment_mode
	 */
	public java.lang.String getPaymentMode () {
		return paymentMode;
	}

	/**
	 * Set the value related to the column: payment_mode
	 * @param paymentMode the payment_mode value
	 */
	public void setPaymentMode (java.lang.String paymentMode) {
		this.paymentMode = paymentMode;
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
	 * Return the value associated with the column: pf_percentage
	 */
	public java.lang.Float getPfPercentage () {
		return pfPercentage;
	}

	/**
	 * Set the value related to the column: pf_percentage
	 * @param pfPercentage the pf_percentage value
	 */
	public void setPfPercentage (java.lang.Float pfPercentage) {
		this.pfPercentage = pfPercentage;
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
	 * Return the value associated with the column: payroll_id
	 */
	public jkt.hms.masters.business.HrMasPayroll getPayroll () {
		return payroll;
	}

	/**
	 * Set the value related to the column: payroll_id
	 * @param payroll the payroll_id value
	 */
	public void setPayroll (jkt.hms.masters.business.HrMasPayroll payroll) {
		this.payroll = payroll;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeePayStructure)) return false;
		else {
			jkt.hms.masters.business.HrEmployeePayStructure hrEmployeePayStructure = (jkt.hms.masters.business.HrEmployeePayStructure) obj;
			if (null == this.getId() || null == hrEmployeePayStructure.getId()) return false;
			else return (this.getId().equals(hrEmployeePayStructure.getId()));
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