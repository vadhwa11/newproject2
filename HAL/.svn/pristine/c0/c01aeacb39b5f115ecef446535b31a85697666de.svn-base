package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_bank_reconciliation_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_bank_reconciliation_details"
 */

public abstract class BaseFaBankReconciliationDetails  implements Serializable {

	public static String REF = "FaBankReconciliationDetails";
	public static String PROP_VOUCHER_HEADER = "VoucherHeader";
	public static String PROP_CHEQUE_STATUS = "ChequeStatus";
	public static String PROP_CLEARING_DATE = "ClearingDate";
	public static String PROP_BANK_RECONCILIATION_HEADER = "BankReconciliationHeader";
	public static String PROP_ID = "Id";
	public static String PROP_CHEQUE_DATE = "ChequeDate";
	public static String PROP_CHEQUE_AMT = "ChequeAmt";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_VOUCHER_TYPE = "VoucherType";


	// constructors
	public BaseFaBankReconciliationDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaBankReconciliationDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date chequeDate;
	private java.lang.String voucherType;
	private java.lang.String chequeNo;
	private java.math.BigDecimal chequeAmt;
	private java.lang.String chequeStatus;
	private java.util.Date clearingDate;

	// many to one
	private jkt.hms.masters.business.FaVoucherHeader voucherHeader;
	private jkt.hms.masters.business.FaBankReconciliationHeader bankReconciliationHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bank_reconciliation_details_id"
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
	 * Return the value associated with the column: cheque_date
	 */
	public java.util.Date getChequeDate () {
		return chequeDate;
	}

	/**
	 * Set the value related to the column: cheque_date
	 * @param chequeDate the cheque_date value
	 */
	public void setChequeDate (java.util.Date chequeDate) {
		this.chequeDate = chequeDate;
	}



	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.String getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * @param voucherType the voucher_type value
	 */
	public void setVoucherType (java.lang.String voucherType) {
		this.voucherType = voucherType;
	}



	/**
	 * Return the value associated with the column: cheque_no
	 */
	public java.lang.String getChequeNo () {
		return chequeNo;
	}

	/**
	 * Set the value related to the column: cheque_no
	 * @param chequeNo the cheque_no value
	 */
	public void setChequeNo (java.lang.String chequeNo) {
		this.chequeNo = chequeNo;
	}



	/**
	 * Return the value associated with the column: cheque_amt
	 */
	public java.math.BigDecimal getChequeAmt () {
		return chequeAmt;
	}

	/**
	 * Set the value related to the column: cheque_amt
	 * @param chequeAmt the cheque_amt value
	 */
	public void setChequeAmt (java.math.BigDecimal chequeAmt) {
		this.chequeAmt = chequeAmt;
	}



	/**
	 * Return the value associated with the column: cheque_status
	 */
	public java.lang.String getChequeStatus () {
		return chequeStatus;
	}

	/**
	 * Set the value related to the column: cheque_status
	 * @param chequeStatus the cheque_status value
	 */
	public void setChequeStatus (java.lang.String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}



	/**
	 * Return the value associated with the column: clearing_date
	 */
	public java.util.Date getClearingDate () {
		return clearingDate;
	}

	/**
	 * Set the value related to the column: clearing_date
	 * @param clearingDate the clearing_date value
	 */
	public void setClearingDate (java.util.Date clearingDate) {
		this.clearingDate = clearingDate;
	}



	/**
	 * Return the value associated with the column: voucher_header_id
	 */
	public jkt.hms.masters.business.FaVoucherHeader getVoucherHeader () {
		return voucherHeader;
	}

	/**
	 * Set the value related to the column: voucher_header_id
	 * @param voucherHeader the voucher_header_id value
	 */
	public void setVoucherHeader (jkt.hms.masters.business.FaVoucherHeader voucherHeader) {
		this.voucherHeader = voucherHeader;
	}



	/**
	 * Return the value associated with the column: bank_reconciliation_header_id
	 */
	public jkt.hms.masters.business.FaBankReconciliationHeader getBankReconciliationHeader () {
		return bankReconciliationHeader;
	}

	/**
	 * Set the value related to the column: bank_reconciliation_header_id
	 * @param bankReconciliationHeader the bank_reconciliation_header_id value
	 */
	public void setBankReconciliationHeader (jkt.hms.masters.business.FaBankReconciliationHeader bankReconciliationHeader) {
		this.bankReconciliationHeader = bankReconciliationHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaBankReconciliationDetails)) return false;
		else {
			jkt.hms.masters.business.FaBankReconciliationDetails faBankReconciliationDetails = (jkt.hms.masters.business.FaBankReconciliationDetails) obj;
			if (null == this.getId() || null == faBankReconciliationDetails.getId()) return false;
			else return (this.getId().equals(faBankReconciliationDetails.getId()));
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