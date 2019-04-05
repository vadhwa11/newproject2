package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_voucher_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_voucher_details"
 */

public abstract class BaseFaVoucherDetails  implements Serializable {

	public static String REF = "FaVoucherDetails";
	public static String PROP_VOUCHER_HEADER = "VoucherHeader";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_NARRATION = "Narration";
	public static String PROP_SUB_LED = "SubLed";
	public static String PROP_PAY_MODE = "PayMode";
	public static String PROP_CLEAR_DATE = "ClearDate";
	public static String PROP_ACCOUNT_ID_FOR_REPORT = "AccountIdForReport";
	public static String PROP_DR_AMOUNT = "DrAmount";
	public static String PROP_CR_AMOUNT = "CrAmount";
	public static String PROP_COST_CENTER = "CostCenter";
	public static String PROP_SUB_LED_ID_FOR_REPORT = "SubLedIdForReport";
	public static String PROP_ID = "Id";
	public static String PROP_RECONCILE = "Reconcile";


	// constructors
	public BaseFaVoucherDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaVoucherDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal drAmount;
	private java.math.BigDecimal crAmount;
	private java.lang.String narration;
	private java.lang.String payMode;
	private java.lang.String reconcile;
	private java.util.Date clearDate;

	// many to one
	private jkt.hms.masters.business.MasCostCenter costCenter;
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.FaMasAccount accountIdForReport;
	private jkt.hms.masters.business.FaMasSubLed subLed;
	private jkt.hms.masters.business.FaMasSubLed subLedIdForReport;
	private jkt.hms.masters.business.FaVoucherHeader voucherHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="voucher_details_id"
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
	 * Return the value associated with the column: dr_amount
	 */
	public java.math.BigDecimal getDrAmount () {
		return drAmount;
	}

	/**
	 * Set the value related to the column: dr_amount
	 * @param drAmount the dr_amount value
	 */
	public void setDrAmount (java.math.BigDecimal drAmount) {
		this.drAmount = drAmount;
	}



	/**
	 * Return the value associated with the column: cr_amount
	 */
	public java.math.BigDecimal getCrAmount () {
		return crAmount;
	}

	/**
	 * Set the value related to the column: cr_amount
	 * @param crAmount the cr_amount value
	 */
	public void setCrAmount (java.math.BigDecimal crAmount) {
		this.crAmount = crAmount;
	}



	/**
	 * Return the value associated with the column: narration
	 */
	public java.lang.String getNarration () {
		return narration;
	}

	/**
	 * Set the value related to the column: narration
	 * @param narration the narration value
	 */
	public void setNarration (java.lang.String narration) {
		this.narration = narration;
	}



	/**
	 * Return the value associated with the column: pay_mode
	 */
	public java.lang.String getPayMode () {
		return payMode;
	}

	/**
	 * Set the value related to the column: pay_mode
	 * @param payMode the pay_mode value
	 */
	public void setPayMode (java.lang.String payMode) {
		this.payMode = payMode;
	}



	/**
	 * Return the value associated with the column: reconcile
	 */
	public java.lang.String getReconcile () {
		return reconcile;
	}

	/**
	 * Set the value related to the column: reconcile
	 * @param reconcile the reconcile value
	 */
	public void setReconcile (java.lang.String reconcile) {
		this.reconcile = reconcile;
	}



	/**
	 * Return the value associated with the column: clear_date
	 */
	public java.util.Date getClearDate () {
		return clearDate;
	}

	/**
	 * Set the value related to the column: clear_date
	 * @param clearDate the clear_date value
	 */
	public void setClearDate (java.util.Date clearDate) {
		this.clearDate = clearDate;
	}



	/**
	 * Return the value associated with the column: cost_center_id
	 */
	public jkt.hms.masters.business.MasCostCenter getCostCenter () {
		return costCenter;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * @param costCenter the cost_center_id value
	 */
	public void setCostCenter (jkt.hms.masters.business.MasCostCenter costCenter) {
		this.costCenter = costCenter;
	}



	/**
	 * Return the value associated with the column: account_id
	 */
	public jkt.hms.masters.business.FaMasAccount getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account_id
	 * @param account the account_id value
	 */
	public void setAccount (jkt.hms.masters.business.FaMasAccount account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: account_id_for_report
	 */
	public jkt.hms.masters.business.FaMasAccount getAccountIdForReport () {
		return accountIdForReport;
	}

	/**
	 * Set the value related to the column: account_id_for_report
	 * @param accountIdForReport the account_id_for_report value
	 */
	public void setAccountIdForReport (jkt.hms.masters.business.FaMasAccount accountIdForReport) {
		this.accountIdForReport = accountIdForReport;
	}



	/**
	 * Return the value associated with the column: sub_led_id
	 */
	public jkt.hms.masters.business.FaMasSubLed getSubLed () {
		return subLed;
	}

	/**
	 * Set the value related to the column: sub_led_id
	 * @param subLed the sub_led_id value
	 */
	public void setSubLed (jkt.hms.masters.business.FaMasSubLed subLed) {
		this.subLed = subLed;
	}



	/**
	 * Return the value associated with the column: sub_led_id_for_report
	 */
	public jkt.hms.masters.business.FaMasSubLed getSubLedIdForReport () {
		return subLedIdForReport;
	}

	/**
	 * Set the value related to the column: sub_led_id_for_report
	 * @param subLedIdForReport the sub_led_id_for_report value
	 */
	public void setSubLedIdForReport (jkt.hms.masters.business.FaMasSubLed subLedIdForReport) {
		this.subLedIdForReport = subLedIdForReport;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaVoucherDetails)) return false;
		else {
			jkt.hms.masters.business.FaVoucherDetails faVoucherDetails = (jkt.hms.masters.business.FaVoucherDetails) obj;
			if (null == this.getId() || null == faVoucherDetails.getId()) return false;
			else return (this.getId().equals(faVoucherDetails.getId()));
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