package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_PRE_FLIGHT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_PRE_FLIGHT"
 */

public abstract class BaseAvPreFlight  implements Serializable {

	public static String REF = "AvPreFlight";
	public static String PROP_RECTIFIED_MO = "RectifiedMo";
	public static String PROP_MO_NAME = "MoName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FLIGHT_TIME = "FlightTime";
	public static String PROP_UNFIT_REMARKS = "UnfitRemarks";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FLIGHT_DATE = "FlightDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_RECTIFIED_WGCDR = "RectifiedWgcdr";


	// constructors
	public BaseAvPreFlight () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvPreFlight (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date flightDate;
	private java.lang.String flightTime;
	private java.lang.String rectifiedWgcdr;
	private java.lang.String rectifiedMo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String unfitRemarks;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee moName;
	private jkt.hms.masters.business.MasUnit unit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="PRE_FLIGHT_ID"
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
	 * Return the value associated with the column: FLIGHT_DATE
	 */
	public java.util.Date getFlightDate () {
		return flightDate;
	}

	/**
	 * Set the value related to the column: FLIGHT_DATE
	 * @param flightDate the FLIGHT_DATE value
	 */
	public void setFlightDate (java.util.Date flightDate) {
		this.flightDate = flightDate;
	}



	/**
	 * Return the value associated with the column: FLIGHT_TIME
	 */
	public java.lang.String getFlightTime () {
		return flightTime;
	}

	/**
	 * Set the value related to the column: FLIGHT_TIME
	 * @param flightTime the FLIGHT_TIME value
	 */
	public void setFlightTime (java.lang.String flightTime) {
		this.flightTime = flightTime;
	}



	/**
	 * Return the value associated with the column: RECTIFIED_WGCDR
	 */
	public java.lang.String getRectifiedWgcdr () {
		return rectifiedWgcdr;
	}

	/**
	 * Set the value related to the column: RECTIFIED_WGCDR
	 * @param rectifiedWgcdr the RECTIFIED_WGCDR value
	 */
	public void setRectifiedWgcdr (java.lang.String rectifiedWgcdr) {
		this.rectifiedWgcdr = rectifiedWgcdr;
	}



	/**
	 * Return the value associated with the column: RECTIFIED_MO
	 */
	public java.lang.String getRectifiedMo () {
		return rectifiedMo;
	}

	/**
	 * Set the value related to the column: RECTIFIED_MO
	 * @param rectifiedMo the RECTIFIED_MO value
	 */
	public void setRectifiedMo (java.lang.String rectifiedMo) {
		this.rectifiedMo = rectifiedMo;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: unfit_remarks
	 */
	public java.lang.String getUnfitRemarks () {
		return unfitRemarks;
	}

	/**
	 * Set the value related to the column: unfit_remarks
	 * @param unfitRemarks the unfit_remarks value
	 */
	public void setUnfitRemarks (java.lang.String unfitRemarks) {
		this.unfitRemarks = unfitRemarks;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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



	/**
	 * Return the value associated with the column: mo_name
	 */
	public jkt.hms.masters.business.MasEmployee getMoName () {
		return moName;
	}

	/**
	 * Set the value related to the column: mo_name
	 * @param moName the mo_name value
	 */
	public void setMoName (jkt.hms.masters.business.MasEmployee moName) {
		this.moName = moName;
	}



	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvPreFlight)) return false;
		else {
			jkt.hms.masters.business.AvPreFlight avPreFlight = (jkt.hms.masters.business.AvPreFlight) obj;
			if (null == this.getId() || null == avPreFlight.getId()) return false;
			else return (this.getId().equals(avPreFlight.getId()));
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