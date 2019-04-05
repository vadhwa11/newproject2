package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the EMERGENCY_PERFORMA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="EMERGENCY_PERFORMA"
 */

public abstract class BaseEmergencyPerforma  implements Serializable {

	public static String REF = "EmergencyPerforma";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CASUALTIES = "Casualties";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LOCATION = "Location";
	public static String PROP_ATTENDED_TIME = "AttendedTime";
	public static String PROP_EMERGENCY_TYPE = "EmergencyType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CALL_RCD_DATE = "CallRcdDate";
	public static String PROP_ID = "Id";
	public static String PROP_SOURCE_FROM = "SourceFrom";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REPORTED_BY = "ReportedBy";
	public static String PROP_CALL_RCD_TIME = "CallRcdTime";


	// constructors
	public BaseEmergencyPerforma () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmergencyPerforma (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date callRcdDate;
	private java.lang.String callRcdTime;
	private java.lang.String sourceFrom;
	private java.lang.String attendedTime;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String reportedBy;
	private java.lang.String casualties;
	private java.lang.String actionTaken;
	private java.lang.String location;
	private java.lang.String emergencyType;

	// many to one
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="EMERGENCY_PERFORMA_ID"
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
	 * Return the value associated with the column: CALL_RCD_DATE
	 */
	public java.util.Date getCallRcdDate () {
		return callRcdDate;
	}

	/**
	 * Set the value related to the column: CALL_RCD_DATE
	 * @param callRcdDate the CALL_RCD_DATE value
	 */
	public void setCallRcdDate (java.util.Date callRcdDate) {
		this.callRcdDate = callRcdDate;
	}



	/**
	 * Return the value associated with the column: CALL_RCD_TIME
	 */
	public java.lang.String getCallRcdTime () {
		return callRcdTime;
	}

	/**
	 * Set the value related to the column: CALL_RCD_TIME
	 * @param callRcdTime the CALL_RCD_TIME value
	 */
	public void setCallRcdTime (java.lang.String callRcdTime) {
		this.callRcdTime = callRcdTime;
	}



	/**
	 * Return the value associated with the column: SOURCE_FROM
	 */
	public java.lang.String getSourceFrom () {
		return sourceFrom;
	}

	/**
	 * Set the value related to the column: SOURCE_FROM
	 * @param sourceFrom the SOURCE_FROM value
	 */
	public void setSourceFrom (java.lang.String sourceFrom) {
		this.sourceFrom = sourceFrom;
	}



	/**
	 * Return the value associated with the column: ATTENDED_TIME
	 */
	public java.lang.String getAttendedTime () {
		return attendedTime;
	}

	/**
	 * Set the value related to the column: ATTENDED_TIME
	 * @param attendedTime the ATTENDED_TIME value
	 */
	public void setAttendedTime (java.lang.String attendedTime) {
		this.attendedTime = attendedTime;
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
	 * Return the value associated with the column: reported_by
	 */
	public java.lang.String getReportedBy () {
		return reportedBy;
	}

	/**
	 * Set the value related to the column: reported_by
	 * @param reportedBy the reported_by value
	 */
	public void setReportedBy (java.lang.String reportedBy) {
		this.reportedBy = reportedBy;
	}



	/**
	 * Return the value associated with the column: casualties
	 */
	public java.lang.String getCasualties () {
		return casualties;
	}

	/**
	 * Set the value related to the column: casualties
	 * @param casualties the casualties value
	 */
	public void setCasualties (java.lang.String casualties) {
		this.casualties = casualties;
	}



	/**
	 * Return the value associated with the column: action_taken
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: action_taken
	 * @param actionTaken the action_taken value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * @param location the location value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: emergency_type
	 */
	public java.lang.String getEmergencyType () {
		return emergencyType;
	}

	/**
	 * Set the value related to the column: emergency_type
	 * @param emergencyType the emergency_type value
	 */
	public void setEmergencyType (java.lang.String emergencyType) {
		this.emergencyType = emergencyType;
	}



	/**
	 * Return the value associated with the column: medical_officer_id
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer () {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: medical_officer_id
	 * @param medicalOfficer the medical_officer_id value
	 */
	public void setMedicalOfficer (jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
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
		if (!(obj instanceof jkt.hms.masters.business.EmergencyPerforma)) return false;
		else {
			jkt.hms.masters.business.EmergencyPerforma emergencyPerforma = (jkt.hms.masters.business.EmergencyPerforma) obj;
			if (null == this.getId() || null == emergencyPerforma.getId()) return false;
			else return (this.getId().equals(emergencyPerforma.getId()));
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