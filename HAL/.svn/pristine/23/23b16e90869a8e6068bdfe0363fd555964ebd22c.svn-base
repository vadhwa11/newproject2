package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_mmf_department_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_mmf_department_t"
 */

public abstract class BaseStoreMmfDepartmentT implements Serializable {

	public static String REF = "StoreMmfDepartmentT";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_CURR_YEAR_MMF = "CurrYearMmf";
	public static String PROP_MMF_IN_QTY = "MmfInQty";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_STATUS = "ApprovedStatus";
	public static String PROP_PRE_YEAR_MMF = "PreYearMmf";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_STORE_MMF_DEPARTMENT_M = "StoreMmfDepartmentM";

	// constructors
	public BaseStoreMmfDepartmentT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMmfDepartmentT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.math.BigDecimal mmfInQty;
	private java.math.BigDecimal preYearMmf;
	private java.math.BigDecimal currYearMmf;
	private java.lang.String remarks;
	private java.lang.String approvedStatus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM;
	private jkt.hms.masters.business.MasStoreItem item;

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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: mmf_in_qty
	 */
	public java.math.BigDecimal getMmfInQty() {
		return mmfInQty;
	}

	/**
	 * Set the value related to the column: mmf_in_qty
	 * 
	 * @param mmfInQty
	 *            the mmf_in_qty value
	 */
	public void setMmfInQty(java.math.BigDecimal mmfInQty) {
		this.mmfInQty = mmfInQty;
	}

	/**
	 * Return the value associated with the column: prev_year_mmf
	 */
	public java.math.BigDecimal getPreYearMmf() {
		return preYearMmf;
	}

	/**
	 * Set the value related to the column: prev_year_mmf
	 * 
	 * @param preYearMmf
	 *            the prev_year_mmf value
	 */
	public void setPreYearMmf(java.math.BigDecimal preYearMmf) {
		this.preYearMmf = preYearMmf;
	}

	/**
	 * Return the value associated with the column: curr_year_mmf
	 */
	public java.math.BigDecimal getCurrYearMmf() {
		return currYearMmf;
	}

	/**
	 * Set the value related to the column: curr_year_mmf
	 * 
	 * @param currYearMmf
	 *            the curr_year_mmf value
	 */
	public void setCurrYearMmf(java.math.BigDecimal currYearMmf) {
		this.currYearMmf = currYearMmf;
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
	 * Return the value associated with the column: approved_status
	 */
	public java.lang.String getApprovedStatus() {
		return approvedStatus;
	}

	/**
	 * Set the value related to the column: approved_status
	 * 
	 * @param approvedStatus
	 *            the approved_status value
	 */
	public void setApprovedStatus(java.lang.String approvedStatus) {
		this.approvedStatus = approvedStatus;
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
	 * Return the value associated with the column: store_mmf_department_m_id
	 */
	public jkt.hms.masters.business.StoreMmfDepartmentM getStoreMmfDepartmentM() {
		return storeMmfDepartmentM;
	}

	/**
	 * Set the value related to the column: store_mmf_department_m_id
	 * 
	 * @param storeMmfDepartmentM
	 *            the store_mmf_department_m_id value
	 */
	public void setStoreMmfDepartmentM(
			jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM) {
		this.storeMmfDepartmentM = storeMmfDepartmentM;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMmfDepartmentT))
			return false;
		else {
			jkt.hms.masters.business.StoreMmfDepartmentT storeMmfDepartmentT = (jkt.hms.masters.business.StoreMmfDepartmentT) obj;
			if (null == this.getId() || null == storeMmfDepartmentT.getId())
				return false;
			else
				return (this.getId().equals(storeMmfDepartmentT.getId()));
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