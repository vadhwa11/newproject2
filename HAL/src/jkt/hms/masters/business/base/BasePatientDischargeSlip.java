package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_DISCHARGE_SLIP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_DISCHARGE_SLIP"
 */

public abstract class BasePatientDischargeSlip  implements Serializable {

	public static String REF = "PatientDischargeSlip";
	public static String PROP_MED_CATEGORY = "MedCategory";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_DISCHARGE_NO = "DischargeNo";
	public static String PROP_DISCHARGE_TIME = "DischargeTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PROCEDURE_DETAILS = "ProcedureDetails";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_INSTRUCTION_TO_PATIENT = "InstructionToPatient";
	public static String PROP_DISCHARGE_STATUS = "DischargeStatus";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_H_L7_FLAG = "HL7Flag";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MH_DEPARTMENT = "MhDepartment";
	public static String PROP_STATUS = "Status";
	public static String PROP_DISCHARGE_TRANSFER_TO_WHERE = "DischargeTransferToWhere";
	public static String PROP_DISCHARGE_TO = "DischargeTo";
	public static String PROP_FOLLOW_UP = "FollowUp";
	public static String PROP_MH = "Mh";
	public static String PROP_REFERRED_FOR = "ReferredFor";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_ID = "Id";
	public static String PROP_HISTORY_EXAMINATION = "HistoryExamination";
	public static String PROP_HIN = "Hin";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";
	public static String PROP_REVIEW_ON = "ReviewOn";


