package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_receipt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_receipt"
 */

public abstract class BaseBlReceipt  implements Serializable {

	public static String REF = "BlReceipt";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RECEIPT_TIME = "ReceiptTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_RECEIPT_MODE = "ReceiptMode";
	public static String PROP_RECEIPT_AMT = "ReceiptAmt";
	public static String PROP_HIN = "Hin";
	public static String PROP_RECEIPT_TYPE = "ReceiptType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MODE_DATE = "ModeDate";
	public static String PROP_MODE_NO = "ModeNo";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_MODE_EXP_DATE = "ModeExpDate";
	public static String PROP_ID = "Id";
	public static String PROP_MODE_BANK = "ModeBank";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseBlReceipt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlReceipt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer receiptNo;
	private java.math.BigDecimal receiptAmt;
	private java.lang.String receiptType;
	private java.lang.String receiptMode;
	private java.lang.String modeNo;
	private java.util.Date modeDate;
	private java.util.Date modeExpDate;
	private java.lang.String modeBank;
	private java.util.Date receiptDate;
	private java.lang.String receiptTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="receipt_id"
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
	 * Return the value associated with the column: receipt_no
	 */
	public java.lang.Integer getReceiptNo () {
		return receiptNo;
	}

	/**
	 * Set the value related to the column: receipt_no
	 * @param receiptNo the receipt_no value
	 */
	public void setReceiptNo (java.lang.Integer receiptNo) {
		this.receiptNo = receiptNo;
	}



	/**
	 * Return the value associated with the column: receipt_amt
	 */
	public java.math.BigDecimal getReceiptAmt () {
		return receiptAmt;
	}

	/**
	 * Set the value related to the column: receipt_amt
	 * @param receiptAmt the receipt_amt value
	 */
	public void setReceiptAmt (java.math.BigDecimal receiptAmt) {
		this.receiptAmt = receiptAmt;
	}



	/**
	 * Return the value associated with the column: receipt_type
	 */
	public java.lang.String getReceiptType () {
		return receiptType;
	}

	/**
	 * Set the value related to the column: receipt_type
	 * @param receiptType the receipt_type value
	 */
	public void setReceiptType (java.lang.String receiptType) {
		this.receiptType = receiptType;
	}



	/**
	 * Return the value associated with the column: receipt_mode
	 */
	public java.lang.String getReceiptMode () {
		return receiptMode;
	}

	/**
	 * Set the value related to the column: receipt_mode
	 * @param receiptMode the receipt_mode value
	 */
	public void setReceiptMode (java.lang.String receiptMode) {
		this.receiptMode = receiptMode;
	}



	/**
	 * Return the value associated with the column: mode_no
	 */
	public java.lang.String getModeNo () {
		return modeNo;
	}

	/**
	 * Set the value related to the column: mode_no
	 * @param modeNo the mode_no value
	 */
	public void setModeNo (java.lang.String modeNo) {
		this.modeNo = modeNo;
	}



	/**
	 * Return the value associated with the column: mode_date
	 */
	public java.util.Date getModeDate () {
		return modeDate;
	}

	/**
	 * Set the value related to the column: mode_date
	 * @param modeDate the mode_date value
	 */
	public void setModeDate (java.util.Date modeDate) {
		this.modeDate = modeDate;
	}



	/**
	 * Return the value associated with the column: mode_exp_date
	 */
	public java.util.Date getModeExpDate () {
		return modeExpDate;
	}

	/**
	 * Set the value related to the column: mode_exp_date
	 * @param modeExpDate the mode_exp_date value
	 */
	public void setModeExpDate (java.util.Date modeExpDate) {
		this.modeExpDate = modeExpDate;
	}



	/**
	 * Return the value associated with the column: mode_bank
	 */
	public java.lang.String getModeBank () {
		return modeBank;
	}

	/**
	 * Set the value related to the column: mode_bank
	 * @param modeBank the mode_bank value
	 */
	public void setModeBank (java.lang.String modeBank) {
		this.modeBank = modeBank;
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
	 * Return the value associated with the column: last_chg_by_id
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by_id
	 * @param lastChgBy the last_chg_by_id value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlReceipt)) return false;
		else {
			jkt.hms.masters.business.BlReceipt blReceipt = (jkt.hms.masters.business.BlReceipt) obj;
			if (null == this.getId() || null == blReceipt.getId()) return false;
			else return (this.getId().equals(blReceipt.getId()));
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