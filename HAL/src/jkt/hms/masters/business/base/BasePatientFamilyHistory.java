package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_FAMILY_HISTORY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_FAMILY_HISTORY"
 */

public abstract class BasePatientFamilyHistory  implements Serializable {

	public static String REF = "PatientFamilyHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_TREATMENT_NAME = "PatientTreatmentName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PATIENT_PRESENT_COMPLAINT_NAME = "PatientPresentComplaintName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PATIENT_HISTORY_NAME = "PatientHistoryName";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_HISTORY_CODE = "PatientHistoryCode";
	public static String PROP_TEMPLATE_CODE = "TemplateCode";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePatientFamilyHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientFamilyHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientHistoryCode;
	private java.lang.String patientHistoryName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String templateCode;
	private java.lang.String patientTreatmentName;
	private java.lang.String patientPresentComplaintName;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment departmentId;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientMedicalHistory> patientMedicalHistorys;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PATIENT_FAMILY_HISTORY_ID"
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
	 * Return the value associated with the column: PATIENT_FAMILY_HISTORY_CODE
	 */
	public java.lang.String getPatientHistoryCode () {
		return patientHistoryCode;
	}

	/**
	 * Set the value related to the column: PATIENT_FAMILY_HISTORY_CODE
	 * @param patientHistoryCode the PATIENT_FAMILY_HISTORY_CODE value
	 */
	public void setPatientHistoryCode (java.lang.String patientHistoryCode) {
		this.patientHistoryCode = patientHistoryCode;
	}



	/**
	 * Return the value associated with the column: PATIENT_FAMILY_HISTORY_NAME
	 */
	public java.lang.String getPatientHistoryName () {
		return patientHistoryName;
	}

	/**
	 * Set the value related to the column: PATIENT_FAMILY_HISTORY_NAME
	 * @param patientHistoryName the PATIENT_FAMILY_HISTORY_NAME value
	 */
	public void setPatientHistoryName (java.lang.String patientHistoryName) {
		this.patientHistoryName = patientHistoryName;
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
	 * Return the value associated with the column: template_code
	 */
	public java.lang.String getTemplateCode () {
		return templateCode;
	}

	/**
	 * Set the value related to the column: template_code
	 * @param templateCode the template_code value
	 */
	public void setTemplateCode (java.lang.String templateCode) {
		this.templateCode = templateCode;
	}



	/**
	 * Return the value associated with the column: patient_treatment_name
	 */
	public java.lang.String getPatientTreatmentName () {
		return patientTreatmentName;
	}

	/**
	 * Set the value related to the column: patient_treatment_name
	 * @param patientTreatmentName the patient_treatment_name value
	 */
	public void setPatientTreatmentName (java.lang.String patientTreatmentName) {
		this.patientTreatmentName = patientTreatmentName;
	}



	/**
	 * Return the value associated with the column: PATIENT_PRESENT_COMPLAINT_NAME
	 */
	public java.lang.String getPatientPresentComplaintName () {
		return patientPresentComplaintName;
	}

	/**
	 * Set the value related to the column: PATIENT_PRESENT_COMPLAINT_NAME
	 * @param patientPresentComplaintName the PATIENT_PRESENT_COMPLAINT_NAME value
	 */
	public void setPatientPresentComplaintName (java.lang.String patientPresentComplaintName) {
		this.patientPresentComplaintName = patientPresentComplaintName;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: PatientMedicalHistorys
	 */
	public java.util.Set<jkt.hms.masters.business.PatientMedicalHistory> getPatientMedicalHistorys () {
		return patientMedicalHistorys;
	}

	/**
	 * Set the value related to the column: PatientMedicalHistorys
	 * @param patientMedicalHistorys the PatientMedicalHistorys value
	 */
	public void setPatientMedicalHistorys (java.util.Set<jkt.hms.masters.business.PatientMedicalHistory> patientMedicalHistorys) {
		this.patientMedicalHistorys = patientMedicalHistorys;
	}

	public void addToPatientMedicalHistorys (jkt.hms.masters.business.PatientMedicalHistory patientMedicalHistory) {
		if (null == getPatientMedicalHistorys()) setPatientMedicalHistorys(new java.util.TreeSet<jkt.hms.masters.business.PatientMedicalHistory>());
		getPatientMedicalHistorys().add(patientMedicalHistory);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientFamilyHistory)) return false;
		else {
			jkt.hms.masters.business.PatientFamilyHistory patientFamilyHistory = (jkt.hms.masters.business.PatientFamilyHistory) obj;
			if (null == this.getId() || null == patientFamilyHistory.getId()) return false;
			else return (this.getId().equals(patientFamilyHistory.getId()));
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