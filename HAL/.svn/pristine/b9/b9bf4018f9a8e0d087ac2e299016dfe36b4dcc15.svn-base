package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_prescription_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_prescription_header"
 */

public abstract class BasePatientPrescriptionHeader  implements Serializable, Comparable {

	public static String REF = "PatientPrescriptionHeader";
	public static String PROP_ISSUED_TIME = "IssuedTime";
	public static String PROP_INJECTION_STATUS = "InjectionStatus";
	public static String PROP_NIP_APPROVED_BY = "NipApprovedBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ISSUED_DATE = "IssuedDate";
	public static String PROP_FAC_STATUS = "FacStatus";
	public static String PROP_EMP = "Emp";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_ISSUED_BY = "IssuedBy";
	public static String PROP_OT_SURGERY = "OtSurgery";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_PRESCRIPTION_TIME = "PrescriptionTime";
	public static String PROP_PRESCRIPTION_NO = "PrescriptionNo";
	public static String PROP_NIP_PRINT_COUNT = "NipPrintCount";
	public static String PROP_ZONAL = "Zonal";
	public static String PROP_PRESCRIPTION_DATE = "PrescriptionDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SPECIALTY = "Specialty";
	public static String PROP_OTHER_TREATMENT = "OtherTreatment";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRES_PRINT_COUNT = "PresPrintCount";
	public static String PROP_DISPENSARY_ISSUE_NO = "DispensaryIssueNo";
	public static String PROP_RC_STATUS = "RcStatus";
	public static String PROP_DIVISION = "Division";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_NIS_PRINT_COUNT = "NisPrintCount";
	public static String PROP_NIP_STATUS = "NipStatus";


	// constructors
	public BasePatientPrescriptionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientPrescriptionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dispensaryIssueNo;
	private java.lang.String facStatus;
	private java.lang.String injectionStatus;
	private java.util.Date issuedDate;
	private java.lang.String issuedTime;
	private java.lang.Integer nipPrintCount;
	private java.lang.String nipStatus;
	private java.lang.Integer nisPrintCount;
	private java.lang.String otherTreatment;
	private java.lang.Integer presPrintCount;
	private java.util.Date prescriptionDate;
	private java.lang.Integer prescriptionNo;
	private java.lang.String prescriptionTime;
	private java.lang.String rcStatus;
	private java.lang.String remarks;
	private java.lang.String specialty;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDivision division;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users issuedBy;
	private jkt.hms.masters.business.Users nipApprovedBy;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.OpdSurgeryHeader otSurgery;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasZonal zonal;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="prescription_id"
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
	 * Return the value associated with the column: dispensary_issue_no
	 */
	public java.lang.String getDispensaryIssueNo () {
		return dispensaryIssueNo;
	}

	/**
	 * Set the value related to the column: dispensary_issue_no
	 * @param dispensaryIssueNo the dispensary_issue_no value
	 */
	public void setDispensaryIssueNo (java.lang.String dispensaryIssueNo) {
		this.dispensaryIssueNo = dispensaryIssueNo;
	}



	/**
	 * Return the value associated with the column: fac_status
	 */
	public java.lang.String getFacStatus () {
		return facStatus;
	}

	/**
	 * Set the value related to the column: fac_status
	 * @param facStatus the fac_status value
	 */
	public void setFacStatus (java.lang.String facStatus) {
		this.facStatus = facStatus;
	}



	/**
	 * Return the value associated with the column: injection_status
	 */
	public java.lang.String getInjectionStatus () {
		return injectionStatus;
	}

	/**
	 * Set the value related to the column: injection_status
	 * @param injectionStatus the injection_status value
	 */
	public void setInjectionStatus (java.lang.String injectionStatus) {
		this.injectionStatus = injectionStatus;
	}



	/**
	 * Return the value associated with the column: issued_date
	 */
	public java.util.Date getIssuedDate () {
		return issuedDate;
	}

	/**
	 * Set the value related to the column: issued_date
	 * @param issuedDate the issued_date value
	 */
	public void setIssuedDate (java.util.Date issuedDate) {
		this.issuedDate = issuedDate;
	}



	/**
	 * Return the value associated with the column: issued_time
	 */
	public java.lang.String getIssuedTime () {
		return issuedTime;
	}

	/**
	 * Set the value related to the column: issued_time
	 * @param issuedTime the issued_time value
	 */
	public void setIssuedTime (java.lang.String issuedTime) {
		this.issuedTime = issuedTime;
	}



	/**
	 * Return the value associated with the column: nip_print_count
	 */
	public java.lang.Integer getNipPrintCount () {
		return nipPrintCount;
	}

	/**
	 * Set the value related to the column: nip_print_count
	 * @param nipPrintCount the nip_print_count value
	 */
	public void setNipPrintCount (java.lang.Integer nipPrintCount) {
		this.nipPrintCount = nipPrintCount;
	}



	/**
	 * Return the value associated with the column: nip_status
	 */
	public java.lang.String getNipStatus () {
		return nipStatus;
	}

	/**
	 * Set the value related to the column: nip_status
	 * @param nipStatus the nip_status value
	 */
	public void setNipStatus (java.lang.String nipStatus) {
		this.nipStatus = nipStatus;
	}



