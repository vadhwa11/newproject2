package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the upload_documents table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="upload_documents"
 */

public abstract class BaseUploadDocuments  implements Serializable {

	public static String REF = "UploadDocuments";
	public static String PROP_OT_UPLOAD_TYPE = "OtUploadType";
	public static String PROP_UPLOAD_DATE = "UploadDate";
	public static String PROP_AGE = "Age";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_DIAG_NO = "DiagNo";
	public static String PROP_FILE_EXTENSION = "FileExtension";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PATIENT_DOCUMENT = "PatientDocument";
	public static String PROP_VISIT = "Visit";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_MAS_MEDICAL_EXAM_REPORT = "MasMedicalExamReport";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_EMPLOYEE_DEPENDENT = "EmployeeDependent";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FWC_FLAG = "FwcFlag";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_RESULT_ENTRY = "ResultEntry";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_REFERRAL_HEADER = "ReferralHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseUploadDocuments () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUploadDocuments (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientName;
	private java.lang.String age;
	private java.lang.String sex;
	private java.lang.String address;
	private byte[] patientDocument;
	private java.lang.String fileName;
	private java.lang.String fileExtension;
	private java.lang.String description;
	private java.util.Date uploadDate;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String fwcFlag;
	private java.lang.String diagNo;
	private java.lang.String otUploadType;

	// many to one
	private jkt.hms.masters.business.ReferralPatientHeader referralHeader;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport;
	private jkt.hms.masters.business.DgResultEntryHeader resultEntry;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.OtBooking otBooking;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployeeDependent employeeDependent;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
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
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: patient_document
	 */
	public byte[] getPatientDocument () {
		return patientDocument;
	}

	/**
	 * Set the value related to the column: patient_document
	 * @param patientDocument the patient_document value
	 */
	public void setPatientDocument (byte[] patientDocument) {
		this.patientDocument = patientDocument;
	}



	/**
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: file_extension
	 */
	public java.lang.String getFileExtension () {
		return fileExtension;
	}

	/**
	 * Set the value related to the column: file_extension
	 * @param fileExtension the file_extension value
	 */
	public void setFileExtension (java.lang.String fileExtension) {
		this.fileExtension = fileExtension;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: upload_date
	 */
	public java.util.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: upload_date
	 * @param uploadDate the upload_date value
	 */
	public void setUploadDate (java.util.Date uploadDate) {
		this.uploadDate = uploadDate;
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
	 * Return the value associated with the column: FWC_FLAG
	 */
	public java.lang.String getFwcFlag () {
		return fwcFlag;
	}

	/**
	 * Set the value related to the column: FWC_FLAG
	 * @param fwcFlag the FWC_FLAG value
	 */
	public void setFwcFlag (java.lang.String fwcFlag) {
		this.fwcFlag = fwcFlag;
	}



	/**
	 * Return the value associated with the column: diag_no
	 */
	public java.lang.String getDiagNo () {
		return diagNo;
	}

	/**
	 * Set the value related to the column: diag_no
	 * @param diagNo the diag_no value
	 */
	public void setDiagNo (java.lang.String diagNo) {
		this.diagNo = diagNo;
	}



	/**
	 * Return the value associated with the column: ot_upload_type
	 */
	public java.lang.String getOtUploadType () {
		return otUploadType;
	}

	/**
	 * Set the value related to the column: ot_upload_type
	 * @param otUploadType the ot_upload_type value
	 */
	public void setOtUploadType (java.lang.String otUploadType) {
		this.otUploadType = otUploadType;
	}



	/**
	 * Return the value associated with the column: referral_header_id
	 */
	public jkt.hms.masters.business.ReferralPatientHeader getReferralHeader () {
		return referralHeader;
	}

	/**
	 * Set the value related to the column: referral_header_id
	 * @param referralHeader the referral_header_id value
	 */
	public void setReferralHeader (jkt.hms.masters.business.ReferralPatientHeader referralHeader) {
		this.referralHeader = referralHeader;
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
	 * Return the value associated with the column: mas_medical_exam_id
	 */
	public jkt.hms.masters.business.MasMedicalExaminationReportOnEntry getMasMedicalExamReport () {
		return masMedicalExamReport;
	}

	/**
	 * Set the value related to the column: mas_medical_exam_id
	 * @param masMedicalExamReport the mas_medical_exam_id value
	 */
	public void setMasMedicalExamReport (jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport) {
		this.masMedicalExamReport = masMedicalExamReport;
	}



	/**
	 * Return the value associated with the column: result_entry_id
	 */
	public jkt.hms.masters.business.DgResultEntryHeader getResultEntry () {
		return resultEntry;
	}

	/**
	 * Set the value related to the column: result_entry_id
	 * @param resultEntry the result_entry_id value
	 */
	public void setResultEntry (jkt.hms.masters.business.DgResultEntryHeader resultEntry) {
		this.resultEntry = resultEntry;
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
	 * Return the value associated with the column: ot_booking
	 */
	public jkt.hms.masters.business.OtBooking getOtBooking () {
		return otBooking;
	}

	/**
	 * Set the value related to the column: ot_booking
	 * @param otBooking the ot_booking value
	 */
	public void setOtBooking (jkt.hms.masters.business.OtBooking otBooking) {
		this.otBooking = otBooking;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UploadDocuments)) return false;
		else {
			jkt.hms.masters.business.UploadDocuments uploadDocuments = (jkt.hms.masters.business.UploadDocuments) obj;
			if (null == this.getId() || null == uploadDocuments.getId()) return false;
			else return (this.getId().equals(uploadDocuments.getId()));
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