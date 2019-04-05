package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_car_garage table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_car_garage"
 */

public abstract class BaseMasCarGarage implements Serializable {

	public static String REF = "MasCarGarage";
	public static String PROP_STATUS = "Status";
	public static String PROP_CAR_GARAGE_NAME = "CarGarageName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CAR_GARAGE_CODE = "CarGarageCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasCarGarage() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCarGarage(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String carGarageCode;
	private java.lang.String carGarageName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.AccomAllotment> accomAllotments;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="car_garage_id"
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
	 * Return the value associated with the column: car_garage_code
	 */
	public java.lang.String getCarGarageCode() {
		return carGarageCode;
	}

	/**
	 * Set the value related to the column: car_garage_code
	 * 
	 * @param carGarageCode
	 *            the car_garage_code value
	 */
	public void setCarGarageCode(java.lang.String carGarageCode) {
		this.carGarageCode = carGarageCode;
	}

	/**
	 * Return the value associated with the column: car_garage_name
	 */
	public java.lang.String getCarGarageName() {
		return carGarageName;
	}

	/**
	 * Set the value related to the column: car_garage_name
	 * 
	 * @param carGarageName
	 *            the car_garage_name value
	 */
	public void setCarGarageName(java.lang.String carGarageName) {
		this.carGarageName = carGarageName;
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
	 * Return the value associated with the column: AccomAllotments
	 */
	public java.util.Set<jkt.hms.masters.business.AccomAllotment> getAccomAllotments() {
		return accomAllotments;
	}

	/**
	 * Set the value related to the column: AccomAllotments
	 * 
	 * @param accomAllotments
	 *            the AccomAllotments value
	 */
	public void setAccomAllotments(
			java.util.Set<jkt.hms.masters.business.AccomAllotment> accomAllotments) {
		this.accomAllotments = accomAllotments;
	}

	public void addToAccomAllotments(
			jkt.hms.masters.business.AccomAllotment accomAllotment) {
		if (null == getAccomAllotments())
			setAccomAllotments(new java.util.TreeSet<jkt.hms.masters.business.AccomAllotment>());
		getAccomAllotments().add(accomAllotment);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCarGarage))
			return false;
		else {
			jkt.hms.masters.business.MasCarGarage masCarGarage = (jkt.hms.masters.business.MasCarGarage) obj;
			if (null == this.getId() || null == masCarGarage.getId())
				return false;
			else
				return (this.getId().equals(masCarGarage.getId()));
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