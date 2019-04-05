package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_history"
 */

public abstract class BaseOpdPatientHistory  implements Serializable {

	public static String REF = "OpdPatientHistory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VISIT_INPATIENT_ID = "VisitInpatientId";
	public static String PROP_PAST_MEDICAL_HISTORY = "PastMedicalHistory";
	public static String PROP_PERSONAL_OTHER_DETAILS = "PersonalOtherDetails";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_FAMILY_PRESENT_HISTORY = "FamilyPresentHistory";
	public static String PROP_RISK_FACTOR = "RiskFactor";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_PRESENT_ADVICE = "PresentAdvice";
	public static String PROP_FAMILY_PRESENT_MEDICATION = "FamilyPresentMedication";
	public static String PROP_PERSONAL_PRESENT_MEDICATION = "PersonalPresentMedication";
	public static String PROP_FAMILY_PAST_HISTORY = "FamilyPastHistory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_IP_OP_PAC_STATUS = "IpOpPacStatus";
	public static String PROP_PRESENT_ILLNESS = "PresentIllness";
	public static String PROP_PERSONAL_PAST_HISTORY = "PersonalPastHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRESENT_COMPLAIN = "PresentComplain";
	public static String PROP_PERSONAL_PRESENT_HISTORY = "PersonalPresentHistory";
	public static String PROP_ID = "Id";
	public static String PROP_FAMILY_OTHER_DETAILS = "FamilyOtherDetails";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdPatientHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitInpatientId;
	private java.lang.String personalPresentHistory;
	private java.lang.String familyPresentHistory;
	private java.lang.String personalPastHistory;
	private java.lang.String familyPastHistory;
	private java.lang.String personalPresentMedication;
	private java.lang.String familyPresentMedication;
	private java.lang.String personalOtherDetails;
	private java.lang.String familyOtherDetails;
	private java.lang.String presentIllness;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String ipOpPacStatus;
	private java.lang.String presentComplain;
	private java.lang.String presentAdvice;
	private java.lang.String pastMedicalHistory;
	private java.lang.String riskFactor;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_patient_history_id"
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
	 * Return the value associated with the column: visit_inpatient_id
	 */
	public java.lang.Integer getVisitInpatientId () {
		return visitInpatientId;
	}

	/**
	 * Set the value related to the column: visit_inpatient_id
	 * @param visitInpatientId the visit_inpatient_id value
	 */
	public void setVisitInpatientId (java.lang.Integer visitInpatientId) {
		this.visitInpatientId = visitInpatientId;
	}



	/**
	 * Return the value associated with the column: personal_present_history
	 */
	public java.lang.String getPersonalPresentHistory () {
		return personalPresentHistory;
	}

	/**
	 * Set the value related to the column: personal_present_history
	 * @param personalPresentHistory the personal_present_history value
	 */
	public void setPersonalPresentHistory (java.lang.String personalPresentHistory) {
		this.personalPresentHistory = personalPresentHistory;
	}



	/**
	 * Return the value associated with the column: family_present_history
	 */
	public java.lang.String getFamilyPresentHistory () {
		return familyPresentHistory;
	}

	/**
	 * Set the value related to the column: family_present_history
	 * @param familyPresentHistory the family_present_history value
	 */
	public void setFamilyPresentHistory (java.lang.String familyPresentHistory) {
		this.familyPresentHistory = familyPresentHistory;
	}



	/**
	 * Return the value associated with the column: personal_past_history
	 */
	public java.lang.String getPersonalPastHistory () {
		return personalPastHistory;
	}

	/**
	 * Set the value related to the column: personal_past_history
	 * @param personalPastHistory the personal_past_history value
	 */
	public void setPersonalPastHistory (java.lang.String personalPastHistory) {
		this.personalPastHistory = personalPastHistory;
	}



	/**
	 * Return the value associated with the column: family_past_history
	 */
	public java.lang.String getFamilyPastHistory () {
		return familyPastHistory;
	}

	/**
	 * Set the value related to the column: family_past_history
	 * @param familyPastHistory the family_past_history value
	 */
	public void setFamilyPastHistory (java.lang.String familyPastHistory) {
		this.familyPastHistory = familyPastHistory;
	}



