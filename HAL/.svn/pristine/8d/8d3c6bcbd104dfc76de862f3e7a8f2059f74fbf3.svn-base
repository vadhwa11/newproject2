package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_deposit_header table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_deposit_header"
 */

public abstract class BaseBlDepositHeader implements Serializable {

	public static String REF = "BlDepositHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_TOTAL_ADVANCE_AMT = "TotalAdvanceAmt";
	public static String PROP_PATIENT_RECEIPT_TYPE = "PatientReceiptType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_RECEIPT_TIME = "ReceiptTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlDepositHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlDepositHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String receiptNo;
	private java.util.Date receiptDate;
	private java.lang.String receiptTime;
	private java.math.BigDecimal totalAdvanceAmt;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String patientReceiptType;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlDepositDetails> blDepositDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="deposit_header_id"
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
	 * Return the value associated with the column: receipt_no
	 */
	public java.lang.String getReceiptNo() {
		return receiptNo;
	}

	/**
	 * Set the value related to the column: receipt_no
	 * 
	 * @param receiptNo
	 *            the receipt_no value
	 */
	public void setReceiptNo(java.lang.String receiptNo) {
		this.receiptNo = receiptNo;
	}

	/**
	 * Return the value associated with the column: receipt_date
	 */
	public java.util.Date getReceiptDate() {
		return receiptDate;
	}

	/**
	 * Set the value related to the column: receipt_date
	 * 
	 * @param receiptDate
	 *            the receipt_date value
	 */
	public void setReceiptDate(java.util.Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	/**
	 * Return the value associated with the column: receipt_time
	 */
	public java.lang.String getReceiptTime() {
		return receiptTime;
	}

	/**
	 * Set the value related to the column: receipt_time
	 * 
	 * @param receiptTime
	 *            the receipt_time value
	 */
	public void setReceiptTime(java.lang.String receiptTime) {
		this.receiptTime = receiptTime;
	}

	/**
	 * Return the value associated with the column: total_advance_amt
	 */
	public java.math.BigDecimal getTotalAdvanceAmt() {
		return totalAdvanceAmt;
	}

	/**
	 * Set the value related to the column: total_advance_amt
	 * 
	 * @param totalAdvanceAmt
	 *            the total_advance_amt value
	 */
	public void setTotalAdvanceAmt(java.math.BigDecimal totalAdvanceAmt) {
		this.totalAdvanceAmt = totalAdvanceAmt;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: patient_receipt_type
	 */
	public java.lang.String getPatientReceiptType() {
		return patientReceiptType;
	}

	/**
	 * Set the value related to the column: patient_receipt_type
	 * 
	 * @param patientReceiptType
	 *            the patient_receipt_type value
	 */
	public void setPatientReceiptType(java.lang.String patientReceiptType) {
		this.patientReceiptType = patientReceiptType;
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

	/**
	 * Return the value associated with the column: BlDepositDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlDepositDetails> getBlDepositDetails() {
		return blDepositDetails;
	}

	/**
	 * Set the value related to the column: BlDepositDetails
	 * 
	 * @param blDepositDetails
	 *            the BlDepositDetails value
	 */
	public void setBlDepositDetails(
			java.util.Set<jkt.hms.masters.business.BlDepositDetails> blDepositDetails) {
		this.blDepositDetails = blDepositDetails;
	}

	public void addToBlDepositDetails(
			jkt.hms.masters.business.BlDepositDetails blDepositDetails) {
		if (null == getBlDepositDetails())
			setBlDepositDetails(new java.util.TreeSet<jkt.hms.masters.business.BlDepositDetails>());
		getBlDepositDetails().add(blDepositDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlDepositHeader))
			return false;
		else {
			jkt.hms.masters.business.BlDepositHeader blDepositHeader = (jkt.hms.masters.business.BlDepositHeader) obj;
			if (null == this.getId() || null == blDepositHeader.getId())
				return false;
			else
				return (this.getId().equals(blDepositHeader.getId()));
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