package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DMO_CALL_REGISTER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DMO_CALL_REGISTER"
 */

public abstract class BaseDmoCallRegister  implements Serializable {

	public static String REF = "DmoCallRegister";
	public static String PROP_CALL_ATTENDED_TIME = "CallAttendedTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_CALL_SENT_DATE = "CallSentDate";
	public static String PROP_PATIENT_REPORTED_TIME = "PatientReportedTime";
	public static String PROP_PATIENT_REPORTED_DATE = "PatientReportedDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_CALL_SENT_TIME = "CallSentTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DMO_ATTENDED_DATE = "DmoAttendedDate";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseDmoCallRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDmoCallRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date patientReportedDate;
	private java.lang.String patientReportedTime;
	private java.util.Date callSentDate;
	private java.lang.String callSentTime;
	private java.util.Date dmoAttendedDate;
	private java.lang.String callAttendedTime;
	private java.lang.String disposal;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="DMO_CALL_REGISTER_ID"
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
	 * Return the value associated with the column: PATIENT_REPORTED_DATE
	 */
	public java.util.Date getPatientReportedDate () {
		return patientReportedDate;
	}

	/**
	 * Set the value related to the column: PATIENT_REPORTED_DATE
	 * @param patientReportedDate the PATIENT_REPORTED_DATE value
	 */
	public void setPatientReportedDate (java.util.Date patientReportedDate) {
		this.patientReportedDate = patientReportedDate;
	}



	/**
	 * Return the value associated with the column: PATIENT_REPORTED_TIME
	 */
	public java.lang.String getPatientReportedTime () {
		return patientReportedTime;
	}

	/**
	 * Set the value related to the column: PATIENT_REPORTED_TIME
	 * @param patientReportedTime the PATIENT_REPORTED_TIME value
	 */
	public void setPatientReportedTime (java.lang.String patientReportedTime) {
		this.patientReportedTime = patientReportedTime;
	}



	/**
	 * Return the value associated with the column: CALL_SENT_DATE
	 */
	public java.util.Date getCallSentDate () {
		return callSentDate;
	}

	/**
	 * Set the value related to the column: CALL_SENT_DATE
	 * @param callSentDate the CALL_SENT_DATE value
	 */
	public void setCallSentDate (java.util.Date callSentDate) {
		this.callSentDate = callSentDate;
	}



	/**
	 * Return the value associated with the column: CALL_SENT_TIME
	 */
	public java.lang.String getCallSentTime () {
		return callSentTime;
	}

	/**
	 * Set the value related to the column: CALL_SENT_TIME
	 * @param callSentTime the CALL_SENT_TIME value
	 */
	public void setCallSentTime (java.lang.String callSentTime) {
		this.callSentTime = callSentTime;
	}



	/**
	 * Return the value associated with the column: DMO_ATTENDED_DATE
	 */
	public java.util.Date getDmoAttendedDate () {
		return dmoAttendedDate;
	}

	/**
	 * Set the value related to the column: DMO_ATTENDED_DATE
	 * @param dmoAttendedDate the DMO_ATTENDED_DATE value
	 */
	public void setDmoAttendedDate (java.util.Date dmoAttendedDate) {
		this.dmoAttendedDate = dmoAttendedDate;
	}



	/**
	 * Return the value associated with the column: CALL_ATTENDED_TIME
	 */
	public java.lang.String getCallAttendedTime () {
		return callAttendedTime;
	}

	/**
	 * Set the value related to the column: CALL_ATTENDED_TIME
	 * @param callAttendedTime the CALL_ATTENDED_TIME value
	 */
	public void setCallAttendedTime (java.lang.String callAttendedTime) {
		this.callAttendedTime = callAttendedTime;
	}



	/**
	 * Return the value associated with the column: DISPOSAL
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: DISPOSAL
	 * @param disposal the DISPOSAL value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
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
		if (!(obj instanceof jkt.hms.masters.business.DmoCallRegister)) return false;
		else {
			jkt.hms.masters.business.DmoCallRegister dmoCallRegister = (jkt.hms.masters.business.DmoCallRegister) obj;
			if (null == this.getId() || null == dmoCallRegister.getId()) return false;
			else return (this.getId().equals(dmoCallRegister.getId()));
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