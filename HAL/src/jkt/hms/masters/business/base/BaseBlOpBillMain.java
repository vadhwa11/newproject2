package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_op_bill_main table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_op_bill_main"
 */

public abstract class BaseBlOpBillMain implements Serializable {

	public static String REF = "BlOpBillMain";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OS_AMT = "OsAmt";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BILL_AMT = "BillAmt";
	public static String PROP_HIN = "Hin";
	public static String PROP_RECEIPT_AMT = "ReceiptAmt";
	public static String PROP_BILL_TIME = "BillTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_DIS_AMT = "DisAmt";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlOpBillMain() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlOpBillMain(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer billNo;
	private java.math.BigDecimal billAmt;
	private java.math.BigDecimal receiptAmt;
	private java.math.BigDecimal osAmt;
	private java.math.BigDecimal disAmt;
	private java.util.Date billDate;
	private java.lang.String billTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlOpBillDetail> blOpBillDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="op_bill_main_id"
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
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.Integer getBillNo() {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * 
	 * @param billNo
	 *            the bill_no value
	 */
	public void setBillNo(java.lang.Integer billNo) {
		this.billNo = billNo;
	}

	/**
	 * Return the value associated with the column: bill_amt
	 */
	public java.math.BigDecimal getBillAmt() {
		return billAmt;
	}

	/**
	 * Set the value related to the column: bill_amt
	 * 
	 * @param billAmt
	 *            the bill_amt value
	 */
	public void setBillAmt(java.math.BigDecimal billAmt) {
		this.billAmt = billAmt;
	}

	/**
	 * Return the value associated with the column: receipt_amt
	 */
	public java.math.BigDecimal getReceiptAmt() {
		return receiptAmt;
	}

	/**
	 * Set the value related to the column: receipt_amt
	 * 
	 * @param receiptAmt
	 *            the receipt_amt value
	 */
	public void setReceiptAmt(java.math.BigDecimal receiptAmt) {
		this.receiptAmt = receiptAmt;
	}

	/**
	 * Return the value associated with the column: os_amt
	 */
	public java.math.BigDecimal getOsAmt() {
		return osAmt;
	}

	/**
	 * Set the value related to the column: os_amt
	 * 
	 * @param osAmt
	 *            the os_amt value
	 */
	public void setOsAmt(java.math.BigDecimal osAmt) {
		this.osAmt = osAmt;
	}

	/**
	 * Return the value associated with the column: dis_amt
	 */
	public java.math.BigDecimal getDisAmt() {
		return disAmt;
	}

	/**
	 * Set the value related to the column: dis_amt
	 * 
	 * @param disAmt
	 *            the dis_amt value
	 */
	public void setDisAmt(java.math.BigDecimal disAmt) {
		this.disAmt = disAmt;
	}

	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate() {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * 
	 * @param billDate
	 *            the bill_date value
	 */
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}

	/**
	 * Return the value associated with the column: bill_time
	 */
	public java.lang.String getBillTime() {
		return billTime;
	}

	/**
	 * Set the value related to the column: bill_time
	 * 
	 * @param billTime
	 *            the bill_time value
	 */
	public void setBillTime(java.lang.String billTime) {
		this.billTime = billTime;
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
	 * Return the value associated with the column: last_chg_by_id
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by_id
	 * 
	 * @param lastChgBy
	 *            the last_chg_by_id value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: BlOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillDetail> getBlOpBillDetails() {
		return blOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlOpBillDetails
	 * 
	 * @param blOpBillDetails
	 *            the BlOpBillDetails value
	 */
	public void setBlOpBillDetails(
			java.util.Set<jkt.hms.masters.business.BlOpBillDetail> blOpBillDetails) {
		this.blOpBillDetails = blOpBillDetails;
	}

	public void addToBlOpBillDetails(
			jkt.hms.masters.business.BlOpBillDetail blOpBillDetail) {
		if (null == getBlOpBillDetails())
			setBlOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillDetail>());
		getBlOpBillDetails().add(blOpBillDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlOpBillMain))
			return false;
		else {
			jkt.hms.masters.business.BlOpBillMain blOpBillMain = (jkt.hms.masters.business.BlOpBillMain) obj;
			if (null == this.getId() || null == blOpBillMain.getId())
				return false;
			else
				return (this.getId().equals(blOpBillMain.getId()));
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