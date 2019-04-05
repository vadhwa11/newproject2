package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_patient_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_patient_header"
 */

public abstract class BaseReferralPatientHeader  implements Serializable {

	public static String REF = "ReferralPatientHeader";
	public static String PROP_ADMIN_APPROVAL_TIME = "AdminApprovalTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NOTE_SHEET_DATE = "NoteSheetDate";
	public static String PROP_NOTE_SHEET_NO = "NoteSheetNo";
	public static String PROP_ADMIN_APPROVAL_DATE = "AdminApprovalDate";
	public static String PROP_DIVISION_NAME = "DivisionName";
	public static String PROP_EMPLOYEE_DEPENDENT = "EmployeeDependent";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_REFERRAL_NO = "ReferralNo";
	public static String PROP_FINANCE_APPROVAL_DATE = "FinanceApprovalDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_GM_APPROVAL_TIME = "GmApprovalTime";
	public static String PROP_GM_APPROVAL_DATE = "GmApprovalDate";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_HR_APPROVAL_DATE = "HrApprovalDate";
	public static String PROP_CONSOLIDATE_DATE = "ConsolidateDate";
	public static String PROP_GENDER = "Gender";
	public static String PROP_DISPATCH_NUMBER = "DispatchNumber";
	public static String PROP_ID = "Id";
	public static String PROP_GM_REMARKS = "GmRemarks";
	public static String PROP_ADMIN_BILL_AMT = "AdminBillAmt";
	public static String PROP_DEDUCTED = "Deducted";
	public static String PROP_FINANCE_APPROVAL_TIME = "FinanceApprovalTime";
	public static String PROP_AGE = "Age";
	public static String PROP_HR_APPROVAL_TIME = "HrApprovalTime";
	public static String PROP_COVERNOTE_DATE = "CovernoteDate";
	public static String PROP_COVERNOTE_NUMBER = "CovernoteNumber";
	public static String PROP_REFERRAL_DATE = "ReferralDate";
	public static String PROP_DISPATCH_DATE = "DispatchDate";
	public static String PROP_EXTENSION_STATUS = "ExtensionStatus";
	public static String PROP_EXCEL_STATUS = "ExcelStatus";
	public static String PROP_HR_REMARKS = "HrRemarks";
	public static String PROP_FROM_HOSPITAL = "FromHospital";
	public static String PROP_CONSOLIDATE_NUMBER = "ConsolidateNumber";
	public static String PROP_TOTAL_BILL_AMT = "TotalBillAmt";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DEDUCTION_FROM_SALARY = "DeductionFromSalary";
	public static String PROP_COMPLETE_BILL_DATE = "CompleteBillDate";
	public static String PROP_GENDER_NAME = "GenderName";
	public static String PROP_RELATION = "Relation";
	public static String PROP_TO_HOSPITAL = "ToHospital";
	public static String PROP_EMP_NO = "EmpNo";
	public static String PROP_NAME = "Name";
	public static String PROP_DIVISION = "Division";
	public static String PROP_APPROVAL_STATUS = "ApprovalStatus";
	public static String PROP_FINANCE_REMARKS = "FinanceRemarks";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseReferralPatientHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralPatientHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	public BaseReferralPatientHeader(BaseReferralPatientHeader baseReferralPatientHeader) {
		super();
		this.lastChgDate = baseReferralPatientHeader.lastChgDate;
		this.lastChgTime = baseReferralPatientHeader.lastChgTime;
		this.name = baseReferralPatientHeader.name;
		this.age = baseReferralPatientHeader.age;
		this.genderName = baseReferralPatientHeader.genderName;
		this.empNo = baseReferralPatientHeader.empNo;
		this.divisionName = baseReferralPatientHeader.divisionName;
		this.contactNo = baseReferralPatientHeader.contactNo;
		this.referralNo = baseReferralPatientHeader.referralNo;
		this.referralDate = baseReferralPatientHeader.referralDate;
		this.completeBillDate = baseReferralPatientHeader.completeBillDate;
		/*this.approvalStatus = baseReferralPatientHeader.approvalStatus;*/
		this.approvalStatus = "WHD";
		this.excelStatus = baseReferralPatientHeader.excelStatus;
		this.totalBillAmt = baseReferralPatientHeader.totalBillAmt;
		this.adminBillAmt = baseReferralPatientHeader.adminBillAmt;
	/*	this.covernoteNumber = baseReferralPatientHeader.covernoteNumber;*/
		this.covernoteDate = baseReferralPatientHeader.covernoteDate;
		this.consolidateNumber = baseReferralPatientHeader.consolidateNumber;
		this.consolidateDate = baseReferralPatientHeader.consolidateDate;
		this.hrRemarks = baseReferralPatientHeader.hrRemarks;
		this.financeRemarks = baseReferralPatientHeader.financeRemarks;
		this.gmRemarks = baseReferralPatientHeader.gmRemarks;
		this.extensionStatus = baseReferralPatientHeader.extensionStatus;
		this.adminApprovalDate = baseReferralPatientHeader.adminApprovalDate;
		this.adminApprovalTime = baseReferralPatientHeader.adminApprovalTime;
		this.hrApprovalDate = baseReferralPatientHeader.hrApprovalDate;
		this.hrApprovalTime = baseReferralPatientHeader.hrApprovalTime;
		this.financeApprovalDate = baseReferralPatientHeader.financeApprovalDate;
		this.financeApprovalTime = baseReferralPatientHeader.financeApprovalTime;
		this.gmApprovalDate = baseReferralPatientHeader.gmApprovalDate;
		this.gmApprovalTime = baseReferralPatientHeader.gmApprovalTime;
		this.relation = baseReferralPatientHeader.relation;
		this.lastChgBy = baseReferralPatientHeader.lastChgBy;
		this.gender = baseReferralPatientHeader.gender;
		this.hospital = baseReferralPatientHeader.hospital;
		this.employeeDependent = baseReferralPatientHeader.employeeDependent;
		this.fromHospital = baseReferralPatientHeader.fromHospital;
		this.hin = baseReferralPatientHeader.hin;
		this.toHospital = baseReferralPatientHeader.toHospital;
		this.opdPatientDetails = baseReferralPatientHeader.opdPatientDetails;
		this.division = baseReferralPatientHeader.division;
		this.doctor = baseReferralPatientHeader.doctor;
		/*this.uploadDocuments = baseReferralPatientHeader.uploadDocuments;*/
	}
	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String name;
	private java.lang.String age;
	private java.lang.String genderName;
	private java.lang.String empNo;
	private java.lang.String divisionName;
	private java.lang.String contactNo;
	private java.lang.String referralNo;
	private java.util.Date referralDate;
	private java.util.Date completeBillDate;
	private java.lang.String approvalStatus;
	private java.lang.String excelStatus;
	private java.math.BigDecimal totalBillAmt;
	private java.math.BigDecimal adminBillAmt;
	private java.lang.String covernoteNumber;
	private java.util.Date covernoteDate;
	private java.lang.String noteSheetNo;
	private java.util.Date noteSheetDate;
	private java.lang.String dispatchNumber;
	private java.util.Date dispatchDate;
	private java.lang.String consolidateNumber;
	private java.util.Date consolidateDate;
	private java.lang.String hrRemarks;
	private java.lang.String financeRemarks;
	private java.lang.String gmRemarks;
	private java.lang.String extensionStatus;
	private java.util.Date adminApprovalDate;
	private java.lang.String adminApprovalTime;
	private java.util.Date hrApprovalDate;
	private java.lang.String hrApprovalTime;
	private java.util.Date financeApprovalDate;
	private java.lang.String financeApprovalTime;
	private java.util.Date gmApprovalDate;
	private java.lang.String gmApprovalTime;
	private java.math.BigDecimal deductionFromSalary;
	private java.lang.String deducted;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployeeDependent employeeDependent;
	private jkt.hms.masters.business.MasHospital fromHospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasImpanneledHospital toHospital;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.MasDivision division;
	private jkt.hms.masters.business.MasEmployee doctor;

