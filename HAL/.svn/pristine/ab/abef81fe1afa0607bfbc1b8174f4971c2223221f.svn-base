package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_voucher_header table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_voucher_header"
 */

public abstract class BaseBlVoucherHeader implements Serializable {

	public static String REF = "BlVoucherHeader";
	public static String PROP_VOUCHER_DATE = "VoucherDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VOUCHER_TIME = "VoucherTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEBIT_AMT = "DebitAmt";
	public static String PROP_VOUCHER_TYPE = "VoucherType";
	public static String PROP_CREDIT_AMT = "CreditAmt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VOUCHER_NO = "VoucherNo";
	public static String PROP_ID = "Id";
	public static String PROP_NARATION = "Naration";

	// constructors
	public BaseBlVoucherHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlVoucherHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String voucherNo;
	private java.lang.String voucherType;
	private java.lang.String naration;
	private java.util.Date voucherDate;
	private java.lang.String voucherTime;
	private java.math.BigDecimal debitAmt;
	private java.math.BigDecimal creditAmt;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="voucher_header_id"
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
	 * Return the value associated with the column: voucher_no
	 */
	public java.lang.String getVoucherNo() {
		return voucherNo;
	}

	/**
	 * Set the value related to the column: voucher_no
	 * 
	 * @param voucherNo
	 *            the voucher_no value
	 */
	public void setVoucherNo(java.lang.String voucherNo) {
		this.voucherNo = voucherNo;
	}

	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.String getVoucherType() {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * 
	 * @param voucherType
	 *            the voucher_type value
	 */
	public void setVoucherType(java.lang.String voucherType) {
		this.voucherType = voucherType;
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
	 * Return the value associated with the column: voucher_date
	 */
	public java.util.Date getVoucherDate() {
		return voucherDate;
	}

	/**
	 * Set the value related to the column: voucher_date
	 * 
	 * @param voucherDate
	 *            the voucher_date value
	 */
	public void setVoucherDate(java.util.Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	/**
	 * Return the value associated with the column: voucher_time
	 */
	public java.lang.String getVoucherTime() {
		return voucherTime;
	}

	/**
	 * Set the value related to the column: voucher_time
	 * 
	 * @param voucherTime
	 *            the voucher_time value
	 */
	public void setVoucherTime(java.lang.String voucherTime) {
		this.voucherTime = voucherTime;
	}

	/**
	 * Return the value associated with the column: debit_amt
	 */
	public java.math.BigDecimal getDebitAmt() {
		return debitAmt;
	}

	/**
	 * Set the value related to the column: debit_amt
	 * 
	 * @param debitAmt
	 *            the debit_amt value
	 */
	public void setDebitAmt(java.math.BigDecimal debitAmt) {
		this.debitAmt = debitAmt;
	}

	/**
	 * Return the value associated with the column: credit_amt
	 */
	public java.math.BigDecimal getCreditAmt() {
		return creditAmt;
	}

	/**
	 * Set the value related to the column: credit_amt
	 * 
	 * @param creditAmt
	 *            the credit_amt value
	 */
	public void setCreditAmt(java.math.BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
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
	 * Return the value associated with the column: BlVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlVoucherDetails> getBlVoucherDetails() {
		return blVoucherDetails;
	}

	/**
	 * Set the value related to the column: BlVoucherDetails
	 * 
	 * @param blVoucherDetails
	 *            the BlVoucherDetails value
	 */
	public void setBlVoucherDetails(
			java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails) {
		this.blVoucherDetails = blVoucherDetails;
	}

	public void addToBlVoucherDetails(
			jkt.hms.masters.business.BlVoucherDetails blVoucherDetails) {
		if (null == getBlVoucherDetails())
			setBlVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.BlVoucherDetails>());
		getBlVoucherDetails().add(blVoucherDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlVoucherHeader))
			return false;
		else {
			jkt.hms.masters.business.BlVoucherHeader blVoucherHeader = (jkt.hms.masters.business.BlVoucherHeader) obj;
			if (null == this.getId() || null == blVoucherHeader.getId())
				return false;
			else
				return (this.getId().equals(blVoucherHeader.getId()));
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