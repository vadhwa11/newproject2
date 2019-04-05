package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HIV_AIDS_ACTIVITY_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HIV_AIDS_ACTIVITY_DETAILS"
 */

public abstract class BaseHivAidsActivityDetails  implements Serializable {

	public static String REF = "HivAidsActivityDetails";
	public static String PROP_FAMILIES = "Families";
	public static String PROP_SNCO_AIRMEN = "SncoAirmen";
	public static String PROP_OFFICERS = "Officers";
	public static String PROP_ACTIVITY_ID = "ActivityId";
	public static String PROP_ACTIVITY_DETAILS = "ActivityDetails";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ACTIVITY_DATE = "ActivityDate";
	public static String PROP_HOSPITAL = "Hospital";

	// constructors
	public BaseHivAidsActivityDetails () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHivAidsActivityDetails (
		java.lang.Integer activityId) {

		this.setActivityId(activityId);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.util.Date activityDate;
	private java.lang.String activityDetails;
	private java.lang.String officers;
	private java.lang.String sncoAirmen;
	private java.lang.String families;
	private java.lang.String remarks;
	private java.lang.Integer activityId;
	private jkt.hms.masters.business.MasHospital hospital;





	/**
	 * Return the value associated with the column: ACTIVITY_DATE
	 */
	public java.util.Date getActivityDate () {
		return activityDate;
	}

	/**
	 * Set the value related to the column: ACTIVITY_DATE
	 * @param activityDate the ACTIVITY_DATE value
	 */
	public void setActivityDate (java.util.Date activityDate) {
		this.activityDate = activityDate;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_DETAILS
	 */
	public java.lang.String getActivityDetails () {
		return activityDetails;
	}

	/**
	 * Set the value related to the column: ACTIVITY_DETAILS
	 * @param activityDetails the ACTIVITY_DETAILS value
	 */
	public void setActivityDetails (java.lang.String activityDetails) {
		this.activityDetails = activityDetails;
	}



	/**
	 * Return the value associated with the column: OFFICERS
	 */
	public java.lang.String getOfficers () {
		return officers;
	}

	/**
	 * Set the value related to the column: OFFICERS
	 * @param officers the OFFICERS value
	 */
	public void setOfficers (java.lang.String officers) {
		this.officers = officers;
	}



	/**
	 * Return the value associated with the column: SNCO_AIRMEN
	 */
	public java.lang.String getSncoAirmen () {
		return sncoAirmen;
	}

	/**
	 * Set the value related to the column: SNCO_AIRMEN
	 * @param sncoAirmen the SNCO_AIRMEN value
	 */
	public void setSncoAirmen (java.lang.String sncoAirmen) {
		this.sncoAirmen = sncoAirmen;
	}



	/**
	 * Return the value associated with the column: FAMILIES
	 */
	public java.lang.String getFamilies () {
		return families;
	}

	/**
	 * Set the value related to the column: FAMILIES
	 * @param families the FAMILIES value
	 */
	public void setFamilies (java.lang.String families) {
		this.families = families;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_ID
	 */
	public java.lang.Integer getActivityId () {
		return activityId;
	}

	/**
	 * Set the value related to the column: ACTIVITY_ID
	 * @param activityId the ACTIVITY_ID value
	 */
	public void setActivityId (java.lang.Integer activityId) {
		this.activityId = activityId;
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





	public String toString () {
		return super.toString();
	}


}