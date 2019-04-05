package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_FLYING_INCIDENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_FLYING_INCIDENT"
 */

public abstract class BaseAvFlyingIncident  implements Serializable {

	public static String REF = "AvFlyingIncident";
	public static String PROP_FLYING_DATE = "FlyingDate";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_AIRCRAFT_TYPE = "AircraftType";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FLYING_NAME = "FlyingName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OUTCOME = "Outcome";
	public static String PROP_UNIT = "Unit";
	public static String PROP_NATURE_INCIDENT = "NatureIncident";
	public static String PROP_FLYING_REMARKS = "FlyingRemarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FLYING_TIME = "FlyingTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HIN = "Hin";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseAvFlyingIncident () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvFlyingIncident (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String flyingName;
	private java.lang.String natureIncident;
	private java.lang.String outcome;
	private java.lang.String flyingRemarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String serviceNo;
	private java.util.Date flyingDate;
	private java.lang.String flyingTime;
	private java.lang.String age;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasAircraftType aircraftType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="FLYING_INCIDENT_ID"
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
	 * Return the value associated with the column: FLYING_NAME
	 */
	public java.lang.String getFlyingName () {
		return flyingName;
	}

	/**
	 * Set the value related to the column: FLYING_NAME
	 * @param flyingName the FLYING_NAME value
	 */
	public void setFlyingName (java.lang.String flyingName) {
		this.flyingName = flyingName;
	}



	/**
	 * Return the value associated with the column: NATURE_INCIDENT
	 */
	public java.lang.String getNatureIncident () {
		return natureIncident;
	}

	/**
	 * Set the value related to the column: NATURE_INCIDENT
	 * @param natureIncident the NATURE_INCIDENT value
	 */
	public void setNatureIncident (java.lang.String natureIncident) {
		this.natureIncident = natureIncident;
	}



	/**
	 * Return the value associated with the column: OUTCOME
	 */
	public java.lang.String getOutcome () {
		return outcome;
	}

	/**
	 * Set the value related to the column: OUTCOME
	 * @param outcome the OUTCOME value
	 */
	public void setOutcome (java.lang.String outcome) {
		this.outcome = outcome;
	}



	/**
	 * Return the value associated with the column: FLYING_REMARKS
	 */
	public java.lang.String getFlyingRemarks () {
		return flyingRemarks;
	}

	/**
	 * Set the value related to the column: FLYING_REMARKS
	 * @param flyingRemarks the FLYING_REMARKS value
	 */
	public void setFlyingRemarks (java.lang.String flyingRemarks) {
		this.flyingRemarks = flyingRemarks;
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
	 * Return the value associated with the column: FLYING_DATE
	 */
	public java.util.Date getFlyingDate () {
		return flyingDate;
	}

	/**
	 * Set the value related to the column: FLYING_DATE
	 * @param flyingDate the FLYING_DATE value
	 */
	public void setFlyingDate (java.util.Date flyingDate) {
		this.flyingDate = flyingDate;
	}



	/**
	 * Return the value associated with the column: FLYING_TIME
	 */
	public java.lang.String getFlyingTime () {
		return flyingTime;
	}

	/**
	 * Set the value related to the column: FLYING_TIME
	 * @param flyingTime the FLYING_TIME value
	 */
	public void setFlyingTime (java.lang.String flyingTime) {
		this.flyingTime = flyingTime;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: AIRCRAFT_TYPE
	 */
	public jkt.hms.masters.business.MasAircraftType getAircraftType () {
		return aircraftType;
	}

	/**
	 * Set the value related to the column: AIRCRAFT_TYPE
	 * @param aircraftType the AIRCRAFT_TYPE value
	 */
	public void setAircraftType (jkt.hms.masters.business.MasAircraftType aircraftType) {
		this.aircraftType = aircraftType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvFlyingIncident)) return false;
		else {
			jkt.hms.masters.business.AvFlyingIncident avFlyingIncident = (jkt.hms.masters.business.AvFlyingIncident) obj;
			if (null == this.getId() || null == avFlyingIncident.getId()) return false;
			else return (this.getId().equals(avFlyingIncident.getId()));
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