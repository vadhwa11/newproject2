package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_DETENTION_REGISTER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_DETENTION_REGISTER"
 */

public abstract class BasePatientDetentionRegister  implements Serializable {

	public static String REF = "PatientDetentionRegister";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_DETAINED_TO = "DetainedTo";
	public static String PROP_DMA_REGISTER = "DmaRegister";
	public static String PROP_DETENTION_REGISTER_DATE = "DetentionRegisterDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_REVIEW_AT = "ReviewAt";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DETAINED_FROM = "DetainedFrom";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePatientDetentionRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientDetentionRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date detentionRegisterDate;
	private java.lang.String remarks;
	private java.util.Date detainedFrom;
	private java.util.Date detainedTo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String treatment;
	private java.lang.String fromTime;
	private java.lang.String toTime;
	private java.lang.String status;
	private java.util.Date requisitionDate;
	private java.lang.String reviewAt;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.DmaRegisterHeader dmaRegister;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="PATIENT_DETENTION_REGISTER_ID"
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
	 * Return the value associated with the column: DETENTION_REGISTER_DATE
	 */
	public java.util.Date getDetentionRegisterDate () {
		return detentionRegisterDate;
	}

	/**
	 * Set the value related to the column: DETENTION_REGISTER_DATE
	 * @param detentionRegisterDate the DETENTION_REGISTER_DATE value
	 */
	public void setDetentionRegisterDate (java.util.Date detentionRegisterDate) {
		this.detentionRegisterDate = detentionRegisterDate;
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
	 * Return the value associated with the column: DETAINED_FROM
	 */
	public java.util.Date getDetainedFrom () {
		return detainedFrom;
	}

	/**
	 * Set the value related to the column: DETAINED_FROM
	 * @param detainedFrom the DETAINED_FROM value
	 */
	public void setDetainedFrom (java.util.Date detainedFrom) {
		this.detainedFrom = detainedFrom;
	}



	/**
	 * Return the value associated with the column: DETAINED_TO
	 */
	public java.util.Date getDetainedTo () {
		return detainedTo;
	}

	/**
	 * Set the value related to the column: DETAINED_TO
	 * @param detainedTo the DETAINED_TO value
	 */
	public void setDetainedTo (java.util.Date detainedTo) {
		this.detainedTo = detainedTo;
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
	 * Return the value associated with the column: TREATMENT
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: TREATMENT
	 * @param treatment the TREATMENT value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: FROM_TIME
	 */
	public java.lang.String getFromTime () {
		return fromTime;
	}

	/**
	 * Set the value related to the column: FROM_TIME
	 * @param fromTime the FROM_TIME value
	 */
	public void setFromTime (java.lang.String fromTime) {
		this.fromTime = fromTime;
	}



	/**
	 * Return the value associated with the column: TO_TIME
	 */
	public java.lang.String getToTime () {
		return toTime;
	}

	/**
	 * Set the value related to the column: TO_TIME
	 * @param toTime the TO_TIME value
	 */
	public void setToTime (java.lang.String toTime) {
		this.toTime = toTime;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: REQUISITION_DATE
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: REQUISITION_DATE
	 * @param requisitionDate the REQUISITION_DATE value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	/**
	 * Return the value associated with the column: review_at
	 */
	public java.lang.String getReviewAt () {
		return reviewAt;
	}

	/**
	 * Set the value related to the column: review_at
	 * @param reviewAt the review_at value
	 */
	public void setReviewAt (java.lang.String reviewAt) {
		this.reviewAt = reviewAt;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visit the VISIT_ID value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: dma_register_id
	 */
	public jkt.hms.masters.business.DmaRegisterHeader getDmaRegister () {
		return dmaRegister;
	}

	/**
	 * Set the value related to the column: dma_register_id
	 * @param dmaRegister the dma_register_id value
	 */
	public void setDmaRegister (jkt.hms.masters.business.DmaRegisterHeader dmaRegister) {
		this.dmaRegister = dmaRegister;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientDetentionRegister)) return false;
		else {
			jkt.hms.masters.business.PatientDetentionRegister patientDetentionRegister = (jkt.hms.masters.business.PatientDetentionRegister) obj;
			if (null == this.getId() || null == patientDetentionRegister.getId()) return false;
			else return (this.getId().equals(patientDetentionRegister.getId()));
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