package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_disposal_m table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_disposal_m"
 */

public abstract class BaseStoreDisposalM implements Serializable {

	public static String REF = "StoreDisposalM";
	public static String PROP_TYPE = "Type";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ISSUE = "Issue";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOS = "Bos";
	public static String PROP_INDENT = "Indent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISPOSAL_NO = "DisposalNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreDisposalM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDisposalM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreDisposalM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.StoreBosM bos,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String disposalNo, java.util.Date date,
			java.lang.String type, java.lang.String status,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setBos(bos);
		this.setDepartment(department);
		this.setDisposalNo(disposalNo);
		this.setDate(date);
		this.setType(type);
		this.setStatus(status);
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
	private java.lang.String disposalNo;
	private java.util.Date date;
	private java.lang.String type;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.StoreBosM bos;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreIndentM indent;
	private jkt.hms.masters.business.StoreIssueM issue;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreDisposalT> storeDisposalTs;

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
	 * Return the value associated with the column: disposal_no
	 */
	public java.lang.String getDisposalNo() {
		return disposalNo;
	}

	/**
	 * Set the value related to the column: disposal_no
	 * 
	 * @param disposalNo
	 *            the disposal_no value
	 */
	public void setDisposalNo(java.lang.String disposalNo) {
		this.disposalNo = disposalNo;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: bos_id
	 */
	public jkt.hms.masters.business.StoreBosM getBos() {
		return bos;
	}

	/**
	 * Set the value related to the column: bos_id
	 * 
	 * @param bos
	 *            the bos_id value
	 */
	public void setBos(jkt.hms.masters.business.StoreBosM bos) {
		this.bos = bos;
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
	 * Return the value associated with the column: indent_id
	 */
	public jkt.hms.masters.business.StoreIndentM getIndent() {
		return indent;
	}

	/**
	 * Set the value related to the column: indent_id
	 * 
	 * @param indent
	 *            the indent_id value
	 */
	public void setIndent(jkt.hms.masters.business.StoreIndentM indent) {
		this.indent = indent;
	}

	/**
	 * Return the value associated with the column: issue_id
	 */
	public jkt.hms.masters.business.StoreIssueM getIssue() {
		return issue;
	}

	/**
	 * Set the value related to the column: issue_id
	 * 
	 * @param issue
	 *            the issue_id value
	 */
	public void setIssue(jkt.hms.masters.business.StoreIssueM issue) {
		this.issue = issue;
	}

	/**
	 * Return the value associated with the column: StoreDisposalTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalT> getStoreDisposalTs() {
		return storeDisposalTs;
	}

	/**
	 * Set the value related to the column: StoreDisposalTs
	 * 
	 * @param storeDisposalTs
	 *            the StoreDisposalTs value
	 */
	public void setStoreDisposalTs(
			java.util.Set<jkt.hms.masters.business.StoreDisposalT> storeDisposalTs) {
		this.storeDisposalTs = storeDisposalTs;
	}

	public void addToStoreDisposalTs(
			jkt.hms.masters.business.StoreDisposalT storeDisposalT) {
		if (null == getStoreDisposalTs())
			setStoreDisposalTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDisposalT>());
		getStoreDisposalTs().add(storeDisposalT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreDisposalM))
			return false;
		else {
			jkt.hms.masters.business.StoreDisposalM storeDisposalM = (jkt.hms.masters.business.StoreDisposalM) obj;
			if (null == this.getId() || null == storeDisposalM.getId())
				return false;
			else
				return (this.getId().equals(storeDisposalM.getId()));
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