	/**
	 * Return the value associated with the column: nis_print_count
	 */
	public java.lang.Integer getNisPrintCount () {
		return nisPrintCount;
	}

	/**
	 * Set the value related to the column: nis_print_count
	 * @param nisPrintCount the nis_print_count value
	 */
	public void setNisPrintCount (java.lang.Integer nisPrintCount) {
		this.nisPrintCount = nisPrintCount;
	}



	/**
	 * Return the value associated with the column: OTHER_TREATMENT
	 */
	public java.lang.String getOtherTreatment () {
		return otherTreatment;
	}

	/**
	 * Set the value related to the column: OTHER_TREATMENT
	 * @param otherTreatment the OTHER_TREATMENT value
	 */
	public void setOtherTreatment (java.lang.String otherTreatment) {
		this.otherTreatment = otherTreatment;
	}



	/**
	 * Return the value associated with the column: pres_print_count
	 */
	public java.lang.Integer getPresPrintCount () {
		return presPrintCount;
	}

	/**
	 * Set the value related to the column: pres_print_count
	 * @param presPrintCount the pres_print_count value
	 */
	public void setPresPrintCount (java.lang.Integer presPrintCount) {
		this.presPrintCount = presPrintCount;
	}



	/**
	 * Return the value associated with the column: prescription_date
	 */
	public java.util.Date getPrescriptionDate () {
		return prescriptionDate;
	}

	/**
	 * Set the value related to the column: prescription_date
	 * @param prescriptionDate the prescription_date value
	 */
	public void setPrescriptionDate (java.util.Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}



	/**
	 * Return the value associated with the column: prescription_no
	 */
	public java.lang.Integer getPrescriptionNo () {
		return prescriptionNo;
	}

	/**
	 * Set the value related to the column: prescription_no
	 * @param prescriptionNo the prescription_no value
	 */
	public void setPrescriptionNo (java.lang.Integer prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}



	/**
	 * Return the value associated with the column: prescription_time
	 */
	public java.lang.String getPrescriptionTime () {
		return prescriptionTime;
	}

	/**
	 * Set the value related to the column: prescription_time
	 * @param prescriptionTime the prescription_time value
	 */
	public void setPrescriptionTime (java.lang.String prescriptionTime) {
		this.prescriptionTime = prescriptionTime;
	}



	/**
	 * Return the value associated with the column: rc_status
	 */
	public java.lang.String getRcStatus () {
		return rcStatus;
	}

	/**
	 * Set the value related to the column: rc_status
	 * @param rcStatus the rc_status value
	 */
	public void setRcStatus (java.lang.String rcStatus) {
		this.rcStatus = rcStatus;
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
	 * Return the value associated with the column: SPECIALTY
	 */
	public java.lang.String getSpecialty () {
		return specialty;
	}

	/**
	 * Set the value related to the column: SPECIALTY
	 * @param specialty the SPECIALTY value
	 */
	public void setSpecialty (java.lang.String specialty) {
		this.specialty = specialty;
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
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.Users getIssuedBy () {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * @param issuedBy the issued_by value
	 */
	public void setIssuedBy (jkt.hms.masters.business.Users issuedBy) {
		this.issuedBy = issuedBy;
	}



	/**
	 * Return the value associated with the column: nip_approved_by
	 */
	public jkt.hms.masters.business.Users getNipApprovedBy () {
		return nipApprovedBy;
	}

	/**
	 * Set the value related to the column: nip_approved_by
	 * @param nipApprovedBy the nip_approved_by value
	 */
	public void setNipApprovedBy (jkt.hms.masters.business.Users nipApprovedBy) {
		this.nipApprovedBy = nipApprovedBy;
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
	 * Return the value associated with the column: ot_surgery_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOtSurgery () {
		return otSurgery;
	}

	/**
	 * Set the value related to the column: ot_surgery_id
	 * @param otSurgery the ot_surgery_id value
	 */
	public void setOtSurgery (jkt.hms.masters.business.OpdSurgeryHeader otSurgery) {
		this.otSurgery = otSurgery;
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
	 * Return the value associated with the column: zonal_id
	 */
	public jkt.hms.masters.business.MasZonal getZonal () {
		return zonal;
	}

	/**
	 * Set the value related to the column: zonal_id
	 * @param zonal the zonal_id value
	 */
	public void setZonal (jkt.hms.masters.business.MasZonal zonal) {
		this.zonal = zonal;
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientPrescriptionHeader)) return false;
		else {
			jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader = (jkt.hms.masters.business.PatientPrescriptionHeader) obj;
			if (null == this.getId() || null == patientPrescriptionHeader.getId()) return false;
			else return (this.getId().equals(patientPrescriptionHeader.getId()));
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
	
	public int compareTo(jkt.hms.masters.business.PatientPrescriptionHeader hd){  
		if(this.getHin().getId()==hd.getHin().getId())  
		return 0;  
		else if(this.getHin().getId()>hd.getHin().getId())  
		return 1;  
		else  
		return -1;  
		}  

	public String toString () {
		return super.toString();
	}


}