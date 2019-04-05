package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_patient_ledger table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_patient_ledger"
 */

public abstract class BaseBlPatientLedger implements Serializable {

	public static String REF = "BlPatientLedger";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_REFUND_AMT = "TotalRefundAmt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TOTAL_FINAL_BILL_AMT = "TotalFinalBillAmt";
	public static String PROP_TOTAL_ADV_AMT = "TotalAdvAmt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TOTAL_CHARGE_SLIP_AMT = "TotalChargeSlipAmt";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlPatientLedger() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPatientLedger(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal totalAdvAmt;
	private java.math.BigDecimal totalChargeSlipAmt;
	private java.math.BigDecimal totalFinalBillAmt;
	private java.math.BigDecimal totalRefundAmt;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="patient_ledger_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: total_adv_amt
	 */
	public java.math.BigDecimal getTotalAdvAmt() {
		return totalAdvAmt;
	}

	/**
	 * Set the value related to the column: total_adv_amt
	 * 
	 * @param totalAdvAmt
	 *            the total_adv_amt value
	 */
	public void setTotalAdvAmt(java.math.BigDecimal totalAdvAmt) {
		this.totalAdvAmt = totalAdvAmt;
	}

	/**
	 * Return the value associated with the column: total_charge_slip_amt
	 */
	public java.math.BigDecimal getTotalChargeSlipAmt() {
		return totalChargeSlipAmt;
	}

	/**
	 * Set the value related to the column: total_charge_slip_amt
	 * 
	 * @param totalChargeSlipAmt
	 *            the total_charge_slip_amt value
	 */
	public void setTotalChargeSlipAmt(java.math.BigDecimal totalChargeSlipAmt) {
		this.totalChargeSlipAmt = totalChargeSlipAmt;
	}

	/**
	 * Return the value associated with the column: total_final_bill_amt
	 */
	public java.math.BigDecimal getTotalFinalBillAmt() {
		return totalFinalBillAmt;
	}

	/**
	 * Set the value related to the column: total_final_bill_amt
	 * 
	 * @param totalFinalBillAmt
	 *            the total_final_bill_amt value
	 */
	public void setTotalFinalBillAmt(java.math.BigDecimal totalFinalBillAmt) {
		this.totalFinalBillAmt = totalFinalBillAmt;
	}

	/**
	 * Return the value associated with the column: total_refund_amt
	 */
	public java.math.BigDecimal getTotalRefundAmt() {
		return totalRefundAmt;
	}

	/**
	 * Set the value related to the column: total_refund_amt
	 * 
	 * @param totalRefundAmt
	 *            the total_refund_amt value
	 */
	public void setTotalRefundAmt(java.math.BigDecimal totalRefundAmt) {
		this.totalRefundAmt = totalRefundAmt;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlPatientLedger))
			return false;
		else {
			jkt.hms.masters.business.BlPatientLedger blPatientLedger = (jkt.hms.masters.business.BlPatientLedger) obj;
			if (null == this.getId() || null == blPatientLedger.getId())
				return false;
			else
				return (this.getId().equals(blPatientLedger.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}