package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the discharge table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="discharge"
 */

public abstract class BaseDischarge  implements Serializable {

	public static String REF = "Discharge";
	public static String PROP_MOVEMENT_CODE = "MovementCode";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_WARD = "Ward";
	public static String PROP_DISCHARGE_NO = "DischargeNo";
	public static String PROP_SHR = "Shr";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TIME_OF_DISCHARGE = "TimeOfDischarge";
	public static String PROP_BOARD_HELD_ON = "BoardHeldOn";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_CARE_SUMMARY = "CareSummary";
	public static String PROP_CARE_TYPE = "CareType";
	public static String PROP_DISCHARGE_STATUS = "DischargeStatus";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_FOLLOW_UP_DATE = "FollowUpDate";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_INJURY_REPORT_INITIATED_ON = "InjuryReportInitiatedOn";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_OTHER_HOSPITAL = "OtherHospital";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISCHARGE_IN_MEDICAL_CATEGORY = "DischargeInMedicalCategory";
	public static String PROP_DISPOSED_TO = "DisposedTo";
	public static String PROP_DOCUMENT_INITIATED = "DocumentInitiated";
	public static String PROP_INJURY_REPORT_INIT_AT = "InjuryReportInitAt";
	public static String PROP_DISCHARGE_ADVICED = "DischargeAdviced";
	public static String PROP_STATUS = "Status";
	public static String PROP_AD_STATUS = "AdStatus";
	public static String PROP_INSTRUCTIONS_TO_PATIENT = "InstructionsToPatient";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_WARRANT_NO = "WarrantNo";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_DISCHARGE = "DateOfDischarge";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseDischarge () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischarge (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer dischargeNo;
	private java.lang.String adNo;
	private java.util.Date injuryReportInitiatedOn;
	private java.lang.String dischargeInMedicalCategory;
	private java.util.Date boardHeldOn;
	private java.lang.String careSummary;
	private java.lang.String instructionsToPatient;
	private java.util.Date followUpDate;
	private java.util.Date dateOfDischarge;
	private java.lang.String timeOfDischarge;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String adStatus;
	private java.lang.String status;
	private java.lang.String dischargeAdviced;
	private java.lang.String movementCode;
	private java.lang.String warrantNo;
	private java.lang.String shr;
	private java.lang.String remarks;
	private java.lang.String otherHospital;
	private java.lang.String injuryReportInitAt;
	private java.lang.String documentInitiated;
	private java.lang.String workingDiagnosis;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasDiagnosisConclusion diagnosis;
	private jkt.hms.masters.business.MasDischargeStatus dischargeStatus;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasDisposedTo disposedTo;
	private jkt.hms.masters.business.MasCareType careType;
	private jkt.hms.masters.business.MasDepartment ward;
	private jkt.hms.masters.business.MasDisposal disposal;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="discharge_id"
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
	 * Return the value associated with the column: discharge_no
	 */
	public java.lang.Integer getDischargeNo () {
		return dischargeNo;
	}

	/**
	 * Set the value related to the column: discharge_no
	 * @param dischargeNo the discharge_no value
	 */
	public void setDischargeNo (java.lang.Integer dischargeNo) {
		this.dischargeNo = dischargeNo;
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
	 * Return the value associated with the column: injury_report_initiated_on
	 */
	public java.util.Date getInjuryReportInitiatedOn () {
		return injuryReportInitiatedOn;
	}

	/**
	 * Set the value related to the column: injury_report_initiated_on
	 * @param injuryReportInitiatedOn the injury_report_initiated_on value
	 */
	public void setInjuryReportInitiatedOn (java.util.Date injuryReportInitiatedOn) {
		this.injuryReportInitiatedOn = injuryReportInitiatedOn;
	}



	/**
	 * Return the value associated with the column: discharge_in_medical_category
	 */
	public java.lang.String getDischargeInMedicalCategory () {
		return dischargeInMedicalCategory;
	}

	/**
	 * Set the value related to the column: discharge_in_medical_category
	 * @param dischargeInMedicalCategory the discharge_in_medical_category value
	 */
	public void setDischargeInMedicalCategory (java.lang.String dischargeInMedicalCategory) {
		this.dischargeInMedicalCategory = dischargeInMedicalCategory;
	}



	/**
	 * Return the value associated with the column: board_held_on
	 */
	public java.util.Date getBoardHeldOn () {
		return boardHeldOn;
	}

	/**
	 * Set the value related to the column: board_held_on
	 * @param boardHeldOn the board_held_on value
	 */
	public void setBoardHeldOn (java.util.Date boardHeldOn) {
		this.boardHeldOn = boardHeldOn;
	}



	/**
	 * Return the value associated with the column: care_summary
	 */
	public java.lang.String getCareSummary () {
		return careSummary;
	}

	/**
	 * Set the value related to the column: care_summary
	 * @param careSummary the care_summary value
	 */
	public void setCareSummary (java.lang.String careSummary) {
		this.careSummary = careSummary;
	}



	/**
	 * Return the value associated with the column: instructions_to_patient
	 */
	public java.lang.String getInstructionsToPatient () {
		return instructionsToPatient;
	}

	/**
	 * Set the value related to the column: instructions_to_patient
	 * @param instructionsToPatient the instructions_to_patient value
	 */
	public void setInstructionsToPatient (java.lang.String instructionsToPatient) {
		this.instructionsToPatient = instructionsToPatient;
	}



	/**
	 * Return the value associated with the column: follow_up_date
	 */
	public java.util.Date getFollowUpDate () {
		return followUpDate;
	}

	/**
	 * Set the value related to the column: follow_up_date
	 * @param followUpDate the follow_up_date value
	 */
	public void setFollowUpDate (java.util.Date followUpDate) {
		this.followUpDate = followUpDate;
	}



	/**
	 * Return the value associated with the column: date_of_discharge
	 */
	public java.util.Date getDateOfDischarge () {
		return dateOfDischarge;
	}

	/**
	 * Set the value related to the column: date_of_discharge
	 * @param dateOfDischarge the date_of_discharge value
	 */
	public void setDateOfDischarge (java.util.Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}



	/**
	 * Return the value associated with the column: time_of_discharge
	 */
	public java.lang.String getTimeOfDischarge () {
		return timeOfDischarge;
	}

	/**
	 * Set the value related to the column: time_of_discharge
	 * @param timeOfDischarge the time_of_discharge value
	 */
	public void setTimeOfDischarge (java.lang.String timeOfDischarge) {
		this.timeOfDischarge = timeOfDischarge;
	}



	/**
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
	}



	/**
	 * Return the value associated with the column: ad_status
	 */
	public java.lang.String getAdStatus () {
		return adStatus;
	}

	/**
	 * Set the value related to the column: ad_status
	 * @param adStatus the ad_status value
	 */
	public void setAdStatus (java.lang.String adStatus) {
		this.adStatus = adStatus;
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
	 * Return the value associated with the column: discharge_adviced
	 */
	public java.lang.String getDischargeAdviced () {
		return dischargeAdviced;
	}

	/**
	 * Set the value related to the column: discharge_adviced
	 * @param dischargeAdviced the discharge_adviced value
	 */
	public void setDischargeAdviced (java.lang.String dischargeAdviced) {
		this.dischargeAdviced = dischargeAdviced;
	}



	/**
	 * Return the value associated with the column: movement_code
	 */
	public java.lang.String getMovementCode () {
		return movementCode;
	}

	/**
	 * Set the value related to the column: movement_code
	 * @param movementCode the movement_code value
	 */
	public void setMovementCode (java.lang.String movementCode) {
		this.movementCode = movementCode;
	}



	/**
	 * Return the value associated with the column: warrant_no
	 */
	public java.lang.String getWarrantNo () {
		return warrantNo;
	}

	/**
	 * Set the value related to the column: warrant_no
	 * @param warrantNo the warrant_no value
	 */
	public void setWarrantNo (java.lang.String warrantNo) {
		this.warrantNo = warrantNo;
	}



	/**
	 * Return the value associated with the column: shr
	 */
	public java.lang.String getShr () {
		return shr;
	}

	/**
	 * Set the value related to the column: shr
	 * @param shr the shr value
	 */
	public void setShr (java.lang.String shr) {
		this.shr = shr;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: other_hospital
	 */
	public java.lang.String getOtherHospital () {
		return otherHospital;
	}

	/**
	 * Set the value related to the column: other_hospital
	 * @param otherHospital the other_hospital value
	 */
	public void setOtherHospital (java.lang.String otherHospital) {
		this.otherHospital = otherHospital;
	}



	/**
	 * Return the value associated with the column: injury_report_init_at
	 */
	public java.lang.String getInjuryReportInitAt () {
		return injuryReportInitAt;
	}

	/**
	 * Set the value related to the column: injury_report_init_at
	 * @param injuryReportInitAt the injury_report_init_at value
	 */
	public void setInjuryReportInitAt (java.lang.String injuryReportInitAt) {
		this.injuryReportInitAt = injuryReportInitAt;
	}



	/**
	 * Return the value associated with the column: document_initiated
	 */
	public java.lang.String getDocumentInitiated () {
		return documentInitiated;
	}

	/**
	 * Set the value related to the column: document_initiated
	 * @param documentInitiated the document_initiated value
	 */
	public void setDocumentInitiated (java.lang.String documentInitiated) {
		this.documentInitiated = documentInitiated;
	}



	/**
	 * Return the value associated with the column: working_diagnosis
	 */
	public java.lang.String getWorkingDiagnosis () {
		return workingDiagnosis;
	}

	/**
	 * Set the value related to the column: working_diagnosis
	 * @param workingDiagnosis the working_diagnosis value
	 */
	public void setWorkingDiagnosis (java.lang.String workingDiagnosis) {
		this.workingDiagnosis = workingDiagnosis;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}



	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public jkt.hms.masters.business.MasDiagnosisConclusion getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * @param diagnosis the diagnosis_id value
	 */
	public void setDiagnosis (jkt.hms.masters.business.MasDiagnosisConclusion diagnosis) {
		this.diagnosis = diagnosis;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: disposed_to_id
	 */
	public jkt.hms.masters.business.MasDisposedTo getDisposedTo () {
		return disposedTo;
	}

	/**
	 * Set the value related to the column: disposed_to_id
	 * @param disposedTo the disposed_to_id value
	 */
	public void setDisposedTo (jkt.hms.masters.business.MasDisposedTo disposedTo) {
		this.disposedTo = disposedTo;
	}



	/**
	 * Return the value associated with the column: care_type_id
	 */
	public jkt.hms.masters.business.MasCareType getCareType () {
		return careType;
	}

	/**
	 * Set the value related to the column: care_type_id
	 * @param careType the care_type_id value
	 */
	public void setCareType (jkt.hms.masters.business.MasCareType careType) {
		this.careType = careType;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasDepartment ward) {
		this.ward = ward;
	}



	/**
	 * Return the value associated with the column: disposal_id
	 */
	public jkt.hms.masters.business.MasDisposal getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal_id
	 * @param disposal the disposal_id value
	 */
	public void setDisposal (jkt.hms.masters.business.MasDisposal disposal) {
		this.disposal = disposal;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Discharge)) return false;
		else {
			jkt.hms.masters.business.Discharge discharge = (jkt.hms.masters.business.Discharge) obj;
			if (null == this.getId() || null == discharge.getId()) return false;
			else return (this.getId().equals(discharge.getId()));
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