	// collections
	private java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments;
	private java.util.Set<jkt.hms.masters.business.ReferralPatientDetails> referralPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="referral_header_id"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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
	 * Return the value associated with the column: gender_name
	 */
	public java.lang.String getGenderName () {
		return genderName;
	}

	/**
	 * Set the value related to the column: gender_name
	 * @param genderName the gender_name value
	 */
	public void setGenderName (java.lang.String genderName) {
		this.genderName = genderName;
	}



	/**
	 * Return the value associated with the column: emp_no
	 */
	public java.lang.String getEmpNo () {
		return empNo;
	}

	/**
	 * Set the value related to the column: emp_no
	 * @param empNo the emp_no value
	 */
	public void setEmpNo (java.lang.String empNo) {
		this.empNo = empNo;
	}



	/**
	 * Return the value associated with the column: division_name
	 */
	public java.lang.String getDivisionName () {
		return divisionName;
	}

	/**
	 * Set the value related to the column: division_name
	 * @param divisionName the division_name value
	 */
	public void setDivisionName (java.lang.String divisionName) {
		this.divisionName = divisionName;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: referral_no
	 */
	public java.lang.String getReferralNo () {
		return referralNo;
	}

	/**
	 * Set the value related to the column: referral_no
	 * @param referralNo the referral_no value
	 */
	public void setReferralNo (java.lang.String referralNo) {
		this.referralNo = referralNo;
	}



	/**
	 * Return the value associated with the column: referral_date
	 */
	public java.util.Date getReferralDate () {
		return referralDate;
	}

	/**
	 * Set the value related to the column: referral_date
	 * @param referralDate the referral_date value
	 */
	public void setReferralDate (java.util.Date referralDate) {
		this.referralDate = referralDate;
	}



	/**
	 * Return the value associated with the column: complete_bill_date
	 */
	public java.util.Date getCompleteBillDate () {
		return completeBillDate;
	}

	/**
	 * Set the value related to the column: complete_bill_date
	 * @param completeBillDate the complete_bill_date value
	 */
	public void setCompleteBillDate (java.util.Date completeBillDate) {
		this.completeBillDate = completeBillDate;
	}



	/**
	 * Return the value associated with the column: approval_status
	 */
	public java.lang.String getApprovalStatus () {
		return approvalStatus;
	}

	/**
	 * Set the value related to the column: approval_status
	 * @param approvalStatus the approval_status value
	 */
	public void setApprovalStatus (java.lang.String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}



	/**
	 * Return the value associated with the column: excel_status
	 */
	public java.lang.String getExcelStatus () {
		return excelStatus;
	}

	/**
	 * Set the value related to the column: excel_status
	 * @param excelStatus the excel_status value
	 */
	public void setExcelStatus (java.lang.String excelStatus) {
		this.excelStatus = excelStatus;
	}



	/**
	 * Return the value associated with the column: total_bill_amt
	 */
	public java.math.BigDecimal getTotalBillAmt () {
		return totalBillAmt;
	}

	/**
	 * Set the value related to the column: total_bill_amt
	 * @param totalBillAmt the total_bill_amt value
	 */
	public void setTotalBillAmt (java.math.BigDecimal totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}



	/**
	 * Return the value associated with the column: admin_bill_amt
	 */
	public java.math.BigDecimal getAdminBillAmt () {
		return adminBillAmt;
	}

	/**
	 * Set the value related to the column: admin_bill_amt
	 * @param adminBillAmt the admin_bill_amt value
	 */
	public void setAdminBillAmt (java.math.BigDecimal adminBillAmt) {
		this.adminBillAmt = adminBillAmt;
	}



	/**
	 * Return the value associated with the column: covernote_number
	 */
	public java.lang.String getCovernoteNumber () {
		return covernoteNumber;
	}

	/**
	 * Set the value related to the column: covernote_number
	 * @param covernoteNumber the covernote_number value
	 */
	public void setCovernoteNumber (java.lang.String covernoteNumber) {
		this.covernoteNumber = covernoteNumber;
	}



	/**
	 * Return the value associated with the column: covernote_date
	 */
	public java.util.Date getCovernoteDate () {
		return covernoteDate;
	}

	/**
	 * Set the value related to the column: covernote_date
	 * @param covernoteDate the covernote_date value
	 */
	public void setCovernoteDate (java.util.Date covernoteDate) {
		this.covernoteDate = covernoteDate;
	}



	/**
	 * Return the value associated with the column: note_sheet_no
	 */
	public java.lang.String getNoteSheetNo () {
		return noteSheetNo;
	}

	/**
	 * Set the value related to the column: note_sheet_no
	 * @param noteSheetNo the note_sheet_no value
	 */
	public void setNoteSheetNo (java.lang.String noteSheetNo) {
		this.noteSheetNo = noteSheetNo;
	}



	/**
	 * Return the value associated with the column: note_sheet_date
	 */
	public java.util.Date getNoteSheetDate () {
		return noteSheetDate;
	}

	/**
	 * Set the value related to the column: note_sheet_date
	 * @param noteSheetDate the note_sheet_date value
	 */
	public void setNoteSheetDate (java.util.Date noteSheetDate) {
		this.noteSheetDate = noteSheetDate;
	}



	/**
	 * Return the value associated with the column: dispatch_number
	 */
	public java.lang.String getDispatchNumber () {
		return dispatchNumber;
	}

	/**
	 * Set the value related to the column: dispatch_number
	 * @param dispatchNumber the dispatch_number value
	 */
	public void setDispatchNumber (java.lang.String dispatchNumber) {
		this.dispatchNumber = dispatchNumber;
	}



	/**
	 * Return the value associated with the column: dispatch_date
	 */
	public java.util.Date getDispatchDate () {
		return dispatchDate;
	}

	/**
	 * Set the value related to the column: dispatch_date
	 * @param dispatchDate the dispatch_date value
	 */
	public void setDispatchDate (java.util.Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}



	/**
	 * Return the value associated with the column: consolidate_number
	 */
	public java.lang.String getConsolidateNumber () {
		return consolidateNumber;
	}

	/**
	 * Set the value related to the column: consolidate_number
	 * @param consolidateNumber the consolidate_number value
	 */
	public void setConsolidateNumber (java.lang.String consolidateNumber) {
		this.consolidateNumber = consolidateNumber;
	}



	/**
	 * Return the value associated with the column: consolidate_date
	 */
	public java.util.Date getConsolidateDate () {
		return consolidateDate;
	}

	/**
	 * Set the value related to the column: consolidate_date
	 * @param consolidateDate the consolidate_date value
	 */
	public void setConsolidateDate (java.util.Date consolidateDate) {
		this.consolidateDate = consolidateDate;
	}



	/**
	 * Return the value associated with the column: hr_remarks
	 */
	public java.lang.String getHrRemarks () {
		return hrRemarks;
	}

	/**
	 * Set the value related to the column: hr_remarks
	 * @param hrRemarks the hr_remarks value
	 */
	public void setHrRemarks (java.lang.String hrRemarks) {
		this.hrRemarks = hrRemarks;
	}



	/**
	 * Return the value associated with the column: finance_remarks
	 */
	public java.lang.String getFinanceRemarks () {
		return financeRemarks;
	}

	/**
	 * Set the value related to the column: finance_remarks
	 * @param financeRemarks the finance_remarks value
	 */
	public void setFinanceRemarks (java.lang.String financeRemarks) {
		this.financeRemarks = financeRemarks;
	}



	/**
	 * Return the value associated with the column: gm_remarks
	 */
	public java.lang.String getGmRemarks () {
		return gmRemarks;
	}

	/**
	 * Set the value related to the column: gm_remarks
	 * @param gmRemarks the gm_remarks value
	 */
	public void setGmRemarks (java.lang.String gmRemarks) {
		this.gmRemarks = gmRemarks;
	}



	/**
	 * Return the value associated with the column: extension_status
	 */
	public java.lang.String getExtensionStatus () {
		return extensionStatus;
	}

	/**
	 * Set the value related to the column: extension_status
	 * @param extensionStatus the extension_status value
	 */
	public void setExtensionStatus (java.lang.String extensionStatus) {
		this.extensionStatus = extensionStatus;
	}



	/**
	 * Return the value associated with the column: admin_approval_date
	 */
	public java.util.Date getAdminApprovalDate () {
		return adminApprovalDate;
	}

	/**
	 * Set the value related to the column: admin_approval_date
	 * @param adminApprovalDate the admin_approval_date value
	 */
	public void setAdminApprovalDate (java.util.Date adminApprovalDate) {
		this.adminApprovalDate = adminApprovalDate;
	}



	/**
	 * Return the value associated with the column: admin_approval_time
	 */
	public java.lang.String getAdminApprovalTime () {
		return adminApprovalTime;
	}

	/**
	 * Set the value related to the column: admin_approval_time
	 * @param adminApprovalTime the admin_approval_time value
	 */
	public void setAdminApprovalTime (java.lang.String adminApprovalTime) {
		this.adminApprovalTime = adminApprovalTime;
	}



	/**
	 * Return the value associated with the column: hr_approval_date
	 */
	public java.util.Date getHrApprovalDate () {
		return hrApprovalDate;
	}

	/**
	 * Set the value related to the column: hr_approval_date
	 * @param hrApprovalDate the hr_approval_date value
	 */
	public void setHrApprovalDate (java.util.Date hrApprovalDate) {
		this.hrApprovalDate = hrApprovalDate;
	}



	/**
	 * Return the value associated with the column: hr_approval_time
	 */
	public java.lang.String getHrApprovalTime () {
		return hrApprovalTime;
	}

	/**
	 * Set the value related to the column: hr_approval_time
	 * @param hrApprovalTime the hr_approval_time value
	 */
	public void setHrApprovalTime (java.lang.String hrApprovalTime) {
		this.hrApprovalTime = hrApprovalTime;
	}



	/**
	 * Return the value associated with the column: finance_approval_date
	 */
	public java.util.Date getFinanceApprovalDate () {
		return financeApprovalDate;
	}

	/**
	 * Set the value related to the column: finance_approval_date
	 * @param financeApprovalDate the finance_approval_date value
	 */
	public void setFinanceApprovalDate (java.util.Date financeApprovalDate) {
		this.financeApprovalDate = financeApprovalDate;
	}



	/**
	 * Return the value associated with the column: finance_approval_time
	 */
	public java.lang.String getFinanceApprovalTime () {
		return financeApprovalTime;
	}

	/**
	 * Set the value related to the column: finance_approval_time
	 * @param financeApprovalTime the finance_approval_time value
	 */
	public void setFinanceApprovalTime (java.lang.String financeApprovalTime) {
		this.financeApprovalTime = financeApprovalTime;
	}



	/**
	 * Return the value associated with the column: gm_approval_date
	 */
	public java.util.Date getGmApprovalDate () {
		return gmApprovalDate;
	}

	/**
	 * Set the value related to the column: gm_approval_date
	 * @param gmApprovalDate the gm_approval_date value
	 */
	public void setGmApprovalDate (java.util.Date gmApprovalDate) {
		this.gmApprovalDate = gmApprovalDate;
	}



	/**
	 * Return the value associated with the column: gm_approval_time
	 */
	public java.lang.String getGmApprovalTime () {
		return gmApprovalTime;
	}

	/**
	 * Set the value related to the column: gm_approval_time
	 * @param gmApprovalTime the gm_approval_time value
	 */
	public void setGmApprovalTime (java.lang.String gmApprovalTime) {
		this.gmApprovalTime = gmApprovalTime;
	}



	/**
	 * Return the value associated with the column: deduction_from_salary
	 */
	public java.math.BigDecimal getDeductionFromSalary () {
		return deductionFromSalary;
	}

	/**
	 * Set the value related to the column: deduction_from_salary
	 * @param deductionFromSalary the deduction_from_salary value
	 */
	public void setDeductionFromSalary (java.math.BigDecimal deductionFromSalary) {
		this.deductionFromSalary = deductionFromSalary;
	}



	/**
	 * Return the value associated with the column: deducted
	 */
	public java.lang.String getDeducted () {
		return deducted;
	}

	/**
	 * Set the value related to the column: deducted
	 * @param deducted the deducted value
	 */
	public void setDeducted (java.lang.String deducted) {
		this.deducted = deducted;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
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
	 * Return the value associated with the column: employee_dependent_id
	 */
	public jkt.hms.masters.business.MasEmployeeDependent getEmployeeDependent () {
		return employeeDependent;
	}

	/**
	 * Set the value related to the column: employee_dependent_id
	 * @param employeeDependent the employee_dependent_id value
	 */
	public void setEmployeeDependent (jkt.hms.masters.business.MasEmployeeDependent employeeDependent) {
		this.employeeDependent = employeeDependent;
	}



	/**
	 * Return the value associated with the column: from_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getFromHospital () {
		return fromHospital;
	}

	/**
	 * Set the value related to the column: from_hospital_id
	 * @param fromHospital the from_hospital_id value
	 */
	public void setFromHospital (jkt.hms.masters.business.MasHospital fromHospital) {
		this.fromHospital = fromHospital;
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
	 * Return the value associated with the column: to_hospital_id
	 */
	public jkt.hms.masters.business.MasImpanneledHospital getToHospital () {
		return toHospital;
	}

	/**
	 * Set the value related to the column: to_hospital_id
	 * @param toHospital the to_hospital_id value
	 */
	public void setToHospital (jkt.hms.masters.business.MasImpanneledHospital toHospital) {
		this.toHospital = toHospital;
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
	 * Return the value associated with the column: doctor
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor
	 * @param doctor the doctor value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
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
	 * Return the value associated with the column: ReferralPatientDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ReferralPatientDetails> getReferralPatientDetails () {
		return referralPatientDetails;
	}

	/**
	 * Set the value related to the column: ReferralPatientDetails
	 * @param referralPatientDetails the ReferralPatientDetails value
	 */
	public void setReferralPatientDetails (java.util.Set<jkt.hms.masters.business.ReferralPatientDetails> referralPatientDetails) {
		this.referralPatientDetails = referralPatientDetails;
	}

	public void addToReferralPatientDetails (jkt.hms.masters.business.ReferralPatientDetails referralPatientDetails) {
		if (null == getReferralPatientDetails()) setReferralPatientDetails(new java.util.TreeSet<jkt.hms.masters.business.ReferralPatientDetails>());
		getReferralPatientDetails().add(referralPatientDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralPatientHeader)) return false;
		else {
			jkt.hms.masters.business.ReferralPatientHeader referralPatientHeader = (jkt.hms.masters.business.ReferralPatientHeader) obj;
			if (null == this.getId() || null == referralPatientHeader.getId()) return false;
			else return (this.getId().equals(referralPatientHeader.getId()));
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