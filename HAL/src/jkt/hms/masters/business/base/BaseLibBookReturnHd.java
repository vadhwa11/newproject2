package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_return_hd table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_return_hd"
 */

public abstract class BaseLibBookReturnHd implements Serializable {

	public static String REF = "LibBookReturnHd";
	public static String PROP_RETURN_DATE = "ReturnDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ISSUE_HD = "IssueHd";
	public static String PROP_RETURN_NO = "ReturnNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookReturnHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookReturnHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String returnNo;
	private java.util.Date returnDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.LibBookIssueHeader issueHd;
	private jkt.hms.masters.business.MasEmployee receivedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibBookReturnDt> libBookReturnDts;

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
	 * Return the value associated with the column: issue_hd_id
	 */
	public jkt.hms.masters.business.LibBookIssueHeader getIssueHd() {
		return issueHd;
	}

	/**
	 * Set the value related to the column: issue_hd_id
	 * 
	 * @param issueHd
	 *            the issue_hd_id value
	 */
	public void setIssueHd(jkt.hms.masters.business.LibBookIssueHeader issueHd) {
		this.issueHd = issueHd;
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
	 * Return the value associated with the column: LibBookReturnDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibBookReturnDt> getLibBookReturnDts() {
		return libBookReturnDts;
	}

	/**
	 * Set the value related to the column: LibBookReturnDts
	 * 
	 * @param libBookReturnDts
	 *            the LibBookReturnDts value
	 */
	public void setLibBookReturnDts(
			java.util.Set<jkt.hms.masters.business.LibBookReturnDt> libBookReturnDts) {
		this.libBookReturnDts = libBookReturnDts;
	}

	public void addToLibBookReturnDts(
			jkt.hms.masters.business.LibBookReturnDt libBookReturnDt) {
		if (null == getLibBookReturnDts())
			setLibBookReturnDts(new java.util.TreeSet<jkt.hms.masters.business.LibBookReturnDt>());
		getLibBookReturnDts().add(libBookReturnDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookReturnHd))
			return false;
		else {
			jkt.hms.masters.business.LibBookReturnHd libBookReturnHd = (jkt.hms.masters.business.LibBookReturnHd) obj;
			if (null == this.getId() || null == libBookReturnHd.getId())
				return false;
			else
				return (this.getId().equals(libBookReturnHd.getId()));
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