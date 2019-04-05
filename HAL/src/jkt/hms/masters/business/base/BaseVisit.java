package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the visit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="visit"
 */

public abstract class BaseVisit  implements Serializable {

	public static String REF = "Visit";
	public static String PROP_USER = "User";
	public static String PROP_PRESCRIPTION_COUNTER = "PrescriptionCounter";
	public static String PROP_CASE_TYPE = "CaseType";
	public static String PROP_DISPOSAL_DAYS = "DisposalDays";
	public static String PROP_HOSPITAL_STAFF = "HospitalStaff";
	public static String PROP_AGE = "Age";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_ROOM_NO = "RoomNo";
	public static String PROP_REPORTING_FOR = "ReportingFor";
	public static String PROP_TOKEN_STATUS = "TokenStatus";
	public static String PROP_VISIT_TIME = "VisitTime";
	public static String PROP_DISPOSAL_NAME = "DisposalName";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_VISIT_STATUS = "VisitStatus";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_INIT_DIAGNOSIS = "InitDiagnosis";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_SESSION = "Session";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_COMPLAINT = "Complaint";
	public static String PROP_DIAGNOSIS_NAME = "DiagnosisName";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_VISIT_NO = "VisitNo";
	public static String PROP_TOKEN_DOCTOR = "TokenDoctor";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MED_EXAM_TYPE = "MedExamType";
	public static String PROP_MED_STATUS = "MedStatus";
	public static String PROP_DENTAL_FLAG = "DentalFlag";
	public static String PROP_FWC_CATEGORY = "FwcCategory";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_FOLLOW_UP_DEPARTMENT = "FollowUpDepartment";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PHY_STATUS = "PhyStatus";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_REFEREE_OPD_PATIENTDETAILS_ID = "RefereeOpdPatientdetailsId";
	public static String PROP_STATUS = "Status";
	public static String PROP_INT_DOCTOR = "IntDoctor";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_VISIT_BY_ADMIN = "VisitByAdmin";
	public static String PROP_DISPLAY_TOKEN = "DisplayToken";
	public static String PROP_DIVISION = "Division";
	public static String PROP_APPOINTMENT_TYPE = "AppointmentType";
	public static String PROP_ID = "Id";
	public static String PROP_COMPLAINT_DETAILS = "ComplaintDetails";
	public static String PROP_HIN = "Hin";
	public static String PROP_EMERGENCY_VISIT = "EmergencyVisit";


	// constructors
	public BaseVisit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVisit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitNo;
	private java.lang.Integer tokenNo;
	private java.lang.String age;
	private java.lang.String hospitalStaff;
	private java.util.Date visitDate;
	private java.lang.String visitTime;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String status;
	private java.lang.Integer weight;
	private java.lang.String appointmentType;
	private java.lang.String visitStatus;
	private java.lang.String visitByAdmin;
	private java.lang.String diagnosisName;
	private java.lang.String initDiagnosis;
	private java.lang.String complaintDetails;
	private java.lang.String workingDiagnosis;
	private java.lang.String medExamType;
	private java.lang.String medStatus;
	private java.lang.String reportingFor;
	private java.lang.String displayToken;
	private java.lang.String tokenDoctor;
	private java.lang.Integer priority;
	private java.lang.String followUpDepartment;
	private java.lang.String disposalName;
	private java.lang.String disposalDays;
	private java.lang.String phyStatus;
	private java.lang.String fwcCategory;
	private java.lang.Integer roomNo;
	private java.lang.String tokenStatus;
	private java.lang.String dentalFlag;
	private java.lang.String emergencyVisit;
	private java.lang.Integer prescriptionCounter;

	// many to one
	private jkt.hms.masters.business.MasDisposal disposal;
	private jkt.hms.masters.business.MasCaseType caseType;
	private jkt.hms.masters.business.MasSession session;
	private jkt.hms.masters.business.MasDiagnosisConclusion diagnosis;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasComplaint complaint;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasDivision division;
	private jkt.hms.masters.business.MasEmployee intDoctor;
	private jkt.hms.masters.business.OpdPatientDetails refereeOpdPatientdetailsId;

	// collections
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps;
	private java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies;
	private java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> opdOncosurgeryCaseSheets;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders;
	private java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments;
	private java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets;
	private java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains;
	private java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts;
	private java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains;
	private java.util.Set<jkt.hms.masters.business.OpdOncology> opdOncologies;
	private java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails;
	private java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders;
	private java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> otPreAnesthesiaDetails;
	private java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs;
	private java.util.Set<jkt.hms.masters.business.OpdUrology> opdUrologies;
	private java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards;
	private java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedures;
	private java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> otProcedureNotesEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies;
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts;
	private java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> otSpecimenDispatchEntrys;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> opdTemplateDepartmentWises;
	private java.util.Set<jkt.hms.masters.business.OpdGynaecology> opdGynaecologys;
	private java.util.Set<jkt.hms.masters.business.TherapyHeader> therapyHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="visit_id"
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
	 * Return the value associated with the column: visit_no
	 */
	public java.lang.Integer getVisitNo () {
		return visitNo;
	}

	/**
	 * Set the value related to the column: visit_no
	 * @param visitNo the visit_no value
	 */
	public void setVisitNo (java.lang.Integer visitNo) {
		this.visitNo = visitNo;
	}



	/**
	 * Return the value associated with the column: token_no
	 */
	public java.lang.Integer getTokenNo () {
		return tokenNo;
	}

