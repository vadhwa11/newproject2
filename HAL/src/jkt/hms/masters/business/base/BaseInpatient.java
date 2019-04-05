package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the inpatient table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="inpatient"
 */

public abstract class BaseInpatient  implements Serializable {

	public static String REF = "Inpatient";
	public static String PROP_LIST_DATE = "ListDate";
	public static String PROP_CASE_TYPE = "CaseType";
	public static String PROP_FRW_ISSUED = "FrwIssued";
	public static String PROP_DISCHARGE_TIME = "DischargeTime";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_VIP = "Vip";
	public static String PROP_AD_WARD_ID = "AdWardId";
	public static String PROP_PARENT_AD_NO = "ParentAdNo";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_HSR_RECEIPT_NO = "HsrReceiptNo";
	public static String PROP_DATE_OF_ADDMISSION = "DateOfAddmission";
	public static String PROP_STAFF_SL_NO = "StaffSlNo";
	public static String PROP_PREV_HOSPITAL_NAME = "PrevHospitalName";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_PREVIOUS_AD_NO = "PreviousAdNo";
	public static String PROP_LR_TRANSFER_STATUS = "LrTransferStatus";
	public static String PROP_TIME_OF_ADDMISSION = "TimeOfAddmission";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_MLC = "Mlc";
	public static String PROP_RECORD_OFFICE_ADDRESS = "RecordOfficeAddress";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PREV_DISPOSAL = "PrevDisposal";
	public static String PROP_VISIT = "Visit";
	public static String PROP_FRW_SL_NO = "FrwSlNo";
	public static String PROP_SURGERY_STATUS = "SurgeryStatus";
	public static String PROP_HSR_AMOUNT = "HsrAmount";
	public static String PROP_AD_NO_TYPE = "AdNoType";
	public static String PROP_DELIVERY_STATUS = "DeliveryStatus";
	public static String PROP_SERVICE_CARD_STATUS = "ServiceCardStatus";
	public static String PROP_ID = "Id";
	public static String PROP_DIET = "Diet";
	public static String PROP_LIST_TIME = "ListTime";
	public static String PROP_BED = "Bed";
	public static String PROP_AGE = "Age";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_DELIVERY_OT_STATUS = "DeliveryOtStatus";
	public static String PROP_AT_OR_DT = "AtOrDt";
	public static String PROP_CONDITION_STATUS = "ConditionStatus";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_PREV_AD_NO = "PrevAdNo";
	public static String PROP_INIT_DIAGNOSIS = "InitDiagnosis";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_H_L7_FLAG = "HL7Flag";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PLACE_OF_ISSUE = "PlaceOfIssue";
	public static String PROP_LIST = "List";
	public static String PROP_MOTHER_AD_NO = "MotherAdNo";
	public static String PROP_PREV_DIAGNOSIS = "PrevDiagnosis";
	public static String PROP_ADMISSION_TYPE = "AdmissionType";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_TRANS_FROM = "TransFrom";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_STATUS = "Status";
	public static String PROP_AD_STATUS = "AdStatus";
	public static String PROP_ATTACHED_UNIT = "AttachedUnit";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_ATTACHED_PATIENT = "AttachedPatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";


