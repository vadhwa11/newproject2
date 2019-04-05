package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_grn_return_m table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_grn_return_m"
 */

public abstract class BaseStoreGrnReturnM implements Serializable {

	public static String REF = "StoreGrnReturnM";
	public static String PROP_STATUS = "Status";
	public static String PROP_RETURN_DATE = "ReturnDate";
	public static String PROP_REF_DOC_NO = "RefDocNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RETURN_NO = "ReturnNo";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RETURN_BY = "ReturnBy";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_SUPPLY_ORDER_NO = "SupplyOrderNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_REASON = "Reason";

	// constructors
	public BaseStoreGrnReturnM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreGrnReturnM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreGrnReturnM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital) {

		this.setId(id);
		this.setHospital(hospital);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String reason;
	private java.lang.String refDocNo;
	private java.lang.String remarks;
	private java.util.Date returnDate;
	private java.lang.String returnNo;
	private java.lang.String status;
	private java.lang.String supplyOrderNo;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee returnBy;
	private jkt.hms.masters.business.MasStoreSupplier supplier;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="grn_return_id"
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
	 * Return the value associated with the column: ref_doc_no
	 */
	public java.lang.String getRefDocNo() {
		return refDocNo;
	}

	/**
	 * Set the value related to the column: ref_doc_no
	 * 
	 * @param refDocNo
	 *            the ref_doc_no value
	 */
	public void setRefDocNo(java.lang.String refDocNo) {
		this.refDocNo = refDocNo;
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
	 * Return the value associated with the column: return_date
	 */
	public java.util.Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Set the value related to the column: return_date
	 * 
	 * @param returnDate
	 *            the return_date value
	 */
	public void setReturnDate(java.util.Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Return the value associated with the column: return_no
	 */
	public java.lang.String getReturnNo() {
		return returnNo;
	}

	/**
	 * Set the value related to the column: return_no
	 * 
	 * @param returnNo
	 *            the return_no value
	 */
	public void setReturnNo(java.lang.String returnNo) {
		this.returnNo = returnNo;
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
	 * Return the value associated with the column: supply_order_no
	 */
	public java.lang.String getSupplyOrderNo() {
		return supplyOrderNo;
	}

	/**
	 * Set the value related to the column: supply_order_no
	 * 
	 * @param supplyOrderNo
	 *            the supply_order_no value
	 */
	public void setSupplyOrderNo(java.lang.String supplyOrderNo) {
		this.supplyOrderNo = supplyOrderNo;
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
	 * Return the value associated with the column: return_by
	 */
	public jkt.hms.masters.business.MasEmployee getReturnBy() {
		return returnBy;
	}

	/**
	 * Set the value related to the column: return_by
	 * 
	 * @param returnBy
	 *            the return_by value
	 */
	public void setReturnBy(jkt.hms.masters.business.MasEmployee returnBy) {
		this.returnBy = returnBy;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: StoreGrnReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> getStoreGrnReturnTs() {
		return storeGrnReturnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnTs
	 * 
	 * @param storeGrnReturnTs
	 *            the StoreGrnReturnTs value
	 */
	public void setStoreGrnReturnTs(
			java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs) {
		this.storeGrnReturnTs = storeGrnReturnTs;
	}

	public void addToStoreGrnReturnTs(
			jkt.hms.masters.business.StoreGrnReturnT storeGrnReturnT) {
		if (null == getStoreGrnReturnTs())
			setStoreGrnReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnT>());
		getStoreGrnReturnTs().add(storeGrnReturnT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreGrnReturnM))
			return false;
		else {
			jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM = (jkt.hms.masters.business.StoreGrnReturnM) obj;
			if (null == this.getId() || null == storeGrnReturnM.getId())
				return false;
			else
				return (this.getId().equals(storeGrnReturnM.getId()));
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