	/**
	 * Set the value related to the column: token_no
	 * @param tokenNo the token_no value
	 */
	public void setTokenNo (java.lang.Integer tokenNo) {
		this.tokenNo = tokenNo;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: hospital_staff
	 */
	public java.lang.String getHospitalStaff () {
		return hospitalStaff;
	}

	/**
	 * Set the value related to the column: hospital_staff
	 * @param hospitalStaff the hospital_staff value
	 */
	public void setHospitalStaff (java.lang.String hospitalStaff) {
		this.hospitalStaff = hospitalStaff;
	}



	/**
	 * Return the value associated with the column: visit_date
	 */
	public java.util.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: visit_date
	 * @param visitDate the visit_date value
	 */
	public void setVisitDate (java.util.Date visitDate) {
		this.visitDate = visitDate;
	}



	/**
	 * Return the value associated with the column: visit_time
	 */
	public java.lang.String getVisitTime () {
		return visitTime;
	}

	/**
	 * Set the value related to the column: visit_time
	 * @param visitTime the visit_time value
	 */
	public void setVisitTime (java.lang.String visitTime) {
		this.visitTime = visitTime;
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
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: appointment_type
	 */
	public java.lang.String getAppointmentType () {
		return appointmentType;
	}

	/**
	 * Set the value related to the column: appointment_type
	 * @param appointmentType the appointment_type value
	 */
	public void setAppointmentType (java.lang.String appointmentType) {
		this.appointmentType = appointmentType;
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
	 * Return the value associated with the column: visit_by_admin
	 */
	public java.lang.String getVisitByAdmin () {
		return visitByAdmin;
	}

	/**
	 * Set the value related to the column: visit_by_admin
	 * @param visitByAdmin the visit_by_admin value
	 */
	public void setVisitByAdmin (java.lang.String visitByAdmin) {
		this.visitByAdmin = visitByAdmin;
	}



	/**
	 * Return the value associated with the column: diagnosis_name
	 */
	public java.lang.String getDiagnosisName () {
		return diagnosisName;
	}

	/**
	 * Set the value related to the column: diagnosis_name
	 * @param diagnosisName the diagnosis_name value
	 */
	public void setDiagnosisName (java.lang.String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}



	/**
	 * Return the value associated with the column: init_diagnosis
	 */
	public java.lang.String getInitDiagnosis () {
		return initDiagnosis;
	}

	/**
	 * Set the value related to the column: init_diagnosis
	 * @param initDiagnosis the init_diagnosis value
	 */
	public void setInitDiagnosis (java.lang.String initDiagnosis) {
		this.initDiagnosis = initDiagnosis;
	}



	/**
	 * Return the value associated with the column: complaint_details
	 */
	public java.lang.String getComplaintDetails () {
		return complaintDetails;
	}

	/**
	 * Set the value related to the column: complaint_details
	 * @param complaintDetails the complaint_details value
	 */
	public void setComplaintDetails (java.lang.String complaintDetails) {
		this.complaintDetails = complaintDetails;
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
	 * Return the value associated with the column: med_exam_type
	 */
	public java.lang.String getMedExamType () {
		return medExamType;
	}

	/**
	 * Set the value related to the column: med_exam_type
	 * @param medExamType the med_exam_type value
	 */
	public void setMedExamType (java.lang.String medExamType) {
		this.medExamType = medExamType;
	}



	/**
	 * Return the value associated with the column: med_status
	 */
	public java.lang.String getMedStatus () {
		return medStatus;
	}

	/**
	 * Set the value related to the column: med_status
	 * @param medStatus the med_status value
	 */
	public void setMedStatus (java.lang.String medStatus) {
		this.medStatus = medStatus;
	}



	/**
	 * Return the value associated with the column: reporting_for
	 */
	public java.lang.String getReportingFor () {
		return reportingFor;
	}

	/**
	 * Set the value related to the column: reporting_for
	 * @param reportingFor the reporting_for value
	 */
	public void setReportingFor (java.lang.String reportingFor) {
		this.reportingFor = reportingFor;
	}



	/**
	 * Return the value associated with the column: DISPLAY_TOKEN
	 */
	public java.lang.String getDisplayToken () {
		return displayToken;
	}

	/**
	 * Set the value related to the column: DISPLAY_TOKEN
	 * @param displayToken the DISPLAY_TOKEN value
	 */
	public void setDisplayToken (java.lang.String displayToken) {
		this.displayToken = displayToken;
	}



	/**
	 * Return the value associated with the column: TOKEN_DOCTOR
	 */
	public java.lang.String getTokenDoctor () {
		return tokenDoctor;
	}

	/**
	 * Set the value related to the column: TOKEN_DOCTOR
	 * @param tokenDoctor the TOKEN_DOCTOR value
	 */
	public void setTokenDoctor (java.lang.String tokenDoctor) {
		this.tokenDoctor = tokenDoctor;
	}



	/**
	 * Return the value associated with the column: PRIORITY
	 */
	public java.lang.Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: PRIORITY
	 * @param priority the PRIORITY value
	 */
	public void setPriority (java.lang.Integer priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: follow_up_department
	 */
	public java.lang.String getFollowUpDepartment () {
		return followUpDepartment;
	}

	/**
	 * Set the value related to the column: follow_up_department
	 * @param followUpDepartment the follow_up_department value
	 */
	public void setFollowUpDepartment (java.lang.String followUpDepartment) {
		this.followUpDepartment = followUpDepartment;
	}



	/**
	 * Return the value associated with the column: disposal_name
	 */
	public java.lang.String getDisposalName () {
		return disposalName;
	}

	/**
	 * Set the value related to the column: disposal_name
	 * @param disposalName the disposal_name value
	 */
	public void setDisposalName (java.lang.String disposalName) {
		this.disposalName = disposalName;
	}



	/**
	 * Return the value associated with the column: disposal_days
	 */
	public java.lang.String getDisposalDays () {
		return disposalDays;
	}

	/**
	 * Set the value related to the column: disposal_days
	 * @param disposalDays the disposal_days value
	 */
	public void setDisposalDays (java.lang.String disposalDays) {
		this.disposalDays = disposalDays;
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
	 * Return the value associated with the column: fwc_category
	 */
	public java.lang.String getFwcCategory () {
		return fwcCategory;
	}

	/**
	 * Set the value related to the column: fwc_category
	 * @param fwcCategory the fwc_category value
	 */
	public void setFwcCategory (java.lang.String fwcCategory) {
		this.fwcCategory = fwcCategory;
	}



	/**
	 * Return the value associated with the column: ROOM_NO
	 */
	public java.lang.Integer getRoomNo () {
		return roomNo;
	}

	/**
	 * Set the value related to the column: ROOM_NO
	 * @param roomNo the ROOM_NO value
	 */
	public void setRoomNo (java.lang.Integer roomNo) {
		this.roomNo = roomNo;
	}



	/**
	 * Return the value associated with the column: token_status
	 */
	public java.lang.String getTokenStatus () {
		return tokenStatus;
	}

	/**
	 * Set the value related to the column: token_status
	 * @param tokenStatus the token_status value
	 */
	public void setTokenStatus (java.lang.String tokenStatus) {
		this.tokenStatus = tokenStatus;
	}



	/**
	 * Return the value associated with the column: dental_flag
	 */
	public java.lang.String getDentalFlag () {
		return dentalFlag;
	}

	/**
	 * Set the value related to the column: dental_flag
	 * @param dentalFlag the dental_flag value
	 */
	public void setDentalFlag (java.lang.String dentalFlag) {
		this.dentalFlag = dentalFlag;
	}



	/**
	 * Return the value associated with the column: emergency_visit
	 */
	public java.lang.String getEmergencyVisit () {
		return emergencyVisit;
	}

	/**
	 * Set the value related to the column: emergency_visit
	 * @param emergencyVisit the emergency_visit value
	 */
	public void setEmergencyVisit (java.lang.String emergencyVisit) {
		this.emergencyVisit = emergencyVisit;
	}



	/**
	 * Return the value associated with the column: prescription_counter
	 */
	public java.lang.Integer getPrescriptionCounter () {
		return prescriptionCounter;
	}

	/**
	 * Set the value related to the column: prescription_counter
	 * @param prescriptionCounter the prescription_counter value
	 */
	public void setPrescriptionCounter (java.lang.Integer prescriptionCounter) {
		this.prescriptionCounter = prescriptionCounter;
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
	 * Return the value associated with the column: case_type_id
	 */
	public jkt.hms.masters.business.MasCaseType getCaseType () {
		return caseType;
	}

	/**
	 * Set the value related to the column: case_type_id
	 * @param caseType the case_type_id value
	 */
	public void setCaseType (jkt.hms.masters.business.MasCaseType caseType) {
		this.caseType = caseType;
	}



	/**
	 * Return the value associated with the column: session_id
	 */
	public jkt.hms.masters.business.MasSession getSession () {
		return session;
	}

	/**
	 * Set the value related to the column: session_id
	 * @param session the session_id value
	 */
	public void setSession (jkt.hms.masters.business.MasSession session) {
		this.session = session;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: complaint_id
	 */
	public jkt.hms.masters.business.MasComplaint getComplaint () {
		return complaint;
	}

	/**
	 * Set the value related to the column: complaint_id
	 * @param complaint the complaint_id value
	 */
	public void setComplaint (jkt.hms.masters.business.MasComplaint complaint) {
		this.complaint = complaint;
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
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: division_id
	 */
	public jkt.hms.masters.business.MasDivision getDivision () {
		return division;
	}

	/**
	 * Set the value related to the column: division_id
	 * @param division the division_id value
	 */
	public void setDivision (jkt.hms.masters.business.MasDivision division) {
		this.division = division;
	}



	/**
	 * Return the value associated with the column: int_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getIntDoctor () {
		return intDoctor;
	}

	/**
	 * Set the value related to the column: int_doctor_id
	 * @param intDoctor the int_doctor_id value
	 */
	public void setIntDoctor (jkt.hms.masters.business.MasEmployee intDoctor) {
		this.intDoctor = intDoctor;
	}



	/**
	 * Return the value associated with the column: referee_opd_patientdetails_Id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getRefereeOpdPatientdetailsId () {
		return refereeOpdPatientdetailsId;
	}

	/**
	 * Set the value related to the column: referee_opd_patientdetails_Id
	 * @param refereeOpdPatientdetailsId the referee_opd_patientdetails_Id value
	 */
	public void setRefereeOpdPatientdetailsId (jkt.hms.masters.business.OpdPatientDetails refereeOpdPatientdetailsId) {
		this.refereeOpdPatientdetailsId = refereeOpdPatientdetailsId;
	}



	/**
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes () {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * @param dischargeIcdCodes the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes (java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	public void addToDischargeIcdCodes (jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode) {
		if (null == getDischargeIcdCodes()) setDischargeIcdCodes(new java.util.TreeSet<jkt.hms.masters.business.DischargeIcdCode>());
		getDischargeIcdCodes().add(dischargeIcdCode);
	}



	/**
	 * Return the value associated with the column: OpdOphFollowUps
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> getOpdOphFollowUps () {
		return opdOphFollowUps;
	}

	/**
	 * Set the value related to the column: OpdOphFollowUps
	 * @param opdOphFollowUps the OpdOphFollowUps value
	 */
	public void setOpdOphFollowUps (java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps) {
		this.opdOphFollowUps = opdOphFollowUps;
	}

	public void addToOpdOphFollowUps (jkt.hms.masters.business.OpdOphFollowUp opdOphFollowUp) {
		if (null == getOpdOphFollowUps()) setOpdOphFollowUps(new java.util.TreeSet<jkt.hms.masters.business.OpdOphFollowUp>());
		getOpdOphFollowUps().add(opdOphFollowUp);
	}



	/**
	 * Return the value associated with the column: OpdPatientDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientDetails> getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: OpdPatientDetails
	 * @param opdPatientDetails the OpdPatientDetails value
	 */
	public void setOpdPatientDetails (java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}

	public void addToOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		if (null == getOpdPatientDetails()) setOpdPatientDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientDetails>());
		getOpdPatientDetails().add(opdPatientDetails);
	}



	/**
	 * Return the value associated with the column: OpdGastroEnterologyColonoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> getOpdGastroEnterologyColonoscopies () {
		return opdGastroEnterologyColonoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyColonoscopies
	 * @param opdGastroEnterologyColonoscopies the OpdGastroEnterologyColonoscopies value
	 */
	public void setOpdGastroEnterologyColonoscopies (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies) {
		this.opdGastroEnterologyColonoscopies = opdGastroEnterologyColonoscopies;
	}

	public void addToOpdGastroEnterologyColonoscopies (jkt.hms.masters.business.OpdGastroEnterologyColonoscopy opdGastroEnterologyColonoscopy) {
		if (null == getOpdGastroEnterologyColonoscopies()) setOpdGastroEnterologyColonoscopies(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy>());
		getOpdGastroEnterologyColonoscopies().add(opdGastroEnterologyColonoscopy);
	}



	/**
	 * Return the value associated with the column: OpdOncosurgeryCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> getOpdOncosurgeryCaseSheets () {
		return opdOncosurgeryCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdOncosurgeryCaseSheets
	 * @param opdOncosurgeryCaseSheets the OpdOncosurgeryCaseSheets value
	 */
	public void setOpdOncosurgeryCaseSheets (java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> opdOncosurgeryCaseSheets) {
		this.opdOncosurgeryCaseSheets = opdOncosurgeryCaseSheets;
	}

	public void addToOpdOncosurgeryCaseSheets (jkt.hms.masters.business.OpdOncosurgeryCaseSheet opdOncosurgeryCaseSheet) {
		if (null == getOpdOncosurgeryCaseSheets()) setOpdOncosurgeryCaseSheets(new java.util.TreeSet<jkt.hms.masters.business.OpdOncosurgeryCaseSheet>());
		getOpdOncosurgeryCaseSheets().add(opdOncosurgeryCaseSheet);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesTwos
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> getOpdGravidagramGestationalDiabitiesTwos () {
		return opdGravidagramGestationalDiabitiesTwos;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesTwos
	 * @param opdGravidagramGestationalDiabitiesTwos the OpdGravidagramGestationalDiabitiesTwos value
	 */
	public void setOpdGravidagramGestationalDiabitiesTwos (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos) {
		this.opdGravidagramGestationalDiabitiesTwos = opdGravidagramGestationalDiabitiesTwos;
	}

	public void addToOpdGravidagramGestationalDiabitiesTwos (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo opdGravidagramGestationalDiabitiesTwo) {
		if (null == getOpdGravidagramGestationalDiabitiesTwos()) setOpdGravidagramGestationalDiabitiesTwos(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo>());
		getOpdGravidagramGestationalDiabitiesTwos().add(opdGravidagramGestationalDiabitiesTwo);
	}



	/**
	 * Return the value associated with the column: OpdSurgeryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> getOpdSurgeryHeaders () {
		return opdSurgeryHeaders;
	}

	/**
	 * Set the value related to the column: OpdSurgeryHeaders
	 * @param opdSurgeryHeaders the OpdSurgeryHeaders value
	 */
	public void setOpdSurgeryHeaders (java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders) {
		this.opdSurgeryHeaders = opdSurgeryHeaders;
	}

	public void addToOpdSurgeryHeaders (jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader) {
		if (null == getOpdSurgeryHeaders()) setOpdSurgeryHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryHeader>());
		getOpdSurgeryHeaders().add(opdSurgeryHeader);
	}



	/**
	 * Return the value associated with the column: OpdVaccinationPlans
	 */
	public java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> getOpdVaccinationPlans () {
		return opdVaccinationPlans;
	}

	/**
	 * Set the value related to the column: OpdVaccinationPlans
	 * @param opdVaccinationPlans the OpdVaccinationPlans value
	 */
	public void setOpdVaccinationPlans (java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans) {
		this.opdVaccinationPlans = opdVaccinationPlans;
	}

	public void addToOpdVaccinationPlans (jkt.hms.masters.business.OpdVaccinationPlan opdVaccinationPlan) {
		if (null == getOpdVaccinationPlans()) setOpdVaccinationPlans(new java.util.TreeSet<jkt.hms.masters.business.OpdVaccinationPlan>());
		getOpdVaccinationPlans().add(opdVaccinationPlan);
	}



	/**
	 * Return the value associated with the column: PatientInvestigationHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> getPatientInvestigationHeaders () {
		return patientInvestigationHeaders;
	}

	/**
	 * Set the value related to the column: PatientInvestigationHeaders
	 * @param patientInvestigationHeaders the PatientInvestigationHeaders value
	 */
	public void setPatientInvestigationHeaders (java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders) {
		this.patientInvestigationHeaders = patientInvestigationHeaders;
	}

	public void addToPatientInvestigationHeaders (jkt.hms.masters.business.PatientInvestigationHeader patientInvestigationHeader) {
		if (null == getPatientInvestigationHeaders()) setPatientInvestigationHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationHeader>());
		getPatientInvestigationHeaders().add(patientInvestigationHeader);
	}



	/**
	 * Return the value associated with the column: UploadDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.UploadDocuments> getUploadDocuments () {
		return uploadDocuments;
	}

	/**
	 * Set the value related to the column: UploadDocuments
	 * @param uploadDocuments the UploadDocuments value
	 */
	public void setUploadDocuments (java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments) {
		this.uploadDocuments = uploadDocuments;
	}

	public void addToUploadDocuments (jkt.hms.masters.business.UploadDocuments uploadDocuments) {
		if (null == getUploadDocuments()) setUploadDocuments(new java.util.TreeSet<jkt.hms.masters.business.UploadDocuments>());
		getUploadDocuments().add(uploadDocuments);
	}



	/**
	 * Return the value associated with the column: PatientAllergicDrugsHds
	 */
	public java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> getPatientAllergicDrugsHds () {
		return patientAllergicDrugsHds;
	}

	/**
	 * Set the value related to the column: PatientAllergicDrugsHds
	 * @param patientAllergicDrugsHds the PatientAllergicDrugsHds value
	 */
	public void setPatientAllergicDrugsHds (java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds) {
		this.patientAllergicDrugsHds = patientAllergicDrugsHds;
	}

	public void addToPatientAllergicDrugsHds (jkt.hms.masters.business.PatientAllergicDrugsHd patientAllergicDrugsHd) {
		if (null == getPatientAllergicDrugsHds()) setPatientAllergicDrugsHds(new java.util.TreeSet<jkt.hms.masters.business.PatientAllergicDrugsHd>());
		getPatientAllergicDrugsHds().add(patientAllergicDrugsHd);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesOnes
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> getOpdGravidagramGestationalDiabitiesOnes () {
		return opdGravidagramGestationalDiabitiesOnes;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesOnes
	 * @param opdGravidagramGestationalDiabitiesOnes the OpdGravidagramGestationalDiabitiesOnes value
	 */
	public void setOpdGravidagramGestationalDiabitiesOnes (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes) {
		this.opdGravidagramGestationalDiabitiesOnes = opdGravidagramGestationalDiabitiesOnes;
	}

	public void addToOpdGravidagramGestationalDiabitiesOnes (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne opdGravidagramGestationalDiabitiesOne) {
		if (null == getOpdGravidagramGestationalDiabitiesOnes()) setOpdGravidagramGestationalDiabitiesOnes(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne>());
		getOpdGravidagramGestationalDiabitiesOnes().add(opdGravidagramGestationalDiabitiesOne);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramHtns
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> getOpdGravidagramHtns () {
		return opdGravidagramHtns;
	}

	/**
	 * Set the value related to the column: OpdGravidagramHtns
	 * @param opdGravidagramHtns the OpdGravidagramHtns value
	 */
	public void setOpdGravidagramHtns (java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns) {
		this.opdGravidagramHtns = opdGravidagramHtns;
	}

	public void addToOpdGravidagramHtns (jkt.hms.masters.business.OpdGravidagramHtn opdGravidagramHtn) {
		if (null == getOpdGravidagramHtns()) setOpdGravidagramHtns(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramHtn>());
		getOpdGravidagramHtns().add(opdGravidagramHtn);
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> getPatientPrescriptionHeaders () {
		return patientPrescriptionHeaders;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionHeaders
	 * @param patientPrescriptionHeaders the PatientPrescriptionHeaders value
	 */
	public void setPatientPrescriptionHeaders (java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders) {
		this.patientPrescriptionHeaders = patientPrescriptionHeaders;
	}

	public void addToPatientPrescriptionHeaders (jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader) {
		if (null == getPatientPrescriptionHeaders()) setPatientPrescriptionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionHeader>());
		getPatientPrescriptionHeaders().add(patientPrescriptionHeader);
	}



	/**
	 * Return the value associated with the column: OpdCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCaseSheet> getOpdCaseSheets () {
		return opdCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdCaseSheets
	 * @param opdCaseSheets the OpdCaseSheets value
	 */
	public void setOpdCaseSheets (java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets) {
		this.opdCaseSheets = opdCaseSheets;
	}

	public void addToOpdCaseSheets (jkt.hms.masters.business.OpdCaseSheet opdCaseSheet) {
		if (null == getOpdCaseSheets()) setOpdCaseSheets(new java.util.TreeSet<jkt.hms.masters.business.OpdCaseSheet>());
		getOpdCaseSheets().add(opdCaseSheet);
	}



	/**
	 * Return the value associated with the column: OtPreAnaesthesiaProcNotesMains
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> getOtPreAnaesthesiaProcNotesMains () {
		return otPreAnaesthesiaProcNotesMains;
	}

	/**
	 * Set the value related to the column: OtPreAnaesthesiaProcNotesMains
	 * @param otPreAnaesthesiaProcNotesMains the OtPreAnaesthesiaProcNotesMains value
	 */
	public void setOtPreAnaesthesiaProcNotesMains (java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains) {
		this.otPreAnaesthesiaProcNotesMains = otPreAnaesthesiaProcNotesMains;
	}

	public void addToOtPreAnaesthesiaProcNotesMains (jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain) {
		if (null == getOtPreAnaesthesiaProcNotesMains()) setOtPreAnaesthesiaProcNotesMains(new java.util.TreeSet<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain>());
		getOtPreAnaesthesiaProcNotesMains().add(otPreAnaesthesiaProcNotesMain);
	}



	/**
	 * Return the value associated with the column: OpdOphthalmologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphthalmology> getOpdOphthalmologies () {
		return opdOphthalmologies;
	}

	/**
	 * Set the value related to the column: OpdOphthalmologies
	 * @param opdOphthalmologies the OpdOphthalmologies value
	 */
	public void setOpdOphthalmologies (java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies) {
		this.opdOphthalmologies = opdOphthalmologies;
	}

	public void addToOpdOphthalmologies (jkt.hms.masters.business.OpdOphthalmology opdOphthalmology) {
		if (null == getOpdOphthalmologies()) setOpdOphthalmologies(new java.util.TreeSet<jkt.hms.masters.business.OpdOphthalmology>());
		getOpdOphthalmologies().add(opdOphthalmology);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: BlReceipts
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceipt> getBlReceipts () {
		return blReceipts;
	}

	/**
	 * Set the value related to the column: BlReceipts
	 * @param blReceipts the BlReceipts value
	 */
	public void setBlReceipts (java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts) {
		this.blReceipts = blReceipts;
	}

	public void addToBlReceipts (jkt.hms.masters.business.BlReceipt blReceipt) {
		if (null == getBlReceipts()) setBlReceipts(new java.util.TreeSet<jkt.hms.masters.business.BlReceipt>());
		getBlReceipts().add(blReceipt);
	}



	/**
	 * Return the value associated with the column: BlOpBillMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillMain> getBlOpBillMains () {
		return blOpBillMains;
	}

	/**
	 * Set the value related to the column: BlOpBillMains
	 * @param blOpBillMains the BlOpBillMains value
	 */
	public void setBlOpBillMains (java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains) {
		this.blOpBillMains = blOpBillMains;
	}

	public void addToBlOpBillMains (jkt.hms.masters.business.BlOpBillMain blOpBillMain) {
		if (null == getBlOpBillMains()) setBlOpBillMains(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillMain>());
		getBlOpBillMains().add(blOpBillMain);
	}



	/**
	 * Return the value associated with the column: OpdOncologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOncology> getOpdOncologies () {
		return opdOncologies;
	}

	/**
	 * Set the value related to the column: OpdOncologies
	 * @param opdOncologies the OpdOncologies value
	 */
	public void setOpdOncologies (java.util.Set<jkt.hms.masters.business.OpdOncology> opdOncologies) {
		this.opdOncologies = opdOncologies;
	}

	public void addToOpdOncologies (jkt.hms.masters.business.OpdOncology opdOncology) {
		if (null == getOpdOncologies()) setOpdOncologies(new java.util.TreeSet<jkt.hms.masters.business.OpdOncology>());
		getOpdOncologies().add(opdOncology);
	}



	/**
	 * Return the value associated with the column: OpdCardiologyDepartmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> getOpdCardiologyDepartmentDetails () {
		return opdCardiologyDepartmentDetails;
	}

	/**
	 * Set the value related to the column: OpdCardiologyDepartmentDetails
	 * @param opdCardiologyDepartmentDetails the OpdCardiologyDepartmentDetails value
	 */
	public void setOpdCardiologyDepartmentDetails (java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails) {
		this.opdCardiologyDepartmentDetails = opdCardiologyDepartmentDetails;
	}

	public void addToOpdCardiologyDepartmentDetails (jkt.hms.masters.business.OpdCardiologyDepartmentDetails opdCardiologyDepartmentDetails) {
		if (null == getOpdCardiologyDepartmentDetails()) setOpdCardiologyDepartmentDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdCardiologyDepartmentDetails>());
		getOpdCardiologyDepartmentDetails().add(opdCardiologyDepartmentDetails);
	}



	/**
	 * Return the value associated with the column: OpdOphRetinalHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> getOpdOphRetinalHeaders () {
		return opdOphRetinalHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphRetinalHeaders
	 * @param opdOphRetinalHeaders the OpdOphRetinalHeaders value
	 */
	public void setOpdOphRetinalHeaders (java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders) {
		this.opdOphRetinalHeaders = opdOphRetinalHeaders;
	}

	public void addToOpdOphRetinalHeaders (jkt.hms.masters.business.OpdOphRetinalHeader opdOphRetinalHeader) {
		if (null == getOpdOphRetinalHeaders()) setOpdOphRetinalHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdOphRetinalHeader>());
		getOpdOphRetinalHeaders().add(opdOphRetinalHeader);
	}



	/**
	 * Return the value associated with the column: OtPreAnesthesiaDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> getOtPreAnesthesiaDetails () {
		return otPreAnesthesiaDetails;
	}

	/**
	 * Set the value related to the column: OtPreAnesthesiaDetails
	 * @param otPreAnesthesiaDetails the OtPreAnesthesiaDetails value
	 */
	public void setOtPreAnesthesiaDetails (java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> otPreAnesthesiaDetails) {
		this.otPreAnesthesiaDetails = otPreAnesthesiaDetails;
	}

	public void addToOtPreAnesthesiaDetails (jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails) {
		if (null == getOtPreAnesthesiaDetails()) setOtPreAnesthesiaDetails(new java.util.TreeSet<jkt.hms.masters.business.OtPreAnesthesiaDetails>());
		getOtPreAnesthesiaDetails().add(otPreAnesthesiaDetails);
	}



	/**
	 * Return the value associated with the column: OpdObgs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdObg> getOpdObgs () {
		return opdObgs;
	}

	/**
	 * Set the value related to the column: OpdObgs
	 * @param opdObgs the OpdObgs value
	 */
	public void setOpdObgs (java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs) {
		this.opdObgs = opdObgs;
	}

	public void addToOpdObgs (jkt.hms.masters.business.OpdObg opdObg) {
		if (null == getOpdObgs()) setOpdObgs(new java.util.TreeSet<jkt.hms.masters.business.OpdObg>());
		getOpdObgs().add(opdObg);
	}



	/**
	 * Return the value associated with the column: OpdUrologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdUrology> getOpdUrologies () {
		return opdUrologies;
	}

	/**
	 * Set the value related to the column: OpdUrologies
	 * @param opdUrologies the OpdUrologies value
	 */
	public void setOpdUrologies (java.util.Set<jkt.hms.masters.business.OpdUrology> opdUrologies) {
		this.opdUrologies = opdUrologies;
	}

	public void addToOpdUrologies (jkt.hms.masters.business.OpdUrology opdUrology) {
		if (null == getOpdUrologies()) setOpdUrologies(new java.util.TreeSet<jkt.hms.masters.business.OpdUrology>());
		getOpdUrologies().add(opdUrology);
	}



	/**
	 * Return the value associated with the column: OpdAntenatalCards
	 */
	public java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> getOpdAntenatalCards () {
		return opdAntenatalCards;
	}

	/**
	 * Set the value related to the column: OpdAntenatalCards
	 * @param opdAntenatalCards the OpdAntenatalCards value
	 */
	public void setOpdAntenatalCards (java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards) {
		this.opdAntenatalCards = opdAntenatalCards;
	}

	public void addToOpdAntenatalCards (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		if (null == getOpdAntenatalCards()) setOpdAntenatalCards(new java.util.TreeSet<jkt.hms.masters.business.OpdAntenatalCard>());
		getOpdAntenatalCards().add(opdAntenatalCard);
	}



	/**
	 * Return the value associated with the column: OtPostAnaesthesiaProcedures
	 */
	public java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> getOtPostAnaesthesiaProcedures () {
		return otPostAnaesthesiaProcedures;
	}

	/**
	 * Set the value related to the column: OtPostAnaesthesiaProcedures
	 * @param otPostAnaesthesiaProcedures the OtPostAnaesthesiaProcedures value
	 */
	public void setOtPostAnaesthesiaProcedures (java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedures) {
		this.otPostAnaesthesiaProcedures = otPostAnaesthesiaProcedures;
	}

	public void addToOtPostAnaesthesiaProcedures (jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure) {
		if (null == getOtPostAnaesthesiaProcedures()) setOtPostAnaesthesiaProcedures(new java.util.TreeSet<jkt.hms.masters.business.OtPostAnaesthesiaProcedure>());
		getOtPostAnaesthesiaProcedures().add(otPostAnaesthesiaProcedure);
	}



	/**
	 * Return the value associated with the column: OtProcedureNotesEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> getOtProcedureNotesEntryHeaders () {
		return otProcedureNotesEntryHeaders;
	}

	/**
	 * Set the value related to the column: OtProcedureNotesEntryHeaders
	 * @param otProcedureNotesEntryHeaders the OtProcedureNotesEntryHeaders value
	 */
	public void setOtProcedureNotesEntryHeaders (java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> otProcedureNotesEntryHeaders) {
		this.otProcedureNotesEntryHeaders = otProcedureNotesEntryHeaders;
	}

	public void addToOtProcedureNotesEntryHeaders (jkt.hms.masters.business.OtProcedureNotesEntryHeader otProcedureNotesEntryHeader) {
		if (null == getOtProcedureNotesEntryHeaders()) setOtProcedureNotesEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.OtProcedureNotesEntryHeader>());
		getOtProcedureNotesEntryHeaders().add(otProcedureNotesEntryHeader);
	}



	/**
	 * Return the value associated with the column: OpdGastroEnterologyEndoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> getOpdGastroEnterologyEndoscopies () {
		return opdGastroEnterologyEndoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyEndoscopies
	 * @param opdGastroEnterologyEndoscopies the OpdGastroEnterologyEndoscopies value
	 */
	public void setOpdGastroEnterologyEndoscopies (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies) {
		this.opdGastroEnterologyEndoscopies = opdGastroEnterologyEndoscopies;
	}

	public void addToOpdGastroEnterologyEndoscopies (jkt.hms.masters.business.OpdGastroEnterologyEndoscopy opdGastroEnterologyEndoscopy) {
		if (null == getOpdGastroEnterologyEndoscopies()) setOpdGastroEnterologyEndoscopies(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy>());
		getOpdGastroEnterologyEndoscopies().add(opdGastroEnterologyEndoscopy);
	}



	/**
	 * Return the value associated with the column: OpdOphDiagnosisHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> getOpdOphDiagnosisHeaders () {
		return opdOphDiagnosisHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphDiagnosisHeaders
	 * @param opdOphDiagnosisHeaders the OpdOphDiagnosisHeaders value
	 */
	public void setOpdOphDiagnosisHeaders (java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders) {
		this.opdOphDiagnosisHeaders = opdOphDiagnosisHeaders;
	}

	public void addToOpdOphDiagnosisHeaders (jkt.hms.masters.business.OpdOphDiagnosisHeader opdOphDiagnosisHeader) {
		if (null == getOpdOphDiagnosisHeaders()) setOpdOphDiagnosisHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdOphDiagnosisHeader>());
		getOpdOphDiagnosisHeaders().add(opdOphDiagnosisHeader);
	}



	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings () {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * @param otBookings the OtBookings value
	 */
	public void setOtBookings (java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	public void addToOtBookings (jkt.hms.masters.business.OtBooking otBooking) {
		if (null == getOtBookings()) setOtBookings(new java.util.TreeSet<jkt.hms.masters.business.OtBooking>());
		getOtBookings().add(otBooking);
	}



	/**
	 * Return the value associated with the column: OpdEnts
	 */
	public java.util.Set<jkt.hms.masters.business.OpdEnt> getOpdEnts () {
		return opdEnts;
	}

	/**
	 * Set the value related to the column: OpdEnts
	 * @param opdEnts the OpdEnts value
	 */
	public void setOpdEnts (java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts) {
		this.opdEnts = opdEnts;
	}

	public void addToOpdEnts (jkt.hms.masters.business.OpdEnt opdEnt) {
		if (null == getOpdEnts()) setOpdEnts(new java.util.TreeSet<jkt.hms.masters.business.OpdEnt>());
		getOpdEnts().add(opdEnt);
	}



	/**
	 * Return the value associated with the column: OtSpecimenDispatchEntrys
	 */
	public java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> getOtSpecimenDispatchEntrys () {
		return otSpecimenDispatchEntrys;
	}

	/**
	 * Set the value related to the column: OtSpecimenDispatchEntrys
	 * @param otSpecimenDispatchEntrys the OtSpecimenDispatchEntrys value
	 */
	public void setOtSpecimenDispatchEntrys (java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> otSpecimenDispatchEntrys) {
		this.otSpecimenDispatchEntrys = otSpecimenDispatchEntrys;
	}

	public void addToOtSpecimenDispatchEntrys (jkt.hms.masters.business.OtSpecimenDispatchEntry otSpecimenDispatchEntry) {
		if (null == getOtSpecimenDispatchEntrys()) setOtSpecimenDispatchEntrys(new java.util.TreeSet<jkt.hms.masters.business.OtSpecimenDispatchEntry>());
		getOtSpecimenDispatchEntrys().add(otSpecimenDispatchEntry);
	}



	/**
	 * Return the value associated with the column: OpdTemplateDepartmentWises
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> getOpdTemplateDepartmentWises () {
		return opdTemplateDepartmentWises;
	}

	/**
	 * Set the value related to the column: OpdTemplateDepartmentWises
	 * @param opdTemplateDepartmentWises the OpdTemplateDepartmentWises value
	 */
	public void setOpdTemplateDepartmentWises (java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> opdTemplateDepartmentWises) {
		this.opdTemplateDepartmentWises = opdTemplateDepartmentWises;
	}

	public void addToOpdTemplateDepartmentWises (jkt.hms.masters.business.OpdTemplateDepartmentWise opdTemplateDepartmentWise) {
		if (null == getOpdTemplateDepartmentWises()) setOpdTemplateDepartmentWises(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateDepartmentWise>());
		getOpdTemplateDepartmentWises().add(opdTemplateDepartmentWise);
	}



	/**
	 * Return the value associated with the column: OpdGynaecologys
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGynaecology> getOpdGynaecologys () {
		return opdGynaecologys;
	}

	/**
	 * Set the value related to the column: OpdGynaecologys
	 * @param opdGynaecologys the OpdGynaecologys value
	 */
	public void setOpdGynaecologys (java.util.Set<jkt.hms.masters.business.OpdGynaecology> opdGynaecologys) {
		this.opdGynaecologys = opdGynaecologys;
	}

	public void addToOpdGynaecologys (jkt.hms.masters.business.OpdGynaecology opdGynaecology) {
		if (null == getOpdGynaecologys()) setOpdGynaecologys(new java.util.TreeSet<jkt.hms.masters.business.OpdGynaecology>());
		getOpdGynaecologys().add(opdGynaecology);
	}



	/**
	 * Return the value associated with the column: TherapyHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.TherapyHeader> getTherapyHeaders () {
		return therapyHeaders;
	}

	/**
	 * Set the value related to the column: TherapyHeaders
	 * @param therapyHeaders the TherapyHeaders value
	 */
	public void setTherapyHeaders (java.util.Set<jkt.hms.masters.business.TherapyHeader> therapyHeaders) {
		this.therapyHeaders = therapyHeaders;
	}

	public void addToTherapyHeaders (jkt.hms.masters.business.TherapyHeader therapyHeader) {
		if (null == getTherapyHeaders()) setTherapyHeaders(new java.util.TreeSet<jkt.hms.masters.business.TherapyHeader>());
		getTherapyHeaders().add(therapyHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Visit)) return false;
		else {
			jkt.hms.masters.business.Visit visit = (jkt.hms.masters.business.Visit) obj;
			if (null == this.getId() || null == visit.getId()) return false;
			else return (this.getId().equals(visit.getId()));
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