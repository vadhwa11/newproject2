package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_location table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_location"
 */

public abstract class BaseMasLocation implements Serializable {

	public static String REF = "MasLocation";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOCATION_NAME = "LocationName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_LOCATION_CODE = "LocationCode";

	// constructors
	public BaseMasLocation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLocation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String locationCode;
	private java.lang.String locationName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasSmq> masSmqs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="location_id"
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
	 * Return the value associated with the column: location_code
	 */
	public java.lang.String getLocationCode() {
		return locationCode;
	}

	/**
	 * Set the value related to the column: location_code
	 * 
	 * @param locationCode
	 *            the location_code value
	 */
	public void setLocationCode(java.lang.String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * Return the value associated with the column: location_name
	 */
	public java.lang.String getLocationName() {
		return locationName;
	}

	/**
	 * Set the value related to the column: location_name
	 * 
	 * @param locationName
	 *            the location_name value
	 */
	public void setLocationName(java.lang.String locationName) {
		this.locationName = locationName;
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
	 * Return the value associated with the column: MasSmqs
	 */
	public java.util.Set<jkt.hms.masters.business.MasSmq> getMasSmqs() {
		return masSmqs;
	}

	/**
	 * Set the value related to the column: MasSmqs
	 * 
	 * @param masSmqs
	 *            the MasSmqs value
	 */
	public void setMasSmqs(
			java.util.Set<jkt.hms.masters.business.MasSmq> masSmqs) {
		this.masSmqs = masSmqs;
	}

	public void addToMasSmqs(jkt.hms.masters.business.MasSmq masSmq) {
		if (null == getMasSmqs())
			setMasSmqs(new java.util.TreeSet<jkt.hms.masters.business.MasSmq>());
		getMasSmqs().add(masSmq);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasLocation))
			return false;
		else {
			jkt.hms.masters.business.MasLocation masLocation = (jkt.hms.masters.business.MasLocation) obj;
			if (null == this.getId() || null == masLocation.getId())
				return false;
			else
				return (this.getId().equals(masLocation.getId()));
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