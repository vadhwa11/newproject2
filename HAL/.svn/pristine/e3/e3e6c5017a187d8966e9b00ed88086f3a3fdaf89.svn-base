package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_discard_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_discard_entry"
 */

public abstract class BaseBloodDiscardEntry implements Serializable {

	public static String REF = "BloodDiscardEntry";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISCARD_DATE = "DiscardDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_STOCK_DETAIL = "StockDetail";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DISCARD_NO = "DiscardNo";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseBloodDiscardEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodDiscardEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String discardNo;
	private java.util.Date discardDate;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.BloodStockDetail stockDetail;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: discard_no
	 */
	public java.lang.String getDiscardNo() {
		return discardNo;
	}

	/**
	 * Set the value related to the column: discard_no
	 * 
	 * @param discardNo
	 *            the discard_no value
	 */
	public void setDiscardNo(java.lang.String discardNo) {
		this.discardNo = discardNo;
	}

	/**
	 * Return the value associated with the column: discard_date
	 */
	public java.util.Date getDiscardDate() {
		return discardDate;
	}

	/**
	 * Set the value related to the column: discard_date
	 * 
	 * @param discardDate
	 *            the discard_date value
	 */
	public void setDiscardDate(java.util.Date discardDate) {
		this.discardDate = discardDate;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: stock_detail_id
	 */
	public jkt.hms.masters.business.BloodStockDetail getStockDetail() {
		return stockDetail;
	}

	/**
	 * Set the value related to the column: stock_detail_id
	 * 
	 * @param stockDetail
	 *            the stock_detail_id value
	 */
	public void setStockDetail(
			jkt.hms.masters.business.BloodStockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodDiscardEntry))
			return false;
		else {
			jkt.hms.masters.business.BloodDiscardEntry bloodDiscardEntry = (jkt.hms.masters.business.BloodDiscardEntry) obj;
			if (null == this.getId() || null == bloodDiscardEntry.getId())
				return false;
			else
				return (this.getId().equals(bloodDiscardEntry.getId()));
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