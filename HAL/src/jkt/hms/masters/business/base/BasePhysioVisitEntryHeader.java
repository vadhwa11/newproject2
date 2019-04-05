package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_VISIT_ENTRY_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_VISIT_ENTRY_HEADER"
 */

public abstract class BasePhysioVisitEntryHeader  implements Serializable {

	public static String REF = "PhysioVisitEntryHeader";
	public static String PROP_PHYSIO_VISIT_DATE = "PhysioVisitDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PHY_STATUS = "PhyStatus";
	public static String PROP_VISIT_STATUS = "VisitStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_PHYSIO_REQUISITION = "PhysioRequisition";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BasePhysioVisitEntryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioVisitEntryHeader (java.lang.Integer id) {
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
	private java.util.Date physioVisitDate;
	private java.lang.String status;
	private java.lang.String phyStatus;
	private java.lang.String diagnosis;
	private java.lang.String visitStatus;
	private java.lang.String patientType;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.PhysioRequisitionHeader physioRequisition;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhysioVisitEntryDetail> physioVisitEntryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="VISIT_ENTRY_HEADER_ID"
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
	 * Return the value associated with the column: physio_visit_date
	 */
	public java.util.Date getPhysioVisitDate () {
		return physioVisitDate;
	}

	/**
	 * Set the value related to the column: physio_visit_date
	 * @param physioVisitDate the physio_visit_date value
	 */
	public void setPhysioVisitDate (java.util.Date physioVisitDate) {
		this.physioVisitDate = physioVisitDate;
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
	 * Return the value associated with the column: phy_status
	 */
	public java.lang.String getPhyStatus () {
		return phyStatus;
	}

	/**
	 * Set the value related to the column: phy_status
	 * @param phyStatus the phy_status value
	 */
	public void setPhyStatus (java.lang.String phyStatus) {
		this.phyStatus = phyStatus;
	}



	/**
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: visit_status
	 */
	public java.lang.String getVisitStatus () {
		return visitStatus;
	}

	/**
	 * Set the value related to the column: visit_status
	 * @param visitStatus the visit_status value
	 */
	public void setVisitStatus (java.lang.String visitStatus) {
		this.visitStatus = visitStatus;
	}



	/**
	 * Return the value associated with the column: PATIENT_TYPE
	 */
	public java.lang.String getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: PATIENT_TYPE
	 * @param patientType the PATIENT_TYPE value
	 */
	public void setPatientType (java.lang.String patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: hinId
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hinId
	 * @param hin the hinId value
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
	 * Return the value associated with the column: visitId
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visitId
	 * @param visit the visitId value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: PhysioVisitEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioVisitEntryDetail> getPhysioVisitEntryDetails () {
		return physioVisitEntryDetails;
	}

	/**
	 * Set the value related to the column: PhysioVisitEntryDetails
	 * @param physioVisitEntryDetails the PhysioVisitEntryDetails value
	 */
	public void setPhysioVisitEntryDetails (java.util.Set<jkt.hms.masters.business.PhysioVisitEntryDetail> physioVisitEntryDetails) {
		this.physioVisitEntryDetails = physioVisitEntryDetails;
	}

	public void addToPhysioVisitEntryDetails (jkt.hms.masters.business.PhysioVisitEntryDetail physioVisitEntryDetail) {
		if (null == getPhysioVisitEntryDetails()) setPhysioVisitEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.PhysioVisitEntryDetail>());
		getPhysioVisitEntryDetails().add(physioVisitEntryDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysioVisitEntryHeader)) return false;
		else {
			jkt.hms.masters.business.PhysioVisitEntryHeader physioVisitEntryHeader = (jkt.hms.masters.business.PhysioVisitEntryHeader) obj;
			if (null == this.getId() || null == physioVisitEntryHeader.getId()) return false;
			else return (this.getId().equals(physioVisitEntryHeader.getId()));
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