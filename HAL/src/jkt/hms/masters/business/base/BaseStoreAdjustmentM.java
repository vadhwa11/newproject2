package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_adjustment_m table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_adjustment_m"
 */

public abstract class BaseStoreAdjustmentM implements Serializable {

	public static String REF = "StoreAdjustmentM";
	public static String PROP_STATUS = "Status";
	public static String PROP_ADJUSTMENT_DATE = "AdjustmentDate";
	public static String PROP_STORE_STOCK_TAKING_M = "StoreStockTakingM";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ADJUSTMENT_NO = "AdjustmentNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_REASON = "Reason";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreAdjustmentM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreAdjustmentM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adjustmentNo;
	private java.util.Date adjustmentDate;
	private java.lang.String reason;
	private java.lang.String approvedBy;
	private java.lang.String remarks;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreStockTakingM storeStockTakingM;

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
	 * Return the value associated with the column: adjustment_no
	 */
	public java.lang.String getAdjustmentNo() {
		return adjustmentNo;
	}

	/**
	 * Set the value related to the column: adjustment_no
	 * 
	 * @param adjustmentNo
	 *            the adjustment_no value
	 */
	public void setAdjustmentNo(java.lang.String adjustmentNo) {
		this.adjustmentNo = adjustmentNo;
	}

	/**
	 * Return the value associated with the column: adjustment_date
	 */
	public java.util.Date getAdjustmentDate() {
		return adjustmentDate;
	}

	/**
	 * Set the value related to the column: adjustment_date
	 * 
	 * @param adjustmentDate
	 *            the adjustment_date value
	 */
	public void setAdjustmentDate(java.util.Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason() {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * 
	 * @param reason
	 *            the reason value
	 */
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}

	/**
	 * Return the value associated with the column: approved_by
	 */
	public java.lang.String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(java.lang.String approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
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
	 * Return the value associated with the column: store_stock_taking_m_id
	 */
	public jkt.hms.masters.business.StoreStockTakingM getStoreStockTakingM() {
		return storeStockTakingM;
	}

	/**
	 * Set the value related to the column: store_stock_taking_m_id
	 * 
	 * @param storeStockTakingM
	 *            the store_stock_taking_m_id value
	 */
	public void setStoreStockTakingM(
			jkt.hms.masters.business.StoreStockTakingM storeStockTakingM) {
		this.storeStockTakingM = storeStockTakingM;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreAdjustmentM))
			return false;
		else {
			jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM = (jkt.hms.masters.business.StoreAdjustmentM) obj;
			if (null == this.getId() || null == storeAdjustmentM.getId())
				return false;
			else
				return (this.getId().equals(storeAdjustmentM.getId()));
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