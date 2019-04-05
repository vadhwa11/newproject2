package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MONITORING_OF_ADS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONITORING_OF_ADS"
 */

public abstract class BaseMonitoringOfAds  implements Serializable {

	public static String REF = "MonitoringOfAds";
	public static String PROP_LAST_MED_BOARD_DATE = "LastMedBoardDate";
	public static String PROP_COUNSELLING_DATE = "CounsellingDate";
	public static String PROP_WARNING_LETTER = "WarningLetter";
	public static String PROP_DATE_OF_POSTING = "DateOfPosting";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_MEDICAL_CATEGORY_ID = "MedicalCategoryId";
	public static String PROP_RETENTION_IN_SERVICE = "RetentionInService";
	public static String PROP_DATE_OF_DIAGNOSIS = "DateOfDiagnosis";
	public static String PROP_FRESH = "Fresh";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HIN_ID = "HinId";


	// constructors
	public BaseMonitoringOfAds () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonitoringOfAds (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfDiagnosis;
	private java.util.Date lastMedBoardDate;
	private java.util.Date counsellingDate;
	private java.lang.String warningLetter;
	private java.lang.String retentionInService;
	private java.util.Date dateOfPosting;
	private java.lang.String fresh;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.Patient hinId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.Category medicalCategoryId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: DATE_OF_DIAGNOSIS
	 */
	public java.util.Date getDateOfDiagnosis () {
		return dateOfDiagnosis;
	}

	/**
	 * Set the value related to the column: DATE_OF_DIAGNOSIS
	 * @param dateOfDiagnosis the DATE_OF_DIAGNOSIS value
	 */
	public void setDateOfDiagnosis (java.util.Date dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}



	/**
	 * Return the value associated with the column: LAST_MED_BOARD_DATE
	 */
	public java.util.Date getLastMedBoardDate () {
		return lastMedBoardDate;
	}

	/**
	 * Set the value related to the column: LAST_MED_BOARD_DATE
	 * @param lastMedBoardDate the LAST_MED_BOARD_DATE value
	 */
	public void setLastMedBoardDate (java.util.Date lastMedBoardDate) {
		this.lastMedBoardDate = lastMedBoardDate;
	}



	/**
	 * Return the value associated with the column: COUNSELLING_DATE
	 */
	public java.util.Date getCounsellingDate () {
		return counsellingDate;
	}

	/**
	 * Set the value related to the column: COUNSELLING_DATE
	 * @param counsellingDate the COUNSELLING_DATE value
	 */
	public void setCounsellingDate (java.util.Date counsellingDate) {
		this.counsellingDate = counsellingDate;
	}



	/**
	 * Return the value associated with the column: WARNING_LETTER
	 */
	public java.lang.String getWarningLetter () {
		return warningLetter;
	}

	/**
	 * Set the value related to the column: WARNING_LETTER
	 * @param warningLetter the WARNING_LETTER value
	 */
	public void setWarningLetter (java.lang.String warningLetter) {
		this.warningLetter = warningLetter;
	}



	/**
	 * Return the value associated with the column: RETENTION_IN_SERVICE
	 */
	public java.lang.String getRetentionInService () {
		return retentionInService;
	}

	/**
	 * Set the value related to the column: RETENTION_IN_SERVICE
	 * @param retentionInService the RETENTION_IN_SERVICE value
	 */
	public void setRetentionInService (java.lang.String retentionInService) {
		this.retentionInService = retentionInService;
	}



	/**
	 * Return the value associated with the column: DATE_OF_POSTING
	 */
	public java.util.Date getDateOfPosting () {
		return dateOfPosting;
	}

	/**
	 * Set the value related to the column: DATE_OF_POSTING
	 * @param dateOfPosting the DATE_OF_POSTING value
	 */
	public void setDateOfPosting (java.util.Date dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}



	/**
	 * Return the value associated with the column: FRESH
	 */
	public java.lang.String getFresh () {
		return fresh;
	}

	/**
	 * Set the value related to the column: FRESH
	 * @param fresh the FRESH value
	 */
	public void setFresh (java.lang.String fresh) {
		this.fresh = fresh;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: MEDICAL_CATEGORY_ID
	 */
	public jkt.hms.masters.business.Category getMedicalCategoryId () {
		return medicalCategoryId;
	}

	/**
	 * Set the value related to the column: MEDICAL_CATEGORY_ID
	 * @param medicalCategoryId the MEDICAL_CATEGORY_ID value
	 */
	public void setMedicalCategoryId (jkt.hms.masters.business.Category medicalCategoryId) {
		this.medicalCategoryId = medicalCategoryId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MonitoringOfAds)) return false;
		else {
			jkt.hms.masters.business.MonitoringOfAds monitoringOfAds = (jkt.hms.masters.business.MonitoringOfAds) obj;
			if (null == this.getId() || null == monitoringOfAds.getId()) return false;
			else return (this.getId().equals(monitoringOfAds.getId()));
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