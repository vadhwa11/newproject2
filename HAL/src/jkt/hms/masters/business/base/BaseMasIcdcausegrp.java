package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_icdcausegrp table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_icdcausegrp"
 */

public abstract class BaseMasIcdcausegrp implements Serializable {

	public static String REF = "MasIcdcausegrp";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ICD_CAUSE_CODE = "IcdCauseCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ICD_CAUSE_NAME = "IcdCauseName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasIcdcausegrp() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasIcdcausegrp(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String icdCauseCode;
	private java.lang.String icdCauseName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasIcd> masIcds;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="icd_cause_id"
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
	 * Return the value associated with the column: icd_cause_code
	 */
	public java.lang.String getIcdCauseCode() {
		return icdCauseCode;
	}

	/**
	 * Set the value related to the column: icd_cause_code
	 * 
	 * @param icdCauseCode
	 *            the icd_cause_code value
	 */
	public void setIcdCauseCode(java.lang.String icdCauseCode) {
		this.icdCauseCode = icdCauseCode;
	}

	/**
	 * Return the value associated with the column: icd_cause_name
	 */
	public java.lang.String getIcdCauseName() {
		return icdCauseName;
	}

	/**
	 * Set the value related to the column: icd_cause_name
	 * 
	 * @param icdCauseName
	 *            the icd_cause_name value
	 */
	public void setIcdCauseName(java.lang.String icdCauseName) {
		this.icdCauseName = icdCauseName;
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
	 * Return the value associated with the column: MasIcds
	 */
	public java.util.Set<jkt.hms.masters.business.MasIcd> getMasIcds() {
		return masIcds;
	}

	/**
	 * Set the value related to the column: MasIcds
	 * 
	 * @param masIcds
	 *            the MasIcds value
	 */
	public void setMasIcds(
			java.util.Set<jkt.hms.masters.business.MasIcd> masIcds) {
		this.masIcds = masIcds;
	}

	public void addToMasIcds(jkt.hms.masters.business.MasIcd masIcd) {
		if (null == getMasIcds())
			setMasIcds(new java.util.TreeSet<jkt.hms.masters.business.MasIcd>());
		getMasIcds().add(masIcd);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasIcdcausegrp))
			return false;
		else {
			jkt.hms.masters.business.MasIcdcausegrp masIcdcausegrp = (jkt.hms.masters.business.MasIcdcausegrp) obj;
			if (null == this.getId() || null == masIcdcausegrp.getId())
				return false;
			else
				return (this.getId().equals(masIcdcausegrp.getId()));
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