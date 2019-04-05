package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MIS_FEEDBACK_COUNSELOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MIS_FEEDBACK_COUNSELOR"
 */

public abstract class BaseMisFeedbackCounselor  implements Serializable {

	public static String REF = "MisFeedbackCounselor";
	public static String PROP_COUNSELOR_NAME = "CounselorName";
	public static String PROP_NO_OF_LECTURE = "NoOfLecture";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_ALCOHOL_DEPENDENCE = "AlcoholDependence";
	public static String PROP_HONORARIUM = "Honorarium";
	public static String PROP_RECORD_CASES = "RecordCases";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EMPLOYMENT_OF_COUNSELOR = "EmploymentOfCounselor";
	public static String PROP_ADMINISTRATIVE_ACTION = "AdministrativeAction";
	public static String PROP_COUNSELED_PERSONS = "CounseledPersons";
	public static String PROP_COUNSELED_CASES_TYPE = "CounseledCasesType";
	public static String PROP_STATUS = "Status";
	public static String PROP_ANALYSISOF_PSY_CASES = "AnalysisofPsyCases";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COUNSELING_PLACE = "CounselingPlace";
	public static String PROP_PROBLEMS_FACED = "ProblemsFaced";
	public static String PROP_EMPLOYED_DATE = "EmployedDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VISITS_PER_WEEK = "VisitsPerWeek";
	public static String PROP_COUN_AFTER_WORKING_HRS = "CounAfterWorkingHrs";
	public static String PROP_WORK_HOURS = "WorkHours";


	// constructors
	public BaseMisFeedbackCounselor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisFeedbackCounselor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String counselorName;
	private java.lang.String qualification;
	private java.util.Date employedDate;
	private java.lang.String honorarium;
	private java.lang.String visitsPerWeek;
	private java.lang.String workHours;
	private java.lang.String counselingPlace;
	private java.lang.String counseledPersons;
	private java.lang.String counseledCasesType;
	private java.lang.String noOfLecture;
	private java.lang.String counAfterWorkingHrs;
	private java.lang.String alcoholDependence;
	private java.lang.String recordCases;
	private java.lang.String administrativeAction;
	private java.lang.String employmentOfCounselor;
	private java.lang.String problemsFaced;
	private java.lang.String analysisofPsyCases;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: COUNSELOR_NAME
	 */
	public java.lang.String getCounselorName () {
		return counselorName;
	}

	/**
	 * Set the value related to the column: COUNSELOR_NAME
	 * @param counselorName the COUNSELOR_NAME value
	 */
	public void setCounselorName (java.lang.String counselorName) {
		this.counselorName = counselorName;
	}



