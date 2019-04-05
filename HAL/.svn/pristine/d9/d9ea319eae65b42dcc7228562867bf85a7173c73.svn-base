package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_death_cause table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_death_cause"
 */

public abstract class BaseMasDeathCause implements Serializable {

	public static String REF = "MasDeathCause";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DEATH_CAUSE_CODE = "DeathCauseCode";
	public static String PROP_DEATH_CAUSE_NAME = "DeathCauseName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDeathCause() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDeathCause(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deathCauseCode;
	private java.lang.String deathCauseName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsByDDeathCause;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsByCDeathCause;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsBySDeathCause;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="death_cause_id"
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
	 * Return the value associated with the column: death_cause_code
	 */
	public java.lang.String getDeathCauseCode() {
		return deathCauseCode;
	}

	/**
	 * Set the value related to the column: death_cause_code
	 * 
	 * @param deathCauseCode
	 *            the death_cause_code value
	 */
	public void setDeathCauseCode(java.lang.String deathCauseCode) {
		this.deathCauseCode = deathCauseCode;
	}

	/**
	 * Return the value associated with the column: death_cause_name
	 */
	public java.lang.String getDeathCauseName() {
		return deathCauseName;
	}

	/**
	 * Set the value related to the column: death_cause_name
	 * 
	 * @param deathCauseName
	 *            the death_cause_name value
	 */
	public void setDeathCauseName(java.lang.String deathCauseName) {
		this.deathCauseName = deathCauseName;
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
	 * Return the value associated with the column: ExpiryDetailsByDDeathCause
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetailsByDDeathCause() {
		return expiryDetailsByDDeathCause;
	}

	/**
	 * Set the value related to the column: ExpiryDetailsByDDeathCause
	 * 
	 * @param expiryDetailsByDDeathCause
	 *            the ExpiryDetailsByDDeathCause value
	 */
	public void setExpiryDetailsByDDeathCause(
			java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsByDDeathCause) {
		this.expiryDetailsByDDeathCause = expiryDetailsByDDeathCause;
	}

	public void addToExpiryDetailsByDDeathCause(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetailsByDDeathCause())
			setExpiryDetailsByDDeathCause(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetailsByDDeathCause().add(expiryDetails);
	}

	/**
	 * Return the value associated with the column: ExpiryDetailsByCDeathCause
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetailsByCDeathCause() {
		return expiryDetailsByCDeathCause;
	}

	/**
	 * Set the value related to the column: ExpiryDetailsByCDeathCause
	 * 
	 * @param expiryDetailsByCDeathCause
	 *            the ExpiryDetailsByCDeathCause value
	 */
	public void setExpiryDetailsByCDeathCause(
			java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsByCDeathCause) {
		this.expiryDetailsByCDeathCause = expiryDetailsByCDeathCause;
	}

	public void addToExpiryDetailsByCDeathCause(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetailsByCDeathCause())
			setExpiryDetailsByCDeathCause(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetailsByCDeathCause().add(expiryDetails);
	}

	/**
	 * Return the value associated with the column: ExpiryDetailsBySDeathCause
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetailsBySDeathCause() {
		return expiryDetailsBySDeathCause;
	}

	/**
	 * Set the value related to the column: ExpiryDetailsBySDeathCause
	 * 
	 * @param expiryDetailsBySDeathCause
	 *            the ExpiryDetailsBySDeathCause value
	 */
	public void setExpiryDetailsBySDeathCause(
			java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetailsBySDeathCause) {
		this.expiryDetailsBySDeathCause = expiryDetailsBySDeathCause;
	}

	public void addToExpiryDetailsBySDeathCause(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetailsBySDeathCause())
			setExpiryDetailsBySDeathCause(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetailsBySDeathCause().add(expiryDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDeathCause))
			return false;
		else {
			jkt.hms.masters.business.MasDeathCause masDeathCause = (jkt.hms.masters.business.MasDeathCause) obj;
			if (null == this.getId() || null == masDeathCause.getId())
				return false;
			else
				return (this.getId().equals(masDeathCause.getId()));
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