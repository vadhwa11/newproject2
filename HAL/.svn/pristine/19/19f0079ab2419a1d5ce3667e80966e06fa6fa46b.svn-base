package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_tender_proposal
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_proposal"
 */

public abstract class BaseStoreTenderProposal implements Serializable {

	public static String REF = "StoreTenderProposal";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QTY_IN_MMF = "QtyInMmf";
	public static String PROP_ID = "Id";
	public static String PROP_PO = "Po";
	public static String PROP_TENDER_ID = "TenderId";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TENDER_QTY = "TenderQty";

	// constructors
	public BaseStoreTenderProposal() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderProposal(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTenderProposal(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasStoreItem item) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setItem(item);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal qtyInMmf;
	private java.math.BigDecimal tenderQty;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreTenderM tenderId;
	private jkt.hms.masters.business.StorePoHeader po;

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
	 * Return the value associated with the column: qty_in_mmf
	 */
	public java.math.BigDecimal getQtyInMmf() {
		return qtyInMmf;
	}

	/**
	 * Set the value related to the column: qty_in_mmf
	 * 
	 * @param qtyInMmf
	 *            the qty_in_mmf value
	 */
	public void setQtyInMmf(java.math.BigDecimal qtyInMmf) {
		this.qtyInMmf = qtyInMmf;
	}

	/**
	 * Return the value associated with the column: tender_qty
	 */
	public java.math.BigDecimal getTenderQty() {
		return tenderQty;
	}

	/**
	 * Set the value related to the column: tender_qty
	 * 
	 * @param tenderQty
	 *            the tender_qty value
	 */
	public void setTenderQty(java.math.BigDecimal tenderQty) {
		this.tenderQty = tenderQty;
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

	/**
	 * Return the value associated with the column: tender_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTenderId() {
		return tenderId;
	}

	/**
	 * Set the value related to the column: tender_id
	 * 
	 * @param tenderId
	 *            the tender_id value
	 */
	public void setTenderId(jkt.hms.masters.business.StoreTenderM tenderId) {
		this.tenderId = tenderId;
	}

	/**
	 * Return the value associated with the column: po_id
	 */
	public jkt.hms.masters.business.StorePoHeader getPo() {
		return po;
	}

	/**
	 * Set the value related to the column: po_id
	 * 
	 * @param po
	 *            the po_id value
	 */
	public void setPo(jkt.hms.masters.business.StorePoHeader po) {
		this.po = po;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderProposal))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderProposal storeTenderProposal = (jkt.hms.masters.business.StoreTenderProposal) obj;
			if (null == this.getId() || null == storeTenderProposal.getId())
				return false;
			else
				return (this.getId().equals(storeTenderProposal.getId()));
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