	/**
	 * Return the value associated with the column: personal_present_medication
	 */
	public java.lang.String getPersonalPresentMedication () {
		return personalPresentMedication;
	}

	/**
	 * Set the value related to the column: personal_present_medication
	 * @param personalPresentMedication the personal_present_medication value
	 */
	public void setPersonalPresentMedication (java.lang.String personalPresentMedication) {
		this.personalPresentMedication = personalPresentMedication;
	}



	/**
	 * Return the value associated with the column: family_present_medication
	 */
	public java.lang.String getFamilyPresentMedication () {
		return familyPresentMedication;
	}

	/**
	 * Set the value related to the column: family_present_medication
	 * @param familyPresentMedication the family_present_medication value
	 */
	public void setFamilyPresentMedication (java.lang.String familyPresentMedication) {
		this.familyPresentMedication = familyPresentMedication;
	}



	/**
	 * Return the value associated with the column: personal_other_details
	 */
	public java.lang.String getPersonalOtherDetails () {
		return personalOtherDetails;
	}

	/**
	 * Set the value related to the column: personal_other_details
	 * @param personalOtherDetails the personal_other_details value
	 */
	public void setPersonalOtherDetails (java.lang.String personalOtherDetails) {
		this.personalOtherDetails = personalOtherDetails;
	}



	/**
	 * Return the value associated with the column: family_other_details
	 */
	public java.lang.String getFamilyOtherDetails () {
		return familyOtherDetails;
	}

	/**
	 * Set the value related to the column: family_other_details
	 * @param familyOtherDetails the family_other_details value
	 */
	public void setFamilyOtherDetails (java.lang.String familyOtherDetails) {
		this.familyOtherDetails = familyOtherDetails;
	}



	/**
	 * Return the value associated with the column: present_illness
	 */
	public java.lang.String getPresentIllness () {
		return presentIllness;
	}

	/**
	 * Set the value related to the column: present_illness
	 * @param presentIllness the present_illness value
	 */
	public void setPresentIllness (java.lang.String presentIllness) {
		this.presentIllness = presentIllness;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: ip_op_pac_status
	 */
	public java.lang.String getIpOpPacStatus () {
		return ipOpPacStatus;
	}

	/**
	 * Set the value related to the column: ip_op_pac_status
	 * @param ipOpPacStatus the ip_op_pac_status value
	 */
	public void setIpOpPacStatus (java.lang.String ipOpPacStatus) {
		this.ipOpPacStatus = ipOpPacStatus;
	}



	/**
	 * Return the value associated with the column: present_complain
	 */
	public java.lang.String getPresentComplain () {
		return presentComplain;
	}

	/**
	 * Set the value related to the column: present_complain
	 * @param presentComplain the present_complain value
	 */
	public void setPresentComplain (java.lang.String presentComplain) {
		this.presentComplain = presentComplain;
	}



	/**
	 * Return the value associated with the column: present_advice
	 */
	public java.lang.String getPresentAdvice () {
		return presentAdvice;
	}

	/**
	 * Set the value related to the column: present_advice
	 * @param presentAdvice the present_advice value
	 */
	public void setPresentAdvice (java.lang.String presentAdvice) {
		this.presentAdvice = presentAdvice;
	}



	/**
	 * Return the value associated with the column: pastMedicalHistory
	 */
	public java.lang.String getPastMedicalHistory () {
		return pastMedicalHistory;
	}

	/**
	 * Set the value related to the column: pastMedicalHistory
	 * @param pastMedicalHistory the pastMedicalHistory value
	 */
	public void setPastMedicalHistory (java.lang.String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}



	/**
	 * Return the value associated with the column: riskFactor
	 */
	public java.lang.String getRiskFactor () {
		return riskFactor;
	}

	/**
	 * Set the value related to the column: riskFactor
	 * @param riskFactor the riskFactor value
	 */
	public void setRiskFactor (java.lang.String riskFactor) {
		this.riskFactor = riskFactor;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientHistory)) return false;
		else {
			jkt.hms.masters.business.OpdPatientHistory opdPatientHistory = (jkt.hms.masters.business.OpdPatientHistory) obj;
			if (null == this.getId() || null == opdPatientHistory.getId()) return false;
			else return (this.getId().equals(opdPatientHistory.getId()));
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