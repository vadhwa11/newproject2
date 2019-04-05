package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_country table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_country"
 */

public abstract class BaseMasCountry implements Serializable {

	public static String REF = "MasCountry";
	public static String PROP_STATUS = "Status";
	public static String PROP_COUNTRY_NAME = "CountryName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COUNTRY_CODE = "CountryCode";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasCountry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCountry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String countryCode;
	private java.lang.String countryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasCurrency currency;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.MasState> masStates;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="country_id"
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
	 * Return the value associated with the column: country_code
	 */
	public java.lang.String getCountryCode() {
		return countryCode;
	}

	/**
	 * Set the value related to the column: country_code
	 * 
	 * @param countryCode
	 *            the country_code value
	 */
	public void setCountryCode(java.lang.String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Return the value associated with the column: country_name
	 */
	public java.lang.String getCountryName() {
		return countryName;
	}

	/**
	 * Set the value related to the column: country_name
	 * 
	 * @param countryName
	 *            the country_name value
	 */
	public void setCountryName(java.lang.String countryName) {
		this.countryName = countryName;
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
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency() {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * 
	 * @param currency
	 *            the currency_id value
	 */
	public void setCurrency(jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}

	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients() {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * 
	 * @param patients
	 *            the Patients value
	 */
	public void setPatients(
			java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients(jkt.hms.masters.business.Patient patient) {
		if (null == getPatients())
			setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}

	/**
	 * Return the value associated with the column: MasStates
	 */
	public java.util.Set<jkt.hms.masters.business.MasState> getMasStates() {
		return masStates;
	}

	/**
	 * Set the value related to the column: MasStates
	 * 
	 * @param masStates
	 *            the MasStates value
	 */
	public void setMasStates(
			java.util.Set<jkt.hms.masters.business.MasState> masStates) {
		this.masStates = masStates;
	}

	public void addToMasStates(jkt.hms.masters.business.MasState masState) {
		if (null == getMasStates())
			setMasStates(new java.util.TreeSet<jkt.hms.masters.business.MasState>());
		getMasStates().add(masState);
	}

	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails() {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * 
	 * @param expiryDetails
	 *            the ExpiryDetails value
	 */
	public void setExpiryDetails(
			java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails())
			setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCountry))
			return false;
		else {
			jkt.hms.masters.business.MasCountry masCountry = (jkt.hms.masters.business.MasCountry) obj;
			if (null == this.getId() || null == masCountry.getId())
				return false;
			else
				return (this.getId().equals(masCountry.getId()));
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