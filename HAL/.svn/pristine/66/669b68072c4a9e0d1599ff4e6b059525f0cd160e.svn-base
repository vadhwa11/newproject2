package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_medical_History table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_medical_History"
 */

public abstract class BasePatientMedicalHistory  implements Serializable {

	public static String REF = "PatientMedicalHistory";
	public static String PROP_DISEASE_STATUS = "DiseaseStatus";
	public static String PROP_DURATION = "Duration";
	public static String PROP_PATIENT_FAMILY_HISTORY = "PatientFamilyHistory";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BasePatientMedicalHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientMedicalHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String duration;
	private java.lang.String diseaseStatus;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PatientFamilyHistory patientFamilyHistory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="patient_medical_History_id"
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
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: disease_status
	 */
	public java.lang.String getDiseaseStatus () {
		return diseaseStatus;
	}

	/**
	 * Set the value related to the column: disease_status
	 * @param diseaseStatus the disease_status value
	 */
	public void setDiseaseStatus (java.lang.String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: patient_family_history_id
	 */
	public jkt.hms.masters.business.PatientFamilyHistory getPatientFamilyHistory () {
		return patientFamilyHistory;
	}

	/**
	 * Set the value related to the column: patient_family_history_id
	 * @param patientFamilyHistory the patient_family_history_id value
	 */
	public void setPatientFamilyHistory (jkt.hms.masters.business.PatientFamilyHistory patientFamilyHistory) {
		this.patientFamilyHistory = patientFamilyHistory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientMedicalHistory)) return false;
		else {
			jkt.hms.masters.business.PatientMedicalHistory patientMedicalHistory = (jkt.hms.masters.business.PatientMedicalHistory) obj;
			if (null == this.getId() || null == patientMedicalHistory.getId()) return false;
			else return (this.getId().equals(patientMedicalHistory.getId()));
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