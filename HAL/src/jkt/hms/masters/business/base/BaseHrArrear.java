package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_arrear table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_arrear"
 */

public abstract class BaseHrArrear  implements Serializable {

	public static String REF = "HrArrear";
	public static String PROP_PF = "Pf";
	public static String PROP_ARREAR_STATUS = "ArrearStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PAID_DATE = "PaidDate";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_ARREAR_AMOUNT = "ArrearAmount";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PAY_ELEMENT = "PayElement";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ARREAR_DATE = "ArrearDate";


	// constructors
	public BaseHrArrear () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrArrear (java.lang.Integer id) {
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
	private java.math.BigDecimal arrearAmount;
	private java.lang.String pf;
	private java.util.Date arrearDate;
	private java.util.Date paidDate;
	private java.lang.String arrearStatus;
	private java.lang.String remark;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HrMasPayElement payElement;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="arrear_id"
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
	 * Return the value associated with the column: arrear_amount
	 */
	public java.math.BigDecimal getArrearAmount () {
		return arrearAmount;
	}

	/**
	 * Set the value related to the column: arrear_amount
	 * @param arrearAmount the arrear_amount value
	 */
	public void setArrearAmount (java.math.BigDecimal arrearAmount) {
		this.arrearAmount = arrearAmount;
	}



	/**
	 * Return the value associated with the column: pf
	 */
	public java.lang.String getPf () {
		return pf;
	}

	/**
	 * Set the value related to the column: pf
	 * @param pf the pf value
	 */
	public void setPf (java.lang.String pf) {
		this.pf = pf;
	}



	/**
	 * Return the value associated with the column: arrear_date
	 */
	public java.util.Date getArrearDate () {
		return arrearDate;
	}

	/**
	 * Set the value related to the column: arrear_date
	 * @param arrearDate the arrear_date value
	 */
	public void setArrearDate (java.util.Date arrearDate) {
		this.arrearDate = arrearDate;
	}



	/**
	 * Return the value associated with the column: paid_date
	 */
	public java.util.Date getPaidDate () {
		return paidDate;
	}

	/**
	 * Set the value related to the column: paid_date
	 * @param paidDate the paid_date value
	 */
	public void setPaidDate (java.util.Date paidDate) {
		this.paidDate = paidDate;
	}



	/**
	 * Return the value associated with the column: arrear_status
	 */
	public java.lang.String getArrearStatus () {
		return arrearStatus;
	}

	/**
	 * Set the value related to the column: arrear_status
	 * @param arrearStatus the arrear_status value
	 */
	public void setArrearStatus (java.lang.String arrearStatus) {
		this.arrearStatus = arrearStatus;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: pay_element_id
	 */
	public jkt.hms.masters.business.HrMasPayElement getPayElement () {
		return payElement;
	}

	/**
	 * Set the value related to the column: pay_element_id
	 * @param payElement the pay_element_id value
	 */
	public void setPayElement (jkt.hms.masters.business.HrMasPayElement payElement) {
		this.payElement = payElement;
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
		if (!(obj instanceof jkt.hms.masters.business.HrArrear)) return false;
		else {
			jkt.hms.masters.business.HrArrear hrArrear = (jkt.hms.masters.business.HrArrear) obj;
			if (null == this.getId() || null == hrArrear.getId()) return false;
			else return (this.getId().equals(hrArrear.getId()));
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