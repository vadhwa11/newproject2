package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_op_bill_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_op_bill_details"
 */

public abstract class BaseBlOpBillDetails  implements Serializable {

	public static String REF = "BlOpBillDetails";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_RATE = "Rate";
	public static String PROP_REFUNDABLE_STATUS = "RefundableStatus";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_REFUNDED_AMT = "RefundedAmt";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_OP_BILL_HEADER = "OpBillHeader";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_BILL_TIME = "BillTime";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_PROPORTIONAL_DISCOUNT_AMOUNT = "ProportionalDiscountAmount";
	public static String PROP_STD_DEDUCTION_GEN = "StdDeductionGen";
	public static String PROP_STD_DEDUCTION_SPL = "StdDeductionSpl";
	public static String PROP_ID = "Id";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";


	// constructors
	public BaseBlOpBillDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlOpBillDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlOpBillDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.MasChargeCode chargeCode,
		jkt.hms.masters.business.BlOpBillHeader opBillHeader) {

		this.setId(id);
		this.setChargeCode(chargeCode);
		this.setOpBillHeader(opBillHeader);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal amount;
	private java.util.Date billDate;
	private java.lang.String billTime;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal proportionalDiscountAmount;
	private java.lang.Integer quantity;
	private java.math.BigDecimal rate;
	private java.lang.String refundableStatus;
	private java.math.BigDecimal refundedAmt;
	private java.math.BigDecimal stdDeductionGen;
	private java.math.BigDecimal stdDeductionSpl;

	// many to one
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.BlOpBillHeader opBillHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="op_bill_details_id"
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
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate () {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * @param billDate the bill_date value
	 */
	public void setBillDate (java.util.Date billDate) {
		this.billDate = billDate;
	}



	/**
	 * Return the value associated with the column: bill_time
	 */
	public java.lang.String getBillTime () {
		return billTime;
	}

	/**
	 * Set the value related to the column: bill_time
	 * @param billTime the bill_time value
	 */
	public void setBillTime (java.lang.String billTime) {
		this.billTime = billTime;
	}



	/**
	 * Return the value associated with the column: discount_amt
	 */
	public java.math.BigDecimal getDiscountAmt () {
		return discountAmt;
	}

	/**
	 * Set the value related to the column: discount_amt
	 * @param discountAmt the discount_amt value
	 */
	public void setDiscountAmt (java.math.BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}



	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent () {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * @param discountPercent the discount_percent value
	 */
	public void setDiscountPercent (java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}



	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt () {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * @param netAmt the net_amt value
	 */
	public void setNetAmt (java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
	}



	/**
	 * Return the value associated with the column: proportional_discount_amount
	 */
	public java.math.BigDecimal getProportionalDiscountAmount () {
		return proportionalDiscountAmount;
	}

	/**
	 * Set the value related to the column: proportional_discount_amount
	 * @param proportionalDiscountAmount the proportional_discount_amount value
	 */
	public void setProportionalDiscountAmount (java.math.BigDecimal proportionalDiscountAmount) {
		this.proportionalDiscountAmount = proportionalDiscountAmount;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: refundable_status
	 */
	public java.lang.String getRefundableStatus () {
		return refundableStatus;
	}

	/**
	 * Set the value related to the column: refundable_status
	 * @param refundableStatus the refundable_status value
	 */
	public void setRefundableStatus (java.lang.String refundableStatus) {
		this.refundableStatus = refundableStatus;
	}



	/**
	 * Return the value associated with the column: refunded_amt
	 */
	public java.math.BigDecimal getRefundedAmt () {
		return refundedAmt;
	}

	/**
	 * Set the value related to the column: refunded_amt
	 * @param refundedAmt the refunded_amt value
	 */
	public void setRefundedAmt (java.math.BigDecimal refundedAmt) {
		this.refundedAmt = refundedAmt;
	}



	/**
	 * Return the value associated with the column: std_deduction_gen
	 */
	public java.math.BigDecimal getStdDeductionGen () {
		return stdDeductionGen;
	}

	/**
	 * Set the value related to the column: std_deduction_gen
	 * @param stdDeductionGen the std_deduction_gen value
	 */
	public void setStdDeductionGen (java.math.BigDecimal stdDeductionGen) {
		this.stdDeductionGen = stdDeductionGen;
	}



	/**
	 * Return the value associated with the column: std_deduction_spl
	 */
	public java.math.BigDecimal getStdDeductionSpl () {
		return stdDeductionSpl;
	}

	/**
	 * Set the value related to the column: std_deduction_spl
	 * @param stdDeductionSpl the std_deduction_spl value
	 */
	public void setStdDeductionSpl (java.math.BigDecimal stdDeductionSpl) {
		this.stdDeductionSpl = stdDeductionSpl;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: op_bill_header_id
	 */
	public jkt.hms.masters.business.BlOpBillHeader getOpBillHeader () {
		return opBillHeader;
	}

	/**
	 * Set the value related to the column: op_bill_header_id
	 * @param opBillHeader the op_bill_header_id value
	 */
	public void setOpBillHeader (jkt.hms.masters.business.BlOpBillHeader opBillHeader) {
		this.opBillHeader = opBillHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlOpBillDetails)) return false;
		else {
			jkt.hms.masters.business.BlOpBillDetails blOpBillDetails = (jkt.hms.masters.business.BlOpBillDetails) obj;
			if (null == this.getId() || null == blOpBillDetails.getId()) return false;
			else return (this.getId().equals(blOpBillDetails.getId()));
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