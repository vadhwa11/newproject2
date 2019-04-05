package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_op_patient_issue_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_op_patient_issue_m"
 */

public abstract class BaseStoreOpPatientIssueM  implements Serializable {

	public static String REF = "StoreOpPatientIssueM";
	public static String PROP_ISSUE_NO = "IssueNo";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_PRESCRIPTION_NO = "PrescriptionNo";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ISSUE_TO_DATE = "IssueToDate";
	public static String PROP_TYPE_OF_ISSUE = "TypeOfIssue";
	public static String PROP_IN_PATIENT = "InPatient";
	public static String PROP_ISSUE_TYPE = "IssueType";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMP = "Emp";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PATIENT_PRESCRIPTION_HEADER = "PatientPrescriptionHeader";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseStoreOpPatientIssueM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreOpPatientIssueM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String issueType;
	private java.lang.String issueNo;
	private java.util.Date issueDate;
	private java.lang.String status;
	private java.lang.String prescriptionNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String serviceNo;
	private java.util.Date issueToDate;
	private java.lang.String typeOfIssue;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Inpatient inPatient;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="op_issue_id"
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
	 * Return the value associated with the column: issue_type
	 */
	public java.lang.String getIssueType () {
		return issueType;
	}

	/**
	 * Set the value related to the column: issue_type
	 * @param issueType the issue_type value
	 */
	public void setIssueType (java.lang.String issueType) {
		this.issueType = issueType;
	}



	/**
	 * Return the value associated with the column: issue_no
	 */
	public java.lang.String getIssueNo () {
		return issueNo;
	}

	/**
	 * Set the value related to the column: issue_no
	 * @param issueNo the issue_no value
	 */
	public void setIssueNo (java.lang.String issueNo) {
		this.issueNo = issueNo;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
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
	 * Return the value associated with the column: prescription_no
	 */
	public java.lang.String getPrescriptionNo () {
		return prescriptionNo;
	}

	/**
	 * Set the value related to the column: prescription_no
	 * @param prescriptionNo the prescription_no value
	 */
	public void setPrescriptionNo (java.lang.String prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: issue_to_date
	 */
	public java.util.Date getIssueToDate () {
		return issueToDate;
	}

	/**
	 * Set the value related to the column: issue_to_date
	 * @param issueToDate the issue_to_date value
	 */
	public void setIssueToDate (java.util.Date issueToDate) {
		this.issueToDate = issueToDate;
	}



	/**
	 * Return the value associated with the column: type_of_issue
	 */
	public java.lang.String getTypeOfIssue () {
		return typeOfIssue;
	}

	/**
	 * Set the value related to the column: type_of_issue
	 * @param typeOfIssue the type_of_issue value
	 */
	public void setTypeOfIssue (java.lang.String typeOfIssue) {
		this.typeOfIssue = typeOfIssue;
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
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
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
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionHeader getPatientPrescriptionHeader () {
		return patientPrescriptionHeader;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param patientPrescriptionHeader the prescription_id value
	 */
	public void setPatientPrescriptionHeader (jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader) {
		this.patientPrescriptionHeader = patientPrescriptionHeader;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInPatient () {
		return inPatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inPatient the inpatient_id value
	 */
	public void setInPatient (jkt.hms.masters.business.Inpatient inPatient) {
		this.inPatient = inPatient;
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTs () {
		return storeOpPatientIssueTs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTs
	 * @param storeOpPatientIssueTs the StoreOpPatientIssueTs value
	 */
	public void setStoreOpPatientIssueTs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTs) {
		this.storeOpPatientIssueTs = storeOpPatientIssueTs;
	}

	public void addToStoreOpPatientIssueTs (jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTs()) setStoreOpPatientIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTs().add(storeOpPatientIssueT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreOpPatientIssueM)) return false;
		else {
			jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM = (jkt.hms.masters.business.StoreOpPatientIssueM) obj;
			if (null == this.getId() || null == storeOpPatientIssueM.getId()) return false;
			else return (this.getId().equals(storeOpPatientIssueM.getId()));
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