	// constructors
	public BaseInpatient () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInpatient (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String age;
	private java.util.Date dateOfAddmission;
	private java.lang.String timeOfAddmission;
	private java.lang.String dietType;
	private java.lang.String priority;
	private java.lang.String list;
	private java.lang.String mlc;
	private java.util.Date dischargeDate;
	private java.lang.String dischargeTime;
	private java.lang.String serviceCardStatus;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String adStatus;
	private java.lang.String status;
	private java.lang.String patientCondition;
	private java.lang.String motherAdNo;
	private java.lang.String conditionStatus;
	private java.lang.String hinNo;
	private java.lang.String frwIssued;
	private java.lang.String frwSlNo;
	private java.lang.String placeOfIssue;
	private java.util.Date listDate;
	private java.lang.String listTime;
	private java.lang.String vip;
	private java.lang.Integer staffSlNo;
	private java.lang.String hsrReceiptNo;
	private java.math.BigDecimal hsrAmount;
	private java.lang.String parentAdNo;
	private java.lang.String attachedPatient;
	private java.lang.String atOrDt;
	private java.lang.String remarks;
	private java.lang.String transFrom;
	private java.lang.String previousAdNo;
	private java.lang.String initDiagnosis;
	private java.lang.String adNoType;
	private java.lang.String attachedUnit;
	private java.lang.String prevHospitalName;
	private java.lang.String prevAdNo;
	private java.lang.String prevDisposal;
	private java.lang.String surgeryStatus;
	private java.lang.String prevDiagnosis;
	private java.lang.String hL7Flag;
	private java.lang.String deliveryStatus;
	private java.lang.String deliveryOtStatus;
	private java.lang.String lrTransferStatus;

	// many to one
	private jkt.hms.masters.business.MasCaseType caseType;
	private jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress;
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasIcd diagnosis;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDocument document;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasAdmissionType admissionType;
	private jkt.hms.masters.business.MasDepartment adWardId;
	private jkt.hms.masters.business.Visit visit;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains;
	private java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> otPreAnesthesiaDetails;
	private java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails;
	private java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers;
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders;
	private java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.PatientRemarks> patientRemarks;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.OpdGynaecology> opdGynaecologys;
	private java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.ProcedureHeader> procedureHeaders;
	private java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> physioRequisitionHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="inpatient_id"
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
	 * Return the value associated with the column: date_of_addmission
	 */
	public java.util.Date getDateOfAddmission () {
		return dateOfAddmission;
	}

	/**
	 * Set the value related to the column: date_of_addmission
	 * @param dateOfAddmission the date_of_addmission value
	 */
	public void setDateOfAddmission (java.util.Date dateOfAddmission) {
		this.dateOfAddmission = dateOfAddmission;
	}



	/**
	 * Return the value associated with the column: time_of_addmission
	 */
	public java.lang.String getTimeOfAddmission () {
		return timeOfAddmission;
	}

	/**
	 * Set the value related to the column: time_of_addmission
	 * @param timeOfAddmission the time_of_addmission value
	 */
	public void setTimeOfAddmission (java.lang.String timeOfAddmission) {
		this.timeOfAddmission = timeOfAddmission;
	}



	/**
	 * Return the value associated with the column: diet_type
	 */
	public java.lang.String getDietType () {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type
	 * @param dietType the diet_type value
	 */
	public void setDietType (java.lang.String dietType) {
		this.dietType = dietType;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: list
	 */
	public java.lang.String getList () {
		return list;
	}

	/**
	 * Set the value related to the column: list
	 * @param list the list value
	 */
	public void setList (java.lang.String list) {
		this.list = list;
	}



	/**
	 * Return the value associated with the column: mlc
	 */
	public java.lang.String getMlc () {
		return mlc;
	}

	/**
	 * Set the value related to the column: mlc
	 * @param mlc the mlc value
	 */
	public void setMlc (java.lang.String mlc) {
		this.mlc = mlc;
	}



	/**
	 * Return the value associated with the column: discharge_date
	 */
	public java.util.Date getDischargeDate () {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: discharge_date
	 * @param dischargeDate the discharge_date value
	 */
	public void setDischargeDate (java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}



	/**
	 * Return the value associated with the column: discharge_time
	 */
	public java.lang.String getDischargeTime () {
		return dischargeTime;
	}

	/**
	 * Set the value related to the column: discharge_time
	 * @param dischargeTime the discharge_time value
	 */
	public void setDischargeTime (java.lang.String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}



	/**
	 * Return the value associated with the column: service_card_status
	 */
	public java.lang.String getServiceCardStatus () {
		return serviceCardStatus;
	}

	/**
	 * Set the value related to the column: service_card_status
	 * @param serviceCardStatus the service_card_status value
	 */
	public void setServiceCardStatus (java.lang.String serviceCardStatus) {
		this.serviceCardStatus = serviceCardStatus;
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
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * @param patientCondition the patient_condition value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: mother_ad_no
	 */
	public java.lang.String getMotherAdNo () {
		return motherAdNo;
	}

	/**
	 * Set the value related to the column: mother_ad_no
	 * @param motherAdNo the mother_ad_no value
	 */
	public void setMotherAdNo (java.lang.String motherAdNo) {
		this.motherAdNo = motherAdNo;
	}



	/**
	 * Return the value associated with the column: condition_status
	 */
	public java.lang.String getConditionStatus () {
		return conditionStatus;
	}

	/**
	 * Set the value related to the column: condition_status
	 * @param conditionStatus the condition_status value
	 */
	public void setConditionStatus (java.lang.String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: frw_issued
	 */
	public java.lang.String getFrwIssued () {
		return frwIssued;
	}

	/**
	 * Set the value related to the column: frw_issued
	 * @param frwIssued the frw_issued value
	 */
	public void setFrwIssued (java.lang.String frwIssued) {
		this.frwIssued = frwIssued;
	}



	/**
	 * Return the value associated with the column: frw_sl_no
	 */
	public java.lang.String getFrwSlNo () {
		return frwSlNo;
	}

	/**
	 * Set the value related to the column: frw_sl_no
	 * @param frwSlNo the frw_sl_no value
	 */
	public void setFrwSlNo (java.lang.String frwSlNo) {
		this.frwSlNo = frwSlNo;
	}



	/**
	 * Return the value associated with the column: place_of_issue
	 */
	public java.lang.String getPlaceOfIssue () {
		return placeOfIssue;
	}

	/**
	 * Set the value related to the column: place_of_issue
	 * @param placeOfIssue the place_of_issue value
	 */
	public void setPlaceOfIssue (java.lang.String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}



	/**
	 * Return the value associated with the column: list_date
	 */
	public java.util.Date getListDate () {
		return listDate;
	}

	/**
	 * Set the value related to the column: list_date
	 * @param listDate the list_date value
	 */
	public void setListDate (java.util.Date listDate) {
		this.listDate = listDate;
	}



	/**
	 * Return the value associated with the column: list_time
	 */
	public java.lang.String getListTime () {
		return listTime;
	}

	/**
	 * Set the value related to the column: list_time
	 * @param listTime the list_time value
	 */
	public void setListTime (java.lang.String listTime) {
		this.listTime = listTime;
	}



	/**
	 * Return the value associated with the column: vip
	 */
	public java.lang.String getVip () {
		return vip;
	}

	/**
	 * Set the value related to the column: vip
	 * @param vip the vip value
	 */
	public void setVip (java.lang.String vip) {
		this.vip = vip;
	}



	/**
	 * Return the value associated with the column: staff_sl_no
	 */
	public java.lang.Integer getStaffSlNo () {
		return staffSlNo;
	}

	/**
	 * Set the value related to the column: staff_sl_no
	 * @param staffSlNo the staff_sl_no value
	 */
	public void setStaffSlNo (java.lang.Integer staffSlNo) {
		this.staffSlNo = staffSlNo;
	}



	/**
	 * Return the value associated with the column: hsr_receipt_no
	 */
	public java.lang.String getHsrReceiptNo () {
		return hsrReceiptNo;
	}

	/**
	 * Set the value related to the column: hsr_receipt_no
	 * @param hsrReceiptNo the hsr_receipt_no value
	 */
	public void setHsrReceiptNo (java.lang.String hsrReceiptNo) {
		this.hsrReceiptNo = hsrReceiptNo;
	}



	/**
	 * Return the value associated with the column: hsr_amount
	 */
	public java.math.BigDecimal getHsrAmount () {
		return hsrAmount;
	}

	/**
	 * Set the value related to the column: hsr_amount
	 * @param hsrAmount the hsr_amount value
	 */
	public void setHsrAmount (java.math.BigDecimal hsrAmount) {
		this.hsrAmount = hsrAmount;
	}



	/**
	 * Return the value associated with the column: parent_ad_no
	 */
	public java.lang.String getParentAdNo () {
		return parentAdNo;
	}

	/**
	 * Set the value related to the column: parent_ad_no
	 * @param parentAdNo the parent_ad_no value
	 */
	public void setParentAdNo (java.lang.String parentAdNo) {
		this.parentAdNo = parentAdNo;
	}



	/**
	 * Return the value associated with the column: attached_patient
	 */
	public java.lang.String getAttachedPatient () {
		return attachedPatient;
	}

	/**
	 * Set the value related to the column: attached_patient
	 * @param attachedPatient the attached_patient value
	 */
	public void setAttachedPatient (java.lang.String attachedPatient) {
		this.attachedPatient = attachedPatient;
	}



	/**
	 * Return the value associated with the column: at_or_dt
	 */
	public java.lang.String getAtOrDt () {
		return atOrDt;
	}

	/**
	 * Set the value related to the column: at_or_dt
	 * @param atOrDt the at_or_dt value
	 */
	public void setAtOrDt (java.lang.String atOrDt) {
		this.atOrDt = atOrDt;
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
	 * Return the value associated with the column: trans_from
	 */
	public java.lang.String getTransFrom () {
		return transFrom;
	}

	/**
	 * Set the value related to the column: trans_from
	 * @param transFrom the trans_from value
	 */
	public void setTransFrom (java.lang.String transFrom) {
		this.transFrom = transFrom;
	}



	/**
	 * Return the value associated with the column: previous_ad_no
	 */
	public java.lang.String getPreviousAdNo () {
		return previousAdNo;
	}

	/**
	 * Set the value related to the column: previous_ad_no
	 * @param previousAdNo the previous_ad_no value
	 */
	public void setPreviousAdNo (java.lang.String previousAdNo) {
		this.previousAdNo = previousAdNo;
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
	 * Return the value associated with the column: ad_no_type
	 */
	public java.lang.String getAdNoType () {
		return adNoType;
	}

	/**
	 * Set the value related to the column: ad_no_type
	 * @param adNoType the ad_no_type value
	 */
	public void setAdNoType (java.lang.String adNoType) {
		this.adNoType = adNoType;
	}



	/**
	 * Return the value associated with the column: attached_unit
	 */
	public java.lang.String getAttachedUnit () {
		return attachedUnit;
	}

	/**
	 * Set the value related to the column: attached_unit
	 * @param attachedUnit the attached_unit value
	 */
	public void setAttachedUnit (java.lang.String attachedUnit) {
		this.attachedUnit = attachedUnit;
	}



	/**
	 * Return the value associated with the column: prev_hospital_name
	 */
	public java.lang.String getPrevHospitalName () {
		return prevHospitalName;
	}

	/**
	 * Set the value related to the column: prev_hospital_name
	 * @param prevHospitalName the prev_hospital_name value
	 */
	public void setPrevHospitalName (java.lang.String prevHospitalName) {
		this.prevHospitalName = prevHospitalName;
	}



	/**
	 * Return the value associated with the column: prev_ad_no
	 */
	public java.lang.String getPrevAdNo () {
		return prevAdNo;
	}

	/**
	 * Set the value related to the column: prev_ad_no
	 * @param prevAdNo the prev_ad_no value
	 */
	public void setPrevAdNo (java.lang.String prevAdNo) {
		this.prevAdNo = prevAdNo;
	}



	/**
	 * Return the value associated with the column: prev_disposal
	 */
	public java.lang.String getPrevDisposal () {
		return prevDisposal;
	}

	/**
	 * Set the value related to the column: prev_disposal
	 * @param prevDisposal the prev_disposal value
	 */
	public void setPrevDisposal (java.lang.String prevDisposal) {
		this.prevDisposal = prevDisposal;
	}



	/**
	 * Return the value associated with the column: surgery_status
	 */
	public java.lang.String getSurgeryStatus () {
		return surgeryStatus;
	}

	/**
	 * Set the value related to the column: surgery_status
	 * @param surgeryStatus the surgery_status value
	 */
	public void setSurgeryStatus (java.lang.String surgeryStatus) {
		this.surgeryStatus = surgeryStatus;
	}



	/**
	 * Return the value associated with the column: prev_diagnosis
	 */
	public java.lang.String getPrevDiagnosis () {
		return prevDiagnosis;
	}

	/**
	 * Set the value related to the column: prev_diagnosis
	 * @param prevDiagnosis the prev_diagnosis value
	 */
	public void setPrevDiagnosis (java.lang.String prevDiagnosis) {
		this.prevDiagnosis = prevDiagnosis;
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
	 * Return the value associated with the column: delivery_status
	 */
	public java.lang.String getDeliveryStatus () {
		return deliveryStatus;
	}

	/**
	 * Set the value related to the column: delivery_status
	 * @param deliveryStatus the delivery_status value
	 */
	public void setDeliveryStatus (java.lang.String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}



	/**
	 * Return the value associated with the column: delivery_ot_status
	 */
	public java.lang.String getDeliveryOtStatus () {
		return deliveryOtStatus;
	}

	/**
	 * Set the value related to the column: delivery_ot_status
	 * @param deliveryOtStatus the delivery_ot_status value
	 */
	public void setDeliveryOtStatus (java.lang.String deliveryOtStatus) {
		this.deliveryOtStatus = deliveryOtStatus;
	}



	/**
	 * Return the value associated with the column: lr_transfer_status
	 */
	public java.lang.String getLrTransferStatus () {
		return lrTransferStatus;
	}

	/**
	 * Set the value related to the column: lr_transfer_status
	 * @param lrTransferStatus the lr_transfer_status value
	 */
	public void setLrTransferStatus (java.lang.String lrTransferStatus) {
		this.lrTransferStatus = lrTransferStatus;
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
	 * Return the value associated with the column: record_office_address_id
	 */
	public jkt.hms.masters.business.MasRecordOfficeAddress getRecordOfficeAddress () {
		return recordOfficeAddress;
	}

	/**
	 * Set the value related to the column: record_office_address_id
	 * @param recordOfficeAddress the record_office_address_id value
	 */
	public void setRecordOfficeAddress (jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress) {
		this.recordOfficeAddress = recordOfficeAddress;
	}



	/**
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}



	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public jkt.hms.masters.business.MasIcd getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * @param diagnosis the diagnosis_id value
	 */
	public void setDiagnosis (jkt.hms.masters.business.MasIcd diagnosis) {
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
	 * Return the value associated with the column: document_id
	 */
	public jkt.hms.masters.business.MasDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: document_id
	 * @param document the document_id value
	 */
	public void setDocument (jkt.hms.masters.business.MasDocument document) {
		this.document = document;
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
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * @param diet the diet_id value
	 */
	public void setDiet (jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
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
	 * Return the value associated with the column: admission_type_id
	 */
	public jkt.hms.masters.business.MasAdmissionType getAdmissionType () {
		return admissionType;
	}

	/**
	 * Set the value related to the column: admission_type_id
	 * @param admissionType the admission_type_id value
	 */
	public void setAdmissionType (jkt.hms.masters.business.MasAdmissionType admissionType) {
		this.admissionType = admissionType;
	}



	/**
	 * Return the value associated with the column: ad_ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getAdWardId () {
		return adWardId;
	}

	/**
	 * Set the value related to the column: ad_ward_id
	 * @param adWardId the ad_ward_id value
	 */
	public void setAdWardId (jkt.hms.masters.business.MasDepartment adWardId) {
		this.adWardId = adWardId;
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
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: BlChargeSlipMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> getBlChargeSlipMains () {
		return blChargeSlipMains;
	}

	/**
	 * Set the value related to the column: BlChargeSlipMains
	 * @param blChargeSlipMains the BlChargeSlipMains value
	 */
	public void setBlChargeSlipMains (java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains) {
		this.blChargeSlipMains = blChargeSlipMains;
	}

	public void addToBlChargeSlipMains (jkt.hms.masters.business.BlChargeSlipMain blChargeSlipMain) {
		if (null == getBlChargeSlipMains()) setBlChargeSlipMains(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipMain>());
		getBlChargeSlipMains().add(blChargeSlipMain);
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
	 * Return the value associated with the column: BlDepositHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlDepositHeader> getBlDepositHeaders () {
		return blDepositHeaders;
	}

	/**
	 * Set the value related to the column: BlDepositHeaders
	 * @param blDepositHeaders the BlDepositHeaders value
	 */
	public void setBlDepositHeaders (java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders) {
		this.blDepositHeaders = blDepositHeaders;
	}

	public void addToBlDepositHeaders (jkt.hms.masters.business.BlDepositHeader blDepositHeader) {
		if (null == getBlDepositHeaders()) setBlDepositHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlDepositHeader>());
		getBlDepositHeaders().add(blDepositHeader);
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
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathregs().add(birthdeathreg);
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
	 * Return the value associated with the column: MisNotifiables
	 */
	public java.util.Set<jkt.hms.masters.business.MisNotifiable> getMisNotifiables () {
		return misNotifiables;
	}

	/**
	 * Set the value related to the column: MisNotifiables
	 * @param misNotifiables the MisNotifiables value
	 */
	public void setMisNotifiables (java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables) {
		this.misNotifiables = misNotifiables;
	}

	public void addToMisNotifiables (jkt.hms.masters.business.MisNotifiable misNotifiable) {
		if (null == getMisNotifiables()) setMisNotifiables(new java.util.TreeSet<jkt.hms.masters.business.MisNotifiable>());
		getMisNotifiables().add(misNotifiable);
	}



	/**
	 * Return the value associated with the column: DietDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetails () {
		return dietDetails;
	}

	/**
	 * Set the value related to the column: DietDetails
	 * @param dietDetails the DietDetails value
	 */
	public void setDietDetails (java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails) {
		this.dietDetails = dietDetails;
	}

	public void addToDietDetails (jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetails()) setDietDetails(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetails().add(dietDetails);
	}



	/**
	 * Return the value associated with the column: BlPatientLedgers
	 */
	public java.util.Set<jkt.hms.masters.business.BlPatientLedger> getBlPatientLedgers () {
		return blPatientLedgers;
	}

	/**
	 * Set the value related to the column: BlPatientLedgers
	 * @param blPatientLedgers the BlPatientLedgers value
	 */
	public void setBlPatientLedgers (java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers) {
		this.blPatientLedgers = blPatientLedgers;
	}

	public void addToBlPatientLedgers (jkt.hms.masters.business.BlPatientLedger blPatientLedger) {
		if (null == getBlPatientLedgers()) setBlPatientLedgers(new java.util.TreeSet<jkt.hms.masters.business.BlPatientLedger>());
		getBlPatientLedgers().add(blPatientLedger);
	}



	/**
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
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
	 * Return the value associated with the column: InpatientDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.InpatientDocument> getInpatientDocuments () {
		return inpatientDocuments;
	}

	/**
	 * Set the value related to the column: InpatientDocuments
	 * @param inpatientDocuments the InpatientDocuments value
	 */
	public void setInpatientDocuments (java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments) {
		this.inpatientDocuments = inpatientDocuments;
	}

	public void addToInpatientDocuments (jkt.hms.masters.business.InpatientDocument inpatientDocument) {
		if (null == getInpatientDocuments()) setInpatientDocuments(new java.util.TreeSet<jkt.hms.masters.business.InpatientDocument>());
		getInpatientDocuments().add(inpatientDocument);
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
	 * Return the value associated with the column: MisFatalTrackings
	 */
	public java.util.Set<jkt.hms.masters.business.MisFatalTracking> getMisFatalTrackings () {
		return misFatalTrackings;
	}

	/**
	 * Set the value related to the column: MisFatalTrackings
	 * @param misFatalTrackings the MisFatalTrackings value
	 */
	public void setMisFatalTrackings (java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings) {
		this.misFatalTrackings = misFatalTrackings;
	}

	public void addToMisFatalTrackings (jkt.hms.masters.business.MisFatalTracking misFatalTracking) {
		if (null == getMisFatalTrackings()) setMisFatalTrackings(new java.util.TreeSet<jkt.hms.masters.business.MisFatalTracking>());
		getMisFatalTrackings().add(misFatalTracking);
	}



	/**
	 * Return the value associated with the column: BlRefundHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlRefundHeader> getBlRefundHeaders () {
		return blRefundHeaders;
	}

	/**
	 * Set the value related to the column: BlRefundHeaders
	 * @param blRefundHeaders the BlRefundHeaders value
	 */
	public void setBlRefundHeaders (java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders) {
		this.blRefundHeaders = blRefundHeaders;
	}

	public void addToBlRefundHeaders (jkt.hms.masters.business.BlRefundHeader blRefundHeader) {
		if (null == getBlRefundHeaders()) setBlRefundHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlRefundHeader>());
		getBlRefundHeaders().add(blRefundHeader);
	}



	/**
	 * Return the value associated with the column: DgResultEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> getDgResultEntryHeaders () {
		return dgResultEntryHeaders;
	}

	/**
	 * Set the value related to the column: DgResultEntryHeaders
	 * @param dgResultEntryHeaders the DgResultEntryHeaders value
	 */
	public void setDgResultEntryHeaders (java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders) {
		this.dgResultEntryHeaders = dgResultEntryHeaders;
	}

	public void addToDgResultEntryHeaders (jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader) {
		if (null == getDgResultEntryHeaders()) setDgResultEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryHeader>());
		getDgResultEntryHeaders().add(dgResultEntryHeader);
	}



	/**
	 * Return the value associated with the column: SilDilStatus
	 */
	public java.util.Set<jkt.hms.masters.business.SilDilStatus> getSilDilStatus () {
		return silDilStatus;
	}

	/**
	 * Set the value related to the column: SilDilStatus
	 * @param silDilStatus the SilDilStatus value
	 */
	public void setSilDilStatus (java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus) {
		this.silDilStatus = silDilStatus;
	}

	public void addToSilDilStatus (jkt.hms.masters.business.SilDilStatus silDilStatus) {
		if (null == getSilDilStatus()) setSilDilStatus(new java.util.TreeSet<jkt.hms.masters.business.SilDilStatus>());
		getSilDilStatus().add(silDilStatus);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> getDgSampleCollectionHeaders () {
		return dgSampleCollectionHeaders;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionHeaders
	 * @param dgSampleCollectionHeaders the DgSampleCollectionHeaders value
	 */
	public void setDgSampleCollectionHeaders (java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders) {
		this.dgSampleCollectionHeaders = dgSampleCollectionHeaders;
	}

	public void addToDgSampleCollectionHeaders (jkt.hms.masters.business.DgSampleCollectionHeader dgSampleCollectionHeader) {
		if (null == getDgSampleCollectionHeaders()) setDgSampleCollectionHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionHeader>());
		getDgSampleCollectionHeaders().add(dgSampleCollectionHeader);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: PatientRemarks
	 */
	public java.util.Set<jkt.hms.masters.business.PatientRemarks> getPatientRemarks () {
		return patientRemarks;
	}

	/**
	 * Set the value related to the column: PatientRemarks
	 * @param patientRemarks the PatientRemarks value
	 */
	public void setPatientRemarks (java.util.Set<jkt.hms.masters.business.PatientRemarks> patientRemarks) {
		this.patientRemarks = patientRemarks;
	}

	public void addToPatientRemarks (jkt.hms.masters.business.PatientRemarks patientRemarks) {
		if (null == getPatientRemarks()) setPatientRemarks(new java.util.TreeSet<jkt.hms.masters.business.PatientRemarks>());
		getPatientRemarks().add(patientRemarks);
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
	 * Return the value associated with the column: ProcedureHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.ProcedureHeader> getProcedureHeaders () {
		return procedureHeaders;
	}

	/**
	 * Set the value related to the column: ProcedureHeaders
	 * @param procedureHeaders the ProcedureHeaders value
	 */
	public void setProcedureHeaders (java.util.Set<jkt.hms.masters.business.ProcedureHeader> procedureHeaders) {
		this.procedureHeaders = procedureHeaders;
	}

	public void addToProcedureHeaders (jkt.hms.masters.business.ProcedureHeader procedureHeader) {
		if (null == getProcedureHeaders()) setProcedureHeaders(new java.util.TreeSet<jkt.hms.masters.business.ProcedureHeader>());
		getProcedureHeaders().add(procedureHeader);
	}



	/**
	 * Return the value associated with the column: PhysioRequisitionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> getPhysioRequisitionHeaders () {
		return physioRequisitionHeaders;
	}

	/**
	 * Set the value related to the column: PhysioRequisitionHeaders
	 * @param physioRequisitionHeaders the PhysioRequisitionHeaders value
	 */
	public void setPhysioRequisitionHeaders (java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> physioRequisitionHeaders) {
		this.physioRequisitionHeaders = physioRequisitionHeaders;
	}

	public void addToPhysioRequisitionHeaders (jkt.hms.masters.business.PhysioRequisitionHeader physioRequisitionHeader) {
		if (null == getPhysioRequisitionHeaders()) setPhysioRequisitionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PhysioRequisitionHeader>());
		getPhysioRequisitionHeaders().add(physioRequisitionHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Inpatient)) return false;
		else {
			jkt.hms.masters.business.Inpatient inpatient = (jkt.hms.masters.business.Inpatient) obj;
			if (null == this.getId() || null == inpatient.getId()) return false;
			else return (this.getId().equals(inpatient.getId()));
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