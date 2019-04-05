package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the department_medicine_issue table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="department_medicine_issue"
 */

public abstract class BaseDepartmentMedicineIssue  implements Serializable {

	public static String REF = "DepartmentMedicineIssue";
	public static String PROP_QTY_REMAINING = "QtyRemaining";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISPENSARY_ISSUE_NO = "DispensaryIssueNo";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QTY_REQUIRED = "QtyRequired";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_STORE_ITEM_BATCH_STOCK = "StoreItemBatchStock";


	// constructors
	public BaseDepartmentMedicineIssue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDepartmentMedicineIssue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal qtyRequired;
	private java.math.BigDecimal qtyIssued;
	private java.math.BigDecimal qtyRemaining;
	private java.lang.String dispensaryIssueNo;
	private java.lang.String remarks;
	private java.util.Date issueDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: qty_required
	 */
	public java.math.BigDecimal getQtyRequired () {
		return qtyRequired;
	}

	/**
	 * Set the value related to the column: qty_required
	 * @param qtyRequired the qty_required value
	 */
	public void setQtyRequired (java.math.BigDecimal qtyRequired) {
		this.qtyRequired = qtyRequired;
	}



	/**
	 * Return the value associated with the column: qty_issued
	 */
	public java.math.BigDecimal getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.math.BigDecimal qtyIssued) {
		this.qtyIssued = qtyIssued;
	}



	/**
	 * Return the value associated with the column: qty_remaining
	 */
	public java.math.BigDecimal getQtyRemaining () {
		return qtyRemaining;
	}

	/**
	 * Set the value related to the column: qty_remaining
	 * @param qtyRemaining the qty_remaining value
	 */
	public void setQtyRemaining (java.math.BigDecimal qtyRemaining) {
		this.qtyRemaining = qtyRemaining;
	}



	/**
	 * Return the value associated with the column: dispensary_issue_no
	 */
	public java.lang.String getDispensaryIssueNo () {
		return dispensaryIssueNo;
	}

	/**
	 * Set the value related to the column: dispensary_issue_no
	 * @param dispensaryIssueNo the dispensary_issue_no value
	 */
	public void setDispensaryIssueNo (java.lang.String dispensaryIssueNo) {
		this.dispensaryIssueNo = dispensaryIssueNo;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: store_item_batch_stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStoreItemBatchStock () {
		return storeItemBatchStock;
	}

	/**
	 * Set the value related to the column: store_item_batch_stock_id
	 * @param storeItemBatchStock the store_item_batch_stock_id value
	 */
	public void setStoreItemBatchStock (jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		this.storeItemBatchStock = storeItemBatchStock;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DepartmentMedicineIssue)) return false;
		else {
			jkt.hms.masters.business.DepartmentMedicineIssue departmentMedicineIssue = (jkt.hms.masters.business.DepartmentMedicineIssue) obj;
			if (null == this.getId() || null == departmentMedicineIssue.getId()) return false;
			else return (this.getId().equals(departmentMedicineIssue.getId()));
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