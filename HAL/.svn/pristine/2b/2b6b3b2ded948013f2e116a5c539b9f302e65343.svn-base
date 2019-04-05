package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_issue_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_issue_header"
 */

public abstract class BaseLibBookIssueHeader implements Serializable {

	public static String REF = "LibBookIssueHeader";
	public static String PROP_ISSUED_BY = "IssuedBy";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ISSUE_NO = "IssueNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookIssueHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookIssueHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String issueNo;
	private java.util.Date issueDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee issuedBy;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibBookIssueDetail> libBookIssueDetails;

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
	 * Return the value associated with the column: issue_no
	 */
	public java.lang.String getIssueNo() {
		return issueNo;
	}

	/**
	 * Set the value related to the column: issue_no
	 * 
	 * @param issueNo
	 *            the issue_no value
	 */
	public void setIssueNo(java.lang.String issueNo) {
		this.issueNo = issueNo;
	}

	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * 
	 * @param issueDate
	 *            the issue_date value
	 */
	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
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
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedBy() {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * 
	 * @param issuedBy
	 *            the issued_by value
	 */
	public void setIssuedBy(jkt.hms.masters.business.MasEmployee issuedBy) {
		this.issuedBy = issuedBy;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: LibBookIssueDetails
	 */
	public java.util.Set<jkt.hms.masters.business.LibBookIssueDetail> getLibBookIssueDetails() {
		return libBookIssueDetails;
	}

	/**
	 * Set the value related to the column: LibBookIssueDetails
	 * 
	 * @param libBookIssueDetails
	 *            the LibBookIssueDetails value
	 */
	public void setLibBookIssueDetails(
			java.util.Set<jkt.hms.masters.business.LibBookIssueDetail> libBookIssueDetails) {
		this.libBookIssueDetails = libBookIssueDetails;
	}

	public void addToLibBookIssueDetails(
			jkt.hms.masters.business.LibBookIssueDetail libBookIssueDetail) {
		if (null == getLibBookIssueDetails())
			setLibBookIssueDetails(new java.util.TreeSet<jkt.hms.masters.business.LibBookIssueDetail>());
		getLibBookIssueDetails().add(libBookIssueDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookIssueHeader))
			return false;
		else {
			jkt.hms.masters.business.LibBookIssueHeader libBookIssueHeader = (jkt.hms.masters.business.LibBookIssueHeader) obj;
			if (null == this.getId() || null == libBookIssueHeader.getId())
				return false;
			else
				return (this.getId().equals(libBookIssueHeader.getId()));
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