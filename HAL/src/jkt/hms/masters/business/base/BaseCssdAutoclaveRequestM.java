package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_autoclave_request_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_autoclave_request_m"
 */

public abstract class BaseCssdAutoclaveRequestM implements Serializable {

	public static String REF = "CssdAutoclaveRequestM";
	public static String PROP_ORDER_TIME = "OrderTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_ORDER_BY = "OrderBy";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ISSUED_TO = "IssuedTo";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseCssdAutoclaveRequestM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdAutoclaveRequestM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdAutoclaveRequestM(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasEmployee orderBy,
			java.lang.String orderNo, java.util.Date orderDate,
			java.lang.String orderTime) {

		this.setId(id);
		this.setDepartment(department);
		this.setOrderBy(orderBy);
		this.setOrderNo(orderNo);
		this.setOrderDate(orderDate);
		this.setOrderTime(orderTime);
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
	private java.util.Date orderDate;
	private java.lang.String orderNo;
	private java.lang.String orderTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee issuedTo;
	private jkt.hms.masters.business.MasEmployee orderBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptM> cssdAutoclaveReceiptMs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="request_id"
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
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * 
	 * @param orderDate
	 *            the order_date value
	 */
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo() {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * 
	 * @param orderNo
	 *            the order_no value
	 */
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Return the value associated with the column: order_time
	 */
	public java.lang.String getOrderTime() {
		return orderTime;
	}

	/**
	 * Set the value related to the column: order_time
	 * 
	 * @param orderTime
	 *            the order_time value
	 */
	public void setOrderTime(java.lang.String orderTime) {
		this.orderTime = orderTime;
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
	 * Return the value associated with the column: issued_to
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedTo() {
		return issuedTo;
	}

	/**
	 * Set the value related to the column: issued_to
	 * 
	 * @param issuedTo
	 *            the issued_to value
	 */
	public void setIssuedTo(jkt.hms.masters.business.MasEmployee issuedTo) {
		this.issuedTo = issuedTo;
	}

	/**
	 * Return the value associated with the column: order_by
	 */
	public jkt.hms.masters.business.MasEmployee getOrderBy() {
		return orderBy;
	}

	/**
	 * Set the value related to the column: order_by
	 * 
	 * @param orderBy
	 *            the order_by value
	 */
	public void setOrderBy(jkt.hms.masters.business.MasEmployee orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveEntryTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> getCssdAutoclaveEntryTs() {
		return cssdAutoclaveEntryTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveEntryTs
	 * 
	 * @param cssdAutoclaveEntryTs
	 *            the CssdAutoclaveEntryTs value
	 */
	public void setCssdAutoclaveEntryTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs) {
		this.cssdAutoclaveEntryTs = cssdAutoclaveEntryTs;
	}

	public void addToCssdAutoclaveEntryTs(
			jkt.hms.masters.business.CssdAutoclaveEntryT cssdAutoclaveEntryT) {
		if (null == getCssdAutoclaveEntryTs())
			setCssdAutoclaveEntryTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveEntryT>());
		getCssdAutoclaveEntryTs().add(cssdAutoclaveEntryT);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveReceiptMs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptM> getCssdAutoclaveReceiptMs() {
		return cssdAutoclaveReceiptMs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveReceiptMs
	 * 
	 * @param cssdAutoclaveReceiptMs
	 *            the CssdAutoclaveReceiptMs value
	 */
	public void setCssdAutoclaveReceiptMs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptM> cssdAutoclaveReceiptMs) {
		this.cssdAutoclaveReceiptMs = cssdAutoclaveReceiptMs;
	}

	public void addToCssdAutoclaveReceiptMs(
			jkt.hms.masters.business.CssdAutoclaveReceiptM cssdAutoclaveReceiptM) {
		if (null == getCssdAutoclaveReceiptMs())
			setCssdAutoclaveReceiptMs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveReceiptM>());
		getCssdAutoclaveReceiptMs().add(cssdAutoclaveReceiptM);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> getCssdAutoclaveRequestTs() {
		return cssdAutoclaveRequestTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveRequestTs
	 * 
	 * @param cssdAutoclaveRequestTs
	 *            the CssdAutoclaveRequestTs value
	 */
	public void setCssdAutoclaveRequestTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs) {
		this.cssdAutoclaveRequestTs = cssdAutoclaveRequestTs;
	}

	public void addToCssdAutoclaveRequestTs(
			jkt.hms.masters.business.CssdAutoclaveRequestT cssdAutoclaveRequestT) {
		if (null == getCssdAutoclaveRequestTs())
			setCssdAutoclaveRequestTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveRequestT>());
		getCssdAutoclaveRequestTs().add(cssdAutoclaveRequestT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdAutoclaveRequestM))
			return false;
		else {
			jkt.hms.masters.business.CssdAutoclaveRequestM cssdAutoclaveRequestM = (jkt.hms.masters.business.CssdAutoclaveRequestM) obj;
			if (null == this.getId() || null == cssdAutoclaveRequestM.getId())
				return false;
			else
				return (this.getId().equals(cssdAutoclaveRequestM.getId()));
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