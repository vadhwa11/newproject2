package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * lib_journal_receipt_entry_hd table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_journal_receipt_entry_hd"
 */

public abstract class BaseLibJournalReceiptEntryHd implements Serializable {

	public static String REF = "LibJournalReceiptEntryHd";
	public static String PROP_YEAR = "Year";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_MONTH = "Month";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ISSUE_NO = "IssueNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_STATUS_HD = "StatusHd";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibJournalReceiptEntryHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibJournalReceiptEntryHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLibJournalReceiptEntryHd(java.lang.Integer id,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
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
	private java.lang.String year;
	private java.lang.String month;
	private java.lang.String issueNo;
	private java.lang.String statusHd;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibJournalReceiptEntryDt> libJournalReceiptEntryDts;

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
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.String year) {
		this.year = year;
	}

	/**
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth() {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * 
	 * @param month
	 *            the month value
	 */
	public void setMonth(java.lang.String month) {
		this.month = month;
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
	 * Return the value associated with the column: status_hd
	 */
	public java.lang.String getStatusHd() {
		return statusHd;
	}

	/**
	 * Set the value related to the column: status_hd
	 * 
	 * @param statusHd
	 *            the status_hd value
	 */
	public void setStatusHd(java.lang.String statusHd) {
		this.statusHd = statusHd;
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
	 * Return the value associated with the column: LibJournalReceiptEntryDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibJournalReceiptEntryDt> getLibJournalReceiptEntryDts() {
		return libJournalReceiptEntryDts;
	}

	/**
	 * Set the value related to the column: LibJournalReceiptEntryDts
	 * 
	 * @param libJournalReceiptEntryDts
	 *            the LibJournalReceiptEntryDts value
	 */
	public void setLibJournalReceiptEntryDts(
			java.util.Set<jkt.hms.masters.business.LibJournalReceiptEntryDt> libJournalReceiptEntryDts) {
		this.libJournalReceiptEntryDts = libJournalReceiptEntryDts;
	}

	public void addToLibJournalReceiptEntryDts(
			jkt.hms.masters.business.LibJournalReceiptEntryDt libJournalReceiptEntryDt) {
		if (null == getLibJournalReceiptEntryDts())
			setLibJournalReceiptEntryDts(new java.util.TreeSet<jkt.hms.masters.business.LibJournalReceiptEntryDt>());
		getLibJournalReceiptEntryDts().add(libJournalReceiptEntryDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibJournalReceiptEntryHd))
			return false;
		else {
			jkt.hms.masters.business.LibJournalReceiptEntryHd libJournalReceiptEntryHd = (jkt.hms.masters.business.LibJournalReceiptEntryHd) obj;
			if (null == this.getId()
					|| null == libJournalReceiptEntryHd.getId())
				return false;
			else
				return (this.getId().equals(libJournalReceiptEntryHd.getId()));
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