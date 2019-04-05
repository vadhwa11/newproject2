package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_repair_station table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_repair_station"
 */

public abstract class BaseMasRepairStation  implements Serializable {

	public static String REF = "MasRepairStation";
	public static String PROP_STATUS = "Status";
	public static String PROP_STATION_NAME = "StationName";
	public static String PROP_STATION_CODE = "StationCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMasRepairStation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasRepairStation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String stationCode;
	private java.lang.String stationName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: station_code
	 */
	public java.lang.String getStationCode () {
		return stationCode;
	}

	/**
	 * Set the value related to the column: station_code
	 * @param stationCode the station_code value
	 */
	public void setStationCode (java.lang.String stationCode) {
		this.stationCode = stationCode;
	}



	/**
	 * Return the value associated with the column: station_name
	 */
	public java.lang.String getStationName () {
		return stationName;
	}

	/**
	 * Set the value related to the column: station_name
	 * @param stationName the station_name value
	 */
	public void setStationName (java.lang.String stationName) {
		this.stationName = stationName;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasRepairStation)) return false;
		else {
			jkt.hms.masters.business.MasRepairStation masRepairStation = (jkt.hms.masters.business.MasRepairStation) obj;
			if (null == this.getId() || null == masRepairStation.getId()) return false;
			else return (this.getId().equals(masRepairStation.getId()));
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