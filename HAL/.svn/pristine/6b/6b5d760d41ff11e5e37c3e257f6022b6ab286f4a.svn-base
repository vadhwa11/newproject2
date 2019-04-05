package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_receipt_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_receipt_details"
 */

public abstract class BaseBlReceiptDetails  implements Serializable {

	public static String REF = "BlReceiptDetails";
	public static String PROP_ORDER = "Order";
	public static String PROP_ADVANCE_AMOUNT_TYPE = "AdvanceAmountType";
	public static String PROP_BANK = "Bank";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_RECEIPT_TIME = "ReceiptTime";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ID = "Id";
	public static String PROP_CHEQUE_DATE = "ChequeDate";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_PAYMENT_MODE = "PaymentMode";
	public static String PROP_RECEIPT_HEADER = "ReceiptHeader";


	// constructors
	public BaseBlReceiptDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlReceiptDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlReceiptDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.BlReceiptHeader receiptHeader) {

		this.setId(id);
		this.setReceiptHeader(receiptHeader);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String paymentMode;
	private java.math.BigDecimal amount;
	private java.lang.String chequeNo;
	private java.util.Date chequeDate;
	private java.util.Date receiptDate;
	private java.lang.String receiptTime;
	private java.lang.String advanceAmountType;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.BlReceiptHeader receiptHeader;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.DgOrderdt order;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="receipt_details_id"
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
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
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
	 * Return the value associated with the column: receipt_date
	 */
	public java.util.Date getReceiptDate () {
		return receiptDate;
	}

	/**
	 * Set the value related to the column: receipt_date
	 * @param receiptDate the receipt_date value
	 */
	public void setReceiptDate (java.util.Date receiptDate) {
		this.receiptDate = receiptDate;
	}



	/**
	 * Return the value associated with the column: receipt_time
	 */
	public java.lang.String getReceiptTime () {
		return receiptTime;
	}

	/**
	 * Set the value related to the column: receipt_time
	 * @param receiptTime the receipt_time value
	 */
	public void setReceiptTime (java.lang.String receiptTime) {
		this.receiptTime = receiptTime;
	}



	/**
	 * Return the value associated with the column: advance_amount_type
	 */
	public java.lang.String getAdvanceAmountType () {
		return advanceAmountType;
	}

	/**
	 * Set the value related to the column: advance_amount_type
	 * @param advanceAmountType the advance_amount_type value
	 */
	public void setAdvanceAmountType (java.lang.String advanceAmountType) {
		this.advanceAmountType = advanceAmountType;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
	}



	/**
	 * Return the value associated with the column: receipt_header_id
	 */
	public jkt.hms.masters.business.BlReceiptHeader getReceiptHeader () {
		return receiptHeader;
	}

	/**
	 * Set the value related to the column: receipt_header_id
	 * @param receiptHeader the receipt_header_id value
	 */
	public void setReceiptHeader (jkt.hms.masters.business.BlReceiptHeader receiptHeader) {
		this.receiptHeader = receiptHeader;
	}



	/**
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
	}



	/**
	 * Return the value associated with the column: order_id
	 */
	public jkt.hms.masters.business.DgOrderdt getOrder () {
		return order;
	}

	/**
	 * Set the value related to the column: order_id
	 * @param order the order_id value
	 */
	public void setOrder (jkt.hms.masters.business.DgOrderdt order) {
		this.order = order;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlReceiptDetails)) return false;
		else {
			jkt.hms.masters.business.BlReceiptDetails blReceiptDetails = (jkt.hms.masters.business.BlReceiptDetails) obj;
			if (null == this.getId() || null == blReceiptDetails.getId()) return false;
			else return (this.getId().equals(blReceiptDetails.getId()));
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