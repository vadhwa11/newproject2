package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AIR_CRAFT_EMERGENCY_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AIR_CRAFT_EMERGENCY_DT"
 */

public abstract class BaseAirCraftEmergencyDt  implements Serializable {

	public static String REF = "AirCraftEmergencyDt";
	public static String PROP_PILOT = "Pilot";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_AIR_CRAFT_EMERGENCY = "AirCraftEmergency";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAirCraftEmergencyDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAirCraftEmergencyDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String fullName;
	private java.lang.String age;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.AvPilotRegistrationDt pilot;
	private jkt.hms.masters.business.AirCraftEmergency airCraftEmergency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: FULL_NAME
	 */
	public java.lang.String getFullName () {
		return fullName;
	}

	/**
	 * Set the value related to the column: FULL_NAME
	 * @param fullName the FULL_NAME value
	 */
	public void setFullName (java.lang.String fullName) {
		this.fullName = fullName;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: PILOT_ID
	 */
	public jkt.hms.masters.business.AvPilotRegistrationDt getPilot () {
		return pilot;
	}

	/**
	 * Set the value related to the column: PILOT_ID
	 * @param pilot the PILOT_ID value
	 */
	public void setPilot (jkt.hms.masters.business.AvPilotRegistrationDt pilot) {
		this.pilot = pilot;
	}



	/**
	 * Return the value associated with the column: air_craft_emergency_id
	 */
	public jkt.hms.masters.business.AirCraftEmergency getAirCraftEmergency () {
		return airCraftEmergency;
	}

	/**
	 * Set the value related to the column: air_craft_emergency_id
	 * @param airCraftEmergency the air_craft_emergency_id value
	 */
	public void setAirCraftEmergency (jkt.hms.masters.business.AirCraftEmergency airCraftEmergency) {
		this.airCraftEmergency = airCraftEmergency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AirCraftEmergencyDt)) return false;
		else {
			jkt.hms.masters.business.AirCraftEmergencyDt airCraftEmergencyDt = (jkt.hms.masters.business.AirCraftEmergencyDt) obj;
			if (null == this.getId() || null == airCraftEmergencyDt.getId()) return false;
			else return (this.getId().equals(airCraftEmergencyDt.getId()));
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