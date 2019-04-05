package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_autoclave_receipt_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_autoclave_receipt_m"
 */

public abstract class BaseCssdAutoclaveReceiptM implements Serializable {

	public static String REF = "CssdAutoclaveReceiptM";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_REQUEST = "Request";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseCssdAutoclaveReceiptM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdAutoclaveReceiptM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdAutoclaveReceiptM(java.lang.Integer id,
			jkt.hms.masters.business.CssdAutoclaveRequestM request,
			jkt.hms.masters.business.MasEmployee receivedBy,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String receiptNo, java.util.Date receiptDate,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setRequest(request);
		this.setReceivedBy(receivedBy);
		this.setDepartment(department);
		this.setReceiptNo(receiptNo);
		this.setReceiptDate(receiptDate);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String receiptNo;
	private java.util.Date receiptDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.CssdAutoclaveRequestM request;
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="receipt_id"
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
	 * Return the value associated with the column: receipt_no
	 */
	public java.lang.String getReceiptNo() {
		return receiptNo;
	}

	/**
	 * Set the value related to the column: receipt_no
	 * 
	 * @param receiptNo
	 *            the receipt_no value
	 */
	public void setReceiptNo(java.lang.String receiptNo) {
		this.receiptNo = receiptNo;
	}

	/**
	 * Return the value associated with the column: receipt_date
	 */
	public java.util.Date getReceiptDate() {
		return receiptDate;
	}

	/**
	 * Set the value related to the column: receipt_date
	 * 
	 * @param receiptDate
	 *            the receipt_date value
	 */
	public void setReceiptDate(java.util.Date receiptDate) {
		this.receiptDate = receiptDate;
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
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.CssdAutoclaveRequestM getRequest() {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * 
	 * @param request
	 *            the request_id value
	 */
	public void setRequest(
			jkt.hms.masters.business.CssdAutoclaveRequestM request) {
		this.request = request;
	}

	/**
	 * Return the value associated with the column: received_by
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy() {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * 
	 * @param receivedBy
	 *            the received_by value
	 */
	public void setReceivedBy(jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
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
	 * Return the value associated with the column: CssdAutoclaveReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> getCssdAutoclaveReceiptTs() {
		return cssdAutoclaveReceiptTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveReceiptTs
	 * 
	 * @param cssdAutoclaveReceiptTs
	 *            the CssdAutoclaveReceiptTs value
	 */
	public void setCssdAutoclaveReceiptTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs) {
		this.cssdAutoclaveReceiptTs = cssdAutoclaveReceiptTs;
	}

	public void addToCssdAutoclaveReceiptTs(
			jkt.hms.masters.business.CssdAutoclaveReceiptT cssdAutoclaveReceiptT) {
		if (null == getCssdAutoclaveReceiptTs())
			setCssdAutoclaveReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveReceiptT>());
		getCssdAutoclaveReceiptTs().add(cssdAutoclaveReceiptT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdAutoclaveReceiptM))
			return false;
		else {
			jkt.hms.masters.business.CssdAutoclaveReceiptM cssdAutoclaveReceiptM = (jkt.hms.masters.business.CssdAutoclaveReceiptM) obj;
			if (null == this.getId() || null == cssdAutoclaveReceiptM.getId())
				return false;
			else
				return (this.getId().equals(cssdAutoclaveReceiptM.getId()));
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