package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_REQUISITION_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_REQUISITION_HEADER"
 */

public abstract class BasePhysioRequisitionHeader  implements Serializable {

	public static String REF = "PhysioRequisitionHeader";
	public static String PROP_FLAG = "Flag";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_REQ_DATE = "ReqDate";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_REQ_TIME = "ReqTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BasePhysioRequisitionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioRequisitionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date reqDate;
	private java.lang.String reqTime;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;
	private java.lang.String flag;
	private java.lang.String patientType;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhysioVisitEntryHeader> physioVisitEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.PhysioRequisitionDetail> physioRequisitionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PHYSIO_REQUISITION_ID"
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
	 * Return the value associated with the column: REQ_DATE
	 */
	public java.util.Date getReqDate () {
		return reqDate;
	}

	/**
	 * Set the value related to the column: REQ_DATE
	 * @param reqDate the REQ_DATE value
	 */
	public void setReqDate (java.util.Date reqDate) {
		this.reqDate = reqDate;
	}



	/**
	 * Return the value associated with the column: REQ_TIME
	 */
	public java.lang.String getReqTime () {
		return reqTime;
	}

	/**
	 * Set the value related to the column: REQ_TIME
	 * @param reqTime the REQ_TIME value
	 */
	public void setReqTime (java.lang.String reqTime) {
		this.reqTime = reqTime;
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}



	/**
	 * Return the value associated with the column: PhysioVisitEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioVisitEntryHeader> getPhysioVisitEntryHeaders () {
		return physioVisitEntryHeaders;
	}

	/**
	 * Set the value related to the column: PhysioVisitEntryHeaders
	 * @param physioVisitEntryHeaders the PhysioVisitEntryHeaders value
	 */
	public void setPhysioVisitEntryHeaders (java.util.Set<jkt.hms.masters.business.PhysioVisitEntryHeader> physioVisitEntryHeaders) {
		this.physioVisitEntryHeaders = physioVisitEntryHeaders;
	}

	public void addToPhysioVisitEntryHeaders (jkt.hms.masters.business.PhysioVisitEntryHeader physioVisitEntryHeader) {
		if (null == getPhysioVisitEntryHeaders()) setPhysioVisitEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.PhysioVisitEntryHeader>());
		getPhysioVisitEntryHeaders().add(physioVisitEntryHeader);
	}



	/**
	 * Return the value associated with the column: PhysioRequisitionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioRequisitionDetail> getPhysioRequisitionDetails () {
		return physioRequisitionDetails;
	}

	/**
	 * Set the value related to the column: PhysioRequisitionDetails
	 * @param physioRequisitionDetails the PhysioRequisitionDetails value
	 */
	public void setPhysioRequisitionDetails (java.util.Set<jkt.hms.masters.business.PhysioRequisitionDetail> physioRequisitionDetails) {
		this.physioRequisitionDetails = physioRequisitionDetails;
	}

	public void addToPhysioRequisitionDetails (jkt.hms.masters.business.PhysioRequisitionDetail physioRequisitionDetail) {
		if (null == getPhysioRequisitionDetails()) setPhysioRequisitionDetails(new java.util.TreeSet<jkt.hms.masters.business.PhysioRequisitionDetail>());
		getPhysioRequisitionDetails().add(physioRequisitionDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysioRequisitionHeader)) return false;
		else {
			jkt.hms.masters.business.PhysioRequisitionHeader physioRequisitionHeader = (jkt.hms.masters.business.PhysioRequisitionHeader) obj;
			if (null == this.getId() || null == physioRequisitionHeader.getId()) return false;
			else return (this.getId().equals(physioRequisitionHeader.getId()));
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