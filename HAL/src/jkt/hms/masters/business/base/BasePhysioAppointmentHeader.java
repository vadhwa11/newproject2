package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_APPOINTMENT_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_APPOINTMENT_HEADER"
 */

public abstract class BasePhysioAppointmentHeader  implements Serializable {

	public static String REF = "PhysioAppointmentHeader";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STATUS = "Status";
	public static String PROP_PHYSIO_REQUISITION = "PhysioRequisition";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BasePhysioAppointmentHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioAppointmentHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.util.Date appointmentDate;
	private java.lang.String status;
	private java.lang.String patientType;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.PhysioRequisitionHeader physioRequisition;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Visit visit;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhysioAppointmentDetail> physioAppointmentDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="APPOINTMENT_HEADER_ID"
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
	 * Return the value associated with the column: APPOINTMENT_DATE
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: APPOINTMENT_DATE
	 * @param appointmentDate the APPOINTMENT_DATE value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
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
	 * Return the value associated with the column: patient_type
	 */
	public java.lang.String getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type
	 * @param patientType the patient_type value
	 */
	public void setPatientType (java.lang.String patientType) {
		this.patientType = patientType;
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



	/**
	 * Return the value associated with the column: in_patient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: in_patient_id
	 * @param inpatient the in_patient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: PHYSIO_REQUISITION_ID
	 */
	public jkt.hms.masters.business.PhysioRequisitionHeader getPhysioRequisition () {
		return physioRequisition;
	}

	/**
	 * Set the value related to the column: PHYSIO_REQUISITION_ID
	 * @param physioRequisition the PHYSIO_REQUISITION_ID value
	 */
	public void setPhysioRequisition (jkt.hms.masters.business.PhysioRequisitionHeader physioRequisition) {
		this.physioRequisition = physioRequisition;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: PhysioAppointmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioAppointmentDetail> getPhysioAppointmentDetails () {
		return physioAppointmentDetails;
	}

	/**
	 * Set the value related to the column: PhysioAppointmentDetails
	 * @param physioAppointmentDetails the PhysioAppointmentDetails value
	 */
	public void setPhysioAppointmentDetails (java.util.Set<jkt.hms.masters.business.PhysioAppointmentDetail> physioAppointmentDetails) {
		this.physioAppointmentDetails = physioAppointmentDetails;
	}

	public void addToPhysioAppointmentDetails (jkt.hms.masters.business.PhysioAppointmentDetail physioAppointmentDetail) {
		if (null == getPhysioAppointmentDetails()) setPhysioAppointmentDetails(new java.util.TreeSet<jkt.hms.masters.business.PhysioAppointmentDetail>());
		getPhysioAppointmentDetails().add(physioAppointmentDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysioAppointmentHeader)) return false;
		else {
			jkt.hms.masters.business.PhysioAppointmentHeader physioAppointmentHeader = (jkt.hms.masters.business.PhysioAppointmentHeader) obj;
			if (null == this.getId() || null == physioAppointmentHeader.getId()) return false;
			else return (this.getId().equals(physioAppointmentHeader.getId()));
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