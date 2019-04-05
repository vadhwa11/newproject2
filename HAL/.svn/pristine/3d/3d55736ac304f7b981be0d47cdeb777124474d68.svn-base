package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_currency table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_currency"
 */

public abstract class BaseMasCurrency implements Serializable {

	public static String REF = "MasCurrency";
	public static String PROP_STATUS = "Status";
	public static String PROP_CURRENCY_NAME = "CurrencyName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CURRENCY_CODE = "CurrencyCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasCurrency() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCurrency(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String currencyCode;
	private java.lang.String currencyName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasCountry> masCountries;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="currency_id"
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
	 * Return the value associated with the column: currency_code
	 */
	public java.lang.String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Set the value related to the column: currency_code
	 * 
	 * @param currencyCode
	 *            the currency_code value
	 */
	public void setCurrencyCode(java.lang.String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Return the value associated with the column: currency_name
	 */
	public java.lang.String getCurrencyName() {
		return currencyName;
	}

	/**
	 * Set the value related to the column: currency_name
	 * 
	 * @param currencyName
	 *            the currency_name value
	 */
	public void setCurrencyName(java.lang.String currencyName) {
		this.currencyName = currencyName;
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
	 * Return the value associated with the column: MasCountries
	 */
	public java.util.Set<jkt.hms.masters.business.MasCountry> getMasCountries() {
		return masCountries;
	}

	/**
	 * Set the value related to the column: MasCountries
	 * 
	 * @param masCountries
	 *            the MasCountries value
	 */
	public void setMasCountries(
			java.util.Set<jkt.hms.masters.business.MasCountry> masCountries) {
		this.masCountries = masCountries;
	}

	public void addToMasCountries(jkt.hms.masters.business.MasCountry masCountry) {
		if (null == getMasCountries())
			setMasCountries(new java.util.TreeSet<jkt.hms.masters.business.MasCountry>());
		getMasCountries().add(masCountry);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCurrency))
			return false;
		else {
			jkt.hms.masters.business.MasCurrency masCurrency = (jkt.hms.masters.business.MasCurrency) obj;
			if (null == this.getId() || null == masCurrency.getId())
				return false;
			else
				return (this.getId().equals(masCurrency.getId()));
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