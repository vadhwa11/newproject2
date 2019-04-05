package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_reimb_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_reimb_header"
 */

public abstract class BaseHrReimbHeader  implements Serializable {

	public static String REF = "HrReimbHeader";
	public static String PROP_TOTAL_REIMB_AMT = "TotalReimbAmt";
	public static String PROP_REIMB_STATUS = "ReimbStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REIMB = "Reimb";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAYMODE = "Paymode";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_MAX_AMOUNT = "MaxAmount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrReimbHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrReimbHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String paymode;
	private java.lang.String remark;
	private java.math.BigDecimal maxAmount;
	private java.math.BigDecimal totalReimbAmt;
	private java.lang.String reimbStatus;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HrMasReimbersement reimb;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="reimb_header_id"
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
	 * Return the value associated with the column: paymode
	 */
	public java.lang.String getPaymode () {
		return paymode;
	}

	/**
	 * Set the value related to the column: paymode
	 * @param paymode the paymode value
	 */
	public void setPaymode (java.lang.String paymode) {
		this.paymode = paymode;
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
	 * Return the value associated with the column: max_amount
	 */
	public java.math.BigDecimal getMaxAmount () {
		return maxAmount;
	}

	/**
	 * Set the value related to the column: max_amount
	 * @param maxAmount the max_amount value
	 */
	public void setMaxAmount (java.math.BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}



	/**
	 * Return the value associated with the column: total_reimb_amt
	 */
	public java.math.BigDecimal getTotalReimbAmt () {
		return totalReimbAmt;
	}

	/**
	 * Set the value related to the column: total_reimb_amt
	 * @param totalReimbAmt the total_reimb_amt value
	 */
	public void setTotalReimbAmt (java.math.BigDecimal totalReimbAmt) {
		this.totalReimbAmt = totalReimbAmt;
	}



	/**
	 * Return the value associated with the column: reimb_status
	 */
	public java.lang.String getReimbStatus () {
		return reimbStatus;
	}

	/**
	 * Set the value related to the column: reimb_status
	 * @param reimbStatus the reimb_status value
	 */
	public void setReimbStatus (java.lang.String reimbStatus) {
		this.reimbStatus = reimbStatus;
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
	 * Return the value associated with the column: reimb_id
	 */
	public jkt.hms.masters.business.HrMasReimbersement getReimb () {
		return reimb;
	}

	/**
	 * Set the value related to the column: reimb_id
	 * @param reimb the reimb_id value
	 */
	public void setReimb (jkt.hms.masters.business.HrMasReimbersement reimb) {
		this.reimb = reimb;
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
		if (!(obj instanceof jkt.hms.masters.business.HrReimbHeader)) return false;
		else {
			jkt.hms.masters.business.HrReimbHeader hrReimbHeader = (jkt.hms.masters.business.HrReimbHeader) obj;
			if (null == this.getId() || null == hrReimbHeader.getId()) return false;
			else return (this.getId().equals(hrReimbHeader.getId()));
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