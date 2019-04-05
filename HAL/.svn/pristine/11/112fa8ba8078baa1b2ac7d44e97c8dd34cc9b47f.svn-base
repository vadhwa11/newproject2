package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_voucher_details table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_voucher_details"
 */

public abstract class BaseBlVoucherDetails implements Serializable {

	public static String REF = "BlVoucherDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RECEIPT_TYPE = "ReceiptType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_SUC_ACC_CODE = "SucAccCode";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ACC = "Acc";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VOUCHER_HEADER = "VoucherHeader";
	public static String PROP_ID = "Id";
	public static String PROP_NARATION = "Naration";

	// constructors
	public BaseBlVoucherDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlVoucherDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String naration;
	private java.lang.String sucAccCode;
	private java.math.BigDecimal amount;
	private java.lang.String receiptType;
	private java.lang.String patientType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasAccount acc;
	private jkt.hms.masters.business.BlVoucherHeader voucherHeader;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="voucher_details_id"
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
	 * Return the value associated with the column: naration
	 */
	public java.lang.String getNaration() {
		return naration;
	}

	/**
	 * Set the value related to the column: naration
	 * 
	 * @param naration
	 *            the naration value
	 */
	public void setNaration(java.lang.String naration) {
		this.naration = naration;
	}

	/**
	 * Return the value associated with the column: suc_acc_code
	 */
	public java.lang.String getSucAccCode() {
		return sucAccCode;
	}

	/**
	 * Set the value related to the column: suc_acc_code
	 * 
	 * @param sucAccCode
	 *            the suc_acc_code value
	 */
	public void setSucAccCode(java.lang.String sucAccCode) {
		this.sucAccCode = sucAccCode;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: receipt_type
	 */
	public java.lang.String getReceiptType() {
		return receiptType;
	}

	/**
	 * Set the value related to the column: receipt_type
	 * 
	 * @param receiptType
	 *            the receipt_type value
	 */
	public void setReceiptType(java.lang.String receiptType) {
		this.receiptType = receiptType;
	}

	/**
	 * Return the value associated with the column: patient_type
	 */
	public java.lang.String getPatientType() {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type
	 * 
	 * @param patientType
	 *            the patient_type value
	 */
	public void setPatientType(java.lang.String patientType) {
		this.patientType = patientType;
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
	 * Return the value associated with the column: acc_id
	 */
	public jkt.hms.masters.business.MasAccount getAcc() {
		return acc;
	}

	/**
	 * Set the value related to the column: acc_id
	 * 
	 * @param acc
	 *            the acc_id value
	 */
	public void setAcc(jkt.hms.masters.business.MasAccount acc) {
		this.acc = acc;
	}

	/**
	 * Return the value associated with the column: voucher_header_id
	 */
	public jkt.hms.masters.business.BlVoucherHeader getVoucherHeader() {
		return voucherHeader;
	}

	/**
	 * Set the value related to the column: voucher_header_id
	 * 
	 * @param voucherHeader
	 *            the voucher_header_id value
	 */
	public void setVoucherHeader(
			jkt.hms.masters.business.BlVoucherHeader voucherHeader) {
		this.voucherHeader = voucherHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.BlVoucherDetails))
			return false;
		else {
			jkt.hms.masters.business.BlVoucherDetails blVoucherDetails = (jkt.hms.masters.business.BlVoucherDetails) obj;
			if (null == this.getId() || null == blVoucherDetails.getId())
				return false;
			else
				return (this.getId().equals(blVoucherDetails.getId()));
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