	/**
	 * Return the value associated with the column: QUALIFICATION
	 */
	public java.lang.String getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: QUALIFICATION
	 * @param qualification the QUALIFICATION value
	 */
	public void setQualification (java.lang.String qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: EMPLOYED_DATE
	 */
	public java.util.Date getEmployedDate () {
		return employedDate;
	}

	/**
	 * Set the value related to the column: EMPLOYED_DATE
	 * @param employedDate the EMPLOYED_DATE value
	 */
	public void setEmployedDate (java.util.Date employedDate) {
		this.employedDate = employedDate;
	}



	/**
	 * Return the value associated with the column: HONORARIUM
	 */
	public java.lang.String getHonorarium () {
		return honorarium;
	}

	/**
	 * Set the value related to the column: HONORARIUM
	 * @param honorarium the HONORARIUM value
	 */
	public void setHonorarium (java.lang.String honorarium) {
		this.honorarium = honorarium;
	}



	/**
	 * Return the value associated with the column: VISITS_PER_WEEK
	 */
	public java.lang.String getVisitsPerWeek () {
		return visitsPerWeek;
	}

	/**
	 * Set the value related to the column: VISITS_PER_WEEK
	 * @param visitsPerWeek the VISITS_PER_WEEK value
	 */
	public void setVisitsPerWeek (java.lang.String visitsPerWeek) {
		this.visitsPerWeek = visitsPerWeek;
	}



	/**
	 * Return the value associated with the column: WORK_HOURS
	 */
	public java.lang.String getWorkHours () {
		return workHours;
	}

	/**
	 * Set the value related to the column: WORK_HOURS
	 * @param workHours the WORK_HOURS value
	 */
	public void setWorkHours (java.lang.String workHours) {
		this.workHours = workHours;
	}



	/**
	 * Return the value associated with the column: COUNSELING_PLACE
	 */
	public java.lang.String getCounselingPlace () {
		return counselingPlace;
	}

	/**
	 * Set the value related to the column: COUNSELING_PLACE
	 * @param counselingPlace the COUNSELING_PLACE value
	 */
	public void setCounselingPlace (java.lang.String counselingPlace) {
		this.counselingPlace = counselingPlace;
	}



	/**
	 * Return the value associated with the column: COUNSELED_PERSONS
	 */
	public java.lang.String getCounseledPersons () {
		return counseledPersons;
	}

	/**
	 * Set the value related to the column: COUNSELED_PERSONS
	 * @param counseledPersons the COUNSELED_PERSONS value
	 */
	public void setCounseledPersons (java.lang.String counseledPersons) {
		this.counseledPersons = counseledPersons;
	}



	/**
	 * Return the value associated with the column: COUNSELED_CASES_TYPE
	 */
	public java.lang.String getCounseledCasesType () {
		return counseledCasesType;
	}

	/**
	 * Set the value related to the column: COUNSELED_CASES_TYPE
	 * @param counseledCasesType the COUNSELED_CASES_TYPE value
	 */
	public void setCounseledCasesType (java.lang.String counseledCasesType) {
		this.counseledCasesType = counseledCasesType;
	}



	/**
	 * Return the value associated with the column: NO_OF_LECTURE
	 */
	public java.lang.String getNoOfLecture () {
		return noOfLecture;
	}

	/**
	 * Set the value related to the column: NO_OF_LECTURE
	 * @param noOfLecture the NO_OF_LECTURE value
	 */
	public void setNoOfLecture (java.lang.String noOfLecture) {
		this.noOfLecture = noOfLecture;
	}



	/**
	 * Return the value associated with the column: COUN_AFTER_WORKING_HRS
	 */
	public java.lang.String getCounAfterWorkingHrs () {
		return counAfterWorkingHrs;
	}

	/**
	 * Set the value related to the column: COUN_AFTER_WORKING_HRS
	 * @param counAfterWorkingHrs the COUN_AFTER_WORKING_HRS value
	 */
	public void setCounAfterWorkingHrs (java.lang.String counAfterWorkingHrs) {
		this.counAfterWorkingHrs = counAfterWorkingHrs;
	}



	/**
	 * Return the value associated with the column: ALCOHOL_DEPENDENCE
	 */
	public java.lang.String getAlcoholDependence () {
		return alcoholDependence;
	}

	/**
	 * Set the value related to the column: ALCOHOL_DEPENDENCE
	 * @param alcoholDependence the ALCOHOL_DEPENDENCE value
	 */
	public void setAlcoholDependence (java.lang.String alcoholDependence) {
		this.alcoholDependence = alcoholDependence;
	}



	/**
	 * Return the value associated with the column: RECORD_CASES
	 */
	public java.lang.String getRecordCases () {
		return recordCases;
	}

	/**
	 * Set the value related to the column: RECORD_CASES
	 * @param recordCases the RECORD_CASES value
	 */
	public void setRecordCases (java.lang.String recordCases) {
		this.recordCases = recordCases;
	}



	/**
	 * Return the value associated with the column: ADMINISTRATIVE_ACTION
	 */
	public java.lang.String getAdministrativeAction () {
		return administrativeAction;
	}

	/**
	 * Set the value related to the column: ADMINISTRATIVE_ACTION
	 * @param administrativeAction the ADMINISTRATIVE_ACTION value
	 */
	public void setAdministrativeAction (java.lang.String administrativeAction) {
		this.administrativeAction = administrativeAction;
	}



	/**
	 * Return the value associated with the column: EMPLOYMENT_OF_COUNSELOR
	 */
	public java.lang.String getEmploymentOfCounselor () {
		return employmentOfCounselor;
	}

	/**
	 * Set the value related to the column: EMPLOYMENT_OF_COUNSELOR
	 * @param employmentOfCounselor the EMPLOYMENT_OF_COUNSELOR value
	 */
	public void setEmploymentOfCounselor (java.lang.String employmentOfCounselor) {
		this.employmentOfCounselor = employmentOfCounselor;
	}



	/**
	 * Return the value associated with the column: PROBLEMS_FACED
	 */
	public java.lang.String getProblemsFaced () {
		return problemsFaced;
	}

	/**
	 * Set the value related to the column: PROBLEMS_FACED
	 * @param problemsFaced the PROBLEMS_FACED value
	 */
	public void setProblemsFaced (java.lang.String problemsFaced) {
		this.problemsFaced = problemsFaced;
	}



	/**
	 * Return the value associated with the column: ANALYSISOF_PSY_CASES
	 */
	public java.lang.String getAnalysisofPsyCases () {
		return analysisofPsyCases;
	}

	/**
	 * Set the value related to the column: ANALYSISOF_PSY_CASES
	 * @param analysisofPsyCases the ANALYSISOF_PSY_CASES value
	 */
	public void setAnalysisofPsyCases (java.lang.String analysisofPsyCases) {
		this.analysisofPsyCases = analysisofPsyCases;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisFeedbackCounselor)) return false;
		else {
			jkt.hms.masters.business.MisFeedbackCounselor misFeedbackCounselor = (jkt.hms.masters.business.MisFeedbackCounselor) obj;
			if (null == this.getId() || null == misFeedbackCounselor.getId()) return false;
			else return (this.getId().equals(misFeedbackCounselor.getId()));
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