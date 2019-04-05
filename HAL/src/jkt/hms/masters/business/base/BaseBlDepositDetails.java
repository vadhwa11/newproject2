package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_deposit_details table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_deposit_details"
 */

public abstract class BaseBlDepositDetails implements Serializable {

	public static String REF = "BlDepositDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_RECEIVED_FROM = "ReceivedFrom";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CHEQUE_DATE = "ChequeDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ADVANCE_AMOUNT = "AdvanceAmount";
	public static String PROP_DEPOSIT_HEADER = "DepositHeader";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_PAYMENT_MODE = "PaymentMode";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlDepositDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlDepositDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String paymentMode;
	private java.math.BigDecimal advanceAmount;
	private java.lang.String chequeNo;
	private java.util.Date chequeDate;
	private java.lang.String bankName;
	private java.lang.String receivedFrom;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BlDepositHeader depositHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="deposit_details_id"
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
	 * Return the value associated with the column: payment_mode
	 */
	public java.lang.String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * Set the value related to the column: payment_mode
	 * 
	 * @param paymentMode
	 *            the payment_mode value
	 */
	public void setPaymentMode(java.lang.String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * Return the value associated with the column: advance_amount
	 */
	public java.math.BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}

	/**
	 * Set the value related to the column: advance_amount
	 * 
	 * @param advanceAmount
	 *            the advance_amount value
	 */
	public void setAdvanceAmount(java.math.BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	/**
	 * Return the value associated with the column: cheque_no
	 */
	public java.lang.String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Set the value related to the column: cheque_no
	 * 
	 * @param chequeNo
	 *            the cheque_no value
	 */
	public void setChequeNo(java.lang.String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Return the value associated with the column: cheque_date
	 */
	public java.util.Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Set the value related to the column: cheque_date
	 * 
	 * @param chequeDate
	 *            the cheque_date value
	 */
	public void setChequeDate(java.util.Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName() {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * 
	 * @param bankName
	 *            the bank_name value
	 */
	public void setBankName(java.lang.String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Return the value associated with the column: received_from
	 */
	public java.lang.String getReceivedFrom() {
		return receivedFrom;
	}

	/**
	 * Set the value related to the column: received_from
	 * 
	 * @param receivedFrom
	 *            the received_from value
	 */
	public void setReceivedFrom(java.lang.String receivedFrom) {
		this.receivedFrom = receivedFrom;
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
	 * Return the value associated with the column: deposit_header_id
	 */
	public jkt.hms.masters.business.BlDepositHeader getDepositHeader() {
		return depositHeader;
	}

	/**
	 * Set the value related to the column: deposit_header_id
	 * 
	 * @param depositHeader
	 *            the deposit_header_id value
	 */
	public void setDepositHeader(
			jkt.hms.masters.business.BlDepositHeader depositHeader) {
		this.depositHeader = depositHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlDepositDetails))
			return false;
		else {
			jkt.hms.masters.business.BlDepositDetails blDepositDetails = (jkt.hms.masters.business.BlDepositDetails) obj;
			if (null == this.getId() || null == blDepositDetails.getId())
				return false;
			else
				return (this.getId().equals(blDepositDetails.getId()));
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