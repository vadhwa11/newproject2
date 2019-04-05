package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_refund_header table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_refund_header"
 */

public abstract class BaseBlRefundHeader implements Serializable {

	public static String REF = "BlRefundHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REFUND_DATE = "RefundDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REFUND_TIME = "RefundTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_REFUND_NO = "RefundNo";
	public static String PROP_TOTAL_REFUND_AMT = "TotalRefundAmt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlRefundHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlRefundHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlRefundHeader(java.lang.Integer id, java.lang.String refundNo) {

		this.setId(id);
		this.setRefundNo(refundNo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String refundNo;
	private java.util.Date refundDate;
	private java.lang.String refundTime;
	private java.math.BigDecimal totalRefundAmt;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlRefundDetails> blRefundDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="refund_header_id"
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
	 * Return the value associated with the column: refund_no
	 */
	public java.lang.String getRefundNo() {
		return refundNo;
	}

	/**
	 * Set the value related to the column: refund_no
	 * 
	 * @param refundNo
	 *            the refund_no value
	 */
	public void setRefundNo(java.lang.String refundNo) {
		this.refundNo = refundNo;
	}

	/**
	 * Return the value associated with the column: refund_date
	 */
	public java.util.Date getRefundDate() {
		return refundDate;
	}

	/**
	 * Set the value related to the column: refund_date
	 * 
	 * @param refundDate
	 *            the refund_date value
	 */
	public void setRefundDate(java.util.Date refundDate) {
		this.refundDate = refundDate;
	}

	/**
	 * Return the value associated with the column: refund_time
	 */
	public java.lang.String getRefundTime() {
		return refundTime;
	}

	/**
	 * Set the value related to the column: refund_time
	 * 
	 * @param refundTime
	 *            the refund_time value
	 */
	public void setRefundTime(java.lang.String refundTime) {
		this.refundTime = refundTime;
	}

	/**
	 * Return the value associated with the column: total_refund_amt
	 */
	public java.math.BigDecimal getTotalRefundAmt() {
		return totalRefundAmt;
	}

	/**
	 * Set the value related to the column: total_refund_amt
	 * 
	 * @param totalRefundAmt
	 *            the total_refund_amt value
	 */
	public void setTotalRefundAmt(java.math.BigDecimal totalRefundAmt) {
		this.totalRefundAmt = totalRefundAmt;
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
	 * Return the value associated with the column: BlRefundDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlRefundDetails> getBlRefundDetails() {
		return blRefundDetails;
	}

	/**
	 * Set the value related to the column: BlRefundDetails
	 * 
	 * @param blRefundDetails
	 *            the BlRefundDetails value
	 */
	public void setBlRefundDetails(
			java.util.Set<jkt.hms.masters.business.BlRefundDetails> blRefundDetails) {
		this.blRefundDetails = blRefundDetails;
	}

	public void addToBlRefundDetails(
			jkt.hms.masters.business.BlRefundDetails blRefundDetails) {
		if (null == getBlRefundDetails())
			setBlRefundDetails(new java.util.TreeSet<jkt.hms.masters.business.BlRefundDetails>());
		getBlRefundDetails().add(blRefundDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlRefundHeader))
			return false;
		else {
			jkt.hms.masters.business.BlRefundHeader blRefundHeader = (jkt.hms.masters.business.BlRefundHeader) obj;
			if (null == this.getId() || null == blRefundHeader.getId())
				return false;
			else
				return (this.getId().equals(blRefundHeader.getId()));
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