	// constructors
	public BasePatientDischargeSlip () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientDischargeSlip (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String historyExamination;
	private java.lang.String investigation;
	private java.lang.String diagnosis;
	private java.lang.String procedureDetails;
	private java.lang.String treatment;
	private java.lang.String followUp;
	private java.util.Date dischargeDate;
	private java.lang.String dischargeTime;
	private java.lang.Integer dischargeNo;
	private java.lang.String patientCondition;
	private java.lang.String instructionToPatient;
	private java.util.Date reviewOn;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String mh;
	private java.lang.String mhDepartment;
	private java.lang.String referredFor;
	private java.lang.String hL7Flag;
	private java.lang.String dischargeTransferToWhere;

	// many to one
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDisposedTo dischargeTo;
	private jkt.hms.masters.business.MasDischargeStatus dischargeStatus;
	private jkt.hms.masters.business.Category medCategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DISCHARGE_SLIP_ID"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: HISTORY_EXAMINATION
	 */
	public java.lang.String getHistoryExamination () {
		return historyExamination;
	}

	/**
	 * Set the value related to the column: HISTORY_EXAMINATION
	 * @param historyExamination the HISTORY_EXAMINATION value
	 */
	public void setHistoryExamination (java.lang.String historyExamination) {
		this.historyExamination = historyExamination;
	}



	/**
	 * Return the value associated with the column: INVESTIGATION
	 */
	public java.lang.String getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: INVESTIGATION
	 * @param investigation the INVESTIGATION value
	 */
	public void setInvestigation (java.lang.String investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: PROCEDURE_DETAILS
	 */
	public java.lang.String getProcedureDetails () {
		return procedureDetails;
	}

	/**
	 * Set the value related to the column: PROCEDURE_DETAILS
	 * @param procedureDetails the PROCEDURE_DETAILS value
	 */
	public void setProcedureDetails (java.lang.String procedureDetails) {
		this.procedureDetails = procedureDetails;
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
	 * Return the value associated with the column: FOLLOW_UP
	 */
	public java.lang.String getFollowUp () {
		return followUp;
	}

	/**
	 * Set the value related to the column: FOLLOW_UP
	 * @param followUp the FOLLOW_UP value
	 */
	public void setFollowUp (java.lang.String followUp) {
		this.followUp = followUp;
	}



	/**
	 * Return the value associated with the column: DICHARGE_DATE
	 */
	public java.util.Date getDischargeDate () {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: DICHARGE_DATE
	 * @param dischargeDate the DICHARGE_DATE value
	 */
	public void setDischargeDate (java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}



	/**
	 * Return the value associated with the column: DISCHARGE_TIME
	 */
	public java.lang.String getDischargeTime () {
		return dischargeTime;
	}

	/**
	 * Set the value related to the column: DISCHARGE_TIME
	 * @param dischargeTime the DISCHARGE_TIME value
	 */
	public void setDischargeTime (java.lang.String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}



	/**
	 * Return the value associated with the column: DISCHARGE_NO
	 */
	public java.lang.Integer getDischargeNo () {
		return dischargeNo;
	}

	/**
	 * Set the value related to the column: DISCHARGE_NO
	 * @param dischargeNo the DISCHARGE_NO value
	 */
	public void setDischargeNo (java.lang.Integer dischargeNo) {
		this.dischargeNo = dischargeNo;
	}



	/**
	 * Return the value associated with the column: PATIENT_CONDITION
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: PATIENT_CONDITION
	 * @param patientCondition the PATIENT_CONDITION value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: INSTRUCTION_TO_PATIENT
	 */
	public java.lang.String getInstructionToPatient () {
		return instructionToPatient;
	}

	/**
	 * Set the value related to the column: INSTRUCTION_TO_PATIENT
	 * @param instructionToPatient the INSTRUCTION_TO_PATIENT value
	 */
	public void setInstructionToPatient (java.lang.String instructionToPatient) {
		this.instructionToPatient = instructionToPatient;
	}



	/**
	 * Return the value associated with the column: review_on
	 */
	public java.util.Date getReviewOn () {
		return reviewOn;
	}

	/**
	 * Set the value related to the column: review_on
	 * @param reviewOn the review_on value
	 */
	public void setReviewOn (java.util.Date reviewOn) {
		this.reviewOn = reviewOn;
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
	 * Return the value associated with the column: mh
	 */
	public java.lang.String getMh () {
		return mh;
	}

	/**
	 * Set the value related to the column: mh
	 * @param mh the mh value
	 */
	public void setMh (java.lang.String mh) {
		this.mh = mh;
	}



	/**
	 * Return the value associated with the column: MH_DEPARTMENT
	 */
	public java.lang.String getMhDepartment () {
		return mhDepartment;
	}

	/**
	 * Set the value related to the column: MH_DEPARTMENT
	 * @param mhDepartment the MH_DEPARTMENT value
	 */
	public void setMhDepartment (java.lang.String mhDepartment) {
		this.mhDepartment = mhDepartment;
	}



	/**
	 * Return the value associated with the column: REFERRED_FOR
	 */
	public java.lang.String getReferredFor () {
		return referredFor;
	}

	/**
	 * Set the value related to the column: REFERRED_FOR
	 * @param referredFor the REFERRED_FOR value
	 */
	public void setReferredFor (java.lang.String referredFor) {
		this.referredFor = referredFor;
	}



	/**
	 * Return the value associated with the column: HL7_flag
	 */
	public java.lang.String getHL7Flag () {
		return hL7Flag;
	}

	/**
	 * Set the value related to the column: HL7_flag
	 * @param hL7Flag the HL7_flag value
	 */
	public void setHL7Flag (java.lang.String hL7Flag) {
		this.hL7Flag = hL7Flag;
	}



	/**
	 * Return the value associated with the column: DISCHARGE_TRANSFER_TOWHERE
	 */
	public java.lang.String getDischargeTransferToWhere () {
		return dischargeTransferToWhere;
	}

	/**
	 * Set the value related to the column: DISCHARGE_TRANSFER_TOWHERE
	 * @param dischargeTransferToWhere the DISCHARGE_TRANSFER_TOWHERE value
	 */
	public void setDischargeTransferToWhere (java.lang.String dischargeTransferToWhere) {
		this.dischargeTransferToWhere = dischargeTransferToWhere;
	}



	/**
	 * Return the value associated with the column: DOCTOR_ID
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: DOCTOR_ID
	 * @param doctor the DOCTOR_ID value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
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
	 * Return the value associated with the column: discharge_to
	 */
	public jkt.hms.masters.business.MasDisposedTo getDischargeTo () {
		return dischargeTo;
	}

	/**
	 * Set the value related to the column: discharge_to
	 * @param dischargeTo the discharge_to value
	 */
	public void setDischargeTo (jkt.hms.masters.business.MasDisposedTo dischargeTo) {
		this.dischargeTo = dischargeTo;
	}



	/**
	 * Return the value associated with the column: discharge_status_id
	 */
	public jkt.hms.masters.business.MasDischargeStatus getDischargeStatus () {
		return dischargeStatus;
	}

	/**
	 * Set the value related to the column: discharge_status_id
	 * @param dischargeStatus the discharge_status_id value
	 */
	public void setDischargeStatus (jkt.hms.masters.business.MasDischargeStatus dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}



	/**
	 * Return the value associated with the column: med_category
	 */
	public jkt.hms.masters.business.Category getMedCategory () {
		return medCategory;
	}

	/**
	 * Set the value related to the column: med_category
	 * @param medCategory the med_category value
	 */
	public void setMedCategory (jkt.hms.masters.business.Category medCategory) {
		this.medCategory = medCategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientDischargeSlip)) return false;
		else {
			jkt.hms.masters.business.PatientDischargeSlip patientDischargeSlip = (jkt.hms.masters.business.PatientDischargeSlip) obj;
			if (null == this.getId() || null == patientDischargeSlip.getId()) return false;
			else return (this.getId().equals(patientDischargeSlip.getId()));
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