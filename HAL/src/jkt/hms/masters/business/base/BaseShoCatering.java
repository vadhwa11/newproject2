package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_CATERING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_CATERING"
 */

public abstract class BaseShoCatering  implements Serializable {

	public static String REF = "ShoCatering";
	public static String PROP_FLY_PROOFING = "FlyProofing";
	public static String PROP_AIRMEN_MESS = "AirmenMess";
	public static String PROP_RATION_STORE = "RationStore";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_ID = "Id";
	public static String PROP_OFFICER_MESS = "OfficerMess";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_SNCO_MESS = "SncoMess";


	// constructors
	public BaseShoCatering () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoCatering (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String officerMess;
	private java.lang.String sncoMess;
	private java.lang.String airmenMess;
	private java.lang.String flyProofing;
	private java.lang.String rationStore;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="CATERING_ID"
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
	 * Return the value associated with the column: CURRENT_DATE
	 */
	public java.util.Date getCurrentDate () {
		return currentDate;
	}

	/**
	 * Set the value related to the column: CURRENT_DATE
	 * @param currentDate the CURRENT_DATE value
	 */
	public void setCurrentDate (java.util.Date currentDate) {
		this.currentDate = currentDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: OFFICER_MESS
	 */
	public java.lang.String getOfficerMess () {
		return officerMess;
	}

	/**
	 * Set the value related to the column: OFFICER_MESS
	 * @param officerMess the OFFICER_MESS value
	 */
	public void setOfficerMess (java.lang.String officerMess) {
		this.officerMess = officerMess;
	}



	/**
	 * Return the value associated with the column: SNCO_MESS
	 */
	public java.lang.String getSncoMess () {
		return sncoMess;
	}

	/**
	 * Set the value related to the column: SNCO_MESS
	 * @param sncoMess the SNCO_MESS value
	 */
	public void setSncoMess (java.lang.String sncoMess) {
		this.sncoMess = sncoMess;
	}



	/**
	 * Return the value associated with the column: AIRMEN_MESS
	 */
	public java.lang.String getAirmenMess () {
		return airmenMess;
	}

	/**
	 * Set the value related to the column: AIRMEN_MESS
	 * @param airmenMess the AIRMEN_MESS value
	 */
	public void setAirmenMess (java.lang.String airmenMess) {
		this.airmenMess = airmenMess;
	}



	/**
	 * Return the value associated with the column: FLY_PROOFING
	 */
	public java.lang.String getFlyProofing () {
		return flyProofing;
	}

	/**
	 * Set the value related to the column: FLY_PROOFING
	 * @param flyProofing the FLY_PROOFING value
	 */
	public void setFlyProofing (java.lang.String flyProofing) {
		this.flyProofing = flyProofing;
	}



	/**
	 * Return the value associated with the column: RATION_STORE
	 */
	public java.lang.String getRationStore () {
		return rationStore;
	}

	/**
	 * Set the value related to the column: RATION_STORE
	 * @param rationStore the RATION_STORE value
	 */
	public void setRationStore (java.lang.String rationStore) {
		this.rationStore = rationStore;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoCatering)) return false;
		else {
			jkt.hms.masters.business.ShoCatering shoCatering = (jkt.hms.masters.business.ShoCatering) obj;
			if (null == this.getId() || null == shoCatering.getId()) return false;
			else return (this.getId().equals(shoCatering.getId()));
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