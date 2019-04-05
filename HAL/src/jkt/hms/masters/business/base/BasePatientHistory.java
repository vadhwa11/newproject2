package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the patient_history table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="patient_history"
 */

public abstract class BasePatientHistory implements Serializable {

	public static String REF = "PatientHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_PERSONAL_PRESENT_HISTORY = "PersonalPresentHistory";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PERSONAL_PRESENT_MEDICATION = "PersonalPresentMedication";
	public static String PROP_PERSONAL_OTHER_DETAILS = "PersonalOtherDetails";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_FAMILY_PRESENT_HISTORY = "FamilyPresentHistory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_PERSONAL_PAST_HISTORY = "PersonalPastHistory";
	public static String PROP_FAMILY_PAST_HISTORY = "FamilyPastHistory";
	public static String PROP_FAMILY_PRESENT_MEDICATION = "FamilyPresentMedication";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_FAMILY_OTHER_DETAILS = "FamilyOtherDetails";

	// constructors
	public BasePatientHistory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientHistory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitId;
	private java.lang.Integer hinId;
	private java.lang.Integer departmentId;
	private java.lang.Integer hospitalId;
	private java.lang.String personalPresentHistory;
	private java.lang.String familyPresentHistory;
	private java.lang.String personalPastHistory;
	private java.lang.String familyPastHistory;
	private java.lang.String personalPresentMedication;
	private java.lang.String familyPresentMedication;
	private java.lang.String personalOtherDetails;
	private java.lang.String familyOtherDetails;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="patient_history_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: visit_id
	 */
	public java.lang.Integer getVisitId() {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visitId
	 *            the visit_id value
	 */
	public void setVisitId(java.lang.Integer visitId) {
		this.visitId = visitId;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public java.lang.Integer getHinId() {
		return hinId;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hinId
	 *            the hin_id value
	 */
	public void setHinId(java.lang.Integer hinId) {
		this.hinId = hinId;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param departmentId
	 *            the department_id value
	 */
	public void setDepartmentId(java.lang.Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: personal_present_history
	 */
	public java.lang.String getPersonalPresentHistory() {
		return personalPresentHistory;
	}

	/**
	 * Set the value related to the column: personal_present_history
	 * 
	 * @param personalPresentHistory
	 *            the personal_present_history value
	 */
	public void setPersonalPresentHistory(
			java.lang.String personalPresentHistory) {
		this.personalPresentHistory = personalPresentHistory;
	}

	/**
	 * Return the value associated with the column: family_present_history
	 */
	public java.lang.String getFamilyPresentHistory() {
		return familyPresentHistory;
	}

	/**
	 * Set the value related to the column: family_present_history
	 * 
	 * @param familyPresentHistory
	 *            the family_present_history value
	 */
	public void setFamilyPresentHistory(java.lang.String familyPresentHistory) {
		this.familyPresentHistory = familyPresentHistory;
	}

	/**
	 * Return the value associated with the column: personal_past_history
	 */
	public java.lang.String getPersonalPastHistory() {
		return personalPastHistory;
	}

	/**
	 * Set the value related to the column: personal_past_history
	 * 
	 * @param personalPastHistory
	 *            the personal_past_history value
	 */
	public void setPersonalPastHistory(java.lang.String personalPastHistory) {
		this.personalPastHistory = personalPastHistory;
	}

	/**
	 * Return the value associated with the column: family_past_history
	 */
	public java.lang.String getFamilyPastHistory() {
		return familyPastHistory;
	}

	/**
	 * Set the value related to the column: family_past_history
	 * 
	 * @param familyPastHistory
	 *            the family_past_history value
	 */
	public void setFamilyPastHistory(java.lang.String familyPastHistory) {
		this.familyPastHistory = familyPastHistory;
	}

	/**
	 * Return the value associated with the column: personal_present_medication
	 */
	public java.lang.String getPersonalPresentMedication() {
		return personalPresentMedication;
	}

	/**
	 * Set the value related to the column: personal_present_medication
	 * 
	 * @param personalPresentMedication
	 *            the personal_present_medication value
	 */
	public void setPersonalPresentMedication(
			java.lang.String personalPresentMedication) {
		this.personalPresentMedication = personalPresentMedication;
	}

	/**
	 * Return the value associated with the column: family_present_medication
	 */
	public java.lang.String getFamilyPresentMedication() {
		return familyPresentMedication;
	}

	/**
	 * Set the value related to the column: family_present_medication
	 * 
	 * @param familyPresentMedication
	 *            the family_present_medication value
	 */
	public void setFamilyPresentMedication(
			java.lang.String familyPresentMedication) {
		this.familyPresentMedication = familyPresentMedication;
	}

	/**
	 * Return the value associated with the column: personal_other_details
	 */
	public java.lang.String getPersonalOtherDetails() {
		return personalOtherDetails;
	}

	/**
	 * Set the value related to the column: personal_other_details
	 * 
	 * @param personalOtherDetails
	 *            the personal_other_details value
	 */
	public void setPersonalOtherDetails(java.lang.String personalOtherDetails) {
		this.personalOtherDetails = personalOtherDetails;
	}

	/**
	 * Return the value associated with the column: family_other_details
	 */
	public java.lang.String getFamilyOtherDetails() {
		return familyOtherDetails;
	}

	/**
	 * Set the value related to the column: family_other_details
	 * 
	 * @param familyOtherDetails
	 *            the family_other_details value
	 */
	public void setFamilyOtherDetails(java.lang.String familyOtherDetails) {
		this.familyOtherDetails = familyOtherDetails;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientHistory))
			return false;
		else {
			jkt.hms.masters.business.PatientHistory patientHistory = (jkt.hms.masters.business.PatientHistory) obj;
			if (null == this.getId() || null == patientHistory.getId())
				return false;
			else
				return (this.getId().equals(patientHistory.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}