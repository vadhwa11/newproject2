package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_pharma_index
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_pharma_index"
 */

public abstract class BaseMasStorePharmaIndex implements Serializable {

	public static String REF = "MasStorePharmaIndex";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_PHARMA_INDEX_NAME = "PharmaIndexName";

	// constructors
	public BaseMasStorePharmaIndex() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStorePharmaIndex(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pharmaIndexName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItemGeneric> masStoreItemGenerics;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="pharma_index_id"
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
	 * Return the value associated with the column: pharma_index_name
	 */
	public java.lang.String getPharmaIndexName() {
		return pharmaIndexName;
	}

	/**
	 * Set the value related to the column: pharma_index_name
	 * 
	 * @param pharmaIndexName
	 *            the pharma_index_name value
	 */
	public void setPharmaIndexName(java.lang.String pharmaIndexName) {
		this.pharmaIndexName = pharmaIndexName;
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
	 * Return the value associated with the column: MasStoreItemGenerics
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemGeneric> getMasStoreItemGenerics() {
		return masStoreItemGenerics;
	}

	/**
	 * Set the value related to the column: MasStoreItemGenerics
	 * 
	 * @param masStoreItemGenerics
	 *            the MasStoreItemGenerics value
	 */
	public void setMasStoreItemGenerics(
			java.util.Set<jkt.hms.masters.business.MasStoreItemGeneric> masStoreItemGenerics) {
		this.masStoreItemGenerics = masStoreItemGenerics;
	}

	public void addToMasStoreItemGenerics(
			jkt.hms.masters.business.MasStoreItemGeneric masStoreItemGeneric) {
		if (null == getMasStoreItemGenerics())
			setMasStoreItemGenerics(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemGeneric>());
		getMasStoreItemGenerics().add(masStoreItemGeneric);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStorePharmaIndex))
			return false;
		else {
			jkt.hms.masters.business.MasStorePharmaIndex masStorePharmaIndex = (jkt.hms.masters.business.MasStorePharmaIndex) obj;
			if (null == this.getId() || null == masStorePharmaIndex.getId())
				return false;
			else
				return (this.getId().equals(masStorePharmaIndex.getId()));
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