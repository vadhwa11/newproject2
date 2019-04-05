package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_AIRCRAFT_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_AIRCRAFT_TYPE"
 */

public abstract class BaseMasAircraftType  implements Serializable {

	public static String REF = "MasAircraftType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_AIRCRAFT_TYPE_NAME = "AircraftTypeName";
	public static String PROP_AIRCRAFT_TYPE_CODE = "AircraftTypeCode";


	// constructors
	public BaseMasAircraftType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAircraftType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasAircraftType (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String aircraftTypeCode;
	private java.lang.String aircraftTypeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="aircraft_type_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: aircraft_type_code
	 */
	public java.lang.String getAircraftTypeCode () {
		return aircraftTypeCode;
	}

	/**
	 * Set the value related to the column: aircraft_type_code
	 * @param aircraftTypeCode the aircraft_type_code value
	 */
	public void setAircraftTypeCode (java.lang.String aircraftTypeCode) {
		this.aircraftTypeCode = aircraftTypeCode;
	}



	/**
	 * Return the value associated with the column: aircraft_type_name
	 */
	public java.lang.String getAircraftTypeName () {
		return aircraftTypeName;
	}

	/**
	 * Set the value related to the column: aircraft_type_name
	 * @param aircraftTypeName the aircraft_type_name value
	 */
	public void setAircraftTypeName (java.lang.String aircraftTypeName) {
		this.aircraftTypeName = aircraftTypeName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAircraftType)) return false;
		else {
			jkt.hms.masters.business.MasAircraftType masAircraftType = (jkt.hms.masters.business.MasAircraftType) obj;
			if (null == this.getId() || null == masAircraftType.getId()) return false;
			else return (this.getId().equals(masAircraftType.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}